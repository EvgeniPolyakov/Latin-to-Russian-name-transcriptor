package polyakov.nametranscriptor.model.rulesets;

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
            name = name.replace("gul", "гуль");
        }
        if (name.endsWith("dil")) {
            name = name.replace("dil", "диль");
        }
        return name;
    }
}
