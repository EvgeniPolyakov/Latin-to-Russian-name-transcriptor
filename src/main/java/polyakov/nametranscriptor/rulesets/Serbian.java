package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.rulesets.names.BalkanNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Component
public class Serbian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkCombinations(name);
        name = checkCustomCases(name);
        name = checkSingleChars(name);
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.SERBIAN.getName();
    }

    private String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ć", "ч");
        name = name.replace("d", "д");
        name = name.replace("đ", "дж");
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

    private String checkCombinations(String name) {
        for (Map.Entry<String, String> s : polyakov.nametranscriptor.rulesets.customrules.Serbocroatian.UTILITY_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> c : polyakov.nametranscriptor.rulesets.customrules.Serbocroatian.VOWELS_FOR_UTILITY_CONSONANTS.entrySet()) {
                name = name.replace(s.getKey() + c.getKey(), s.getValue() + c.getValue());
            }
        }
        for (String v : polyakov.nametranscriptor.rulesets.customrules.Serbocroatian.VOWELS) {
            for (Map.Entry<String, String> c : polyakov.nametranscriptor.rulesets.customrules.Serbocroatian.J_CASES_AFTER_VOWELS.entrySet()) {
                name = name.replace(v + c.getKey(), v + c.getValue());
            }
            name = name.replace(v + "e", v + "э");
        }
        for (Map.Entry<String, String> c : polyakov.nametranscriptor.rulesets.customrules.Serbocroatian.J_FIRST_CASE.entrySet()) {
            if (name.startsWith(c.getKey())) {
                name = name.replaceFirst(c.getKey(), c.getValue());
            }
        }
        for (Map.Entry<String, String> c : polyakov.nametranscriptor.rulesets.customrules.Serbocroatian.J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(c.getKey(), c.getValue());
        }
        name = name.replace("nj", "нь");
        name = name.replace("lj", "ль");
        name = name.replace("dž", "дж");
        return name;
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(BalkanNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(BalkanNames::getCyrillicName);
    }

    protected String checkCustomCases(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        return name;
    }
}