package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.AzeriNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Azeri.*;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;

@Component
public class Azeri extends RulesetImpl {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name);
        name = checkEndings(name);
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkStart(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("â", "а");
        name = name.replace("ə", "а");
        name = name.replace("ç", "ч");
        name = name.replace("c", "дж");
        name = name.replace("ğ", "г");
        name = name.replace("x", "х");
        name = name.replace("ı", "ы");
        name = name.replace("î", "и");
        name = name.replace("j", "дж");
        name = name.replace("l", "ль");
        name = name.replace("ö", "е");
        name = name.replace("q", "г");
        name = name.replace("ș", "ш");
        name = name.replace("ş", "ш");
        name = name.replace("ü", "ю");
        name = name.replace("y", "й");
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

    private static String checkExceptions(String name) {
        String nameWithNoAccents = StringUtils.stripAccents(name);
        Optional<String> azeriName = Optional.ofNullable(AZERI_NAMES.get(nameWithNoAccents));
        if (azeriName.isPresent()) {
            return azeriName.get();
        }
        Optional<String> azeriSurname = checkAzeriSurname(nameWithNoAccents);
        if (azeriSurname.isPresent()) {
            name = azeriSurname.get();
        }
        Optional<String> russianName = Optional.ofNullable(RUSSIAN_NAMES.get(nameWithNoAccents));
        return russianName.orElse(name);
    }

    private static Optional<String> checkAzeriSurname(String name) {
        return Arrays.stream(AzeriNames.values())
                .filter(s -> name.startsWith(s.getLatinName()))
                .findAny()
                .map(s -> name.replaceFirst(s.getLatinName(), s.getCyrillicName()));
    }

    @Override
    public String getName() {
        return RulesetName.AZERI.getName();
    }
}
