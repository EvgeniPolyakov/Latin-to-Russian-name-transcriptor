package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Bulgarian extends Russian {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkPrimaryCases(name);
        name = checkStart(name);
        name = checkEndings(name);
        name = checkVowels(name);
        name = checkBulgarianChars(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        name = checkYer(name);
        return postcheck(name);
    }

    private String checkBulgarianChars(String name) {
        name = name.replace("ŝ", "шт");
        name = name.replace("č", "ч");
        name = name.replace("š", "ш");
        name = name.replace("ž", "ж");
        name = name.replace("û", "ю");
        name = name.replace("sch", "сч");
        name = name.replace("shch", "шч");
        return name;
    }

    private String checkYer(String name) {
        List<String> yers = List.of("â", "ă", "`a");
        for (String s : yers) {
            if (name.startsWith(s)) {
                name = name.replaceFirst(s, "и");
            }
            name = name.replace("ж" + s, "же");
            name = name.replace("ш" + s, "ше");
            name = name.replace("ц" + s, "це");
            name = name.replace(s, "ы");
        }
        return name;
    }

    private String postcheck(String name) {
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