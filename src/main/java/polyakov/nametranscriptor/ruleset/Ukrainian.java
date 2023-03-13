package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Russian.RUSSIAN_NAMES;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Ukrainian.*;

@Component
public class Ukrainian extends RulesetImpl {

    @Override
    public String transcribe(String name, int mode) {
        name = StringUtils.stripAccents(name);
        name = checkExceptions(name);
        Optional<String> ukrainianName = Optional.ofNullable(UKRAINIAN_NAMES.get(name));
        if (ukrainianName.isPresent()) {
            return ukrainianName.get();
        }
        Optional<String> russianName = Optional.ofNullable(RUSSIAN_NAMES.get(name));
        if (russianName.isPresent()) {
            return russianName.get();
        }
        name = checkStart(name);
        name = checkEndings(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        name = mapStandardChars(name);
        return postcheck(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("c", "ц");
        name = name.replace("h", "г");
        name = name.replace("l", "л");
        name = name.replace("y", "ы");
        name = name.replace("x", "кс");
        name = name.replace("'", "ь");
        return name;
    }

    private String checkCombinations(String name) {
        name = name.replace("sch", "щ");
        name = name.replace("sch", "щ");
        name = name.replace("shch", "щ");
        name = name.replace("sh", "ш");
        name = name.replace("ch", "ч");
        name = name.replace("iya", "ия");
        name = name.replace("iia", "ия");
        name = name.replace("ya", "я");
        name = name.replace("ia", "я");
        name = name.replace("aye", "ае");
        name = name.replace("aie", "ае");
        name = name.replace("ay", "ай");
        name = name.replace("ai", "ай");
        name = name.replace("iu", "ю");
        name = name.replace("yu", "ю");
        name = name.replace("uy", "уй");
        name = name.replace("ui", "уй");
        name = name.replace("ye", "е");
        name = name.replace("ie", "е");
        name = name.replace("ey", "ей");
        name = name.replace("ei", "ей");
        name = name.replace("yi", "ий");
        name = name.replace("yo", "йо");
        name = name.replace("io", "йо");
        name = name.replace("oy", "ой");
        name = name.replace("oi", "ой");
        name = name.replace("y", "и");
        name = name.replace("ts", "ц");
        name = name.replace("zgh", "зг");
        name = name.replace("zh", "ж");
        name = name.replace("kh", "х");
        return name;
    }

    private static String checkStart(String name) {
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replace(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("e")) {
            return name.replaceFirst("e", "э");
        }
        if (name.startsWith("y")) {
            return name.replaceFirst("y", "й");
        }
        return name;
    }

    private static String checkEndings(String name) {
        name = name.replace("j", "y");
        name = name.replace("tskyi", "цкий");
        name = name.replace("tskiy", "цкий");
        name = name.replace("tskii", "цкий");
        name = name.replace("tsky", "цкий");
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        return name;
    }

    private static String postcheck(String name) {
        if (name.endsWith("иы")) {
            return name.substring(0, name.length() - 2) + "ий";
        }
        return name;
    }

    private static String checkExceptions(String name) {
        String nameWithNoAccents = StringUtils.stripAccents(name);
        Optional<String> russianNames = Optional.ofNullable(UKRAINIAN_NAMES.get(nameWithNoAccents));
        return russianNames.orElseGet(() -> Optional.ofNullable(RUSSIAN_NAMES.get(nameWithNoAccents)).orElse(name));
    }

    @Override
    public String getName() {
        return RulesetName.UKRAINIAN.getName();
    }
}