package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.BalkanNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Serbocroat.*;

@Component
public class Serbocroat implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> checkedName = checkPopularNames(name);
        if (checkedName.isPresent()) {
            return checkedName.get();
        }
        name = checkPrimaryCases(name);
        name = checkEndings(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ć", "ч");
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
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("š", "ш");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("y", "ы");
        name = name.replace("x", "кс");
        name = name.replace("z", "з");
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

    private static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                return name.replace(ending.getKey(), ending.getValue());
            }
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        for (Map.Entry<String, String> cons : UTILITY_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> vowel : VOWELS_FOR_UTILITY_CONSONANTS.entrySet()) {
                name = name.replace(cons.getKey() + vowel.getKey(), cons.getValue() + vowel.getValue());
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jCombination : J_CASES_AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
        }
        for (Map.Entry<String, String> jCombination : J_FIRST_CASE.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
                break;
            }
        }
        for (Map.Entry<String, String> jCombination : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(jCombination.getKey(), jCombination.getValue());
        }
        name = name.replace("nj", "нь");
        name = name.replace("lj", "ль");
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(BalkanNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(BalkanNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.SERBOCROAT.getName();
    }
}