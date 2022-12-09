package polyakov.nametranscriptor.model.rulesets;

import polyakov.nametranscriptor.model.rulesets.names.RussianNames;
import polyakov.nametranscriptor.model.rulesets.names.UkrainianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.model.rulesets.custom.Ukrainian.ENDINGS;
import static polyakov.nametranscriptor.model.rulesets.custom.Ukrainian.STARTERS;

public class Ukrainian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkUkrainianNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        os = checkRussianNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkCustomCases(name);
        name = checkCombinations(name);
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("i", "и");
        name = name.replace("k", "к");
        name = name.replace("h", "г");
        name = name.replace("l", "л");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("y", "ы");
        name = name.replace("x", "кс");
        name = name.replace("z", "з");
        name = name.replace("'", "ь");
        return postcheck(name);
    }

    private String postcheck(String name) {
        if (name.endsWith("иы")) {
            name = name.replace("иы", "ий");
        }
        return name;
    }

    private String checkCombinations(String name) {
        name = name.replace("sch", "щ");
        name = name.replace("sch", "щ");
        name = name.replace("shch", "щ");
        name = name.replace("sh", "ш");
        name = name.replace("ch", "ч");
        name = name.replace("iya", "ия");
        name = name.replace("iia", "ия");
        name = name.replace("ya", "я");
        name = name.replace("ia", "я");
        name = name.replace("aye", "ае");
        name = name.replace("aie", "ае");
        name = name.replace("ay", "ай");
        name = name.replace("ai", "ай");
        name = name.replace("iu", "ю");
        name = name.replace("yu", "ю");
        name = name.replace("uy", "уй");
        name = name.replace("ui", "уй");
        name = name.replace("ye", "е");
        name = name.replace("ie", "е");
        name = name.replace("ey", "ей");
        name = name.replace("ei", "ей");
        name = name.replace("yi", "ий");
        name = name.replace("yo", "йо");
        name = name.replace("io", "йо");
        name = name.replace("oy", "ой");
        name = name.replace("oi", "ой");
        name = name.replace("y", "и");
        name = name.replace("ts", "ц");
        name = name.replace("zgh", "зг");
        name = name.replace("zh", "ж");
        name = name.replace("kh", "х");
        return name;
    }

    private Optional<String> checkUkrainianNames(String name) {
        return Arrays.stream(UkrainianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(UkrainianNames::getCyrillicName);
    }

    private Optional<String> checkRussianNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    protected String checkCustomCases(String name) {
        for (Map.Entry<String, String> s : STARTERS.entrySet()) {
            if (name.startsWith(s.getKey())) {
                name = name.replace(s.getKey(), s.getValue());
            }
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        if (name.startsWith("y")) {
            name = name.replaceFirst("y", "й");
        }
        name = name.replace("j", "y");
        name = name.replace("tskyi", "цкий"); // should precede ENDINGS
        name = name.replace("tskiy", "цкий");
        name = name.replace("tskii", "цкий");
        name = name.replace("tsky", "цкий");
        for (Map.Entry<String, String> s : ENDINGS.entrySet()) {
            if (name.endsWith(s.getKey())) {
                name = name.replace(s.getKey(), s.getValue());
            }
        }
        return name;
    }
}