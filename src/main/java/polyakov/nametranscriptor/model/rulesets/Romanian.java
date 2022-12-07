package polyakov.nametranscriptor.model.rulesets;

import java.util.Map;

import static polyakov.nametranscriptor.model.rulesets.custom.Romanian.*;

public class Romanian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkCustomCases(name);
        name = name.replace("a", "а");
        name = name.replace("A", "А");
        name = name.replace("ă", "э");
        name = name.replace("Ă", "Э");
        name = name.replace("â", "ы");
        name = name.replace("Â", "Ы");
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
        name = name.replace("î", "ы");
        name = name.replace("Î", "Ы");
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
        name = name.replace("p", "п");
        name = name.replace("P", "П");
        name = name.replace("q", "к");
        name = name.replace("Q", "К");
        name = name.replace("r", "р");
        name = name.replace("R", "Р");
        name = name.replace("s", "с");
        name = name.replace("S", "С");
        name = name.replace("ș", "ш");
        name = name.replace("Ș", "Ш");
        name = name.replace("ş", "ш");
        name = name.replace("Ş", "Ш");
        name = name.replace("t", "т");
        name = name.replace("T", "Т");
        name = name.replace("ț", "ц");
        name = name.replace("Ț", "Ц");
        name = name.replace("ţ", "ц");
        name = name.replace("Ţ", "Ц");
        name = name.replace("u", "у");
        name = name.replace("U", "У");
        name = name.replace("v", "в");
        name = name.replace("V", "В");
        name = name.replace("w", "в");
        name = name.replace("W", "В");
        name = name.replace("x", "кс");
        name = name.replace("X", "Кс");
        name = name.replace("y", "и");
        name = name.replace("Y", "И");
        name = name.replace("z", "з");
        name = name.replace("Z", "З");
        return name;
    }

    protected String checkCustomCases(String name) {
        name = name.replace("ii", "ий");
        name = name.replace("îi", "ый");
        for (Map.Entry<String, String> i : STARTING_PART.entrySet()) {
            if (name.startsWith(i.getKey())) {
                name = name.replaceFirst(i.getKey(), i.getValue());
            }
        }
        name = name.replace("cea", "ча");
        name = name.replace("Cea", "Ча");
        name = name.replace("cia", "ча");
        name = name.replace("Cia", "Ча");
        name = name.replace("cio", "чо");
        name = name.replace("Cio", "Чо");
        name = name.replace("cio", "чу");
        name = name.replace("Ciu", "Чу");
        name = name.replace("gea", "джа");
        name = name.replace("Gea", "Джа");
        name = name.replace("gia", "джа");
        name = name.replace("Gia", "Джа");
        name = name.replace("geo", "джо");
        name = name.replace("Geo", "Джо");
        name = name.replace("gio", "джо");
        name = name.replace("Gio", "Джо");
        name = name.replace("giu", "джу");
        name = name.replace("Giu", "Джу");
        name = name.replace("ea", "я");
        for (Map.Entry<String, String> c : VOWELS.entrySet()) {
            name = name.replace(c.getKey() + "ia", c.getValue() + "я");
            name = name.replace(c.getKey() + "ie", c.getValue() + "е");
            name = name.replace(c.getKey() + "io", c.getValue() + "йо");
            name = name.replace(c.getKey() + "iu", c.getValue() + "ю");
            name = name.replace(c.getKey() + "i", c.getValue() + "й");
            name = name.replace(c.getKey() + "i", c.getValue() + "й");
        }

        if (name.endsWith("йu")) {
            name = name.replace("йu", "й");
        }
        if (name.endsWith("ci") || name.endsWith("ia") || name.endsWith("ie") || name.endsWith("iu")) {
            name = name.replace("ci", "ч");
            name = name.replace("ia", "ия");
            name = name.replace("ie", "ие");
            name = name.replace("iu", "иу");
        }
        for (Map.Entry<String, String> c : CUSTOM_CONSONANTS.entrySet()) {
            for (String v : UTILITY_VOWELS) {
                name = name.replace(c.getKey() + v, c.getValue() + v);
            }
        }
        name = name.replace("ia", "ья");
        name = name.replace("ie", "ье");
        name = name.replace("io", "ьо");
        name = name.replace("iu", "ью");
        return name;
    }
}
