package polyakov.nametranscriptor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polyakov.nametranscriptor.ruleset.Ruleset;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RulesetFactory {
    private Map<String, Ruleset> rulesets;

    @Autowired
    public RulesetFactory(Set<Ruleset> rulesetSet) {
        createRuleset(rulesetSet);
    }

    public Ruleset findStrategy(String rulesetName) {
        return rulesets.get(rulesetName);
    }

    private void createRuleset(Set<Ruleset> rulesetSet) {
        rulesets = new HashMap<>();
        rulesetSet.forEach(
                ruleset -> rulesets.put(ruleset.getName(), ruleset));
    }
}