package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.rulesets.names.AlbanianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.rulesets.customrules.Albanian.*;

@Component
public class Albanian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkStart(name);
        name = checkEDiaeresisCases(name);
        name = checkCustomCases(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return postCheck(name);
    }

    private String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("ç", "ч");
        name = name.replace("ç", "ч");
        name = name.replace("ć", "ч");
        name = name.replace("č", "ч");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("ë", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("l", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("q", "кь");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "дз");
        name = name.replace("y", "ю");
        name = name.replace("z", "з");
        name = name.replace("ž", "з");
        return name;
    }

    private String checkCombinations(String name) {
        name = name.replace("dh", "д");
        name = name.replace("th", "т");
        name = name.replace("rr", "рр");
        name = name.replace("sh", "ш");
        name = name.replace("xh", "дж");
        name = name.replace("zh", "ж");
        name = name.replace("gj", "гь");
        name = name.replace("nj", "нь");
        name = name.replace("ja", "ья");
        name = name.replace("je", "ье");
        name = name.replace("jë", "ье");
        name = name.replace("ji", "ьи");
        name = name.replace("jo", "ьо");
        name = name.replace("ju", "ью");
        name = name.replace("jy", "ью");
        return name;
    }

    private String checkStart(String name) {
        name = name.replace("ll", "л");
        if (name.startsWith("ë")) {
            name = name.replaceFirst("ë", "э");
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        return name;
    }

    private String postCheck(String name) {
        if (name.endsWith("кь")) {
            return name.replace("кь", "ч");
        }
        name = name.replaceFirst("льь", "ль");
        return name;
    }

    private String checkCustomCases(String name) {
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jwc : J_VOWEL_CASES.entrySet()) {
                name = name.replace(vowel + jwc.getKey(), vowel + jwc.getValue());
            }
            name = name.replace(vowel + "e", vowel + "э");
            name = name.replace(vowel + "ë", vowel + "э");
        }
        for (Map.Entry<String, String> jwc : J_VOWEL_CASES.entrySet()) {
            if (name.startsWith(jwc.getKey())) {
                name = name.replaceFirst(jwc.getKey(), jwc.getValue());
            }
        }
        for (Map.Entry<String, String> sc : SOFT_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> sv : SOFTENED_VOWELS.entrySet()) {
                name = name.replace(sc.getKey() + sv.getKey(), sc.getValue() + sv.getValue());
            }
        }
        return name;
    }

    private String checkEDiaeresisCases(String name) {
        for (Map.Entry<String, String> sc : SOFT_CONSONANTS.entrySet()) {
            if (name.endsWith(sc.getKey() + "ë")) {
                String sub = name.substring(0, name.length() - sc.getKey().length() - 1);
                name = sub + sc.getValue() + "я";
            }
        }
        if (name.endsWith("jë")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "я";
        }
        if (name.endsWith("ë")) {
            String sub = name.substring(0, name.length() - 1);
            name = sub + "а";
        }
        return name;
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(AlbanianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(AlbanianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.ALBANIAN.getName();
    }
}