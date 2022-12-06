package polyakov.nametranscriptor.model.rulesets.custom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Turkish {

    public static final Map<String, String> VOWELS = Map.ofEntries(
            Map.entry("a", "а"),
            Map.entry("A", "А"),
            Map.entry("e", "е"),
            Map.entry("E", "Е"),
            Map.entry("i", "и"),
            Map.entry("İ", "И"),
            Map.entry("ı", "ы"),
            Map.entry("I", "Ы"),
            Map.entry("î", "и"),
            Map.entry("Î", "И"),
            Map.entry("o", "о"),
            Map.entry("O", "О"),
            Map.entry("ö", "о"),
            Map.entry("Ö", "О"),
            Map.entry("u", "у"),
            Map.entry("U", "У"),
            Map.entry("ü", "у"),
            Map.entry("Ü", "У")
    );
    public static final Map<String, String> INITIAL_LETTER = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("E", "Э"),
            Map.entry("ü", "у"),
            Map.entry("Ü", "У"),
            Map.entry("ö", "о"),
            Map.entry("Ö", "О"),
            Map.entry("ya", "я"),
            Map.entry("Ya", "Я"),
            Map.entry("ye", "е"),
            Map.entry("Ye", "Е"),
            Map.entry("yi", "йи"),
            Map.entry("Yi", "Йи"),
            Map.entry("yı", "йы"),
            Map.entry("Yı", "Йы"),
            Map.entry("yo", "йо"),
            Map.entry("Yo", "Йо"),
            Map.entry("yö", "йо"),
            Map.entry("Yö", "Йо"),
            Map.entry("yu", "ю"),
            Map.entry("Yu", "Ю"),
            Map.entry("yü", "ю"),
            Map.entry("Yü", "Ю")
    );
    public static final Map<String, String> UTILITY_LETTERS = Map.ofEntries(
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
