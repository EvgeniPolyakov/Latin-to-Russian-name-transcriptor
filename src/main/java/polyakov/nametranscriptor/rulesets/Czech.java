package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

import java.util.Map;

import static polyakov.nametranscriptor.rulesets.customrules.Czech.*;

@Component
public class Czech implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkStart(name);
        if (mode == 1) {
            name = checkEnd(name);
        }
        name = checkCustomCases(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.CZECH.getName();
    }

    protected String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("á", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("d", "д");
        name = name.replace("ď", "дь");
        name = name.replace("e", "е");
        name = name.replace("é", "е");
        name = name.replace("ě", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "г");
        name = name.replace("i", "и");
        name = name.replace("í", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("l", "л");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("ň", "нь");
        name = name.replace("o", "о");
        name = name.replace("ó", "о");
        name = name.replace("p", "п");
        name = name.replace("q", "к");
        name = name.replace("r", "р");
        name = name.replace("ř", "рш");
        name = name.replace("s", "с");
        name = name.replace("š", "ш");
        name = name.replace("t", "т");
        name = name.replace("ť", "ть");
        name = name.replace("u", "у");
        name = name.replace("ú", "у");
        name = name.replace("ů", "у");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "кс");
        name = name.replace("y", "ы");
        name = name.replace("ý", "ы");
        name = name.replace("z", "з");
        name = name.replace("ž", "ж");
        return name;
    }

    protected String checkCombinations(String name) {
        for (Map.Entry<String, String> u : UTILITY_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> c : AFTER_DNT.entrySet()) {
                name = name.replace(u.getKey() + c.getKey(), u.getValue() + c.getValue());
            }
        }
        for (String v : VOICED_CONSONANTS) {
            name = name.replace(v + "ř", v + "рж");
        }
        name = name.replace("ch", "х");
        name = name.replace("qu", "ку");
        name = name.replace("th", "т");
        name = name.replace("ja", "ья");
        name = name.replace("je", "ье");
        name = name.replace("ji", "ьи");
        name = name.replace("jo", "ье");
        name = name.replace("jó", "ье");
        name = name.replace("ju", "ью");
        name = name.replace("jů", "ью");
        name = name.replace("yá", "иа");
        name = name.replace("ya", "иа");
        return name;
    }

    protected String checkCustomCases(String name) {
        if (name.endsWith("ia")) {
            name = name.replaceFirst("ia", "ия");
        }
        for (String v : VOWELS) {
            for (Map.Entry<String, String> s : STARTERS.entrySet()) {
                name = name.replace(v + s.getKey(), v + s.getValue());
            }
            name = name.replace(v + "jo", v + "е");
            name = name.replace(v + "jó", v + "е");
            name = name.replace(v + "y", v + "й");
            name = name.replace(v + "ý", v + "й");
            name = name.replace(v + "ř", v + "рж");
        }
        for (String c : Y_CASE_CONSONANTS) {
            name = name.replace(c + "y", c + "и");
            name = name.replace(c + "ý", c + "и");
        }
        return name;
    }

    protected String checkStart(String name) {
        for (Map.Entry<String, String> s : STARTERS.entrySet()) {
            if (name.startsWith(s.getKey())) {
                name = name.replaceFirst(s.getKey(), s.getValue());
            }
        }
        if (name.startsWith("jo")) {
            name = name.replaceFirst("jo", "йо");
        }
        if (name.startsWith("jó")) {
            name = name.replaceFirst("jó", "йо");
        }
        if (name.startsWith("ř")) {
            name = name.replaceFirst("ř", "рж");
        }
        return name;
    }

    protected String checkEnd(String name) {
        for (Map.Entry<String, String> e : ENDINGS.entrySet()) {
            if (name.endsWith(e.getKey())) {
                name = name.replace(e.getKey(), e.getValue());
            }
        }
        return name;
    }
}