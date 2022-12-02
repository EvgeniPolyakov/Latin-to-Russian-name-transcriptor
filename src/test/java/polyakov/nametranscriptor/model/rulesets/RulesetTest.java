package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class RulesetTest {

    @Test
    void transcribeText() {
        Ruleset rs = Mockito.mock(Ruleset.class);
        Mockito.when(rs.transcribeName(any()))
                .thenReturn("tEsT");
        Mockito.doCallRealMethod()
                .when(rs)
                .transcribeText(any());

        assertEquals("tEsT tEsT tEsT", rs.transcribeText("test test test"));
    }
}