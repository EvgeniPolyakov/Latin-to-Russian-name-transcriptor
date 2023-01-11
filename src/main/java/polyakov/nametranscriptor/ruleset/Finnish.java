package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.FinnishNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Finnish.*;

@Component
public class Finnish implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> checkedName = checkPopularNames(name);
        if (checkedName.isPresent()) {
            return checkedName.get();
        }
        if (name.contains("c")) {
            name = checkCasesOfC(name);
        }
        name = checkVowels(name);
        name = checkStart(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkIotation(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("ä", "я");
        name = name.replace("å", "о");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("l", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("ö", "е");
        name = name.replace("p", "п");
        name = name.replace("q", "к");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("ü", "ю");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "кс");
        name = name.replace("y", "ю");
        name = name.replace("z", "с");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("äy", "яу");
        name = name.replace("ch", "к");
        name = name.replace("ck", "к");
        name = name.replace("öy", "еу");
        name = name.replace("qu", "кв");
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ck" + vowel2, vowel + "кк" + vowel2);
            }
            if (name.endsWith(vowel + "ck")) {
                return name.substring(0, name.length() - 2) + "кк";
            }
        }
        if (name.endsWith("ia")) {
            return name.substring(0, name.length() - 2) + "ия";
        }
        return name;
    }

    private static String checkStart(String name) {
        if (name.startsWith("äy")) {
            return name.replaceFirst("äy", "эу");
        }
        if (name.startsWith("ää")) {
            return name.replaceFirst("ää", "ээ");
        }
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            if (!vowel.equals("i") && !vowel.equals("и")) {
                name = name.replace(vowel + "i", vowel + "й");
                name = name.replace(vowel + "e", vowel + "э");
            }
        }
        return name;
    }

    private static String checkCasesOfC(String name) {
        for (String vowel : List.of("e", "i", "y")) {
            name = name.replace("c" + vowel, "с" + vowel);
            name = name.replace("ch" + vowel, "ч" + vowel);
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("ll", "лl");
        name = name.replace("lь", "ль");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
        }
        if (name.endsWith("l")) {
            return name.substring(0, name.length() - 1) + "ль";
        }
        for (String vowel : List.of("a", "o", "u")) {
            name = name.replace(vowel + "l", vowel + "л");
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        name = name.replace("jii", "йий");
        name = name.replace("ji", "йи");
        name = name.replace("jo", "йо");
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

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(FinnishNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(FinnishNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.FINNISH.getName();
    }
}