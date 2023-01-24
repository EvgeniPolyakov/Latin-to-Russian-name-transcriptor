package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.Map;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Turkish.*;

@Component
public class Turkish implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkStart(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("â", "а");
        name = name.replace("c", "дж");
        name = name.replace("ç", "ч");
        name = name.replace("ğ", "г");
        name = name.replace("ı", "ы");
        name = name.replace("î", "и");
        name = name.replace("j", "ж");
        name = name.replace("l", "л");
        name = name.replace("ö", "е");
        name = name.replace("ș", "ш");
        name = name.replace("ş", "ш");
        name = name.replace("ü", "ю");
        name = name.replace("y", "й");
        return name;
    }

    private static String checkCombinations(String name) {
        for (Map.Entry<String, String> av : STARTERS_AND_AFTER_VOWELS.entrySet()) {
            for (Map.Entry<String, String> vowel : VOWELS.entrySet()) {
                name = name.replace(vowel.getKey() + av.getKey(), vowel.getValue() + av.getValue());
            }
        }
        for (Map.Entry<String, String> afterVowel : STARTERS_AND_AFTER_VOWELS.entrySet()) {
            for (String vowel : CYRILLIC_VOWELS) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
        }
        name = name.replace("gâ", "гя");
        name = name.replace("kâ", "кя");
        name = name.replace("lâ", "ля");
        name = name.replace("yya", "йя");
        name = name.replace("yyu", "йю");
        name = name.replace("yyü", "йю");
        name = name.replace("yı", "йы");
        name = name.replace("yi", "йи");
        name = name.replace("ya", "ья");
        name = name.replace("ye", "ье");
        name = name.replace("yo", "ьо");
        name = name.replace("yö", "ье");
        name = name.replace("yu", "ью");
        name = name.replace("yü", "ью");
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

    @Override
    public String getName() {
        return RulesetName.TURKISH.getName();
    }
}
