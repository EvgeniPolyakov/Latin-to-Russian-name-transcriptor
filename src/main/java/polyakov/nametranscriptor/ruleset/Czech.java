package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.Map;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Czech.*;

@Component
public class Czech implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkStart(name);
        if (mode == 1) {
            name = checkEndings(name);
        }
        name = checkVowels(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    protected static String mapSingleChars(String name) {
        name = name.replace("á", "а");
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("ď", "дь");
        name = name.replace("é", "е");
        name = name.replace("ě", "е");
        name = name.replace("h", "г");
        name = name.replace("í", "и");
        name = name.replace("j", "й");
        name = name.replace("l", "л");
        name = name.replace("ň", "нь");
        name = name.replace("ó", "о");
        name = name.replace("ř", "рш");
        name = name.replace("š", "ш");
        name = name.replace("ť", "ть");
        name = name.replace("ú", "у");
        name = name.replace("ů", "у");
        name = name.replace("x", "кс");
        name = name.replace("y", "ы");
        name = name.replace("ý", "ы");
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
        name = name.replace("jó", "ье");
        name = name.replace("ju", "ью");
        name = name.replace("jů", "ью");
        name = name.replace("yá", "иа");
        name = name.replace("ya", "иа");
        return name;
    }

    protected static String checkVowels(String name) {
        if (name.endsWith("ia")) {
            name = name.replaceFirst("ia", "ия");
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> afterVowel : STARTERS.entrySet()) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
            name = name.replace(vowel + "jo", vowel + "е");
            name = name.replace(vowel + "jó", vowel + "е");
            name = name.replace(vowel + "y", vowel + "й");
            name = name.replace(vowel + "ý", vowel + "й");
            name = name.replace(vowel + "ř", vowel + "рж");
        }
        for (String consonant : Y_CASE_CONSONANTS) {
            name = name.replace(consonant + "y", consonant + "и");
            name = name.replace(consonant + "ý", consonant + "и");
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
        if (name.startsWith("jó")) {
            return name.replaceFirst("jó", "йо");
        }
        if (name.startsWith("ř")) {
            return name.replaceFirst("ř", "рж");
        }
        return name;
    }

    protected static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                return name.replace(ending.getKey(), ending.getValue());
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.CZECH.getName();
    }
}