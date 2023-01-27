package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Moldovan.*;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;

@Component
public class Moldovan extends Romanian {

    @Override
    protected String checkCustomCases(String name) {
        name = checkName(name);
        Optional<String> russianName = Optional.ofNullable(RUSSIAN_NAMES.get(name));
        if (russianName.isPresent()) {
            return russianName.get();
        }
        Optional<String> moldovanName = Optional.ofNullable(MOLDOVAN_NAMES.get(name));
        if (moldovanName.isPresent()) {
            return moldovanName.get();
        }
        name = checkEndings(name);
        name = name.replace("şciu", "щу");
        name = name.replace("şcia", "ща");
        name = name.replace("şc", "щ");
        return super.checkCustomCases(name);
    }

    private static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : PRIMARY_ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        for (Map.Entry<String, String> ending : SECONDARY_ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        return name;
    }

    private static String checkName(String name) {
        Optional<String> russianNames = Optional.ofNullable(RUSSIAN_NAMES.get(name));
        return russianNames.orElseGet(() -> Optional.ofNullable(MOLDOVAN_NAMES.get(name)).orElse(name));
    }

    @Override
    public String getName() {
        return RulesetName.MOLDOVAN.getName();
    }
}
