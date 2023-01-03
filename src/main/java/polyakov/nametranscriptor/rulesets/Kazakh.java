package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

import java.util.Map;

import static polyakov.nametranscriptor.rulesets.customrules.Russian.ENDINGS;

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
            String sub = name.substring(0, name.length() - 3);
            name = sub + "гуль";
        }
        if (name.endsWith("dil")) {
            String sub = name.substring(0, name.length() - 3);
            name = sub + "диль";
        }
        return name;
    }

    @Override
    protected String checkEndings(String name) {
        if (name.endsWith("tskyi") || name.endsWith("tskiy")) {
            String sub = name.substring(0, name.length() - 5);
            name = sub + "цкий";
        }
        if (name.endsWith("tsky") || name.endsWith("tski")) {
            String sub = name.substring(0, name.length() - 4);
            name = sub + "цкий";
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                name = sub + ending.getValue();
            }
        }
        if (name.endsWith("ia")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "ия";
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.KAZAKH.getName();
    }
}
