package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Belorussian extends Russian {

    @Override
    public String getName() {
        return RulesetName.BELORUSSIAN.getName();
    }
}