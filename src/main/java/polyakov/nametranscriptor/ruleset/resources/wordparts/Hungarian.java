package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.HungarianNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Hungarian {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("ü", "и"),
            Map.entry("ű", "и")
    );

    public static final Map<String, String> VOWEL_SOFTENERS = Map.ofEntries(
            Map.entry("gy", "дь"),
            Map.entry("ny", "нь"),
            Map.entry("ty", "ть")
    );

    public static final Map<String, String> SOFTENED_VOWELS = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("o", "е"),
            Map.entry("ö", "е"),
            Map.entry("u", "ю"),
            Map.entry("ü", "ю")
    );

    public static final Map<String, String> J_START_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("jö", "йе"),
            Map.entry("ju", "ю"),
            Map.entry("jü", "ю")
    );

    public static final Map<String, String> J_VOWEL_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "йе"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("jö", "йе"),
            Map.entry("ju", "ю"),
            Map.entry("jü", "ю")
    );

    public static final Map<String, String> J_CONSONANT_CASES = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("je", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("jo", "ьо"),
            Map.entry("jö", "ье"),
            Map.entry("ju", "ью"),
            Map.entry("jü", "ью")
    );

    public static final List<String> VOWELS = List.of(
            "a", "e", "i", "o", "ö", "u", "ü", "ű", "y", "е", "и", "о", "э", "ю", "я"
    );

    public static final Map<String, String> NAMES = Arrays.stream(HungarianNames.values())
            .collect(Collectors.toMap(HungarianNames::getLatinName, HungarianNames::getCyrillicName));
}