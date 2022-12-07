package polyakov.nametranscriptor.model.rulesets;

import polyakov.nametranscriptor.model.rulesets.names.BalkanNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.model.rulesets.custom.Serbocroatian.*;

public class Serbocroatian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkCombinations(name);
        name = checkCustomCases(name);
        name = name.replace("a", "а");
        name = name.replace("A", "А");
        name = name.replace("b", "б");
        name = name.replace("B", "Б");
        name = name.replace("c", "ц");
        name = name.replace("C", "Ц");
        name = name.replace("č", "ч");
        name = name.replace("Č", "Ч");
        name = name.replace("ć", "ч");
        name = name.replace("Ć", "Ч");
        name = name.replace("d", "д");
        name = name.replace("D", "Д");
        name = name.replace("đ", "дж");
        name = name.replace("Đ", "Дж");
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
        name = name.replace("j", "й");
        name = name.replace("J", "Й");
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
        name = name.replace("r", "р");
        name = name.replace("R", "Р");
        name = name.replace("s", "с");
        name = name.replace("S", "С");
        name = name.replace("š", "ш");
        name = name.replace("Š", "Ш");
        name = name.replace("t", "т");
        name = name.replace("T", "Т");
        name = name.replace("u", "у");
        name = name.replace("U", "У");
        name = name.replace("v", "в");
        name = name.replace("V", "В");
        name = name.replace("y", "ы");
        name = name.replace("Y", "Ы");
        name = name.replace("x", "кс");
        name = name.replace("X", "Кс");
        name = name.replace("z", "з");
        name = name.replace("Z", "З");
        name = name.replace("ž", "ж");
        name = name.replace("Ž", "Ж");
        return name;
    }

    private static String checkCombinations(String name) {
        for (Map.Entry<String, String> s : UTILITY_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> c : VOWELS_FOR_UTILITY_CONSONANTS.entrySet()) {
                name = name.replace(s.getKey() + c.getKey(), s.getValue() + c.getValue());
            }
        }
        for (String v : VOWELS) {
            for (Map.Entry<String, String> c : J_CASES_AFTER_VOWELS.entrySet()) {
                name = name.replace(v + c.getKey(), v + c.getValue());
            }
            name = name.replace(v + "e", v + "э");
        }
        for (Map.Entry<String, String> c : J_FIRST_CASE.entrySet()) {
            if (name.startsWith(c.getKey())) {
                name = name.replaceFirst(c.getKey(), c.getValue());
            }
        }
        for (Map.Entry<String, String> c : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(c.getKey(), c.getValue());
        }
        name = name.replace("nj", "нь");
        name = name.replace("Nj", "Нь");
        name = name.replace("lj", "ль");
        name = name.replace("Lj", "Ль");
        name = name.replace("dž", "дж");
        name = name.replace("Dž", "Дж");
        return name;
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(BalkanNames.values())
                .filter(s -> s.getLatinName().equalsIgnoreCase(name.toLowerCase()))
                .findAny()
                .map(BalkanNames::getCyrillicName);
    }

    protected String checkCustomCases(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        if (name.startsWith("E")) {
            name = name.replaceFirst("E", "Э");
        }
        return name;
    }
}