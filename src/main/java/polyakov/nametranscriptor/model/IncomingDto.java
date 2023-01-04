package polyakov.nametranscriptor.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncomingDto {
    @Schema(description = "Text for transcription", example = "Sun Zi Kung Lao Yongle")
    @NotNull
    private String text;
    @Schema(description = "Country of origin. Used to specify ruleset for transcription", example = "Chinese")
    @NotBlank
    private String country;
}
