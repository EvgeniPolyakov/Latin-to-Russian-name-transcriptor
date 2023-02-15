package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.IcelandicNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Icelandic {

    public static final Map<String, String> PRIMARY_STARTERS = Map.ofEntries(
            Map.entry("au", "эй"),
            Map.entry("eng", "эйнг"),
            Map.entry("enk", "эйнк"),
            Map.entry("gud", "гвюд"),
            Map.entry("öng", "эйнг"),
            Map.entry("önk", "эйнк"),
            Map.entry("ei", "эй"),
            Map.entry("ey", "эй")
    );

    public static final Map<String, String> SECONDARY_STARTERS = Map.ofEntries(
            Map.entry("ö", "э"),
            Map.entry("e", "э"),
            Map.entry("é", "е"),
            Map.entry("u", "у")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("já", "яу"),
            Map.entry("jæ", "яй"),
            Map.entry("je", "е"),
            Map.entry("jé", "е"),
            Map.entry("ji", "йи"),
            Map.entry("jí", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("jó", "йоу"),
            Map.entry("jö", "е"),
            Map.entry("ju", "ю"),
            Map.entry("jú", "ю"),
            Map.entry("jy", "йи"),
            Map.entry("jý", "йи")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("já", "ьяу"),
            Map.entry("jæ", "ьяй"),
            Map.entry("je", "ье"),
            Map.entry("jé", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("jí", "ьи"),
            Map.entry("jo", "ьо"),
            Map.entry("jó", "ьоу"),
            Map.entry("jö", "ьо"),
            Map.entry("ju", "ью"),
            Map.entry("jú", "ью"),
            Map.entry("jy", "ьи"),
            Map.entry("jý", "ьи")
    );

    public static final List<String> VOWELS = List.of(
            "a", "á", "e", "é", "i", "í", "o", "ó", "u", "ú", "y", "ý", "æ", "ö", "е", "и", "й", "о", "э", "у", "ю", "я"
    );

    public static final List<String> VOICELESS_CONSONANTS = List.of(
            "f", "s", "t", "h", "j", "p", "k", "d", "b", "д", "х", "й", "ь"
    );

    public static final Map<String, String> NAMES = Arrays.stream(IcelandicNames.values())
            .collect(Collectors.toMap(IcelandicNames::getLatinName, IcelandicNames::getCyrillicName));
}