package polyakov.nametranscriptor.service;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.rulesets.Ruleset;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TranscriptionServiceTest {

    @Test
    void transcribe() {
        RulesetFactory rf = mock(RulesetFactory.class);
        Ruleset ruleset = mock(Ruleset.class);
        when(rf.findStrategy(any())).thenReturn(ruleset);
        when(ruleset.transcribe(anyString(), anyInt())).thenReturn("тест");

        IncomingDto lowCase = new IncomingDto("test", "Test");
        IncomingDto allCaps = new IncomingDto("TEST", "Test");
        IncomingDto capitalized = new IncomingDto("Test", "Test");
        IncomingDto mixedCase = new IncomingDto("tEsT", "Test");
        TranscriptionService ts = new TranscriptionService(rf);

        assertNotNull(ts);
        assertEquals("тест", ts.transcribe(lowCase, 0));
        assertEquals("ТЕСТ", ts.transcribe(allCaps, 0));
        assertEquals("Тест", ts.transcribe(capitalized, 0));
        assertEquals("Тест", ts.transcribe(mixedCase, 0));
    }
}