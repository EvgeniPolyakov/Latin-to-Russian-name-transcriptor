package polyakov.nametranscriptor.model.rulesets;

import java.util.Map;

import static polyakov.nametranscriptor.model.rulesets.custom.Turkish.*;

public class Turkish extends Ruleset {

    @Override
    protected String transcribeName(String name, int mode) {
        for (Map.Entry<String, String> i : INITIAL_LETTER.entrySet()) {
            if (name.startsWith(i.getKey())) {
                name = name.replaceFirst(i.getKey(), i.getValue());
            }
        }
        name = checkCombinations(name);
        name = name.replace("a", "а");
        name = name.replace("A", "А");
        name = name.replace("â", "а");
        name = name.replace("Â", "А");
        name = name.replace("b", "б");
        name = name.replace("B", "Б");
        name = name.replace("c", "дж");
        name = name.replace("C", "Дж");
        name = name.replace("Ç", "Ч");
        name = name.replace("ç", "ч");
        name = name.replace("d", "д");
        name = name.replace("D", "Д");
        name = name.replace("e", "е");
        name = name.replace("E", "Е");
        name = name.replace("f", "ф");
        name = name.replace("F", "Ф");
        name = name.replace("g", "г");
        name = name.replace("G", "Г");
        name = name.replace("ğ", "г");
        name = name.replace("Ğ", "Г");
        name = name.replace("h", "х");
        name = name.replace("H", "Х");
        name = name.replace("i", "и");
        name = name.replace("İ", "И");
        name = name.replace("ı", "ы");
        name = name.replace("I", "Ы");
        name = name.replace("î", "и");
        name = name.replace("Î", "И");
        name = name.replace("j", "ж");
        name = name.replace("J", "Ж");
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
        name = name.replace("ö", "е");
        name = name.replace("Ö", "Е");
        name = name.replace("p", "п");
        name = name.replace("P", "П");
        name = name.replace("r", "р");
        name = name.replace("R", "Р");
        name = name.replace("s", "с");
        name = name.replace("S", "С");
        name = name.replace("ş", "ш");
        name = name.replace("Ş", "Ш");
        name = name.replace("t", "т");
        name = name.replace("T", "Т");
        name = name.replace("u", "у");
        name = name.replace("U", "У");
        name = name.replace("ü", "ю");
        name = name.replace("Ü", "Ю");
        name = name.replace("v", "в");
        name = name.replace("V", "В");
        name = name.replace("y", "й");
        name = name.replace("Y", "Й");
        name = name.replace("z", "з");
        name = name.replace("Z", "З");
        return name;
    }

    private static String checkCombinations(String name) {
        for (Map.Entry<String, String> u : UTILITY_LETTERS.entrySet()) {
            for (Map.Entry<String, String> v : VOWELS.entrySet()) {
                name = name.replace(v.getKey() + u.getKey(), v.getValue() + u.getValue());
            }
        }
        name = name.replace("Gâ", "Гя");
        name = name.replace("gâ", "гя");
        name = name.replace("Kâ", "Кя");
        name = name.replace("kâ", "кя");
        name = name.replace("Lâ", "Ля");
        name = name.replace("lâ", "ля");
        name = name.replace("yya", "йя");
        name = name.replace("yyu", "йю");
        name = name.replace("yyü", "йю");
        name = name.replace("yı", "йы");
        name = name.replace("yi", "йи");
        name = name.replace("ya", "ья");
        name = name.replace("ye", "ье");
        name = name.replace("yo", "ьо");
        name = name.replace("yö", "ье");
        name = name.replace("yu", "ью");
        name = name.replace("yü", "ью");
        return name;
    }
}
