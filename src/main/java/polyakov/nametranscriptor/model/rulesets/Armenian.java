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
        name = name.replace("Hay", "Ай");
        name = name.replace("Hovhannes", "Оганес");
        name = name.replace("Hambardz", "Амбарц");
        name = name.replace("Hakob", "Акоп");
        name = name.replace("Ha", "А");
        name = name.replace("aha", "аа");
        name = name.replace("Ghaza", "Каза");
        name = name.replace("j", "дж");
        name = name.replace("J", "Дж");
        name = name.replace("Gh", "Г");
        name = name.replace("gh", "г");
        if (name.endsWith("ian")) {
            name = name.replace("ian", "ян");
        }
        return super.checkCustomCases(name);
    }

    private Optional<String> checkCustomNames(String name) {
        return Arrays.stream(ArmenianNames.values())
                .filter(s -> s.getLatinName().equalsIgnoreCase(name))
                .findAny()
                .map(ArmenianNames::getCyrillicName);
    }
}
