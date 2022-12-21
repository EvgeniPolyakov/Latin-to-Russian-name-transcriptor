package polyakov.nametranscriptor.rulesets.customrules;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Czech {
    public static final List<String> VOWELS =
            List.of("a", "á", "ä", "é", "e", "ě", "i", "í", "o", "ó", "ô", "u", "ů", "ú", "y", "ý");
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

    public static final Map<String, String> STARTERS = Map.ofEntries(
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

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("cký", "цкий"),
            Map.entry("cky", "цкий"),
            Map.entry("ský", "ский"),
            Map.entry("sky", "ский"),
            Map.entry("lý", "лы"),
            Map.entry("ly", "лы"),
            Map.entry("ĺý", "лы"),
            Map.entry("ĺy", "лы"),
            Map.entry("vý", "вы"),
            Map.entry("vy", "вы"),
            Map.entry("ný", "ны"),
            Map.entry("ny", "ны"),
            Map.entry("ší", "ший"),
            Map.entry("ši", "ший"),
            Map.entry("čí", "чий"),
            Map.entry("či", "чий")
    );
}
