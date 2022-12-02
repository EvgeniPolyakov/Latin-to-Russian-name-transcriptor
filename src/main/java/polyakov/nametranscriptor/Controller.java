package polyakov.nametranscriptor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.service.TranscriptionService;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "/transcribe")
public class Controller {
    private final TranscriptionService transcriptionService;

    @GetMapping
    public String transcribe(@RequestBody IncomingDto dto) {
        log.info("Received GET request on /transcribe. Country: {}", dto.getCountry());
        return transcriptionService.transcribe(dto);
    }
}
