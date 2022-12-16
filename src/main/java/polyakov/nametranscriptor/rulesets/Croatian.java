package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Croatian extends Serbian {

    @Override
    public String getName() {
        return RulesetName.CROATIAN.getName();
    }
}