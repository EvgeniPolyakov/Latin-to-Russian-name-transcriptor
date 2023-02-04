package polyakov.nametranscriptor.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import polyakov.nametranscriptor.exception.BadRequestException;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.model.OutgoingDto;
import polyakov.nametranscriptor.ruleset.Ruleset;

import java.util.Locale;

@Service
@Slf4j
@AllArgsConstructor
public class TranscriptionService {
    private RulesetFactory rulesetFactory;

    public OutgoingDto transcribe(IncomingDto dto, int mode) {
        log.info("Getting a ruleset for: {}", dto.getLanguage());
        Ruleset ruleset = rulesetFactory.findStrategy(dto.getLanguage());
        if (ruleset == null) {
            throw new BadRequestException("Ruleset for wrong or unsupported language requested");
        }
        log.info("Transcribing text. Mode: {}", mode);
        String regex = "[^\\p{L}]";
        String[] words = dto.getText().split(String.format("(?=%s)|(?<=%s)", regex, regex));
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            String transcription = ruleset.transcribe(word.toLowerCase(Locale.ROOT), mode);
            if (word.equals(word.toLowerCase(Locale.ROOT))) {
                result.append(transcription);
            } else if (word.equals(word.toUpperCase(Locale.ROOT))) {
                result.append(transcription.toUpperCase(Locale.ROOT));
            } else {
                result.append(StringUtils.capitalize(transcription));
            }
        }
        return new OutgoingDto(result.toString());
    }
}
