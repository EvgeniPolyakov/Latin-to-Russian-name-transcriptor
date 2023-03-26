package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.EstonianNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Estonian {
    public static final Map<String, String> PRIMARY_STARTERS = Map.ofEntries(
            Map.entry("jää", "яэ"),
            Map.entry("jöö", "йеэ"),
            Map.entry("jüü", "юй"),
            Map.entry("öö", "ээ"),
            Map.entry("ää", "ээ"),
            Map.entry("e", "э")
    );

    public static final Map<String, String> SECONDARY_STARTERS = Map.ofEntries(
            Map.entry("ä", "э"),
            Map.entry("ö", "э")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("suu", "суу"),
            Map.entry("ää", "я"),
            Map.entry("l", "ль")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("jä", "я"),
            Map.entry("je", "е"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("jö", "йе"),
            Map.entry("ju", "ю"),
            Map.entry("jü", "ю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("jä", "ья"),
            Map.entry("je", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("jo", "ьо"),
            Map.entry("jö", "ье"),
            Map.entry("ju", "ью"),
            Map.entry("jü", "ью")
    );

    public static final List<String> VOWELS = List.of("a", "ä", "e", "i", "o", "õ", "ö", "u", "ü", "э", "я");

    public static final Map<String, String> NAMES = Arrays.stream(EstonianNames.values())
            .collect(Collectors.toMap(EstonianNames::getLatinName, EstonianNames::getCyrillicName));
}