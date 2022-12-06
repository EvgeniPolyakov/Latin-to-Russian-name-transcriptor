package polyakov.nametranscriptor.model.rulesets.custom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Romanian {

    public static final Map<String, String> CUSTOM_CONSONANTS = Map.ofEntries(
            Map.entry("ch", "к"),
            Map.entry("Ch", "К"),
            Map.entry("gh", "г"),
            Map.entry("Gh", "Г"),
            Map.entry("th", "т"),
            Map.entry("Th", "Т"),
            Map.entry("c", "ч"),
            Map.entry("C", "Ч"),
            Map.entry("g", "дж"),
            Map.entry("G", "Дж")
    );

    public static final Map<String, String> VOWELS = Map.ofEntries(
            Map.entry("a", "а"),
            Map.entry("A", "А"),
            Map.entry("ă", "э"),
            Map.entry("Ă", "Э"),
            Map.entry("â", "ы"),
            Map.entry("Â", "Ы"),
            Map.entry("e", "е"),
            Map.entry("E", "Е"),
            Map.entry("i", "и"),
            Map.entry("I", "И"),
            Map.entry("î", "ы"),
            Map.entry("Î", "Ы"),
            Map.entry("o", "о"),
            Map.entry("O", "О"),
            Map.entry("u", "у"),
            Map.entry("U", "У"),
            Map.entry("y", "и"),
            Map.entry("Y", "И")
    );

    public static final Map<String, String> STARTING_PART = Map.ofEntries(
            Map.entry("ia", "я"),
            Map.entry("Ia", "Я"),
            Map.entry("ie", "е"),
            Map.entry("Ie", "Е"),
            Map.entry("io", "йо"),
            Map.entry("Io", "Йо"),
            Map.entry("Iu", "Ю"),
            Map.entry("iu", "ю"),
            Map.entry("Eric", "Эрик"),
            Map.entry("Eugen", "Эуджен")
    );

    public static final List<String> UTILITY_VOWELS = List.of("e", "E", "i", "I");
}
