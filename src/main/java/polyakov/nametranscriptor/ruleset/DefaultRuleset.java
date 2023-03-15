package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Optional;

public abstract class DefaultRuleset implements Ruleset {

    protected String mapStandardChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("k", "к");
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
        name = name.replace("w", "в");
        name = name.replace("z", "з");
        return name;
    }

    protected static String checkEndings(String name, Map<String, String> endings) {
        for (Map.Entry<String, String> ending : endings.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        return name;
    }

    protected static String checkExceptions(String name, Map<String, String> popularNames, boolean stripAccents) {
        String tempString = name;
        if (stripAccents) {
            tempString = StringUtils.stripAccents(tempString);
        }
        return Optional.ofNullable(popularNames.get(tempString)).orElse(name);
    }
}
