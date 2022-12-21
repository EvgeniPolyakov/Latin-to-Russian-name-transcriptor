package polyakov.nametranscriptor.rulesets.customrules;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Albanian {
    public static final List<String> VOWELS =
            List.of("a", "e", "ë", "i", "o", "u", "y");

    public static final Map<String, String> J_VOWEL_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("jë", "йе"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("ju", "ю"),
            Map.entry("jy", "ю")
    );

    public static final Map<String, String> SOFTENED_VOWELS = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("ë", "е"),
            Map.entry("e", "е"),
            Map.entry("i", "и"),
            Map.entry("o", "е"),
            Map.entry("u", "ю")
    );

    public static final Map<String, String> SOFT_CONSONANTS = Map.ofEntries(
            Map.entry("gj", "г"),
            Map.entry("nj", "н"),
            Map.entry("q", "к"),
            Map.entry("l", "л")
    );
}
