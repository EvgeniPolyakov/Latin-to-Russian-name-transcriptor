package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Lithuanian {

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("jė", "е"),
            Map.entry("jie", "е"),
            Map.entry("ju", "ю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("je", "ья"),
            Map.entry("jė", "ье"),
            Map.entry("jie", "ье"),
            Map.entry("ju", "ью")
    );

    public static final List<String> VOWELS = List.of("a", "e", "ė", "i", "o", "u", "э");
    public static final List<String> CONSONANT_SOFTENERS = List.of("ь", "e", "ė", "i");
}