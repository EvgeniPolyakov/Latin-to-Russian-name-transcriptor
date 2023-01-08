package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.DutchNames;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Dutch.*;

@Component
public class Dutch implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkPrimaryCases(name, mode);
        if (name.contains("c")) {
            name = checkCasesOfC(name);
        }
        name = checkVowels(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = checkStart(name);
        name = checkEndings(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("ä", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("ë", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("ï", "и");
        name = name.replace("j", "й");
        name = name.replace("k", "к");
        name = name.replace("l", "л");
        name = name.replace("n", "н");
        name = name.replace("m", "м");
        name = name.replace("o", "о");
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("q", "к");
        name = name.replace("u", "ю");
        name = name.replace("ü", "у");
        name = name.replace("w", "в");
        name = name.replace("v", "в");
        name = name.replace("x", "кс");
        name = name.replace("y", "и");
        name = name.replace("z", "з");
        return name;
    }

    private static String checkPrimaryCases(String name, int mode) {
        if (name.startsWith("eeu")) {
            name = name.replaceFirst("eeu", "эу");
        }
        name = name.replaceFirst("eeu", "еу");
        if (mode != 1) {
            name = name.replace("aa", "a");
            name = name.replace("ee", "e");
            name = name.replace("ii", "i");
            name = name.replace("oo", "o");
            name = name.replace("uu", "u");
        }
        name = name.replace("aeu", "ау");
        name = name.replace("ae", "а");
        name = name.replace("eëe", "ее");
        name = name.replace("ee", "еe");
        name = name.replace("oe", "у");
        name = name.replace("iu", "иу");
        name = name.replace("qu", "кв");
        name = name.replace("schen", "сен");
        name = name.replace("sche", "се");
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("aë", "аэ");
        name = name.replace("auwe", "ауэ");
        name = name.replace("auw", "ау");
        name = name.replace("au", "ау");
        name = name.replace("eë", "ее");
        name = name.replace("ia", "ия");
        name = name.replace("ie", "и");
        name = name.replace("ië", "ие");
        name = name.replace("ouwe", "ауэ");
        name = name.replace("ouw", "ау");
        name = name.replace("ou", "ау");
        name = name.replace("oë", "оэ");
        name = name.replace("ckx", "кс");
        name = name.replace("ch", "х");
        name = name.replace("ck", "к");
        name = name.replace("eu", "е");
        name = name.replace("gh", "г");
        name = name.replace("ij", "ей");
        name = name.replace("ph", "ф");
        name = name.replace("sj", "ш");
        name = name.replace("sz", "с");
        return name;
    }

    private static String checkStart(String name) {
        for (Map.Entry<String, String> starter : FIRST_TIER_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        for (Map.Entry<String, String> starter : SECOND_TIER_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("u")) {
            name = name.replaceFirst("u", "у");
            return name;
        }
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
            return name;
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
        if (name.endsWith("h")) {
            return name.substring(0, name.length() - 1);
        }
        return name;
    }

    private static String checkCasesOfJ(String name) {
        if (name.startsWith("jou")) {
            name = name.replaceFirst("jou", "яу");
        }
        for (Map.Entry<String, String> jc : J_CASES.entrySet()) {
            if (name.startsWith(jc.getKey())) {
                name = name.replaceFirst(jc.getKey(), jc.getValue());
                break;
            }
        }
        for (String vowel : VOWELS) {
            if (name.startsWith("jou")) {
                name = name.replace(vowel + "jou", vowel + "яу");
            }
            for (Map.Entry<String, String> jc : J_CASES.entrySet()) {
                name = name.replace(vowel + jc.getKey(), vowel + jc.getValue());
            }
        }
        name = name.replace("jou", "ьяу");
        for (Map.Entry<String, String> jcac : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(jcac.getKey(), jcac.getValue());
        }
        return name;
    }

    private static String checkCasesOfC(String name) {
        for (String vowel : List.of("e", "i", "y")) {
            name = name.replace("cc" + vowel, "кс" + vowel);
            name = name.replace("c" + vowel, "с" + vowel);
        }
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ck" + vowel2, vowel + "кк" + vowel2);
            }
            name = name.replace(vowel + "uij", vowel + "эй");
            name = name.replace(vowel + "ij", vowel + "й");
            for (Map.Entry<String, String> afterVowel : AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
            }
        }
        name = name.replace("uэ", "ей");
        name = name.replace("uй", "ей");
        return name;
    }

    private static Optional<String> checkPopularNames(String name) {
        return Arrays.stream(DutchNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(DutchNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.DUTCH.getName();
    }
}