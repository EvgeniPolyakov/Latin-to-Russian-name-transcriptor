package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;
import polyakov.nametranscriptor.ruleset.RulesetWithIotation;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Danish.*;

@Component
public class Danish extends RulesetWithIotation {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, FALSE);
        name = checkPrimaryCases(name);
        name = checkStart(name);
        name = checkEndings(name, ENDINGS);
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
        name = checkStart(name, PRIMARY_STARTERS);
        name = checkStart(name, SECONDARY_STARTERS);
        return name;
    }

    private static String checkCasesOfJ(String name) {
        name = name.replace("sj", "ш");
        name = name.replace("gj", "г");
        name = name.replace("kj", "к");
        name = name.replace("ej", "ай");
        name = name.replace("øj", "ой");
        name = checkIotation(name, VOWELS, J_CASES, J_CASES_AFTER_CONSONANTS);
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

    @Override
    public String getName() {
        return RulesetName.DANISH.getName();
    }
}