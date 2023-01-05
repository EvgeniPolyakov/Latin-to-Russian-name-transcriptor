package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.LithuanianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Lithuanian.*;


@Component
public class Lithuanian implements Ruleset {
    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkPrimaryCases(name);
        name = checkCustomCases(name);
        name = checkCombinations(name, mode);
        name = checkSingleChars(name);
        return name;
    }

    private String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "ц");
        name = name.replace("č", "ч");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("ė", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("l", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("š", "ш");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("v", "в");
        name = name.replace("z", "з");
        name = name.replace("ž", "ж");
        return name;
    }

    private String checkPrimaryCases(String name) {
        name = name.replace("ą", "a");
        name = name.replace("ę", "e");
        name = name.replace("é", "ė");
        name = name.replace("į", "i");
        name = name.replace("y", "i");
        name = name.replace("ū", "u");
        name = name.replace("ų", "ū");
        name = name.replace("kevič", "кявич");
        name = name.replace("levič", "лявич");
        name = name.replace("zevič", "зявич");
        name = name.replace("cevič", "цявич");
        name = name.replace("čevič", "чявич");
        name = name.replace("nevič", "нявич");
        name = name.replace("sevič", "сявич");
        return name;
    }

    private String checkCustomCases(String name) {
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        if (name.startsWith("ė")) {
            name = name.replaceFirst("ė", "э");
        }
        for (String vowel : VOWELS) {
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "ė", vowel + "э");
            }
            name = name.replace("l" + vowel, "л" + vowel);
            name = name.replace(vowel + "i", vowel + "й");
        }
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        return name;
    }

    private String checkCombinations(String name, int mode) {
        name = name.replace("ji", "йи");
        name = name.replace("jo", "йо");
        name = name.replace("ch", "х");
        name = name.replace("šč", "щ");
        name = name.replace("ei", "ей");
        name = name.replace("ia", "я");
        name = name.replace("ie", "е");
        name = name.replace("iu", "ю");
        if (mode == 1) {
            name = name.replace("io", "ё");
        }
        name = name.replace("io", "е");
        return name;
    }

    private String checkCasesOfJ(String name) {
        for (Map.Entry<String, String> jfc : J_CASES.entrySet()) {
            if (name.startsWith(jfc.getKey())) {
                name = name.replaceFirst(jfc.getKey(), jfc.getValue());
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> c : J_CASES.entrySet()) {
                name = name.replace(vowel + c.getKey(), vowel + c.getValue());
            }
        }
        for (Map.Entry<String, String> jcac : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(jcac.getKey(), jcac.getValue());
        }
        return name;
    }

    private String checkCasesOfL(String name) {
        if (name.endsWith("ll")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "лль";
        }
        if (name.endsWith("l")) {
            String sub = name.substring(0, name.length() - 1);
            name = sub + "ль";
        }
        while (name.contains("l")) {
            int indexOfL = name.indexOf("l");
            if (indexOfL + 2 >= name.length()) {
                return name;
            }
            String charToCheck = String.valueOf(name.charAt(indexOfL + 2));
            for (String sc : CONSONANT_SOFTENERS) {
                if (charToCheck.equals(sc)) {
                    name = name.substring(0, indexOfL) + "ль" + name.substring(indexOfL + 1);
                } else {
                    name = name.substring(0, indexOfL) + "л" + name.substring(indexOfL + 1);
                }
            }
        }
        return name;
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(LithuanianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(LithuanianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.LITHUANIAN.getName();
    }
}