package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

import java.util.Map;

import static polyakov.nametranscriptor.rulesets.customrules.Romanian.*;

@Component
public class Romanian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkCustomCases(name);
        name = checkSingleChars(name);
        return name;
    }

    private String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("ă", "э");
        name = name.replace("â", "ы");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("î", "ы");
        name = name.replace("î", "и");
        name = name.replace("j", "ж");
        name = name.replace("k", "к");
        name = name.replace("l", "л");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("q", "к");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("ș", "ш");
        name = name.replace("ş", "ш");
        name = name.replace("t", "т");
        name = name.replace("ț", "ц");
        name = name.replace("ţ", "ц");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "кс");
        name = name.replace("y", "и");
        name = name.replace("z", "з");
        return name;
    }

    protected String checkCustomCases(String name) {
        name = name.replace("ii", "ий");
        name = name.replace("îi", "ый");
        name = checkStarters(name);
        name = name.replace("cea", "ча");
        name = name.replace("cia", "ча");
        name = name.replace("cio", "чо");
        name = name.replace("ciu", "чу");
        name = name.replace("gea", "джа");
        name = name.replace("gia", "джа");
        name = name.replace("geo", "джо");
        name = name.replace("gio", "джо");
        name = name.replace("giu", "джу");
        name = name.replace("ea", "я");
        name = checkVowels(name);
        name = checkEndings(name);
        name = checkConsonants(name);
        name = name.replace("ia", "ья");
        name = name.replace("ie", "ье");
        name = name.replace("io", "ьо");
        name = name.replace("iu", "ью");
        return name;
    }

    private static String checkStarters(String name) {
        for (Map.Entry<String, String> i : STARTERS.entrySet()) {
            if (name.startsWith(i.getKey())) {
                name = name.replaceFirst(i.getKey(), i.getValue());
            }
        }
        return name;
    }

    private static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                name = sub + ending.getValue();
            }
        }
        return name;
    }

    private static String checkVowels(String name) {
        for (Map.Entry<String, String> c : VOWELS.entrySet()) {
            name = name.replace(c.getKey() + "ia", c.getValue() + "я");
            name = name.replace(c.getKey() + "ie", c.getValue() + "е");
            name = name.replace(c.getKey() + "io", c.getValue() + "йо");
            name = name.replace(c.getKey() + "iu", c.getValue() + "ю");
            name = name.replace(c.getKey() + "i", c.getValue() + "й");
            name = name.replace(c.getKey() + "i", c.getValue() + "й");
        }
        return name;
    }

    private static String checkConsonants(String name) {
        for (Map.Entry<String, String> consonants : CUSTOM_CONSONANTS.entrySet()) {
            for (String v : UTILITY_VOWELS) {
                name = name.replace(consonants.getKey() + v, consonants.getValue() + v);
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.ROMANIAN.getName();
    }
}
