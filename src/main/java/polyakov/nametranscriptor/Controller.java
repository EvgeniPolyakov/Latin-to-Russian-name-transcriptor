package polyakov.nametranscriptor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import polyakov.nametranscriptor.model.IncomingDto;
import polyakov.nametranscriptor.model.OutgoingDto;
import polyakov.nametranscriptor.service.TranscriptionService;

@RestController
@Tag(name = "Main controller")
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "/transcribe")
@Validated
public class Controller {
    private final TranscriptionService transcriptionService;

    @Operation(summary = "Transcribe text")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transcription done", content = {
                    @Content(mediaType = "string", schema = @Schema(type = "string", example = "Сунь Цзы Кун Лао Юнлэ"))
            })
    })
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public OutgoingDto transcribe(
            @Valid @RequestBody IncomingDto dto,
            @RequestParam(required = false, defaultValue = "0")
            @Parameter(description = "Used to define specific transcription modes if several are supported") int mode) {
        log.info("Received GET request on /transcribe. Language: {}, mode: {}", dto.getLanguage(), mode);
        return transcriptionService.transcribe(dto, mode);
    }
}
