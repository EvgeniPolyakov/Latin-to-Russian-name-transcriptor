package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.FinnishNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Finnish {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("ä", "э"),
            Map.entry("e", "э")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("jä", "я"),
            Map.entry("je", "е"),
            Map.entry("jö", "йе"),
            Map.entry("ju", "ю"),
            Map.entry("jü", "ю"),
            Map.entry("jy", "йю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("jä", "ья"),
            Map.entry("je", "ье"),
            Map.entry("jö", "ье"),
            Map.entry("ju", "ью"),
            Map.entry("jü", "ью"),
            Map.entry("jy", "ью")
    );

    public static final List<String> VOWELS = List.of(
            "a", "ä", "e", "i", "o", "ö", "u", "ü", "y", "е", "и", "о", "э", "ю", "я"
    );

    public static final Map<String, String> NAMES = Arrays.stream(FinnishNames.values())
            .collect(Collectors.toMap(FinnishNames::getLatinName, FinnishNames::getCyrillicName));
}