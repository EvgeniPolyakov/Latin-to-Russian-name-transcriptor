package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.DanishNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Danish {
    public static final Map<String, String> PRIMARY_STARTERS = Map.ofEntries(
            Map.entry("af", "ау"),
            Map.entry("ej", "ай"),
            Map.entry("æ", "э"),
            Map.entry("øj", "ой"),
            Map.entry("nord", "нор"),
            Map.entry("y", "и")
    );

    public static final Map<String, String> SECONDARY_STARTERS = Map.ofEntries(
            Map.entry("ø", "э"),
            Map.entry("e", "э")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("eg", "ай"),
            Map.entry("øg", "ой"),
            Map.entry("nd", "нн"),
            Map.entry("ld", "лль"),
            Map.entry("lv", "ль"),
            Map.entry("rd", "р")
    );

    public static final Map<String, String> J_CASES = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("jå", "йо"),
            Map.entry("jæ", "йе"),
            Map.entry("je", "йе"),
            Map.entry("ji", "йи"),
            Map.entry("jo", "йо"),
            Map.entry("jø", "йе"),
            Map.entry("ju", "ю"),
            Map.entry("jy", "йю")
    );

    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("jå", "ьо"),
            Map.entry("jæ", "ье"),
            Map.entry("je", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("jo", "ьо"),
            Map.entry("jø", "ье"),
            Map.entry("ju", "ью"),
            Map.entry("jy", "ью")
    );

    public static final List<String> VOWELS = List.of(
            "a", "å", "æ", "e", "i", "o", "ø", "u", "y", "а", "е", "и", "о", "э", "ю", "я"
    );

    public static final Map<String, String> NAMES = Arrays.stream(DanishNames.values())
            .collect(Collectors.toMap(DanishNames::getLatinName, DanishNames::getCyrillicName));
}