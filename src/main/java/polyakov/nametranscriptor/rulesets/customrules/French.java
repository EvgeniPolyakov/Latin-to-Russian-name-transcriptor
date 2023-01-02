package polyakov.nametranscriptor.rulesets.customrules;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class French {

    public static final Map<String, String> FIRST_TIER_ENDINGS = Map.ofEntries(
            Map.entry("eille", "ей"),
            Map.entry("euil", "ей"),
            Map.entry("оld", "о"),
            Map.entry("оlt", "о"),
            Map.entry("ould", "у"),
            Map.entry("oult", "у"),
            Map.entry("cher", "ше"),
            Map.entry("cquэs", "к"),
            Map.entry("cquэ", "к"),
            Map.entry("ger", "же"),
            Map.entry("iers", "ье"),
            Map.entry("йers", "йе"),
            Map.entry("ийes", "иль"),
            Map.entry("оx", "о"),
            Map.entry("еx", "е"),
            Map.entry("эx", "э"),
            Map.entry("ьеx", "ье"),
            Map.entry("ieu", "ье"),
            Map.entry("ail", "ай"),
            Map.entry("ien", "ьен"),
            Map.entry("ects", "е"),
            Map.entry("am", "ам"),
            Map.entry("in", "ен"),
            Map.entry("yn", "ен"),
            Map.entry("ès", "ес"),
            Map.entry("ais", "е"),
            Map.entry("ays", "еи"),
            Map.entry("aye", "ай"),
            Map.entry("ois", "уа"),
            Map.entry("eis", "ей"),
            Map.entry("ouis", "уи")
    );

    public static final Map<String, String> SECOND_TIER_ENDINGS = Map.ofEntries(
            Map.entry("ille", "й"),
            Map.entry("quэs", "к"),
            Map.entry("quэ", "к"),
            Map.entry("cts", ""),
            Map.entry("ch", "ш"),
            Map.entry("aux", "о"),
            Map.entry("uis", "юи"),
            Map.entry("ier", "ье"),
            Map.entry("йer", "йе"),
            Map.entry("eil", "ей"),
            Map.entry("en", "ен")
    );

    public static final Map<String, String> THIRD_TIER_ENDINGS = Map.ofEntries(
            Map.entry("is", "ис"),
            Map.entry("es", ""),
            Map.entry("ct", "")
    );

    public static final Map<String, String> FIRST_TIER_STARTERS = Map.ofEntries(
            Map.entry("hin", "эн"),
            Map.entry("un", "эн"),
            Map.entry("ey", "э"),
            Map.entry("eû", "э"),
            Map.entry("ei", "эй"),
            Map.entry("eî", "эй"),
            Map.entry("he", "э"),
            Map.entry("hé", "э"),
            Map.entry("œu", "э"),
            Map.entry("aim", "эн"),
            Map.entry("ain", "эн"),
            Map.entry("ay", "э"),
            Map.entry("ya", "я")
    );

    public static final Map<String, String> SECOND_TIER_STARTERS = Map.ofEntries(
            Map.entry("é", "э"),
            Map.entry("œ", "э"),
            Map.entry("e", "э"),
            Map.entry("ai", "э")
    );

    public static final Map<String, String> AFTER_VOWELS = Map.ofEntries(
            Map.entry("ier", "йе"),
            Map.entry("eû", "э"),
            Map.entry("ey", "э"),
            Map.entry("eu", "э"),
            Map.entry("ai", "э"),
            Map.entry("ay", "э"),
            Map.entry("in", "эн"),
            Map.entry("œ", "э"),
            Map.entry("œu", "э"),
            Map.entry("é", "э")
    );

    public static final Map<String, String> BEFORE_VOWELS = Map.ofEntries(
            Map.entry("ch", "ш"),
            Map.entry("om", "ом"),
            Map.entry("um", "юм"),
            Map.entry("un", "юн"),
            Map.entry("oy", "уай"),
            Map.entry("in", "ин"),
            Map.entry("yn", "ин"),
            Map.entry("ym", "им"),
            Map.entry("ey", "ей"),
            Map.entry("en", "ен"),
            Map.entry("am", "ам"),
            Map.entry("ï", "й")
    );

    public static final Map<String, String> BEFORE_BMP = Map.ofEntries(
            Map.entry("ain", "эм"),
            Map.entry("aim", "эм"),
            Map.entry("am", "ам"),
            Map.entry("em", "ам"),
            Map.entry("om", "ом")
    );

    public static final List<String> EMPTY_ENDINGS = List.of("e", "g", "s", "c", "d", "t", "p");
    public static final List<String> BM_CONSONANTS = List.of("b", "m", "б", "м");
    public static final List<String> AOU_VOWELS = List.of("a", "o", "u", "а", "о");
    public static final List<String> EIY_VOWELS = List.of("e", "é", "è", "ê", "ë", "i", "y", "э");
    public static final List<String> VOWELS = List.of("a", "à", "â", "e", "é", "é", "ë", "è", "ê", "i", "î",
            "ï", "o", "ô", "u", "û", "y", "а", "е", "и", "о", "э", "ю", "я");
}