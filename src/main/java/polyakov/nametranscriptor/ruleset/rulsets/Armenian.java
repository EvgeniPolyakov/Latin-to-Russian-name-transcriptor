package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Armenian.ARMENIAN_NAMES;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Armenian.STARTERS;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;

@Component
public class Armenian extends Russian {

    @Override
    protected String checkPrimaryCases(String name) {
        name = checkExceptions(name);
        if (name.endsWith("ian") || name.endsWith("yan")) {
            name = name.substring(0, name.length() - 3) + "ян";
        }
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                name = name.replaceFirst(starter.getKey(), starter.getValue());
                break;
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

    private static String checkExceptions(String name) {
        Optional<String> armenianName = Optional.ofNullable(ARMENIAN_NAMES.get(name));
        if (armenianName.isPresent()) {
            return armenianName.get();
        }
        Optional<String> russianName = Optional.ofNullable(RUSSIAN_NAMES.get(name));
        return russianName.orElse(name);
    }

    @Override
    public String getName() {
        return RulesetName.ARMENIAN.getName();
    }
}
