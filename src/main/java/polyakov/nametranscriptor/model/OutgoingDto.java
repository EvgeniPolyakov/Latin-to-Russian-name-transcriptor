package polyakov.nametranscriptor.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutgoingDto {
    @Schema(description = "Transcribed text", example = "Сунь Цзы Кун Лао Юнлэ")
    private String text;
}
