package polyakov.nametranscriptor.ruleset.resources.wordparts;

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
            Map.entry("iil", "иил"),
            Map.entry("ail", "аил"),
            Map.entry("aia", "ая"),
            Map.entry("uia", "уя"),
            Map.entry("eia", "ея"),
            Map.entry("oia", "оя"),
            Map.entry("iia", "ия"),
            Map.entry("sky", "ский"),
            Map.entry("ski", "ский"),
            Map.entry("skiy", "ский")
    );

    public static final Map<String, String> IY_CASES = Map.ofEntries(
            Map.entry("ia", "я"),
            Map.entry("ie", "е"),
            Map.entry("ii", "йи"),
            Map.entry("io", "ио"),
            Map.entry("iu", "ю"),
            Map.entry("ya", "я"),
            Map.entry("ye", "е"),
            Map.entry("yi", "йи"),
            Map.entry("yo", "йо"),
            Map.entry("yu", "ю")
    );

    public static final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "y", "е", "и", "й", "о", "ю", "я");
    public static final List<String> CUSTOM_ENDINGS = List.of("y", "iy", "yy");
    public static final List<String> Y_CONSONANTS_PART1 = List.of("v", "l", "t", "z", "p", "d", "m", "b", "n");
    public static final List<String> Y_CONSONANTS_PART2 = List.of("g", "k", "h");
}
