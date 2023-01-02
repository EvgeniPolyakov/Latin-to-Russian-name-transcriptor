package polyakov.nametranscriptor.rulesets.customrules;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Turkish {

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

    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("ü", "у"),
            Map.entry("ö", "о"),
            Map.entry("ya", "я"),
            Map.entry("ye", "е"),
            Map.entry("yi", "йи"),
            Map.entry("yı", "йы"),
            Map.entry("yo", "йо"),
            Map.entry("yö", "йо"),
            Map.entry("yu", "ю"),
            Map.entry("yü", "ю")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
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
