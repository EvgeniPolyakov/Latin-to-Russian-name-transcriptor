package polyakov.nametranscriptor.model.rulesets.custom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Russian {

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("sky", "ский"),
            Map.entry("ski", "ский"),
            Map.entry("skiy", "ский"),
            Map.entry("ii", "ий")
    );
    public static final List<String> CUSTOM_ENDINGS = List.of("y", "iy", "ii", "yy");

    public static final List<String> CUSTOM_CONSONANTS_PART1 = List.of("v", "l", "s", "d", "m", "b", "n");

    public static final List<String> CUSTOM_CONSONANTS_PART2 = List.of("g", "k", "h");
}
