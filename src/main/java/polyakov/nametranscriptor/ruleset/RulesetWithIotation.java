package polyakov.nametranscriptor.ruleset;

import java.util.List;
import java.util.Map;

public abstract class RulesetWithIotation extends DefaultRuleset {

    protected static String checkIotation(String name, List<String> vowels, Map<String, String> jCases,
                                          Map<String, String> jCasesAfterConsonants) {
        for (Map.Entry<String, String> jCombination : jCases.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
                break;
            }
        }
        for (String vowel : vowels) {
            for (Map.Entry<String, String> jCombination : jCases.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
        }
        for (Map.Entry<String, String> jCombination : jCasesAfterConsonants.entrySet()) {
            name = name.replace(jCombination.getKey(), jCombination.getValue());
        }
        return name;
    }
}
