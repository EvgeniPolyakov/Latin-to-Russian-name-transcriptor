package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;

@Component
public class Bulgarian extends Russian {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, RUSSIAN_NAMES, TRUE);
        name = checkPrimaryCases(name);
        name = checkStart(name);
        name = checkEndings(name);
        name = checkVowels(name);
        name = checkBulgarianChars(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        name = mapStandardChars(name);
        name = checkYerCases(name);
        return postcheck(name);
    }

    private static String checkBulgarianChars(String name) {
        name = name.replace("ŝ", "шт");
        name = name.replace("č", "ч");
        name = name.replace("š", "ш");
        name = name.replace("ž", "ж");
        name = name.replace("û", "ю");
        name = name.replace("sch", "сч");
        name = name.replace("shch", "шч");
        return name;
    }

    private static String checkYerCases(String name) {
        name = name.replace("ă", "â");
        if (name.startsWith("â")) {
            name = name.replaceFirst("â", "и");
        }
        name = name.replace("жâ", "же");
        name = name.replace("шâ", "ше");
        name = name.replace("цâ", "це");
        name = name.replace("â", "ы");
        return name;
    }

    private static String postcheck(String name) {
        if (!name.startsWith("йо")) {
            name = name.replace("йо", "е");
        }
        name = name.replace("ьо", "е");
        if (name.endsWith("ский")) {
            name = name.substring(0, name.length() - 1);
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.BULGARIAN.getName();
    }
}