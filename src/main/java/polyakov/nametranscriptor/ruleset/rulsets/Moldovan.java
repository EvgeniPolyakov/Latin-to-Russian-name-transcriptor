package polyakov.nametranscriptor.ruleset.rulsets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Moldovan.*;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;

@Component
public class Moldovan extends Romanian {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name);
        name = checkEndings(name);
        name = name.replace("şciu", "щу");
        name = name.replace("şcia", "ща");
        name = name.replace("şc", "щ");
        return super.transcribe(name, mode);
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
