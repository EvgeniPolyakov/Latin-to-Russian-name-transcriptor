package polyakov.nametranscriptor.ruleset.resources.wordparts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import polyakov.nametranscriptor.ruleset.resources.popularnames.UkrainianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static final Map<String, String> UKRAINIAN_NAMES = Arrays.stream(UkrainianNames.values())
            .collect(Collectors.toMap(UkrainianNames::getLatinName, UkrainianNames::getCyrillicName));
}
