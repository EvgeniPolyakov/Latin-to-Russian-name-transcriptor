package polyakov.nametranscriptor.model.rulesets;

import polyakov.nametranscriptor.model.rulesets.names.GreekNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.model.rulesets.custom.Greek.*;

public class Greek implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> gn = checkGreekNames(name);
        if (gn.isPresent()) {
            name = gn.get();
        }
        name = checkCustomCases(name);
        name = name.replace("a", "а");
        name = name.replace("A", "А");
        name = name.replace("á", "а");
        name = name.replace("Á", "А");
        name = name.replace("b", "б");
        name = name.replace("B", "Б");
        name = name.replace("c", "к");
        name = name.replace("C", "К");
        name = name.replace("d", "д");
        name = name.replace("D", "Д");
        name = name.replace("e", "е");
        name = name.replace("E", "Е");
        name = name.replace("f", "ф");
        name = name.replace("F", "Ф");
        name = name.replace("g", "г");
        name = name.replace("G", "Г");
        name = name.replace("h", "х");
        name = name.replace("H", "Х");
        name = name.replace("i", "и");
        name = name.replace("I", "И");
        name = name.replace("ï", "и");
        name = name.replace("Ï", "И");
        name = name.replace("í", "и");
        name = name.replace("Í", "И");
        name = name.replace("k", "к");
        name = name.replace("K", "К");
        name = name.replace("l", "л");
        name = name.replace("L", "Л");
        name = name.replace("m", "м");
        name = name.replace("M", "М");
        name = name.replace("n", "н");
        name = name.replace("N", "Н");
        name = name.replace("o", "о");
        name = name.replace("O", "О");
        name = name.replace("p", "п");
        name = name.replace("P", "П");
        name = name.replace("q", "к");
        name = name.replace("Q", "К");
        name = name.replace("r", "р");
        name = name.replace("R", "Р");
        name = name.replace("s", "с");
        name = name.replace("S", "С");
        name = name.replace("t", "т");
        name = name.replace("T", "Т");
        name = name.replace("u", "у");
        name = name.replace("U", "У");
        name = name.replace("v", "в");
        name = name.replace("V", "В");
        name = name.replace("x", "кс");
        name = name.replace("X", "Кс");
        name = name.replace("y", "и");
        name = name.replace("Y", "И");
        name = name.replace("z", "з");
        name = name.replace("Z", "З");
        return name;
    }

    private Optional<String> checkGreekNames(String name) {
        return Arrays.stream(GreekNames.values())
                .filter(s -> s.getLatinName().equalsIgnoreCase(name))
                .findAny()
                .map(GreekNames::getCyrillicName);
    }

    protected String checkCustomCases(String name) {
        for (Map.Entry<String, String> s : STARTERS.entrySet()) {
            if (name.startsWith(s.getKey())) {
                name = name.replaceFirst(s.getKey(), s.getValue());
            }
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
        name = name.replace("Ch", "Х");
        name = name.replace("ts", "ц");
        name = name.replace("Ts", "Ц");
        name = name.replace("tz", "дз");
        name = name.replace("Tz", "Дз");
        name = name.replace("th", "т");
        name = name.replace("Th", "Т");
        name = name.replace("ph", "ф");
        name = name.replace("Ph", "Ф");
        name = name.replace("kh", "х");
        name = name.replace("Kh", "Х");
        name = name.replace("gk", "г");
        name = name.replace("Gk", "Г");
        name = name.replace("ói", "ои");
        name = name.replace("Ói", "Ои");
        name = name.replace("ou", "у");
        name = name.replace("Ou", "У");
        name = name.replace("yi", "йи");
        name = name.replace("yii", "йи");
        name = name.replace("yí", "йи");
        name = name.replace("yií", "йи");
        name = name.replace("Yi", "Йи");
        name = name.replace("Yii", "Йи");
        name = name.replace("Yí", "Йи");
        name = name.replace("Yií", "Йи");
        name = name.replace("ío", "ьо");
        for (String v : VOICELESS_CONSONANTS) {
            name = name.replace("mp" + v, "мп" + v);
            name = name.replace("Mp" + v, "Мп" + v);
        }
        name = name.replace("mp", "мб");
        name = name.replace("Mp", "М");
        for (String s : S_CASE_CONSONANTS) {
            name = name.replace("s" + s, "з" + s);
            name = name.replace("S" + s, "З" + s);
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

    private static String checkVowelCombinations(String name) {
        for (String v : VOWELS) {
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
            if ((!v.equals("i")) && (!v.equals("y"))) {
                name = name.replace(v + "e", v + "э");
                name = name.replace(v + "ai", v + "э");
            }
        }
        return name;
    }
}
