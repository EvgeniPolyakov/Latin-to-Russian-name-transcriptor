package polyakov.nametranscriptor.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.model.Rulesets;
import polyakov.nametranscriptor.model.rulesets.Ruleset;

@Service
@Slf4j
public class TranscriptionService {
    private static final String REGEX = "[!#@%^:;+._,?|/{}~&№ ]";

    public String transcribe(IncomingDto dto, int mode) {
        log.info("Getting a ruleset for: {}", dto.getCountry());
        Ruleset ruleset = Rulesets.getRules().get(dto.getCountry());
        log.info("Transcribing text. Mode: {}", mode);
        String[] names = dto.getText().split(String.format("(?=%s)|(?<=%s)", REGEX, REGEX));
        StringBuilder result = new StringBuilder();
        for (String w : names) {
            if (w.equals(w.toLowerCase())) {
                result.append(ruleset.transcribe(w, mode));
            } else if (w.equals(w.toUpperCase())) {
                result.append(ruleset.transcribe(w.toLowerCase(), mode).toUpperCase());
            } else {
                result.append(StringUtils.capitalize(ruleset.transcribe(w.toLowerCase(), mode)));
            }
        }
        return result.toString();
    }
}
