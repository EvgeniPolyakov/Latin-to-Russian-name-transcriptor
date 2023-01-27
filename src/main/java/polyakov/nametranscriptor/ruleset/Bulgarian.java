package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;

@Component
public class Bulgarian extends Russian {

    @Override
    public String transcribe(String name, int mode) {
        name = checkName(name);
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
        List<String> yers = List.of("â", "ă", "`a");
        for (String yer : yers) {
            if (name.startsWith(yer)) {
                name = name.replaceFirst(yer, "и");
            }
            name = name.replace("ж" + yer, "же");
            name = name.replace("ш" + yer, "ше");
            name = name.replace("ц" + yer, "це");
            name = name.replace(yer, "ы");
        }
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

    private static String checkName(String name) {
        return Optional.ofNullable(RUSSIAN_NAMES.get(name)).orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.BULGARIAN.getName();
    }
}