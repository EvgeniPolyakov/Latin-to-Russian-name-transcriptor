package polyakov.nametranscriptor.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import polyakov.nametranscriptor.exception.BadRequestException;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.model.OutgoingDto;
import polyakov.nametranscriptor.ruleset.Ruleset;

@Service
@Slf4j
@AllArgsConstructor
public class TranscriptionService {
    private static final String REGEX = "[-–—!#@%^:;+._,?|/`’'{}~&№ ]";

    private RulesetFactory rulesetFactory;

    public OutgoingDto transcribe(IncomingDto dto, int mode) {
        log.info("Getting a ruleset for: {}", dto.getLanguage());
        Ruleset ruleset = rulesetFactory.findStrategy(dto.getLanguage());
        if (ruleset == null) {
            throw new BadRequestException("Ruleset for wrong or unsupported language requested");
        }
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
        return new OutgoingDto(result.toString());
    }
}
