package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Albanian.*;

@Component
public class Albanian implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name);
        name = checkPrimaryCases(name);
        if (name.contains("ë")) {
            name = checkCasesOfDiaeresisE(name);
        }
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = checkVowels(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        name = mapStandardChars(name);
        return postCheck(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("c", "ц");
        name = name.replace("ç", "ч");
        name = name.replace("ë", "е");
        name = name.replace("j", "й");
        name = name.replace("l", "ль");
        name = name.replace("q", "кь");
        name = name.replace("š", "ш");
        name = name.replace("x", "дз");
        name = name.replace("y", "ю");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("dh", "д");
        name = name.replace("th", "т");
        name = name.replace("rr", "рр");
        name = name.replace("sh", "ш");
        name = name.replace("xh", "дж");
        name = name.replace("zh", "ж");
        name = name.replace("gj", "гь");
        name = name.replace("nj", "нь");
        name = name.replace("ja", "ья");
        name = name.replace("je", "ье");
        name = name.replace("jë", "ье");
        name = name.replace("ji", "ьи");
        name = name.replace("jo", "ьо");
        name = name.replace("ju", "ью");
        name = name.replace("jy", "ью");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("ll", "л");
        name = name.replace("ҫ", "ç");
        name = name.replace("ć", "ç");
        name = name.replace("č", "ç");
        if (name.startsWith("ë")) {
            name = name.replaceFirst("ë", "э");
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jCombination : J_VOWEL_CASES.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
        }
        for (Map.Entry<String, String> jCombination : J_VOWEL_CASES.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
            }
        }
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "e", vowel + "э");
            name = name.replace(vowel + "ë", vowel + "э");
        }
        for (Map.Entry<String, String> cons : SOFT_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> vowel : SOFTENED_VOWELS.entrySet()) {
                name = name.replace(cons.getKey() + vowel.getKey(), cons.getValue() + vowel.getValue());
            }
        }
        return name;
    }

    private static String checkCasesOfDiaeresisE(String name) {
        for (Map.Entry<String, String> consonant : SOFT_CONSONANTS.entrySet()) {
            if (name.endsWith(consonant.getKey() + "ë")) {
                String sub = name.substring(0, name.length() - consonant.getKey().length() - 1);
                return sub + consonant.getValue() + "я";
            }
        }
        if (name.endsWith("jë")) {
            return name.substring(0, name.length() - 2) + "я";
        }
        if (name.endsWith("ë")) {
            return name.substring(0, name.length() - 1) + "а";
        }
        return name;
    }

    private static String postCheck(String name) {
        if (name.endsWith("кь")) {
            return name.replace("кь", "ч");
        }
        name = name.replaceFirst("льь", "ль");
        return name;
    }

    private static String checkExceptions(String name) {
        return Optional.ofNullable(NAMES.get(name)).orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.ALBANIAN.getName();
    }
}