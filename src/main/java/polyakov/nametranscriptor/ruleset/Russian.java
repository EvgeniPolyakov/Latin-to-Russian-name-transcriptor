package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.RussianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.*;

@Component
public class Russian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkPrimaryCases(name);
        Optional<String> checkedName = checkPopularNames(name);
        if (checkedName.isPresent()) {
            return checkedName.get();
        }
        name = checkStart(name);
        name = checkEndings(name);
        if (name.contains("i") || name.contains("y")) {
            name = checkVowels(name);
        }
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    protected static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("k", "к");
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
        name = name.replace("w", "в");
        name = name.replace("y", "ы");
        name = name.replace("x", "кс");
        name = name.replace("z", "з");
        name = name.replace("'", "ь");
        return name;
    }

    protected static String checkCombinations(String name) {
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
            return name.substring(0, name.length() - 2) + "iy";
        }
        return name;
    }

    protected static String checkStart(String name) {
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("e")) {
            return name.replaceFirst("e", "э");
        }
        return name;
    }

    protected String checkEndings(String name) {
        if (name.endsWith("tskyi") || name.endsWith("tskiy")) {
            return name.substring(0, name.length() - 5) + "цкий";
        }
        if (name.endsWith("tsky") || name.endsWith("tski")) {
            return name.substring(0, name.length() - 4) + "цкий";
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        if (name.endsWith("ia")) {
            return name.substring(0, name.length() - 2) + "ия";
        }
        if (name.contains("y")) {
            for (String ending : CUSTOM_ENDINGS) {
                if (name.length() > 1 && name.endsWith(ending)) {
                    name = checkCasesOfYEndings(name, ending);
                }
            }
        }
        return name;
    }

    private static String checkCasesOfYEndings(String name, String ending) {
        for (String consonant : Y_CONSONANTS_TIER_ONE) {
            if (name.charAt(name.length() - (ending.length() + 1)) == consonant.charAt(0)) {
                return name.substring(0, name.length() - ending.length()) + "ый";
            }
        }
        for (String consonant : Y_CONSONANTS_TIER_TWO) {
            if (name.charAt(name.length() - (ending.length() + 1)) == consonant.charAt(0)) {
                return name.substring(0, name.length() - ending.length()) + "ий";
            }
        }
        return name;
    }

    protected static String checkVowels(String name) {
        for (Map.Entry<String, String> vowels : IY_CASES.entrySet()) {
            if (name.startsWith(vowels.getKey())) {
                name = name.replaceFirst(vowels.getKey(), vowels.getValue());
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> afterVowels : IY_CASES.entrySet()) {
                name = name.replace(vowel + afterVowels.getKey(), vowel + afterVowels.getValue());
            }
            name = name.replace(vowel + "i", vowel + "й");
            name = name.replace(vowel + "y", vowel + "й");
        }
        return name;
    }

    protected static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.RUSSIAN.getName();
    }
}