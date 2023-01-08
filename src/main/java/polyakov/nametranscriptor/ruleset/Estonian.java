package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.EstonianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Estonian.*;

@Component
public class Estonian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> checkedName = checkPopularNames(name);
        if (checkedName.isPresent()) {
            return checkedName.get();
        }
        name = checkEndings(name);
        name = checkVowels(name);
        name = checkStart(name);
        name = checkCasesOfJ(name);
        name = checkIotation(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("ä", "я");
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
        name = name.replace("l", "л");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("ö", "е");
        name = name.replace("õ", "ы");
        name = name.replace("p", "п");
        name = name.replace("q", "к");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("š", "ш");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("ü", "ю");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "кс");
        name = name.replace("y", "ю");
        name = name.replace("z", "з");
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
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("ä")) {
            return name.replaceFirst("ä", "э");
        }
        if (name.startsWith("ö")) {
            return name.replaceFirst("ö", "э");
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

    private static String checkCasesOfJ(String name) {
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

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "i", vowel + "й");
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
            }
        }
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(EstonianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(EstonianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.ESTONIAN.getName();
    }
}