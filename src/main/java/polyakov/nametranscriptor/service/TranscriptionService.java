package polyakov.nametranscriptor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.model.Rulesets;
import polyakov.nametranscriptor.model.rulesets.Ruleset;

@Service
@Slf4j
public class TranscriptionService {

    public String transcribe(IncomingDto dto, int mode) {
        log.info("Getting a ruleset for: {}", dto.getCountry());
        Ruleset ruleset = Rulesets.getRules().get(dto.getCountry());
        log.info("Transcribing text. Mode: {}", mode);
        return ruleset.transcribeText(dto.getText(), mode);
    }
}
