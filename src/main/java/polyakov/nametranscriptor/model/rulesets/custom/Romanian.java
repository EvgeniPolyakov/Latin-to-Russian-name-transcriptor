package polyakov.nametranscriptor.model.rulesets.custom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Romanian {

    public static final Map<String, String> CUSTOM_CONSONANTS = Map.ofEntries(
            Map.entry("ch", "к"),
            Map.entry("gh", "г"),
            Map.entry("th", "т"),
            Map.entry("c", "ч"),
            Map.entry("g", "дж")
    );

    public static final Map<String, String> VOWELS = Map.ofEntries(
            Map.entry("a", "а"),
            Map.entry("ă", "э"),
            Map.entry("â", "ы"),
            Map.entry("e", "е"),
            Map.entry("i", "и"),
            Map.entry("î", "ы"),
            Map.entry("o", "о"),
            Map.entry("u", "у"),
            Map.entry("y", "и")
    );

    public static final Map<String, String> STARTING_PART = Map.ofEntries(
            Map.entry("ia", "я"),
            Map.entry("ie", "е"),
            Map.entry("io", "йо"),
            Map.entry("iu", "ю"),
            Map.entry("eric", "эрик"),
            Map.entry("eugen", "эуджен")
    );

    public static final List<String> UTILITY_VOWELS = List.of("e", "i");
}
