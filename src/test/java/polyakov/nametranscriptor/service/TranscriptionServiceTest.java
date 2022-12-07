package polyakov.nametranscriptor.service;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.model.IncomingDto;

import static org.junit.jupiter.api.Assertions.*;

class TranscriptionServiceTest {

    @Test
    void transcribe() {
        IncomingDto dto = new IncomingDto("test, !TEST Test# tEsT", "Russia");
        TranscriptionService ts = new TranscriptionService();

        assertEquals("тест, !ТЕСТ Тест# Тест", ts.transcribe(dto, 0));
    }
}