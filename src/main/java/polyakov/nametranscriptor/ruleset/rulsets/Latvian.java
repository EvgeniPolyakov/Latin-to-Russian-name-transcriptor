package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;
import polyakov.nametranscriptor.ruleset.RulesetWithIotation;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Latvian.*;

@Component
public class Latvian extends RulesetWithIotation {
    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, TRUE);
        name = checkPrimaryCases(name);
        name = checkCustomCases(name);
        name = checkSoftConsonants(name, mode);
        if (name.contains("j")) {
            name = checkIotation(name, VOWELS, J_CASES, J_CASES_AFTER_CONSONANTS);
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
        name = checkEndings(name, ENDINGS);
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

    @Override
    public String getName() {
        return RulesetName.LATVIAN.getName();
    }
}