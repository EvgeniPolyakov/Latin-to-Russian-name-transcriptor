package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.DefaultRuleset;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Portuguese.*;

@Component
public class Portuguese extends DefaultRuleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, TRUE);
        name = checkPrimaryCases(name);
        name = normalizeAccents(name);
        name = checkStart(name);
        name = checkEndings(name);
        name = checkVowels(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    protected String mapSingleChars(String name) {
        name = name.replace("ã", "ан");
        name = name.replace("c", "к");
        name = name.replace("ç", "с");
        name = name.replace("ê", "е");
        name = name.replace("é", "е");
        name = name.replace("j", "ж");
        name = name.replace("í", "и");
        name = name.replace("l", "л");
        name = name.replace("m", "н");
        name = name.replace("ó", "о");
        name = name.replace("ô", "о");
        name = name.replace("ú", "у");
        name = name.replace("ü", "у");
        name = name.replace("x", "ш");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("ãу", "ан");
        name = name.replace("ãэ", "айн");
        name = name.replace("ou", "о");
        name = name.replace("oa", "уа");
        name = name.replace("oe", "уэ");
        name = name.replace("oэ", "уэ");
        name = name.replace("ge", "жe");
        name = name.replace("gé", "жe");
        name = name.replace("gê", "жe");
        name = name.replace("gi", "жi");
        name = name.replace("sce", "шсе");
        name = name.replace("sci", "шси");
        name = name.replace("ce", "сe");
        name = name.replace("cé", "сe");
        name = name.replace("cê", "сe");
        name = name.replace("ci", "сi");
        name = name.replace("ch", "ш");
        name = name.replace("cb", "б");
        name = name.replace("cd", "д");
        name = name.replace("cp", "п");
        name = name.replace("ct", "т");
        name = name.replace("iu", "иу");
        name = name.replace("lh", "ль");
        name = name.replace("nh", "нь");
        name = name.replace("nã", "на");
        name = name.replace("mb", "мб");
        name = name.replace("mp", "мп");
        name = name.replace("õэ", "ойн");
        name = name.replace("sp", "шп");
        name = name.replace("st", "шт");
        name = name.replace("sc", "шк");
        name = name.replace("sq", "шк");
        name = name.replace("zp", "шп");
        name = name.replace("zt", "шт");
        name = name.replace("zc", "шк");
        name = name.replace("zq", "шк");
        name = name.replace("th", "т");
        name = name.replace("ph", "ф");
        for (String consonant : VOICED_CONSONANTS) {
            name = name.replace("z" + consonant, "ж" + consonant);
            name = name.replace("s" + consonant, "з" + consonant);
        }
        return name;
    }

    private static String normalizeAccents(String name) {
        name = name.replace("à", "a");
        name = name.replace("á", "a");
        name = name.replace("â", "a");
        name = name.replace("ì", "í");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("y", "i");
        name = name.replace("gue", "гe");
        name = name.replace("gui", "гi");
        name = name.replace("que", "кe");
        name = name.replace("qui", "кi");
        name = name.replace("maxim", "максим");
        name = name.replace("máxim", "масим");
        return name;
    }

    private static String checkStart(String name) {
        if (name.startsWith("h")) {
            name = name.substring(1);
        }
        name = checkStart(name, STARTERS);
        for (String vowel : VOWELS) {
            if (name.startsWith("ex" + vowel)) {
                return name.replaceFirst("ex" + vowel, "эз" + vowel);
            }
        }
        return name;
    }

    private static String checkEndings(String name) {
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> afterVowel : ENDINGS_AFTER_VOWELS.entrySet()) {
                if (name.endsWith(vowel + afterVowel.getKey())) {
                    String sub = name.substring(0, name.length() - afterVowel.getKey().length());
                    return sub + afterVowel.getValue();
                }
            }
        }
        if (name.endsWith("ios")) {
            return name.substring(0, name.length() - 3) + "иуш";
        }
        if (name.endsWith("os")) {
            return name.substring(0, name.length() - 2) + "уш";
        }
        name = checkEndings(name, ENDINGS);
        if (name.endsWith("m")) {
            name = name.substring(0, name.length() - 1) + "м";
        }
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ss" + vowel2, vowel + "с" + vowel2);
                name = name.replace(vowel + "s" + vowel2, vowel + "з" + vowel2);
                name = name.replace(vowel + "h" + vowel2, vowel + vowel2);
            }
            for (Map.Entry<String, String> beforeVowel : BEFORE_VOWELS.entrySet()) {
                name = name.replace(beforeVowel.getKey() + vowel, beforeVowel.getValue() + vowel);
            }
            for (Map.Entry<String, String> afterVowel : AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
                if (!vowel.equals("i")) {
                    name = name.replace(vowel + "e", vowel + "э");
                }
            }
            name = name.replace(vowel + "i", vowel + "й");
        }
        name = checkSoftenedVowels(name);
        return name;
    }

    private static String checkSoftenedVowels(String name) {
        for (String consonant : SOFT_CONSONANTS) {
            for (Map.Entry<String, String> vowel : SOFTENED_VOWELS.entrySet()) {
                name = name.replace(consonant + vowel.getKey(), consonant + vowel.getValue());
            }
            name = name.replace(consonant + "ãу", consonant + "ян");
            name = name.replace(consonant + "ã", consonant + "ян");
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.PORTUGUESE.getName();
    }
}