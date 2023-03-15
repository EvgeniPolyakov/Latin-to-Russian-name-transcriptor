package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Map;

@Component
public class Georgian extends Russian {
    public static final Map<String, String> NAMES = Map.ofEntries(
            Map.entry("aleksandre", "александр"),
            Map.entry("davit", "давид"),
            Map.entry("mikheil", "михаил"),
            Map.entry("giorgi", "георгий"),
            Map.entry("teimuraz", "теймураз")
    );

    @Override
    protected String checkPrimaryCases(String name) {
        if (name.endsWith("aia")) {
            name = name.substring(0, name.length() - 3) + "ая";
        }
        if (name.endsWith("ia")) {
            name = name.substring(0, name.length() - 2) + "ия";
        }
        for (Map.Entry<String, String> firstName : NAMES.entrySet()) {
            if (name.equals(firstName.getKey())) {
                name = name.replace(firstName.getKey(), firstName.getValue());
                break;
            }
        }
        name = name.replace("mja", "мжа");
        name = name.replace("bja", "бжа");
        name = name.replace("q", "к");
        name = name.replace("ia", "иа");
        name = name.replace("ai", "аи");
        name = name.replace("ei", "еи");
        name = name.replace("dj", "дж");
        name = name.replace("j", "дж");
        name = name.replace("J", "Дж");
        name = name.replace("ghe", "ге");
        name = name.replace("tch", "ч");
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.GEORGIAN.getName();
    }
}
