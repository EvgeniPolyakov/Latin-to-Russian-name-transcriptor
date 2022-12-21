package polyakov.nametranscriptor.rulesets.customrules;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Ukrainian {

    public static final Map<String, String> STARTERS = Map.ofEntries(
            Map.entry("ye", "е"),
            Map.entry("yu", "ю"),
            Map.entry("yi", "и"),
            Map.entry("ya", "я")
    );

    public static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("skyi", "ский"),
            Map.entry("sky", "ский"),
            Map.entry("ski", "ский"),
            Map.entry("skiy", "ский"),
            Map.entry("ii", "ий")
    );
}
