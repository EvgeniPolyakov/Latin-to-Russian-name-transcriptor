package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Moldovan.*;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;

@Component
public class Moldovan extends Romanian {

    @Override
    protected String checkCustomCases(String name) {
        name = checkExceptions(name);
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
        name = checkEndings(name, PRIMARY_ENDINGS);
        name = checkEndings(name, SECONDARY_ENDINGS);
        return name;
    }

    private static String checkExceptions(String name) {
        String nameWithNoAccents = StringUtils.stripAccents(name);
        Optional<String> russianNames = Optional.ofNullable(RUSSIAN_NAMES.get(nameWithNoAccents));
        return russianNames.orElseGet(() -> Optional.ofNullable(MOLDOVAN_NAMES.get(nameWithNoAccents)).orElse(name));
    }

    @Override
    public String getName() {
        return RulesetName.MOLDOVAN.getName();
    }
}
