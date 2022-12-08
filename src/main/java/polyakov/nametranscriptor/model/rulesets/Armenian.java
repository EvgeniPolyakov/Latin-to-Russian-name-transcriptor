package polyakov.nametranscriptor.model.rulesets;

import polyakov.nametranscriptor.model.rulesets.names.ArmenianNames;

import java.util.Arrays;
import java.util.Optional;

public class Armenian extends Russian {

    @Override
    protected String checkCustomCases(String name) {
        Optional<String> os = checkCustomNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        if (name.endsWith("ian")) {
            name = name.replace("ian", "ян");
        }
        if (name.startsWith("hay")) {
            name = name.replace("hay", "оганес");
        }
        if (name.startsWith("hovhannes")) {
            name = name.replace("hovhannes", "оганес");
        }
        if (name.startsWith("hambardz")) {
            name = name.replace("hambardz", "амбарц");
        }
        if (name.startsWith("hakob")) {
            name = name.replace("hakob", "акоп");
        }
        if (name.startsWith("ha")) {
            name = name.replace("ha", "а");
        }
        name = name.replace("ghaza", "каза");
        name = name.replace("j", "дж");
        name = name.replace("gh", "г");
        name = name.replace("aha", "аа");
        return super.checkCustomCases(name);
    }

    private Optional<String> checkCustomNames(String name) {
        return Arrays.stream(ArmenianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(ArmenianNames::getCyrillicName);
    }
}
