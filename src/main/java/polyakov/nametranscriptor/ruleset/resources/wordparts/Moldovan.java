package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.MoldovanNames;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Moldovan {
    public static final Map<String, String> PRIMARY_ENDINGS = Map.ofEntries(
            Map.entry("ri", "рь"),
            Map.entry("şciu", "щу"),
            Map.entry("ciuc", "чук"),
            Map.entry("ciuk", "чук"),
            Map.entry("schii", "ский"),
            Map.entry("chii", "кий")
    );

    public static final Map<String, String> SECONDARY_ENDINGS = Map.ofEntries(
            Map.entry("iuc", "юк"),
            Map.entry("iuk", "юк"),
            Map.entry("schi", "ский")
    );

    public static final Map<String, String> MOLDOVAN_NAMES = Arrays.stream(MoldovanNames.values())
            .collect(Collectors.toMap(MoldovanNames::getLatinName, MoldovanNames::getCyrillicName));
}
