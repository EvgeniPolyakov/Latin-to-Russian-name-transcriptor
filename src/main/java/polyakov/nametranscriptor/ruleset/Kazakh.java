package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.Map;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.ENDINGS;

@Component
public class Kazakh extends Russian {

    @Override
    protected String checkPrimaryCases(String name) {
        name = name.replace("ss", "с");
        name = name.replace("j", "ж");
        name = name.replace("J", "Ж");
        name = name.replace("gulm", "гульм");
        name = name.replace("guln", "гульн");
        if (name.endsWith("gul")) {
            return name.substring(0, name.length() - 3) + "гуль";
        }
        if (name.endsWith("dil")) {
            return name.substring(0, name.length() - 3) + "диль";
        }
        return name;
    }

    @Override
    protected String checkEndings(String name) {
        if (name.endsWith("tskyi") || name.endsWith("tskiy")) {
            return name.substring(0, name.length() - 5) + "цкий";
        }
        if (name.endsWith("tsky") || name.endsWith("tski")) {
            return name.substring(0, name.length() - 4) + "цкий";
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        if (name.endsWith("ia")) {
            return name.substring(0, name.length() - 2) + "ия";
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.KAZAKH.getName();
    }
}
