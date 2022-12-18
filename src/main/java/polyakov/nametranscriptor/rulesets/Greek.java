package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.rulesets.names.GreekNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.rulesets.customrules.Greek.*;

@Component
public class Greek implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> gn = checkPopularNames(name);
        if (gn.isPresent()) {
            name = gn.get();
        }
        name = checkCustomCases(name);
        name = checkSingleChars(name);
        return name;
    }

    private String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("á", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("ï", "и");
        name = name.replace("í", "и");
        name = name.replace("k", "к");
        name = name.replace("l", "л");
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
        name = name.replace("x", "кс");
        name = name.replace("y", "и");
        name = name.replace("z", "з");
        return name;
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(GreekNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(GreekNames::getCyrillicName);
    }

    protected String checkCustomCases(String name) {
        for (Map.Entry<String, String> s : STARTERS.entrySet()) {
            if (name.startsWith(s.getKey())) {
                name = name.replaceFirst(s.getKey(), s.getValue());
            }
        }
        if (name.startsWith("yi")) {
            name = name.replaceFirst("yi", "йи");
        }
        name = name.replace("aioa", "аиоа");
        name = name.replace("aio", "ейо");
        name = checkVowelCombinations(name);
        name = name.replace("ye", "ье");
        name = name.replace("yai", "ье");
        name = name.replace("yi", "ьи");
        name = name.replace("yii", "ьи");
        name = name.replace("yí", "ьи");
        name = name.replace("yií", "ьи");
        name = name.replace("yia", "ья");
        name = name.replace("yiia", "ья");
        name = name.replace("yie", "ье");
        name = name.replace("yiai", "ье");
        name = name.replace("yio", "ьо");
        name = name.replace("yiio", "ьо");
        name = name.replace("yiou", "ью");
        name = name.replace("yiiou", "ью");
        name = name.replace("ch", "х");
        name = name.replace("ts", "ц");
        name = name.replace("tz", "дз");
        name = name.replace("th", "т");
        name = name.replace("ph", "ф");
        name = name.replace("kh", "х");
        name = name.replace("gk", "г");
        name = name.replace("ói", "ои");
        name = name.replace("ou", "у");
        name = name.replace("yi", "йи");
        name = name.replace("yii", "йи");
        name = name.replace("yí", "йи");
        name = name.replace("yií", "йи");
        name = name.replace("ío", "ьо");
        for (String v : VOICELESS_CONSONANTS) {
            name = name.replace("mp" + v, "мп" + v);
        }
        name = name.replace("mp", "мб");
        for (String s : S_CASE_CONSONANTS) {
            name = name.replace("s" + s, "з" + s);
        }
        for (Map.Entry<String, String> s : ENDINGS.entrySet()) {
            if (name.endsWith(s.getKey())) {
                name = name.replace(s.getKey(), s.getValue());
            }
        }
        if (name.endsWith("ia")) {
            name = name.replace("ia", "ия");
        }
        if (name.endsWith("ïa")) {
            name = name.replace("ïa", "ия");
        }
        name = name.replace("ia", "иа");
        name = name.replace("ïa", "иа");
        return name;
    }

    private String checkVowelCombinations(String name) {
        for (String v : VOWELS) {
            name = checkAfterVowelCases(name, v);
            if ((!v.equals("i")) && (!v.equals("y"))) {
                name = name.replace(v + "e", v + "э");
                name = name.replace(v + "ai", v + "э");
            }
        }
        return name;
    }

    private static String checkAfterVowelCases(String name, String v) {
        for (Map.Entry<String, String> a : AFTER_VOWELS_PART_ONE.entrySet()) {
            if (name.contains(a.getKey())) {
                name = name.replace(v + a.getKey(), v + a.getValue());
            }
        }
        for (Map.Entry<String, String> a : AFTER_VOWELS_PART_TWO.entrySet()) {
            if (name.contains(a.getKey())) {
                name = name.replace(v + a.getKey(), v + a.getValue());
            }
        }
        for (Map.Entry<String, String> a : AFTER_VOWELS_PART_THREE.entrySet()) {
            if (name.contains(a.getKey())) {
                name = name.replace(v + a.getKey(), v + a.getValue());
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.GREEK.getName();
    }
}
