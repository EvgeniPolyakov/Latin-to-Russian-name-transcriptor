package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Greek {
    public static final Map<String, String> FIRST_TIER_STARTERS = Map.ofEntries(
            Map.entry("ai", "э"),
            Map.entry("e", "э"),
            Map.entry("ie", "ие"),
            Map.entry("mp", "б"),
            Map.entry("nt", "д"),
            Map.entry("ye", "е"),
            Map.entry("yai", "е"),
            Map.entry("yiia", "я"),
            Map.entry("giia", "я"),
            Map.entry("ioa", "я"),
            Map.entry("yie", "е"),
            Map.entry("gie", "е"),
            Map.entry("yiai", "е"),
            Map.entry("giai", "е"),
            Map.entry("yiio", "йо"),
            Map.entry("giio", "йо"),
            Map.entry("yiou", "ю"),
            Map.entry("giou", "ю"),
            Map.entry("yiiou", "ю"),
            Map.entry("giiou", "ю")
    );

    public static final Map<String, String> SECOND_TIER_STARTERS = Map.ofEntries(
            Map.entry("gia", "я"),
            Map.entry("gii", "е"),
            Map.entry("gio", "йо"),
            Map.entry("yia", "я"),
            Map.entry("yii", "е"),
            Map.entry("yio", "йо")
    );

    public static final Map<String, String> AFTER_VOWELS_TIER_ONE = Map.ofEntries(
            Map.entry("ye", "йе"),
            Map.entry("yai", "йе"),
            Map.entry("yiia", "я"),
            Map.entry("giia", "я"),
            Map.entry("yie", "йе"),
            Map.entry("gie", "йе"),
            Map.entry("yiai", "йе"),
            Map.entry("giai", "йе"),
            Map.entry("yiio", "йо"),
            Map.entry("giio", "йо"),
            Map.entry("yiou", "ю"),
            Map.entry("giou", "ю"),
            Map.entry("yiiou", "ю"),
            Map.entry("giiou", "ю")
    );

    public static final Map<String, String> AFTER_VOWELS_TIER_TWO = Map.ofEntries(
            Map.entry("yia", "я"),
            Map.entry("gia", "я"),
            Map.entry("yio", "йо"),
            Map.entry("gio", "йо")
    );

    public static final Map<String, String> AFTER_VOWELS_TIER_THREE = Map.ofEntries(
            Map.entry("yo", "йо"),
            Map.entry("io", "йо")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("ea", "ея"),
            Map.entry("aia", "ея"),
            Map.entry("aía", "ея"),
            Map.entry("yi", "ьи"),
            Map.entry("gi", "ьи"),
            Map.entry("aiá", "еа")
    );

    public static final List<String> S_CASE_CONSONANTS = List.of("v", "g", "d", "m", "n");
    public static final List<String> VOICELESS_CONSONANTS = List.of("p", "t", "k", "f", "s");
    public static final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "y");
}
