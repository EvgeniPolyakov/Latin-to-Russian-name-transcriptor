package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Bosnian extends Serbian {

    @Override
    public String getName() {
        return RulesetName.BOSNIAN.getName();
    }
}