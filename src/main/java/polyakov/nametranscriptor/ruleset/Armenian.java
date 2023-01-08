package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.ArmenianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Armenian.STARTERS;

@Component
public class Armenian extends Russian {

    @Override
    protected String checkPrimaryCases(String name) {
        Optional<String> checkedName = checkArmenianNames(name);
        if (checkedName.isPresent()) {
            return checkedName.get();
        }
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

    private static Optional<String> checkArmenianNames(String name) {
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
