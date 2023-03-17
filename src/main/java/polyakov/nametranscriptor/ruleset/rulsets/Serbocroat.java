package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;
import polyakov.nametranscriptor.ruleset.RulesetWithIotation;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Serbocroat.*;

@Component
public class Serbocroat extends RulesetWithIotation {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, TRUE);
        name = checkPrimaryCases(name);
        name = checkEndings(name, ENDINGS);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ć", "ч");
        name = name.replace("j", "й");
        name = name.replace("l", "л");
        name = name.replace("š", "ш");
        name = name.replace("y", "ы");
        name = name.replace("x", "кс");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("đ", "dj");
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "e", vowel + "э");
        }
        if (name.startsWith("e")) {
            return name.replaceFirst("e", "э");
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        for (Map.Entry<String, String> cons : UTILITY_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> vowel : VOWELS_FOR_UTILITY_CONSONANTS.entrySet()) {
                name = name.replace(cons.getKey() + vowel.getKey(), cons.getValue() + vowel.getValue());
            }
        }
        name = checkIotation(name, VOWELS, J_CASES, J_CASES_AFTER_CONSONANTS);
        name = name.replace("nj", "нь");
        name = name.replace("lj", "ль");
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.SERBOCROAT.getName();
    }
}