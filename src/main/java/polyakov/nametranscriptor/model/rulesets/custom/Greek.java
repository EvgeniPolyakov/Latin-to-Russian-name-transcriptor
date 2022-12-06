package polyakov.nametranscriptor.model.rulesets.custom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Greek {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("ai", "э"),
            Map.entry("Ai", "Э"),
            Map.entry("e", "э"),
            Map.entry("E", "Э"),
            Map.entry("ie", "ие"),
            Map.entry("Ie", "Ие"),
            Map.entry("mp", "б"),
            Map.entry("Mp", "Б"),
            Map.entry("nt", "д"),
            Map.entry("Nt", "Д"),
            Map.entry("ye", "е"),
            Map.entry("yai", "е"),
            Map.entry("Ye", "Е"),
            Map.entry("Yai", "Е"),
            Map.entry("yia", "я"),
            Map.entry("yiia", "я"),
            Map.entry("gia", "я"),
            Map.entry("giia", "я"),
            Map.entry("ioa", "я"),
            Map.entry("Yia", "Я"),
            Map.entry("Yiia", "Я"),
            Map.entry("Gia", "Я"),
            Map.entry("Giia", "Я"),
            Map.entry("Ioa", "Я"),
            Map.entry("yie", "е"),
            Map.entry("gie", "е"),
            Map.entry("yiai", "е"),
            Map.entry("giai", "е"),
            Map.entry("Yie", "Е"),
            Map.entry("Gie", "Е"),
            Map.entry("Yiai", "Е"),
            Map.entry("Giai", "Е"),
            Map.entry("yio", "йо"),
            Map.entry("gio", "йо"),
            Map.entry("yiio", "йо"),
            Map.entry("giio", "йо"),
            Map.entry("Yio", "Йо"),
            Map.entry("Gio", "Йо"),
            Map.entry("Yiio", "Йо"),
            Map.entry("Giio", "Йо"),
            Map.entry("yiou", "ю"),
            Map.entry("giou", "ю"),
            Map.entry("yiiou", "ю"),
            Map.entry("giiou", "ю"),
            Map.entry("Yiou", "Ю"),
            Map.entry("Giou", "Ю"),
            Map.entry("Yiiou", "Ю"),
            Map.entry("Giiou", "Ю")
    );

    public static final Map<String, String> AFTER_VOWELS_PART_ONE = Map.ofEntries(
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

    public static final Map<String, String> AFTER_VOWELS_PART_TWO = Map.ofEntries(
            Map.entry("yia", "я"),
            Map.entry("gia", "я"),
            Map.entry("yio", "йо"),
            Map.entry("gio", "йо")
    );

    public static final Map<String, String> AFTER_VOWELS_PART_THREE = Map.ofEntries(
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

    public static final List<String> VOWELS = List.of(
            "ou", "Ou", "OU", "a", "A", "e", "E", "i", "I", "ï", "Ï", "í", "Í", "o", "O", "u", "U", "y", "Y"
    );
}
