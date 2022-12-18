package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.rulesets.names.RussianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.rulesets.customrules.Russian.*;

@Component
public class Russian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkCustomCases(name);
        name = checkStart(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    protected String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("i", "и");
        name = name.replace("k", "к");
        name = name.replace("h", "х");
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
        return name;
    }

    protected String checkCombinations(String name) {
        name = name.replace("sch", "щ");
        name = name.replace("shch", "щ");
        name = name.replace("sh", "ш");
        name = name.replace("ch", "ч");
        name = name.replace("iya", "ия");
        name = name.replace("ya", "я");
        name = name.replace("aye", "ае");
        name = name.replace("ay", "ай");
        name = name.replace("yu", "ю");
        name = name.replace("uy", "уй");
        name = name.replace("ye", "е");
        name = name.replace("ey", "ей");
        name = name.replace("yo", "йо");
        name = name.replace("oy", "ой");
        name = name.replace("yi", "ьи");
        name = name.replace("ei", "ей");
        name = name.replace("oi", "ой");
        name = name.replace("ui", "уй");
        name = name.replace("iy", "ий");
        name = name.replace("ts", "ц");
        name = name.replace("zh", "ж");
        name = name.replace("kh", "х");
        return name;
    }

    protected Optional<String> checkPopularNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    protected String checkCustomCases(String name) {
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
        for (String s : CUSTOM_ENDINGS) {
            if (name.length() > 1 && name.endsWith(s)) {
                name = checkYCaseEndings(name, s);
            }
        }
        if (name.endsWith("ii")) {
            name = name.replace("ii", "ий");
        }
        return name;
    }

    protected String checkStart(String name) {
        for (Map.Entry<String, String> s : STARTERS.entrySet()) {
            if (name.startsWith(s.getKey())) {
                name = name.replaceFirst(s.getKey(), s.getValue());
            }
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        return name;
    }

    private static String checkYCaseEndings(String name, String s) {
        for (String c : Y_CONSONANTS_PART1) {
            if (name.charAt(name.length() - (s.length() + 1)) == c.charAt(0)) {
                String substring = name.substring(0, name.length() - s.length());
                name = substring + "ый";
            }
        }
        for (String c : Y_CONSONANTS_PART2) {
            if (name.charAt(name.length() - (s.length() + 1)) == c.charAt(0)) {
                String substring = name.substring(0, name.length() - s.length());
                name = substring + "ий";
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.RUSSIAN.getName();
    }
}