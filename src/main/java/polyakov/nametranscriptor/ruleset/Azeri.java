package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.AzeriNames;
import polyakov.nametranscriptor.ruleset.resources.popularnames.RussianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Azeri.*;

@Component
public class Azeri implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkName(name);
        name = checkEndings(name);
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkStart(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("â", "а");
        name = name.replace("ə", "а");
        name = name.replace("b", "б");
        name = name.replace("ç", "ч");
        name = name.replace("c", "дж");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("ğ", "г");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("x", "х");
        name = name.replace("ı", "ы");
        name = name.replace("i", "и");
        name = name.replace("î", "и");
        name = name.replace("j", "дж");
        name = name.replace("k", "к");
        name = name.replace("l", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("ö", "е");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("q", "г");
        name = name.replace("r", "р");
        name = name.replace("ș", "ш");
        name = name.replace("ş", "ш");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("ü", "ю");
        name = name.replace("v", "в");
        name = name.replace("y", "й");
        name = name.replace("z", "з");
        return name;
    }

    private static String checkCombinations(String name) {
        for (Map.Entry<String, String> afterVowel : STARTERS_AND_AFTER_VOWELS.entrySet()) {
            for (String vowel : VOWELS) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
        }
        for (Map.Entry<String, String> afterVowel : STARTERS_AND_AFTER_VOWELS.entrySet()) {
            for (String vowel : CYRILLIC_VOWELS) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
        }
        name = name.replace("yı", "йы");
        name = name.replace("yi", "йи");
        name = name.replace("ya", "ья");
        name = name.replace("yə", "ья");
        name = name.replace("ye", "ье");
        name = name.replace("yo", "ье");
        name = name.replace("yö", "ье");
        name = name.replace("yu", "ью");
        name = name.replace("yü", "ью");
        name = name.replace("gh", "г");
        name = name.replace("kh", "х");
        name = name.replace("ts", "ц");
        name = name.replace("ch", "ч");
        name = name.replace("sh", "ш");
        name = name.replace("zh", "ж");
        return name;
    }

    private static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("ll", "лl");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
        }
        for (String vowel : UTILITY_VOWELS) {
            name = name.replace(vowel + "l", vowel + "л");
        }
        return name;
    }

    private static String checkStart(String name) {
        for (Map.Entry<String, String> starter : STARTERS_AND_AFTER_VOWELS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        return name;
    }

    private static String checkName(String name) {
        Optional<String> azeriName = checkAzeriNames(name);
        if (azeriName.isPresent()) {
            return azeriName.get();
        }
        Optional<String> azeriSurname = checkAzeriSurname(name);
        if (azeriSurname.isPresent()) {
            name = azeriSurname.get();
        }
        Optional<String> russianName = checkRussianNames(name);
        return russianName.orElse(name);
    }

    private static Optional<String> checkAzeriNames(String name) {
        return Arrays.stream(AzeriNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(AzeriNames::getCyrillicName);
    }

    private static Optional<String> checkAzeriSurname(String name) {
        return Arrays.stream(AzeriNames.values())
                .filter(s -> name.startsWith(s.getLatinName()))
                .findAny()
                .map(s -> name.replaceFirst(s.getLatinName(), s.getCyrillicName()));
    }

    private static Optional<String> checkRussianNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.AZERI.getName();
    }
}
