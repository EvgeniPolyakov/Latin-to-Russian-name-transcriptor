package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.DefaultRuleset;
import polyakov.nametranscriptor.ruleset.RulesetName;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Czech.*;

@Component
public class Slovak extends Czech {

    @Override
    public String transcribe(String name, int mode) {
        name = DefaultRuleset.checkExceptions(name, NAMES, TRUE);
        name = normalizeAccents(name);
        name = checkStart(name, STARTERS);
        if (mode != 1) {
            name = DefaultRuleset.checkEndings(name, ENDINGS);
        }
        name = checkVowels(name);
        name = checkSlovakCombinations(name);
        name = checkConsonants(name);
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