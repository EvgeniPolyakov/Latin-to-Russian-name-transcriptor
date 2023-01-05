package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.LatvianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Latvian.*;

@Component
public class Latvian implements Ruleset {
    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkPrimaryCases(name);
        name = checkCustomCases(name);
        name = checkSoftConsonants(name, mode);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("ģ", "гь");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("ķ", "кь");
        name = name.replace("l", "л");
        name = name.replace("ļ", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("ņ", "нь");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("š", "ш");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("y", "ы");
        name = name.replace("z", "з");
        name = name.replace("ž", "ж");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("ā", "a");
        name = name.replace("ē", "e");
        name = name.replace("ī", "i");
        name = name.replace("ō", "o");
        name = name.replace("ū", "u");
        name = name.replace("ļļ", "лļ");
        name = name.replace("ņņ", "нņ");
        name = name.replace("šč", "щ");
        return name;
    }

    private static String checkCustomCases(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                name = sub + ending.getValue();
                break;
            }
        }
        for (String vowel : VOWELS) {
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "i", vowel + "й");
            }
        }
        return name;
    }

    private static String checkSoftConsonants(String name, int mode) {
        for (Map.Entry<String, String> cons : SOFT_CONSONANTS.entrySet()) {
            if (mode == 1) {
                name = name.replace(cons.getKey() + "o", cons.getValue() + "ё");
            }
            for (Map.Entry<String, String> asc : AFTER_SOFT_CONSONANTS.entrySet()) {
                name = name.replace(cons.getKey() + asc.getKey(), cons.getValue() + asc.getValue());
            }
            name = name.replace(cons.getKey() + "j", cons.getValue() + "j");
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        for (Map.Entry<String, String> jfc : J_CASES.entrySet()) {
            if (name.startsWith(jfc.getKey())) {
                name = name.replaceFirst(jfc.getKey(), jfc.getValue());
                break;
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jc : J_CASES.entrySet()) {
                name = name.replace(vowel + jc.getKey(), vowel + jc.getValue());
            }
        }
        for (Map.Entry<String, String> jcac : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(jcac.getKey(), jcac.getValue());
        }
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(LatvianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(LatvianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.LATVIAN.getName();
    }
}