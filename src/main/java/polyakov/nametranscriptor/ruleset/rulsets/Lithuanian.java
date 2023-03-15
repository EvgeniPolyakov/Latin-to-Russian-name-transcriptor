package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.DefaultRuleset;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Lithuanian.*;

@Component
public class Lithuanian extends DefaultRuleset {
    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, TRUE);
        name = checkPrimaryCases(name);
        name = checkCustomCases(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkCombinations(name, mode);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ė", "е");
        name = name.replace("j", "й");
        name = name.replace("l", "ль");
        name = name.replace("š", "ш");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("ą", "a");
        name = name.replace("ę", "e");
        name = name.replace("é", "ė");
        name = name.replace("į", "i");
        name = name.replace("y", "i");
        name = name.replace("ū", "u");
        name = name.replace("ų", "ū");
        name = name.replace("kevič", "кявич");
        name = name.replace("levič", "лявич");
        name = name.replace("zevič", "зявич");
        name = name.replace("cevič", "цявич");
        name = name.replace("čevič", "чявич");
        name = name.replace("nevič", "нявич");
        name = name.replace("sevič", "сявич");
        return name;
    }

    private static String checkCustomCases(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        if (name.startsWith("ė")) {
            name = name.replaceFirst("ė", "э");
        }
        for (String vowel : VOWELS) {
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "ė", vowel + "э");
            }
            name = name.replace("l" + vowel, "л" + vowel);
            name = name.replace(vowel + "i", vowel + "й");
        }
        return name;
    }

    private static String checkCombinations(String name, int mode) {
        name = name.replace("ji", "йи");
        name = name.replace("jo", "йо");
        name = name.replace("ch", "х");
        name = name.replace("šč", "щ");
        name = name.replace("ei", "ей");
        name = name.replace("ia", "я");
        name = name.replace("ie", "е");
        name = name.replace("iu", "ю");
        if (mode == 1) {
            name = name.replace("io", "ё");
        }
        name = name.replace("io", "е");
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

    private static String checkCasesOfL(String name) {
        name = name.replace("lь", "ль");
        name = name.replace("ll", "лl");
        name = checkSoftVowelsAfterL(name);
        return name;
    }

    private static String checkSoftVowelsAfterL(String name) {
        while (name.contains("l")) {
            int indexOfL = name.indexOf("l");
            if (indexOfL + 2 >= name.length()) {
                return name;
            }
            String charToCheck = String.valueOf(name.charAt(indexOfL + 2));
            for (String soft : CONSONANT_SOFTENERS) {
                if (charToCheck.equals(soft)) {
                    name = name.substring(0, indexOfL) + "ль" + name.substring(indexOfL + 1);
                    break;
                }
            }
            name = name.substring(0, indexOfL) + "л" + name.substring(indexOfL + 1);
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.LITHUANIAN.getName();
    }
}