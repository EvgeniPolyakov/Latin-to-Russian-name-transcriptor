package polyakov.nametranscriptor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.service.TranscriptionService;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "/transcribe")
public class Controller {
    private final TranscriptionService transcriptionService;

    @PostMapping
    public String transcribe(
            @RequestBody IncomingDto dto,
            @RequestParam(required = false, defaultValue = "0") int mode) {
        log.info("Received GET request on /transcribe. Country: {}, mode: {}", dto.getCountry(), mode);
        return transcriptionService.transcribe(dto, mode);
    }
}
