package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.GermanNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.German.*;

@Component
public class German implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkPrimaryCases(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = checkStart(name);
        name = checkEndings(name);
        name = checkVowels(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("ä", "е");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
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
        name = name.replace("ö", "е");
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("q", "к");
        name = name.replace("u", "у");
        name = name.replace("ü", "ю");
        name = name.replace("v", "ф");
        name = name.replace("w", "в");
        name = name.replace("x", "кс");
        name = name.replace("y", "и");
        name = name.replace("z", "ц");
        name = name.replace("ß", "с");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("aa", "a");
        name = name.replace("ae", "ä");
        name = name.replace("aie", "айе");
        name = name.replace("ai", "ай");
        name = name.replace("ay", "ай");
        name = name.replace("ah", "a");
        name = name.replace("äh", "ä");
        name = name.replace("dh", "d");
        name = name.replace("ee", "e");
        name = name.replace("eh", "e");
        name = name.replace("eie", "айе");
        name = name.replace("ei", "ай");
        name = name.replace("eu", "ой");
        name = name.replace("ey", "ай");
        name = name.replace("ien", "иен");
        name = name.replace("ih", "i");
        name = name.replace("ieh", "ie");
        name = name.replace("oie", "ойе");
        name = name.replace("oi", "ой");
        name = name.replace("ie", "и");
        name = name.replace("oe", "ö");
        name = name.replace("oo", "o");
        name = name.replace("oh", "o");
        name = name.replace("öh", "ö");
        name = name.replace("uh", "u");
        name = name.replace("üh", "ü");
        name = name.replace("yh", "y");
        name = name.replace("ph", "ф");
        name = name.replace("chs", "кс");
        name = name.replace("ss", "сс");
        name = name.replace("ll", "лl");
        name = name.replace("schtsch", "щ");
        name = name.replace("tsch", "ч");
        name = name.replace("tzsch", "ч");
        name = name.replace("zsch", "ч");
        name = name.replace("sch", "ш");
        name = name.replace("sp", "шп");
        name = name.replace("stst", "стшт");
        name = name.replace("сtst", "стшт");
        name = name.replace("st", "шт");
        name = name.replace("сt", "шт");
        name = name.replace("quä", "кве");
        name = name.replace("que", "кве");
        name = name.replace("äue", "ойэ");
        name = name.replace("aue", "ауэ");
        name = name.replace("ue", "ü");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("äu", "ой");
        name = name.replace("chh", "хх");
        name = name.replace("ck", "к");
        name = name.replace("eue", "ойэ");
        name = name.replace("gk", "г");
        name = name.replace("oe", "ö");
        name = name.replace("лu", "лю");
        name = name.replace("oy", "ой");
        name = name.replace("qu", "кв");
        name = name.replace("rh", "р");
        name = name.replace("th", "т");
        name = name.replace("tion", "цион");
        name = name.replace("tz", "ц");
        name = name.replace("ch", "х");
        name = name.replace("ce", "цe");
        name = name.replace("ci", "цi");
        name = name.replace("ye", "ие");
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

    private static String checkEndings(String name) {
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                return sub + ending.getValue();
            }
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        for (Map.Entry<String, String> jc : J_CASES.entrySet()) {
            if (name.startsWith(jc.getKey())) {
                name = name.replaceFirst(jc.getKey(), jc.getValue());
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

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "e", vowel + "э");
            for (Map.Entry<String, String> beforeVowel : BEFORE_VOWELS.entrySet()) {
                name = name.replace(beforeVowel.getKey() + vowel, beforeVowel.getValue() + vowel);
            }
            for (Map.Entry<String, String> av : AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + av.getKey(), vowel + av.getValue());
            }
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ck" + vowel2, vowel + "кк" + vowel2);
                name = name.replace(vowel + "tz" + vowel2, vowel + "тц" + vowel2);
                name = name.replace(vowel + "ll" + vowel2, vowel + "лл" + vowel2);
            }
        }
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(GermanNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(GermanNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.GERMAN.getName();
    }
}