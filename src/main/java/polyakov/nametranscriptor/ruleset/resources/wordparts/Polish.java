package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.PolishNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Polish {
    public static final List<String> VOWELS = List.of(
            "a", "ą", "e", "ę", "i", "o", "ó", "u", "y", "а", "е", "и", "о", "у", "э", "ю", "я"
    );

    public static final List<String> UTILITY_CONSONANTS = List.of(
            "b", "d", "f", "g", "h", "j", "k", "ł", "m", "n", "p", "r", "s", "t", "w", "z", "ź", "ż"
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("cki", "цкий"),
            Map.entry("dzki", "дзкий"),
            Map.entry("ski", "ский"),
            Map.entry("dzka", "дзкая"),
            Map.entry("cka", "цкая"),
            Map.entry("ska", "ская")
    );

    public static final Map<String, String> J_PRIMARY_START_CASES = Map.ofEntries(
            Map.entry("jąb", "йомб"),
            Map.entry("jąp", "йомп"),
            Map.entry("jęb", "емб"),
            Map.entry("jęp", "емп"),
            Map.entry("jo", "йо")
    );

    public static final Map<String, String> J_PRIMARY_VOWEL_CASES = Map.ofEntries(
            Map.entry("jąb", "емб"),
            Map.entry("jąp", "емп"),
            Map.entry("jęb", "емб"),
            Map.entry("jęp", "емп"),
            Map.entry("jo", "е")
    );

    public static final Map<String, String> J_PRIMARY_AFTER_CONSONANT_CASES = Map.ofEntries(
            Map.entry("jąb", "ьомб"),
            Map.entry("jąp", "ьомп"),
            Map.entry("jęb", "ьемб"),
            Map.entry("jęp", "ьемп")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("ją", "йон"),
            Map.entry("je", "е"),
            Map.entry("ję", "ен"),
            Map.entry("jó", "ю"),
            Map.entry("ju", "ю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANT_CASES = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("ją", "ьон"),
            Map.entry("je", "ье"),
            Map.entry("ję", "ьен"),
            Map.entry("jo", "ьо"),
            Map.entry("jó", "ью"),
            Map.entry("ju", "ью")
    );

    public static final Map<String, String> L_CASES = Map.ofEntries(
            Map.entry("la", "ля"),
            Map.entry("lą", "лен"),
            Map.entry("le", "ле"),
            Map.entry("li", "ли"),
            Map.entry("lo", "ле"),
            Map.entry("ló", "лю"),
            Map.entry("lu", "лю"),
            Map.entry("ly", "ли"),
            Map.entry("lа", "ля"),
            Map.entry("lе", "ле"),
            Map.entry("lи", "ли"),
            Map.entry("lо", "ле"),
            Map.entry("lу", "лю"),
            Map.entry("lы", "лы"),
            Map.entry("lю", "лю"),
            Map.entry("lя", "ля")
    );

    public static final Map<String, String> NAMES = Arrays.stream(PolishNames.values())
            .collect(Collectors.toMap(PolishNames::getLatinName, PolishNames::getCyrillicName));
}
