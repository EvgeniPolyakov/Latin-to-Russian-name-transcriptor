package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Azeri {

    public static final List<String> VOWELS = List.of("a", "e", "ə", "i", "ı", "o", "ö", "u", "ü");
    public static final List<String> UTILITY_VOWELS = List.of("a", "ı", "o", "u");
    public static final List<String> CYRILLIC_VOWELS = List.of("а", "е", "о", "у", "э", "ю", "я");

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("zada", "заде"),
            Map.entry("al", "aл"),
            Map.entry("ıl", "ıл"),
            Map.entry("ol", "oл"),
            Map.entry("ul", "uл")
    );

    public static final Map<String, String> STARTERS_AND_AFTER_VOWELS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("ö", "о"),
            Map.entry("ü", "у"),
            Map.entry("ya", "я"),
            Map.entry("yə", "я"),
            Map.entry("ye", "е"),
            Map.entry("yo", "йо"),
            Map.entry("yö", "йо"),
            Map.entry("yu", "ю"),
            Map.entry("yü", "ю")
    );
}
