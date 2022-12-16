package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Montenegrin extends Serbian {

    @Override
    public String getName() {
        return RulesetName.MONTENEGRIN.getName();
    }
}