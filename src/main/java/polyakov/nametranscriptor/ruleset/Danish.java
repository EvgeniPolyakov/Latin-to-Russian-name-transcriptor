package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Danish.*;

@Component
public class Danish implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name);
        name = checkPrimaryCases(name);
        name = checkStart(name);
        name = checkEndings(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        if (name.contains("c")) {
            name = checkCasesOfC(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        if (name.contains("d")) {
            name = checkCasesOfD(name);
        }
        name = checkVowels(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return mapStandardChars(name);
    }

    private static String checkSingleChars(String name) {
        name = name.replace("å", "о");
        name = name.replace("æ", "е");
        name = name.replace("c", "к");
        name = name.replace("j", "й");
        name = name.replace("l", "ль");
        name = name.replace("ø", "е");
        name = name.replace("x", "кс");
        name = name.replace("y", "ю");
        name = name.replace("z", "с");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("aa", "å");
        name = name.replace("hj", "j");
        name = name.replace("hv", "v");
        name = name.replace("th", "t");
        name = name.replace("ö", "ø");
        name = name.replace("øe", "ø");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("egm", "айм");
        name = name.replace("egn", "айн");
        name = name.replace("ch", "к");
        name = name.replace("øg", "ой");
        name = name.replace("qu", "кв");
        name = name.replace("tion", "шон");
        return name;
    }

    private static String checkStart(String name) {
        for (Map.Entry<String, String> starter : PRIMARY_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("ø")) {
            return name.replaceFirst("ø", "э");
        }
        if (name.startsWith("e")) {
            return name.replaceFirst("e", "э");
        }
        return name;
    }

    private static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        name = name.replace("sj", "ш");
        name = name.replace("gj", "г");
        name = name.replace("kj", "к");
        name = name.replace("ej", "ай");
        name = name.replace("øj", "ой");
        for (Map.Entry<String, String> jCombination : J_CASES.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
                break;
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jCombination : J_CASES.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
        }
        for (Map.Entry<String, String> jCombination : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(jCombination.getKey(), jCombination.getValue());
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("egl", "айl");
        name = name.replace("lь", "ль");
        name = name.replace("ll", "лl");
        name = name.replace("lds", "лльс");
        name = name.replace("lde", "лле");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
        }
        return name;
    }

    private static String checkCasesOfC(String name) {
        for (String vowel : List.of("e", "i", "y", "æ", "ø")) {
            name = name.replace("c" + vowel, "с" + vowel);
        }
        return name;
    }

    private static String checkCasesOfD(String name) {
        for (String vowel : VOWELS) {
            if (!vowel.equals("e")) {
                name = name.replace("nd" + vowel, "нд" + vowel);
            }
        }
        name = name.replace("nde", "нне");
        name = name.replace("nds", "ннс");
        name = name.replace("nd", "n");
        name = name.replace("dt", "тт");
        name = name.replace("ds", "с");
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "øg", vowel + "ег");
            name = name.replace(vowel + "ø", vowel + "э");
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "æ", vowel + "э");
            }
        }
        return name;
    }

    private static String checkExceptions(String name) {
        return Optional.ofNullable(NAMES.get(name)).orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.DANISH.getName();
    }
}