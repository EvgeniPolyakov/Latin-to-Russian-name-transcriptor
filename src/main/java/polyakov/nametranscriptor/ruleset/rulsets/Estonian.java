package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;
import polyakov.nametranscriptor.ruleset.RulesetWithIotation;

import static java.lang.Boolean.FALSE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Estonian.*;

@Component
public class Estonian extends RulesetWithIotation {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, FALSE);
        name = checkEndings(name);
        name = checkVowels(name);
        name = checkStart(name);
        if (name.contains("j")) {
            name = checkIotation(name, VOWELS, J_CASES, J_CASES_AFTER_CONSONANTS);
        }
        name = checkIotation(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("ä", "я");
        name = name.replace("c", "к");
        name = name.replace("j", "й");
        name = name.replace("l", "л");
        name = name.replace("ö", "е");
        name = name.replace("õ", "ы");
        name = name.replace("š", "ш");
        name = name.replace("ü", "ю");
        name = name.replace("x", "кс");
        name = name.replace("y", "ю");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("üü", "юй");
        name = name.replace("štš", "щ");
        name = name.replace("tš", "ч");
        name = name.replace("jõ", "йы");
        name = name.replace("öö", "еэ");
        name = name.replace("ää", "яэ");
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ss" + vowel2, vowel + "с" + vowel2);
                name = name.replace(vowel + "s" + vowel2, vowel + "з" + vowel2);
                name = name.replace(vowel + "hh" + vowel2, vowel + "х" + vowel2);
            }
        }
        return name;
    }

    private static String checkStart(String name) {
        name = checkStart(name, PRIMARY_STARTERS);
        name = checkStart(name, SECONDARY_STARTERS);
        return name;
    }

    private static String checkEndings(String name) {
        name = checkEndings(name, ENDINGS);
        for (String vowel : VOWELS) {
            if (name.endsWith(vowel + "hh")) {
                return name.substring(0, name.length() - 2) + "х";
            }
            if (name.endsWith(vowel + "ss")) {
                return name.substring(0, name.length() - 2) + "с";
            }
        }
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "i", vowel + "й");
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.ESTONIAN.getName();
    }
}