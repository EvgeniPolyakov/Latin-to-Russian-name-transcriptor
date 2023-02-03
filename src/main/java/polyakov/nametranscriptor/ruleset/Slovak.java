package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

@Component
public class Slovak extends Czech {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name);
        name = normalizeAccents(name);
        name = checkStart(name);
        if (mode != 1) {
            name = checkEndings(name);
        }
        name = checkVowels(name);
        name = checkSlovakCombinations(name);
        name = checkCombinations(name);
        name = checkSlovakChars(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String checkSlovakCombinations(String name) {
        name = name.replace("ľa", "ля");
        name = name.replace("ľo", "ле");
        name = name.replace("ľu", "лю");
        name = name.replace("čia", "ча");
        name = name.replace("šia", "ша");
        name = name.replace("ia", "ья");
        name = name.replace("čiu", "чу");
        name = name.replace("šiu", "шу");
        name = name.replace("iu", "ью");
        name = name.replace("iэ", "ье");
        return name;
    }

    private static String checkSlovakChars(String name) {
        name = name.replace("ä", "е");
        name = name.replace("ô", "уо");
        name = name.replace("ĺ", "л");
        name = name.replace("ľ", "ль");
        name = name.replace("ŕ", "р");
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.SLOVAK.getName();
    }
}