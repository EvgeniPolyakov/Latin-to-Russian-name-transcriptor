package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.SpanishNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Spanish {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("ье", "е"),
            Map.entry("rья", "риа"),
            Map.entry("rье", "рие"),
            Map.entry("rьо", "рио")
    );

    public static final Map<String, String> SOFTENED_VOWELS = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("u", "ю")
    );

    public static final Map<String, String> SOFT_CONSONANTS = Map.ofEntries(
            Map.entry("ll", "ль"),
            Map.entry("ñ", "нь")
    );

    public static final Map<String, String> I_VOWEL_COMBINATIONS = Map.ofEntries(
            Map.entry("ia", "иа"),
            Map.entry("ie", "ие"),
            Map.entry("io", "ио")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
            Map.entry("ия", "йя"),
            Map.entry("ио", "йо"),
            Map.entry("ia", "йя"),
            Map.entry("ie", "йе"),
            Map.entry("io", "йо")
    );

    public static final Map<String, String> Y_CASES = Map.ofEntries(
            Map.entry("ye", "е"),
            Map.entry("yo", "йо")
    );

    public static final Map<String, String> Y_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ye", "ье"),
            Map.entry("yo", "ьо")
    );

    public static final List<String> VOWELS = List.of(
            "a", "e", "i", "í", "o", "u", "ü", "y", "е", "и", "о", "э", "ю", "я");

    public static final Map<String, String> NAMES = Arrays.stream(SpanishNames.values())
            .collect(Collectors.toMap(SpanishNames::getLatinName, SpanishNames::getCyrillicName));
}