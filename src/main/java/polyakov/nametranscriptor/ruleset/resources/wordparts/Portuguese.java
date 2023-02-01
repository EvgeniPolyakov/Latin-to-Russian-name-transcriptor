package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.PortugueseNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Portuguese {
    public static final List<String> VOWELS = List.of(
            "a", "ã", "e", "é", "ê", "i", "í", "o", "ó", "õ", "ô", "u", "ü", "а", "е", "и", "о", "у", "ю"
    );

    public static final Map<String, String> BEFORE_VOWELS = Map.ofEntries(
            Map.entry("m", "м"),
            Map.entry("x", "ш")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
            Map.entry("io", "йо"),
            Map.entry("iu", "ю"),
            Map.entry("iú", "ю")
    );

    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("é", "э"),
            Map.entry("ia", "иа"),
            Map.entry("iu", "иу"),
            Map.entry("iú", "иу"),
            Map.entry("x", "ш"),
            Map.entry("z", "з")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("ia", "ия"),
            Map.entry("em", "ен"),
            Map.entry("im", "ин"),
            Map.entry("o", "у"),
            Map.entry("s", "ш"),
            Map.entry("z", "ш")
    );

    public static final Map<String, String> ENDINGS_AFTER_VOWELS = Map.ofEntries(
            Map.entry("ia", "я"),
            Map.entry("ios", "юш"),
            Map.entry("io", "ю")
    );

    public static final Map<String, String> SOFTENED_VOWELS = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("ãэ", "яйн"),
            Map.entry("у", "ю"),
            Map.entry("o", "ю"),
            Map.entry("u", "ю")
    );

    public static final List<String> SOFT_CONSONANTS = List.of("lh", "nh");

    public static final List<String> VOICED_CONSONANTS =
            List.of("b", "d", "g", "m", "n", "l", "r", "v", "м", "л", "б", "ж");

    public static final Map<String, String> NAMES = Arrays.stream(PortugueseNames.values())
            .collect(Collectors.toMap(PortugueseNames::getLatinName, PortugueseNames::getCyrillicName));
}
