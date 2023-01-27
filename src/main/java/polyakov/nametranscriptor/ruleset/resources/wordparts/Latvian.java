package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.LatvianNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Latvian {
    public static final Map<String, String> AFTER_SOFT_CONSONANTS = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("e", "е"),
            Map.entry("i", "и"),
            Map.entry("o", "е"),
            Map.entry("u", "ю")
    );

    public static final Map<String, String> SOFT_CONSONANTS = Map.ofEntries(
            Map.entry("ģ", "г"),
            Map.entry("ķ", "к"),
            Map.entry("ļ", "л"),
            Map.entry("ņ", "н")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("ezers", "эзерс"),
            Map.entry("ni", "ны"),
            Map.entry("li", "лы"),
            Map.entry("upe", "упе")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("ji", "йи"),
            Map.entry("ju", "ю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("je", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("ju", "ью")
    );

    public static final List<String> VOWELS = List.of("a", "e", "i", "o", "u");

    public static final Map<String, String> NAMES = Arrays.stream(LatvianNames.values())
            .collect(Collectors.toMap(LatvianNames::getLatinName, LatvianNames::getCyrillicName));
}