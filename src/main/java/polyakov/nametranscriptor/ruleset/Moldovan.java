package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.MoldovanNames;
import polyakov.nametranscriptor.ruleset.resources.popularnames.RussianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Moldovan.PRIMARY_ENDINGS;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Moldovan.SECONDARY_ENDINGS;

@Component
public class Moldovan extends Romanian {

    @Override
    protected String checkCustomCases(String name) {
        Optional<String> rn = checkRussianNames(name);
        if (rn.isPresent()) {
            name = rn.get();
        }
        Optional<String> mn = checkMoldovanNames(name);
        if (mn.isPresent()) {
            name = mn.get();
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

    private static Optional<String> checkRussianNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    private static Optional<String> checkMoldovanNames(String name) {
        return Arrays.stream(MoldovanNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(MoldovanNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.MOLDOVAN.getName();
    }
}
