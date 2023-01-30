package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Latvian.*;

@Component
public class Latvian implements Ruleset {
    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name);
        name = checkPrimaryCases(name);
        name = checkCustomCases(name);
        name = checkSoftConsonants(name, mode);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ģ", "гь");
        name = name.replace("j", "й");
        name = name.replace("ķ", "кь");
        name = name.replace("l", "л");
        name = name.replace("ļ", "ль");
        name = name.replace("ņ", "нь");
        name = name.replace("š", "ш");
        name = name.replace("y", "ы");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("ā", "a");
        name = name.replace("ē", "e");
        name = name.replace("ī", "i");
        name = name.replace("ō", "o");
        name = name.replace("ū", "u");
        name = name.replace("ļļ", "лļ");
        name = name.replace("ņņ", "нņ");
        name = name.replace("šč", "щ");
        return name;
    }

    private static String checkCustomCases(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                name = sub + ending.getValue();
                break;
            }
        }
        for (String vowel : VOWELS) {
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "i", vowel + "й");
            }
        }
        return name;
    }

    private static String checkSoftConsonants(String name, int mode) {
        for (Map.Entry<String, String> cons : SOFT_CONSONANTS.entrySet()) {
            if (mode == 1) {
                name = name.replace(cons.getKey() + "o", cons.getValue() + "ё");
            }
            for (Map.Entry<String, String> asc : AFTER_SOFT_CONSONANTS.entrySet()) {
                name = name.replace(cons.getKey() + asc.getKey(), cons.getValue() + asc.getValue());
            }
            name = name.replace(cons.getKey() + "j", cons.getValue() + "j");
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

    private static String checkExceptions(String name) {
        String nameWithNoAccents = StringUtils.stripAccents(name);
        return Optional.ofNullable(NAMES.get(nameWithNoAccents)).orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.LATVIAN.getName();
    }
}