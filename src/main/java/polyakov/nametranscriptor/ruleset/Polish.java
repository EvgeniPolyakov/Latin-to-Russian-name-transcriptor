package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Polish.*;

@Component
public class Polish implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name);
        if (mode != 1) {
            name = checkSurnameEndings(name);
        }
        name = checkSoftConsonants(name);
        if (name.contains("j")) {
            name = checkJ(name);
        }
        name = checkVowels(name);
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkCombinations(name);
        if (name.contains("i")) {
            name = checkIotation(name);
        }
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("ą", "он");
        name = name.replace("c", "ц");
        name = name.replace("ć", "ць");
        name = name.replace("ę", "ен");
        name = name.replace("j", "й");
        name = name.replace("l", "ль");
        name = name.replace("ł", "л");
        name = name.replace("ń", "нь");
        name = name.replace("ó", "у");
        name = name.replace("ś", "сь");
        name = name.replace("x", "кс");
        name = name.replace("y", "ы");
        name = name.replace("ź", "зь");
        name = name.replace("ż", "ж");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("szcz", "щ");
        name = name.replace("ch", "х");
        name = name.replace("czy", "чи");
        name = name.replace("rzy", "жи");
        name = name.replace("szy", "ши");
        name = name.replace("ży", "жи");
        name = name.replace("жy", "жи");
        name = name.replace("чy", "чи");
        name = name.replace("шy", "ши");
        name = name.replace("cz", "ч");
        name = name.replace("sz", "ш");
        name = name.replace("rz", "ж");
        return name;
    }

    private static String checkVowels(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        name = name.replace("ia", "я");
        name = name.replace("ie", "е");
        name = name.replace("cio", "цио");
        name = name.replace("io", "е");
        name = name.replace("ció", "цу");
        name = name.replace("ciu", "цу");
        name = name.replace("ió", "ю");
        name = name.replace("iusz", "иуш");
        name = name.replace("iu", "ю");
        name = name.replace("ciąb", "циомб");
        name = name.replace("ciąp", "циомп");
        name = name.replace("cią", "цион");
        name = name.replace("iąb", "емб");
        name = name.replace("iąp", "емп");
        name = name.replace("ią", "ен");
        name = name.replace("ię", "ę");
        name = name.replace("ąb", "омб");
        name = name.replace("ąp", "омп");
        name = name.replace("ęb", "емб");
        name = name.replace("ęp", "емп");
        return name;
    }

    private static String checkSoftConsonants(String name) {
        if (name.contains("ś")) {
            name = checkSoftS(name);
        }
        if (name.contains("ź")) {
            name = checkSoftZ(name);
        }
        if (name.contains("rz")) {
            name = checkRZ(name);
        }
        if (name.contains("ć")) {
            name = checkSoftC(name);
        }
        return name;
    }

    private static String checkSoftS(String name) {
        if (name.endsWith("ść")) {
            name = name.replace("ść", "сть");
        }
        for (String vowelCombination : List.of("ia", "ió", "iu")) {
            name = name.replace("ść" + vowelCombination, "ст" + vowelCombination);
        }
        for (String consonant : List.of("ć", "l", "ń", "ś", "ź")) {
            name = name.replace("ś" + consonant, "с" + consonant);
        }
        for (String consonant : UTILITY_CONSONANTS) {
            name = name.replace("ś" + consonant + "i", "с" + consonant + "i");
        }
        return name;
    }

    private static String checkSoftZ(String name) {
        for (String consonant : List.of("ć", "l", "ń", "ś", "dź")) {
            name = name.replace("ź" + consonant, "з" + consonant);
        }
        for (String consonant : UTILITY_CONSONANTS) {
            name = name.replace("ź" + consonant + "i", "з" + consonant + "i");
        }
        name = name.replace("źci", "зci");
        return name;
    }

    private static String checkRZ(String name) {
        for (String consonant : List.of("k", "p", "t", "ch")) {
            name = name.replace("rz" + consonant, "ш" + consonant);
            name = name.replace(consonant + "rz", consonant + "ш");
        }
        return name;
    }

    private static String checkSoftC(String name) {
        name = name.replace("ćia", "ця");
        name = name.replace("ćią", "цен");
        name = name.replace("ćie", "це");
        name = name.replace("ćię", "цен");
        name = name.replace("ćio", "це");
        name = name.replace("ćió", "цю");
        name = name.replace("ćiu", "цю");
        return name;
    }

    private static String checkJ(String name) {
        name = checkStartCasesOfJ(name);
        name = checkAfterVowelCasesOfJ(name);
        name = checkAfterConsonantCasesOfJ(name);
        return name;
    }

    private static String checkStartCasesOfJ(String name) {
        for (Map.Entry<String, String> jCombination : J_PRIMARY_START_CASES.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
                break;
            }
        }
        for (Map.Entry<String, String> jCombination : J_CASES.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
                break;
            }
        }
        return name;
    }

    private static String checkAfterVowelCasesOfJ(String name) {
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jCombination : J_PRIMARY_VOWEL_CASES.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
            name = name.replace(vowel + "ją", vowel + "ен");
            name = name.replace(vowel + "ję", vowel + "ен");
            for (Map.Entry<String, String> jCombination : J_CASES.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
        }
        return name;
    }

    private static String checkAfterConsonantCasesOfJ(String name) {
        for (Map.Entry<String, String> jCombination : J_PRIMARY_AFTER_CONSONANT_CASES.entrySet()) {
            name = name.replace(jCombination.getKey(), jCombination.getValue());
        }
        for (Map.Entry<String, String> jCombination : J_CASES_AFTER_CONSONANT_CASES.entrySet()) {
            name = name.replace(jCombination.getKey(), jCombination.getValue());
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("ll", "лl");
        name = name.replace("lь", "ль");
        name = name.replace("ląb", "лемб");
        name = name.replace("ląp", "лемп");
        for (Map.Entry<String, String> entry : L_CASES.entrySet()) {
            name = name.replace(entry.getKey(), entry.getValue());
        }
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "i", vowel + "й");
        }
        return name;
    }

    private static String checkSurnameEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                return name.replace(ending.getKey(), ending.getValue());
            }
        }
        return name;
    }

    private static String checkExceptions(String name) {
        String nameWithNoAccents = StringUtils.stripAccents(name);
        return Optional.ofNullable(NAMES.get(nameWithNoAccents)).orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.POLISH.getName();
    }
}