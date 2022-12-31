package polyakov.nametranscriptor.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncomingDto {
    @Schema(description = "Text for transcription", example = "Sun Zi Kung Lao Yongle")
    private String text;
    @Schema(description = "Country of origin. Used to specify ruleset for transcription", example = "Chinese")
    private String country;
}
