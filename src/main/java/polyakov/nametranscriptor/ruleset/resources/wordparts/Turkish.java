package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Turkish {
    public static final List<String> CYRILLIC_VOWELS = List.of("е", "о", "у", "э", "ю", "я");

    public static final Map<String, String> VOWELS = Map.ofEntries(
            Map.entry("a", "а"),
            Map.entry("e", "е"),
            Map.entry("i", "и"),
            Map.entry("ı", "ы"),
            Map.entry("î", "и"),
            Map.entry("o", "о"),
            Map.entry("ö", "о"),
            Map.entry("u", "у"),
            Map.entry("ü", "у")
    );

    public static final Map<String, String> STARTERS_AND_AFTER_VOWELS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("ö", "о"),
            Map.entry("ü", "у"),
            Map.entry("ya", "я"),
            Map.entry("ye", "е"),
            Map.entry("yo", "йо"),
            Map.entry("yö", "йо"),
            Map.entry("yu", "ю"),
            Map.entry("yü", "ю")
    );
}
