package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.rulesets.names.ArmenianNames;

import java.util.Arrays;
import java.util.Optional;

@Component
public class Armenian extends Russian {

    @Override
    protected String checkCustomCases(String name) {
        Optional<String> os = checkCustomNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        if (name.endsWith("ian")) {
            String sub = name.substring(0, name.length() - 3);
            name = sub + "ян";
        }
        if (name.startsWith("hay")) {
            name = name.replaceFirst("hay", "ай");
        }
        if (name.startsWith("hovhannes")) {
            name = name.replaceFirst("hovhannes", "оганес");
        }
        if (name.startsWith("hambardz")) {
            name = name.replaceFirst("hambardz", "амбарц");
        }
        if (name.startsWith("hakob")) {
            name = name.replaceFirst("hakob", "акоп");
        }
        if (name.startsWith("ha")) {
            name = name.replaceFirst("ha", "а");
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

    @Override
    public String getName() {
        return RulesetName.ARMENIAN.getName();
    }
}
