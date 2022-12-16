package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Slovenian extends Serbian {

    @Override
    public String getName() {
        return RulesetName.SLOVENIAN.getName();
    }
}