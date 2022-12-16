package polyakov.nametranscriptor.service;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.rulesets.Ruleset;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RulesetFactoryTest {

    @Test
    void createRuleset() {
        Ruleset ruleset = mock(Ruleset.class);
        when(ruleset.getName()).thenReturn("test");
        RulesetFactory rf = new RulesetFactory(Set.of(ruleset));

        assertNotNull(rf);
        assertEquals(ruleset, rf.findStrategy("test"));

    }

}