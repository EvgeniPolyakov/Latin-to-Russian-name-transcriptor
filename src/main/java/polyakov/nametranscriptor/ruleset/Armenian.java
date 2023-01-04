package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.ArmenianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Component
public class Armenian extends Russian {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("hay", "ай"),
            Map.entry("hakob", "акоп"),
            Map.entry("hovhann", "оган"),
            Map.entry("hambardz", "амбарц")
    );

    @Override
    protected String checkPrimaryCases(String name) {
        Optional<String> os = checkCustomNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        if (name.endsWith("ian") || name.endsWith("yan")) {
            String sub = name.substring(0, name.length() - 3);
            name = sub + "ян";
        }
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                name = name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("hovhan")) {
            name = name.replaceFirst("hovhan", "оган");
        }
        if (name.startsWith("ha")) {
            name = name.replaceFirst("ha", "а");
        }
        name = name.replace("ghaza", "каза");
        name = name.replace("j", "дж");
        name = name.replace("gh", "г");
        name = name.replace("aha", "аа");
        return super.checkEndings(name);
    }

    private Optional<String> checkCustomNames(String name) {
        return Arrays.stream(ArmenianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(ArmenianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.ARMENIAN.getName();
    }
}
