package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.DefaultRuleset;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Greek.*;

@Component
public class Greek extends DefaultRuleset {

    @Override
    public String transcribe(String name, int mode) {
        name = normalizeAccents(name);
        name = checkExceptions(name, NAMES, TRUE);
        name = checkStart(name);
        name = checkCombinations(name);
        name = checkConsonants(name);
        name = checkEndings(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("á", "а");
        name = name.replace("c", "к");
        name = name.replace("j", "й");
        name = name.replace("l", "л");
        name = name.replace("x", "кс");
        name = name.replace("y", "и");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("aioa", "аиоа");
        name = name.replace("aio", "ейо");
        name = checkVowels(name);
        name = name.replace("ye", "ье");
        name = name.replace("yai", "ье");
        name = name.replace("yi", "ьи");
        name = name.replace("yii", "ьи");
        name = name.replace("yia", "ья");
        name = name.replace("yiia", "ья");
        name = name.replace("yie", "ье");
        name = name.replace("yiai", "ье");
        name = name.replace("yio", "ьо");
        name = name.replace("yiio", "ьо");
        name = name.replace("yiou", "ью");
        name = name.replace("yiiou", "ью");
        name = name.replace("dj", "дж");
        name = name.replace("ch", "х");
        name = name.replace("ts", "ц");
        name = name.replace("tz", "дз");
        name = name.replace("th", "т");
        name = name.replace("ph", "ф");
        name = name.replace("kh", "х");
        name = name.replace("gk", "г");
        name = name.replace("ou", "у");
        name = name.replace("yi", "йи");
        name = name.replace("yii", "йи");
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            name = checkAfterVowelCases(name, vowel);
            if ((!vowel.equals("i")) && (!vowel.equals("y") && (!vowel.equals("и")))) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "ai", vowel + "э");
            }
        }
        return name;
    }

    private static String checkConsonants(String name) {
        for (String consonant : VOICELESS_CONSONANTS) {
            name = name.replace("mp" + consonant, "мп" + consonant);
            name = name.replace("mp" + consonant, "мп" + consonant);
        }
        name = name.replace("mp", "мб");
        for (String consonant : S_CASE_CONSONANTS) {
            name = name.replace("s" + consonant, "з" + consonant);
        }
        return name;
    }

    private static String checkStart(String name) {
        name = checkStart(name, PRIMARY_STARTERS);
        name = checkStart(name, SECONDARY_STARTERS);
        if (name.startsWith("yi")) {
            name = name.replaceFirst("yi", "йи");
        }
        return name;
    }

    private static String checkEndings(String name) {
        name = checkEndings(name, ENDINGS);
        if (name.endsWith("ia")) {
            name = name.substring(0, name.length() - 2) + "ия";
        }
        name = name.replace("ia", "иа");
        return name;
    }

    private static String checkAfterVowelCases(String name, String vowel) {
        for (Map.Entry<String, String> afterVowel : AFTER_VOWELS_TIER_ONE.entrySet()) {
            if (name.contains(afterVowel.getKey())) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
        }
        for (Map.Entry<String, String> afterVowel : AFTER_VOWELS_TIER_TWO.entrySet()) {
            if (name.contains(afterVowel.getKey())) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
        }
        for (Map.Entry<String, String> afterVowel : AFTER_VOWELS_TIER_THREE.entrySet()) {
            if (name.contains(afterVowel.getKey())) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
        }
        return name;
    }

    private static String normalizeAccents(String name) {
        name = name.replace("ó", "o");
        name = name.replace("ï", "i");
        name = name.replace("í", "i");
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.GREEK.getName();
    }
}
