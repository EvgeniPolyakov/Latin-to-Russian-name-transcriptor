package polyakov.nametranscriptor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncomingDto {
    private String text;
    private String country;
}
