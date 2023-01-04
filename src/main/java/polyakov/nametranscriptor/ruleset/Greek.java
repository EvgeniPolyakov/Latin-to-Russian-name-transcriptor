package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.GreekNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Greek.*;

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

    private String checkCustomCases(String name) {
        for (Map.Entry<String, String> starter : FIRST_TIER_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                name = name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        for (Map.Entry<String, String> starter : SECOND_TIER_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                name = name.replaceFirst(starter.getKey(), starter.getValue());
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
        for (String vc : VOICELESS_CONSONANTS) {
            name = name.replace("mp" + vc, "мп" + vc);
            name = name.replace("mp" + vc, "мп" + vc);
        }
        name = name.replace("mp", "мб");
        for (String scc : S_CASE_CONSONANTS) {
            name = name.replace("s" + scc, "з" + scc);
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                name = sub + ending.getValue();
            }
        }
        if (name.endsWith("ia")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "ия";
        }
        if (name.endsWith("ïa")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "ия";
        }
        name = name.replace("ia", "иа");
        name = name.replace("ïa", "иа");
        return name;
    }

    private String checkVowelCombinations(String name) {
        for (String vowel : VOWELS) {
            name = checkAfterVowelCases(name, vowel);
            if ((!vowel.equals("i")) && (!vowel.equals("y"))) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "ai", vowel + "э");
            }
        }
        return name;
    }

    private static String checkAfterVowelCases(String name, String v) {
        for (Map.Entry<String, String> avpo : AFTER_VOWELS_TIER_ONE.entrySet()) {
            if (name.contains(avpo.getKey())) {
                name = name.replace(v + avpo.getKey(), v + avpo.getValue());
            }
        }
        for (Map.Entry<String, String> avpt : AFTER_VOWELS_TIER_TWO.entrySet()) {
            if (name.contains(avpt.getKey())) {
                name = name.replace(v + avpt.getKey(), v + avpt.getValue());
            }
        }
        for (Map.Entry<String, String> avpt : AFTER_VOWELS_TIER_THREE.entrySet()) {
            if (name.contains(avpt.getKey())) {
                name = name.replace(v + avpt.getKey(), v + avpt.getValue());
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.GREEK.getName();
    }
}
