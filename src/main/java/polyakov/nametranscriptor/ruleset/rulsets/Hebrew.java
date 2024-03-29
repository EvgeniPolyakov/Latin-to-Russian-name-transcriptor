package polyakov.nametranscriptor.ruleset.rulsets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;
import polyakov.nametranscriptor.ruleset.RulesetWithIotation;

import static java.lang.Boolean.FALSE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Hebrew.*;

@Component
public class Hebrew extends RulesetWithIotation {

    @Override
    public String transcribe(String name, int mode) {
        name = StringUtils.stripAccents(name);
        name = checkExceptions(name, NAMES, FALSE);
        name = name.replace("ou", "u");
        if (name.contains("y")) {
            name = checkIotation(name, VOWELS, Y_CASES, Y_CASES_AFTER_CONSONANTS);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkCustomCases(name);
        if (name.contains("i")) {
            name = checkIotation(name);
        }
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    protected static String mapSingleChars(String name) {
        name = name.replace("c", "к");
        name = name.replace("j", "дж");
        name = name.replace("l", "ль");
        name = name.replace("x", "кс");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("shch", "щ");
        name = name.replace("tsch", "ч");
        name = name.replace("tch", "ч");
        name = name.replace("sch", "ш");
        name = name.replace("ch", "х");
        name = name.replace("ph", "ф");
        name = name.replace("sh", "ш");
        name = name.replace("kh", "х");
        name = name.replace("th", "т");
        name = name.replace("ts", "ц");
        name = name.replace("tz", "ц");
        name = name.replace("ou", "у");
        return name;
    }

    private static String checkCustomCases(String name) {
        name = name.replace("ee", "и");
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "e", vowel + "э");
        }
        if (name.startsWith("йи")) {
            name = name.replaceFirst("йи", "и");
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        name = name.replace("y", "i");
        if (name.endsWith("ich")) {
            return name.substring(0, name.length() - 3) + "ич";
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("lь", "ль");
        name = name.replace("ll", "лl");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
        }
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "i", vowel + "й");
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.HEBREW.getName();
    }
}