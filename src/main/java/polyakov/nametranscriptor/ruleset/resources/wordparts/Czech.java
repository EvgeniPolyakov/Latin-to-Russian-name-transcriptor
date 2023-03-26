package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.CzechoslovakNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Czech {
    public static final List<String> VOWELS = List.of("a", "ä", "e", "ě", "i", "o", "ô", "u", "y");

    public static final List<String> VOICED_CONSONANTS = List.of("b", "v", "d", "ď", "z", "ž", "g", "h");

    public static final List<String> Y_CASE_CONSONANTS = List.of("g", "k", "h", "ch", "c", "č", "š");

    public static final Map<String, String> UTILITY_CONSONANTS = Map.ofEntries(
            Map.entry("ď", "д"),
            Map.entry("ň", "н"),
            Map.entry("ť", "т")
    );

    public static final Map<String, String> AFTER_DNT = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("á", "я"),
            Map.entry("o", "е"),
            Map.entry("ó", "е"),
            Map.entry("u", "ю"),
            Map.entry("ú", "ю"),
            Map.entry("ů", "ю")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("é", "э"),
            Map.entry("ja", "я"),
            Map.entry("já", "я"),
            Map.entry("je", "е"),
            Map.entry("jé", "е"),
            Map.entry("ji", "йи"),
            Map.entry("ju", "ю"),
            Map.entry("jú", "ю"),
            Map.entry("jů", "ю")
    );

    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("e", "э"),
            Map.entry("é", "э"),
            Map.entry("ja", "я"),
            Map.entry("já", "я"),
            Map.entry("je", "е"),
            Map.entry("jé", "е"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("ju", "ю"),
            Map.entry("jú", "ю"),
            Map.entry("jů", "ю"),
            Map.entry("ř", "рж")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("cky", "цкий"),
            Map.entry("sky", "ский"),
            Map.entry("ly", "лы"),
            Map.entry("ĺy", "лы"),
            Map.entry("vy", "вы"),
            Map.entry("ny", "ны"),
            Map.entry("ši", "ший"),
            Map.entry("či", "чий")
    );

    public static final Map<String, String> NAMES = Arrays.stream(CzechoslovakNames.values())
            .collect(Collectors.toMap(CzechoslovakNames::getLatinName, CzechoslovakNames::getCyrillicName));
}
