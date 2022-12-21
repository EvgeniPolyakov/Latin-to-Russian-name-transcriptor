package polyakov.nametranscriptor.rulesets.customrules;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Russian {

    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("ei", "эй"),
            Map.entry("ey", "эй"),
            Map.entry("ia", "я")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("aia", "ая"),
            Map.entry("uia", "уя"),
            Map.entry("eia", "ея"),
            Map.entry("oia", "оя"),
            Map.entry("iia", "ия"),
            Map.entry("sky", "ский"),
            Map.entry("ski", "ский"),
            Map.entry("skiy", "ский")
    );

    public static final List<String> CUSTOM_ENDINGS = List.of("y", "iy", "ii", "yy");
    public static final List<String> Y_CONSONANTS_PART1 = List.of("v", "l", "t", "z", "p", "s", "d", "m", "b", "n");
    public static final List<String> Y_CONSONANTS_PART2 = List.of("g", "k", "h");
}
