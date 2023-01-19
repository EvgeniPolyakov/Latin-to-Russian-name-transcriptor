package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.HebrewNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Hebrew.*;

@Component
public class Hebrew implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = StringUtils.stripAccents(name);
        Optional<String> checkedName = checkPopularNames(name);
        if (checkedName.isPresent()) {
            return checkedName.get();
        }
        name = name.replace("ou", "u");
        if (name.contains("y")) {
            name = checkCasesOfY(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkCustomCases(name);
        if (name.contains("i")) {
            name = checkIotation(name);
        }
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    protected static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "дж");
        name = name.replace("k", "к");
        name = name.replace("l", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("q", "к");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "кс");
        name = name.replace("z", "з");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("shch", "щ");
        name = name.replace("tch", "ч");
        name = name.replace("ch", "х");
        name = name.replace("ph", "ф");
        name = name.replace("sh", "ш");
        name = name.replace("kh", "х");
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
            return name.replace("ich", "ич");
        }
        return name;
    }

    private static String checkCasesOfY(String name) {
        for (Map.Entry<String, String> yCombination : Y_CASES.entrySet()) {
            if (name.startsWith(yCombination.getKey())) {
                name = name.replaceFirst(yCombination.getKey(), yCombination.getValue());
                break;
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> yCombination : Y_CASES.entrySet()) {
                name = name.replace(vowel + yCombination.getKey(), vowel + yCombination.getValue());
            }
        }
        for (Map.Entry<String, String> yCombination : Y_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(yCombination.getKey(), yCombination.getValue());
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("lь", "ль");
        name = name.replace("ll", "лl");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
        }
        if (name.endsWith("l")) {
            return name.substring(0, name.length() - 1) + "ль";
        }
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "i", vowel + "й");
        }
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(HebrewNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(HebrewNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.HEBREW.getName();
    }
}