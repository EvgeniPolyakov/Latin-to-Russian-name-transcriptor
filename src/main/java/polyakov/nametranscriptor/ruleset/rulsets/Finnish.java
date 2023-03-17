package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;
import polyakov.nametranscriptor.ruleset.RulesetWithIotation;

import java.util.List;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Finnish.*;

@Component
public class Finnish extends RulesetWithIotation {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, FALSE);
        if (name.contains("c")) {
            name = checkCasesOfC(name);
        }
        name = checkVowels(name);
        name = checkStart(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkIotation(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("ä", "я");
        name = name.replace("å", "о");
        name = name.replace("c", "к");
        name = name.replace("j", "й");
        name = name.replace("l", "ль");
        name = name.replace("ö", "е");
        name = name.replace("ü", "ю");
        name = name.replace("x", "кс");
        name = name.replace("y", "ю");
        name = name.replace("z", "с");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("äy", "яу");
        name = name.replace("ch", "к");
        name = name.replace("ck", "к");
        name = name.replace("öy", "еу");
        name = name.replace("qu", "кв");
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ck" + vowel2, vowel + "кк" + vowel2);
            }
            if (name.endsWith(vowel + "ck")) {
                return name.substring(0, name.length() - 2) + "кк";
            }
        }
        if (name.endsWith("ia")) {
            return name.substring(0, name.length() - 2) + "ия";
        }
        return name;
    }

    private static String checkStart(String name) {
        if (name.startsWith("äy")) {
            return name.replaceFirst("äy", "эу");
        }
        if (name.startsWith("ää")) {
            return name.replaceFirst("ää", "ээ");
        }
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            if (!vowel.equals("i") && !vowel.equals("и")) {
                name = name.replace(vowel + "i", vowel + "й");
                name = name.replace(vowel + "e", vowel + "э");
            }
        }
        return name;
    }

    private static String checkCasesOfC(String name) {
        for (String vowel : List.of("e", "i", "y")) {
            name = name.replace("c" + vowel, "с" + vowel);
            name = name.replace("ch" + vowel, "ч" + vowel);
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("ll", "лl");
        name = name.replace("lь", "ль");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
        }
        if (name.endsWith("l")) {
            return name.substring(0, name.length() - 1) + "ль";
        }
        for (String vowel : List.of("a", "o", "u")) {
            name = name.replace(vowel + "l", vowel + "л");
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        name = name.replace("jii", "йий");
        name = name.replace("ji", "йи");
        name = name.replace("jo", "йо");
        name = checkIotation(name, VOWELS, J_CASES, J_CASES_AFTER_CONSONANTS);
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.FINNISH.getName();
    }
}