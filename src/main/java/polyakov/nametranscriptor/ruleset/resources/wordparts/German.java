package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class German {

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("ia", "ия"),
            Map.entry("rh", "р"),
            Map.entry("th", "т"),
            Map.entry("gh", "г"),
            Map.entry("mann", "ман")
    );

    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("ä", "э"),
            Map.entry("e", "э"),
            Map.entry("ch", "к"),
            Map.entry("ö", "э"),
            Map.entry("ü", "и")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
            Map.entry("ä", "э"),
            Map.entry("i", "й")
    );

    public static final Map<String, String> BEFORE_VOWELS = Map.ofEntries(
            Map.entry("l", "л"),
            Map.entry("s", "з")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("jä", "е"),
            Map.entry("je", "е"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("jö", "йе"),
            Map.entry("ju", "ю"),
            Map.entry("jü", "ю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("jä", "ье"),
            Map.entry("je", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("jo", "ьо"),
            Map.entry("jö", "ье"),
            Map.entry("ju", "ью"),
            Map.entry("jü", "ью")
    );

    public static final List<String> VOWELS = List.of(
            "a", "ä", "e", "i", "o", "ö", "u", "ü", "а", "е", "и", "о", "у"
    );
}