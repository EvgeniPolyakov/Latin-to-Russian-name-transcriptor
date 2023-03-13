package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Czech.*;

@Component
public class Czech extends RulesetImpl {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, TRUE);
        name = normalizeAccents(name);
        name = checkStart(name);
        if (mode != 1) {
            name = checkEndings(name);
        }
        name = checkVowels(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    protected static String mapSingleChars(String name) {
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ď", "дь");
        name = name.replace("ě", "е");
        name = name.replace("h", "г");
        name = name.replace("j", "й");
        name = name.replace("l", "л");
        name = name.replace("ň", "нь");
        name = name.replace("ř", "рш");
        name = name.replace("š", "ш");
        name = name.replace("ť", "ть");
        name = name.replace("x", "кс");
        name = name.replace("y", "ы");
        name = name.replace("ž", "ж");
        return name;
    }

    protected static String checkCombinations(String name) {
        for (Map.Entry<String, String> cons : UTILITY_CONSONANTS.entrySet()) {
            for (Map.Entry<String, String> vowel : AFTER_DNT.entrySet()) {
                name = name.replace(cons.getKey() + vowel.getKey(), cons.getValue() + vowel.getValue());
            }
        }
        for (String consonant : VOICED_CONSONANTS) {
            name = name.replace(consonant + "ř", consonant + "рж");
        }
        name = name.replace("ch", "х");
        name = name.replace("qu", "ку");
        name = name.replace("th", "т");
        name = name.replace("ja", "ья");
        name = name.replace("je", "ье");
        name = name.replace("ji", "ьи");
        name = name.replace("jo", "ье");
        name = name.replace("ju", "ью");
        name = name.replace("ya", "иа");
        return name;
    }

    protected static String normalizeAccents(String name) {
        name = name.replace("á", "a");
        name = name.replace("é", "e");
        name = name.replace("í", "i");
        name = name.replace("ó", "o");
        name = name.replace("ú", "u");
        name = name.replace("ů", "u");
        name = name.replace("ý", "y");
        return name;
    }

    protected static String checkVowels(String name) {
        if (name.endsWith("ia")) {
            name = name.substring(0, name.length() - 2) + "ия";
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> afterVowel : STARTERS.entrySet()) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
            name = name.replace(vowel + "jo", vowel + "е");
            name = name.replace(vowel + "y", vowel + "й");
            name = name.replace(vowel + "ř", vowel + "рж");
        }
        for (String consonant : Y_CASE_CONSONANTS) {
            name = name.replace(consonant + "y", consonant + "и");
        }
        return name;
    }

    protected static String checkStart(String name) {
        for (Map.Entry<String, String> startingPart : STARTERS.entrySet()) {
            if (name.startsWith(startingPart.getKey())) {
                return name.replaceFirst(startingPart.getKey(), startingPart.getValue());
            }
        }
        if (name.startsWith("jo")) {
            return name.replaceFirst("jo", "йо");
        }
        if (name.startsWith("ř")) {
            return name.replaceFirst("ř", "рж");
        }
        return name;
    }

    protected static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.CZECH.getName();
    }
}