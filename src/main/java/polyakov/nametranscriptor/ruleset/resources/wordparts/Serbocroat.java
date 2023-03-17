package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.BalkanNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Serbocroat {
    public static final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "е", "и", "о", "э", "ю", "я");

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("ji", "и"),
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

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("njić", "ньич"),
            Map.entry("njič", "ньич"),
            Map.entry("njic", "ньиц")
    );

    public static final Map<String, String> UTILITY_CONSONANTS = Map.ofEntries(
            Map.entry("dj", "дж"),
            Map.entry("lj", "л"),
            Map.entry("nj", "н")
    );

    public static final Map<String, String> VOWELS_FOR_UTILITY_CONSONANTS = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("e", "е"),
            Map.entry("i", "и"),
            Map.entry("o", "е"),
            Map.entry("u", "ю")
    );

    public static final Map<String, String> NAMES = Arrays.stream(BalkanNames.values())
            .collect(Collectors.toMap(BalkanNames::getLatinName, BalkanNames::getCyrillicName));
}
