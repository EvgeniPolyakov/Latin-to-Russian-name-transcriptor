package polyakov.nametranscriptor.ruleset.rulsets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;
import polyakov.nametranscriptor.ruleset.resources.popularnames.GeorgianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Georgian extends Russian {

    @Override
    protected String checkPrimaryCases(String name) {
        if (name.endsWith("aia")) {
            name = name.substring(0, name.length() - 3) + "ая";
        }
        if (name.endsWith("ia")) {
            name = name.substring(0, name.length() - 2) + "ия";
        }
        name = checkExceptions(name);
        name = checkGeorgianCases(name);
        return name;
    }

    private static String checkGeorgianCases(String name) {
        name = name.replace("mja", "мжа");
        name = name.replace("bja", "бжа");
        name = name.replace("q", "к");
        name = name.replace("ia", "иа");
        name = name.replace("ai", "аи");
        name = name.replace("ei", "еи");
        name = name.replace("dj", "дж");
        name = name.replace("j", "дж");
        name = name.replace("ghe", "ге");
        name = name.replace("tch", "ч");
        return name;
    }

    private static String checkExceptions(String name) {
        String nameWithNoAccents = StringUtils.stripAccents(name);
        Map<String, String> names = Arrays.stream(GeorgianNames.values())
                .collect(Collectors.toMap(GeorgianNames::getLatinName, GeorgianNames::getCyrillicName));
        return Optional.ofNullable(names.get(nameWithNoAccents)).orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.GEORGIAN.getName();
    }
}
