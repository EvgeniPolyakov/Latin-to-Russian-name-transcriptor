package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Kazakh extends Russian {

    @Override
    protected String checkCustomCases(String name) {
        name = name.replace("ai", "ай");
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
    public String getName() {
        return RulesetName.KAZAKH.getName();
    }
}
