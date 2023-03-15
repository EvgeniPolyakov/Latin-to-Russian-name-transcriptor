package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.DefaultRuleset;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Map;

import static java.lang.Boolean.TRUE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.German.*;

@Component
public class German extends DefaultRuleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, TRUE);
        name = checkPrimaryCases(name);
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        name = checkStart(name);
        name = checkEndings(name, ENDINGS);
        name = checkVowels(name);
        name = checkCombinations(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("ä", "е");
        name = name.replace("c", "к");
        name = name.replace("j", "й");
        name = name.replace("l", "ль");
        name = name.replace("ö", "е");
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
        name = name.replace("lь", "ль");
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

    private static String checkCasesOfJ(String name) {
        for (Map.Entry<String, String> jCombination : J_CASES.entrySet()) {
            if (name.startsWith(jCombination.getKey())) {
                name = name.replaceFirst(jCombination.getKey(), jCombination.getValue());
                break;
            }
        }
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> jCombination : J_CASES.entrySet()) {
                name = name.replace(vowel + jCombination.getKey(), vowel + jCombination.getValue());
            }
        }
        for (Map.Entry<String, String> jCombination : J_CASES_AFTER_CONSONANTS.entrySet()) {
            name = name.replace(jCombination.getKey(), jCombination.getValue());
        }
        return name;
    }

    private static String checkVowels(String name) {
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "e", vowel + "э");
            for (Map.Entry<String, String> beforeVowel : BEFORE_VOWELS.entrySet()) {
                name = name.replace(beforeVowel.getKey() + vowel, beforeVowel.getValue() + vowel);
            }
            for (Map.Entry<String, String> afterVowel : AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + afterVowel.getKey(), vowel + afterVowel.getValue());
            }
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ck" + vowel2, vowel + "кк" + vowel2);
                name = name.replace(vowel + "tz" + vowel2, vowel + "тц" + vowel2);
                name = name.replace(vowel + "ll" + vowel2, vowel + "лл" + vowel2);
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.GERMAN.getName();
    }
}