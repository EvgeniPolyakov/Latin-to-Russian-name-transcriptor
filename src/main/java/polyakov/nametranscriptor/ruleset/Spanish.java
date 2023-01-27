package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Spanish.*;

@Component
public class Spanish implements Ruleset {
    @Override
    public String transcribe(String name, int mode) {
        name = checkName(name);
        name = normalizeAccents(name);
        name = checkPrimaryCases(name);
        name = checkSoftenedVowels(name);
        name = checkVowels(name);
        if (name.contains("y")) {
            name = checkCasesOfY(name);
        }
        if (name.contains("i")) {
            name = checkIotation(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkStart(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("c", "к");
        name = name.replace("h", "");
        name = name.replace("j", "х");
        name = name.replace("í", "и");
        name = name.replace("l", "ль");
        name = name.replace("ñ", "нь");
        name = name.replace("ü", "у");
        name = name.replace("x", "кс");
        name = name.replace("y", "и");
        name = name.replace("z", "с");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("dz", "ц");
        name = name.replace("ch", "ч");
        name = name.replace("ix", "ш");
        name = name.replace("jh", "дж");
        name = name.replace("sh", "ш");
        name = name.replace("tx", "ч");
        name = name.replace("tz", "ц");
        return name;
    }

    private static String normalizeAccents(String name) {
        name = name.replace("á", "a");
        name = name.replace("à", "a");
        name = name.replace("é", "e");
        name = name.replace("è", "e");
        name = name.replace("ì", "í");
        name = name.replace("ó", "o");
        name = name.replace("ò", "o");
        name = name.replace("ú", "u");
        name = name.replace("ù", "u");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("ce", "сe");
        name = name.replace("ci", "сi");
        name = name.replace("cí", "сi");
        name = name.replace("ge", "хe");
        name = name.replace("gi", "хi");
        name = name.replace("gí", "хi");
        name = name.replace("gue", "гe");
        name = name.replace("gui", "гi");
        name = name.replace("que", "кe");
        name = name.replace("qui", "кi");
        return name;
    }

    private static String checkSoftenedVowels(String name) {
        for (Map.Entry<String, String> cons : SOFT_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> vowel : SOFTENED_VOWELS.entrySet()) {
                name = name.replace(cons.getKey() + vowel.getKey(), cons.getValue() + vowel.getValue());
            }
        }
        return name;
    }

    private static String checkVowels(String name) {
        if (name.endsWith("ia") || name.endsWith("ía")) {
            name = name.substring(0, name.length() - 2) + "ия";
        }
        if (name.endsWith("io")) {
            name = name.substring(0, name.length() - 2) + "ио";
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> afterVowel : AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
            if (!vowel.equals("i") && !vowel.equals("y")) {
                name = name.replace(vowel + "e", vowel + "э");
            }
            name = name.replace("l" + vowel, "л" + vowel);
        }
        for (Map.Entry<String, String> ivc : I_VOWEL_COMBINATIONS.entrySet()) {
            for (String consonant : List.of("b", "d", "f", "t", "p", "r")) {
                name = name.replace(consonant + "r" + ivc.getKey(), consonant + "r" + ivc.getValue());
            }
        }
        name = name.replace("ia", "ья");
        name = name.replace("ía", "иа");
        name = name.replace("ie", "ье");
        name = name.replace("io", "ьо");
        name = name.replace("iu", "ью");
        name = name.replace("ui", "уи");
        return name;
    }

    private static String checkStart(String name) {
        if (name.startsWith("h")) {
            name = name.substring(1);
        }
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        return name;
    }

    private static String checkCasesOfY(String name) {
        name = name.replace("yu", "ю");
        for (Map.Entry<String, String> yCombination : Y_CASES.entrySet()) {
            if (name.startsWith(yCombination.getKey())) {
                name = name.replaceFirst(yCombination.getKey(), yCombination.getValue());
                break;
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> yCombination : Y_CASES.entrySet()) {
                name = name.replace(vowel + yCombination.getKey(), vowel + yCombination.getValue());
            }
            name = name.replace(vowel + "ya", vowel + "йя");
        }
        for (Map.Entry<String, String> yCombination : Y_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(yCombination.getKey(), yCombination.getValue());
        }
        name = name.replace("ya", "я");
        if (name.contains("y")) {
            for (String vowel : VOWELS) {
                name = name.replace(vowel + "y", vowel + "й");
            }
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("ll", "ль");
        name = name.replace("lль", "ль");
        name = name.replace("lл", "ль");
        name = name.replace("lь", "ль");
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "i", vowel + "й");
        }
        return name;
    }

    private static String checkName(String name) {
        return Optional.ofNullable(NAMES.get(StringUtils.stripAccents(name))).orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.SPANISH.getName();
    }
}