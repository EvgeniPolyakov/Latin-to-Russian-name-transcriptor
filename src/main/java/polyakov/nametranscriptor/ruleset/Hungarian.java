package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Hungarian.*;

@Component
public class Hungarian extends RulesetImpl {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, TRUE);
        name = checkPrimaryCases(name);
        name = checkVowels(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkStart(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    protected static String mapSingleChars(String name) {
        name = name.replace("c", "ц");
        name = name.replace("j", "и");
        name = name.replace("l", "ль");
        name = name.replace("ö", "е");
        name = name.replace("s", "ш");
        name = name.replace("y", "и");
        name = name.replace("ü", "ю");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("ck", "к");
        name = name.replace("cs", "ч");
        name = name.replace("cz", "ц");
        name = name.replace("dy", "дь");
        name = name.replace("ggy", "ддь");
        name = name.replace("gyj", "ддь");
        name = name.replace("gy", "дь");
        name = name.replace("jj", "й");
        name = name.replace("lja", "лья");
        name = name.replace("lju", "лью");
        name = name.replace("ny", "нь");
        name = name.replace("qu", "к");
        name = name.replace("sz", "с");
        name = name.replace("tzsch", "ч");
        name = name.replace("ch", "х");
        name = name.replace("ty", "ть");
        name = name.replace("tz", "ц");
        name = name.replace("zs", "ж");
        name = name.replace("ss", "ш");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("á", "a");
        name = name.replace("é", "e");
        name = name.replace("í", "i");
        name = name.replace("ó", "o");
        name = name.replace("ő", "ö");
        name = name.replace("eö", "ö");
        name = name.replace("ew", "ö");
        name = name.replace("ú", "u");
        name = name.replace("ű", "ü");
        name = name.replace("lly", "j");
        name = name.replace("ly", "j");
        name = name.replace("gh", "g");
        name = name.replace("th", "t");
        return name;
    }

    private static String checkVowels(String name) {
        name = checkSoftenedVowels(name);
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        if (name.startsWith("ö")) {
            name = name.replaceFirst("ö", "э");
        }
        if (name.endsWith("ia")) {
            name = name.substring(0, name.length() - 2) + "ия";
        }
        for (String vowel : VOWELS) {
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
            }
            name = name.replace(vowel + "ö", vowel + "э");
        }
        return name;
    }

    private static String checkSoftenedVowels(String name) {
        for (Map.Entry<String, String> vowel : SOFTENED_VOWELS.entrySet()) {
            for (Map.Entry<String, String> vs : VOWEL_SOFTENERS.entrySet()) {
                name = name.replace(vs.getKey() + vowel.getKey(), vs.getValue() + vowel.getValue());
            }
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        for (Map.Entry<String, String> entry : J_START_CASES.entrySet()) {
            if (name.startsWith(entry.getKey())) {
                name = name.replaceFirst(entry.getKey(), entry.getValue());
                break;
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> entry : J_VOWEL_CASES.entrySet()) {
                name = name.replace(vowel + entry.getKey(), vowel + entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry : J_CONSONANT_CASES.entrySet()) {
            name = name.replace(entry.getKey(), entry.getValue());
        }
        name = checkIotation(name);
        return name;
    }

    private static String checkIotation(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "j", vowel + "й");
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("lь", "ль");
        name = name.replace("ll", "лl");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
        }
        return name;
    }

    private static String checkStart(String name) {
        for (Map.Entry<String, String> starter : STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.HUNGARIAN.getName();
    }
}