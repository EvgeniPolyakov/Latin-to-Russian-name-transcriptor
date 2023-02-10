package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.ItalianNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Italian {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("ia", "я"),
            Map.entry("e", "э"),
            Map.entry("ie", "е"),
            Map.entry("io", "йо"),
            Map.entry("iu", "ю"),
            Map.entry("z", "дз")
    );

    public static final Map<String, String> SOFTENED_VOWELS = Map.ofEntries(
            Map.entry("ia", "ья"),
            Map.entry("ie", "ье"),
            Map.entry("io", "ьо"),
            Map.entry("iu", "ью")
    );

    public static final Map<String, String> SOFT_COMBINATIONS = Map.ofEntries(
            Map.entry("ch", "к"),
            Map.entry("gh", "г"),
            Map.entry("gl", "л"),
            Map.entry("gn", "н")
    );

    public static final Map<String, String> BEFORE_VOWELS = Map.ofEntries(
            Map.entry("ch", "к"),
            Map.entry("чi", "ч"),
            Map.entry("chi", "кь"),
            Map.entry("джi", "дж"),
            Map.entry("льi", "ль")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
            Map.entry("ia", "я"),
            Map.entry("ie", "е"),
            Map.entry("ii", "и"),
            Map.entry("io", "йо"),
            Map.entry("iu", "ю")
    );

    public static final Map<String, String> FIRST_TIER_ENDINGS = Map.ofEntries(
            Map.entry("cia", "ча"),
            Map.entry("ggi", "джи"),
            Map.entry("gлia", "лья"),
            Map.entry("gia", "джа")
    );

    public static final Map<String, String> SECOND_TIER_ENDINGS = Map.ofEntries(
            Map.entry("ci", "чи"),
            Map.entry("gлi", "льи"),
            Map.entry("gi", "джи"),
            Map.entry("ia", "ия"),
            Map.entry("ie", "ие"),
            Map.entry("io", "ио"),
            Map.entry("iu", "иу"),
            Map.entry("ll", "ль")
    );

    public static final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "е", "и", "о", "э", "ю", "я");

    public static final Map<String, String> NAMES = Arrays.stream(ItalianNames.values())
            .collect(Collectors.toMap(ItalianNames::getLatinName, ItalianNames::getCyrillicName));
}