package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.HebrewNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Hebrew {
    public static final Map<String, String> Y_CASES = Map.ofEntries(
            Map.entry("ya", "я"),
            Map.entry("ye", "е"),
            Map.entry("yi", "йи"),
            Map.entry("yo", "йо"),
            Map.entry("yu", "ю")
    );

    public static final Map<String, String> Y_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ya", "ья"),
            Map.entry("ye", "ье"),
            Map.entry("yi", "ьи"),
            Map.entry("yo", "ьо"),
            Map.entry("yu", "ью")
    );

    public static final List<String> VOWELS = List.of(
            "a", "e", "i", "o", "u", "y", "е", "и", "о", "у", "э", "ю", "я"
    );

    public static final Map<String, String> NAMES = Arrays.stream(HebrewNames.values())
            .collect(Collectors.toMap(HebrewNames::getLatinName, HebrewNames::getCyrillicName));
}