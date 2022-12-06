package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

class RulesetTest {

    @Test
    void transcribeText() {
        Ruleset rs = Mockito.mock(Ruleset.class);
        Mockito.when(rs.transcribeName(any(), anyInt()))
                .thenReturn("response");
        Mockito.doCallRealMethod()
                .when(rs)
                .transcribeText(any(), anyInt());

        assertEquals("response", rs.transcribeText("query", 0));
        assertEquals("RESPONSE", rs.transcribeText("QUERY", 0));
    }
}