package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

@Component
public class Macedonian extends Bulgarian {

    @Override
    public String transcribe(String name, int mode) {
        name = checkBalkanChars(name);
        if (name.contains("j")) {
            name = checkMacedonianCases(name);
        }
        return super.transcribe(name, mode);
    }

    private static String checkBalkanChars(String name) {
        name = name.replace("ć", "ч");
        name = name.replace("đ", "дж");
        name = name.replace("š", "ш");
        name = name.replace("ž", "ж");
        name = name.replace("̂ḱ", "ч");
        name = name.replace("ǵ", "gj");
        name = name.replace("d̂", "дж");
        name = name.replace("n̂", "nj");
        return name;
    }

    private static String checkMacedonianCases(String name) {
        name = name.replace("lja", "ля");
        name = name.replace("lje", "ле");
        name = name.replace("lji", "ли");
        name = name.replace("ljo", "ле");
        name = name.replace("lju", "лю");
        name = name.replace("lj", "ль");
        name = name.replace("nja", "ня");
        name = name.replace("nje", "не");
        name = name.replace("nji", "ни");
        name = name.replace("njo", "не");
        name = name.replace("nju", "ню");
        name = name.replace("nj", "нь");
        name = name.replace("gja", "джя");
        name = name.replace("gjo", "дже");
        name = name.replace("gju", "джю");
        name = name.replace("gj", "дж");
        name = name.replace("kj", "ч");
        name = name.replace("dj", "дж");
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.MACEDONIAN.getName();
    }
}