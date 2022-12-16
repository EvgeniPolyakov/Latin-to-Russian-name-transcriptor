package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Cypriot extends Greek {

    @Override
    public String getName() {
        return RulesetName.CYPRIOT.getName();
    }
}