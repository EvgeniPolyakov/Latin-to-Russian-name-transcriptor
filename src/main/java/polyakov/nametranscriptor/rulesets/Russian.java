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
        name = checkPrimaryCases(name);
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkStart(name);
        name = checkEndings(name);
        name = checkVowels(name);
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
        name = name.replace("ya", "я");
        name = name.replace("ye", "ье");
        name = name.replace("yi", "ьи");
        name = name.replace("yo", "е");
        name = name.replace("yu", "ю");
        name = name.replace("iu", "ю");
        name = name.replace("ts", "ц");
        name = name.replace("zh", "ж");
        name = name.replace("kh", "х");
        return name;
    }

    protected String checkPrimaryCases(String name) {
        name = name.replace("j", "y");
        if (name.endsWith("ii")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "iy";
        }
        return name;
    }

    protected Optional<String> checkPopularNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    protected String checkStart(String name) {
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                name = name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        return name;
    }

    protected String checkEndings(String name) {
        if (name.endsWith("tskyi") || name.endsWith("tskiy")) {
            String sub = name.substring(0, name.length() - 5);
            name = sub + "цкий";
        }
        if (name.endsWith("tsky") || name.endsWith("tski")) {
            String sub = name.substring(0, name.length() - 4);
            name = sub + "цкий";
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
        for (String ending : CUSTOM_ENDINGS) {
            if (name.length() > 1 && name.endsWith(ending)) {
                name = checkYCaseEndings(name, ending);
            }
        }
        return name;
    }

    private String checkYCaseEndings(String name, String ending) {
        for (String yc : Y_CONSONANTS_PART1) {
            if (name.charAt(name.length() - (ending.length() + 1)) == yc.charAt(0)) {
                String substring = name.substring(0, name.length() - ending.length());
                name = substring + "ый";
            }
        }
        for (String yc : Y_CONSONANTS_PART2) {
            if (name.charAt(name.length() - (ending.length() + 1)) == yc.charAt(0)) {
                String substring = name.substring(0, name.length() - ending.length());
                name = substring + "ий";
            }
        }
        return name;
    }

    protected String checkVowels(String name) {
        for (Map.Entry<String, String> iyc : IY_CASES.entrySet()) {
            if (name.startsWith(iyc.getKey())) {
                name = name.replaceFirst(iyc.getKey(), iyc.getValue());
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> iyc : IY_CASES.entrySet()) {
                name = name.replace(vowel + iyc.getKey(), vowel + iyc.getValue());
            }
            name = name.replace(vowel + "i", vowel + "й");
            name = name.replace(vowel + "y", vowel + "й");
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.RUSSIAN.getName();
    }
}