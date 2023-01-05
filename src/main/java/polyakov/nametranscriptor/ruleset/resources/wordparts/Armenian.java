package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Armenian {
    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("hay", "ай"),
            Map.entry("hakob", "акоп"),
            Map.entry("hovhann", "оган"),
            Map.entry("hambardz", "амбарц")
    );
}
