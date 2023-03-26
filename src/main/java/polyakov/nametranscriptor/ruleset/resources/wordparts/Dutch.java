package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.DutchNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dutch {
    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("sch", "с"),
            Map.entry("w", "")
    );

    public static final Map<String, String> PRIMARY_STARTERS = Map.ofEntries(
            Map.entry("eij", "эй"),
            Map.entry("uij", "эй"),
            Map.entry("ij", "эй")
    );

    public static final Map<String, String> SECONDARY_STARTERS = Map.ofEntries(
            Map.entry("ei", "эй"),
            Map.entry("ey", "эй"),
            Map.entry("eu", "эй"),
            Map.entry("ui", "эй"),
            Map.entry("uy", "эй")
    );

    public static final Map<String, String> TERTIARY_STARTERS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("u", "у")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
            Map.entry("i", "й"),
            Map.entry("ui", "эй"),
            Map.entry("uy", "эй"),
            Map.entry("y", "й")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("ju", "ю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("je", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("jo", "ьо"),
            Map.entry("ju", "ью")
    );

    public static final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "а", "у", "э");

    public static final Map<String, String> NAMES = Arrays.stream(DutchNames.values())
            .collect(Collectors.toMap(DutchNames::getLatinName, DutchNames::getCyrillicName));
}