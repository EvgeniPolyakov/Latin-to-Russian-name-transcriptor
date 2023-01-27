package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.ArmenianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Armenian {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("hay", "ай"),
            Map.entry("hakob", "акоп"),
            Map.entry("hovhann", "оган"),
            Map.entry("hambardz", "амбарц")
    );

    public static final Map<String, String> ARMENIAN_NAMES = Arrays.stream(ArmenianNames.values())
            .collect(Collectors.toMap(ArmenianNames::getLatinName, ArmenianNames::getCyrillicName));
}
