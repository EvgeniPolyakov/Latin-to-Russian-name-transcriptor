package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.DefaultRuleset;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.List;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static polyakov.nametranscriptor.ruleset.resources.wordparts.Icelandic.*;

@Component
public class Icelandic extends DefaultRuleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkExceptions(name, NAMES, FALSE);
        name = checkPrimaryCases(name);
        name = checkStart(name);
        if (name.contains("g")) {
            name = checkCasesOfG(name);
        }
        if (name.contains("j")) {
            name = checkCasesOfJ(name);
        }
        if (name.contains("f")) {
            name = checkCasesOfF(name);
        }
        if (name.contains("l")) {
            name = checkCasesOfL(name);
        }
        name = checkVowels(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return mapStandardChars(name);
    }

    private static String checkSingleChars(String name) {
        name = name.replace("á", "ау");
        name = name.replace("æ", "ай");
        name = name.replace("é", "ье");
        name = name.replace("f", "в");
        name = name.replace("í", "и");
        name = name.replace("l", "ль");
        name = name.replace("ó", "оу");
        name = name.replace("u", "ю");
        name = name.replace("ú", "у");
        name = name.replace("y", "и");
        name = name.replace("ý", "и");
        name = name.replace("x", "хс");
        name = name.replace("z", "с");
        name = name.replace("ö", "е");
        return name;
    }

    private static String checkPrimaryCases(String name) {
        name = name.replace("ð", "d");
        name = name.replace("lft", "lt");
        name = name.replace("th", "t");
        name = name.replace("þ", "t");
        for (String forepart : List.of("á", "é", "í", "ó", "ú", "ý", "ee", "æ", "ei", "ey")) {
            name = name.replace(forepart + "nn", forepart + "дн");
        }
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("au", "ей");
        name = name.replace("ks", "хс");
        name = name.replace("kt", "хт");
        name = name.replace("ps", "фс");
        name = name.replace("pt", "фт");
        name = name.replace("rl", "дл");
        name = name.replace("rл", "дл");
        name = name.replace("rn", "дн");
        return name;
    }

    private static String checkStart(String name) {
        for (Map.Entry<String, String> starter : PRIMARY_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        for (Map.Entry<String, String> starter : SECONDARY_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                return name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        return name;
    }

    private static String checkCasesOfL(String name) {
        name = name.replace("lь", "ль");
        name = name.replace("lld", "лld");
        name = name.replace("lls", "лls");
        name = name.replace("llt", "лlt");
        name = name.replace("ll", "дl");
        for (String vowel : VOWELS) {
            name = name.replace("l" + vowel, "л" + vowel);
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

    private static String checkCasesOfF(String name) {
        if (name.startsWith("f")) {
            name = name.replaceFirst("f", "ф");
        }
        name = name.replace("fl", "бл");
        name = name.replace("fn", "бн");
        for (String consonant : VOICELESS_CONSONANTS) {
            name = name.replace("f" + consonant, "ф" + consonant);
        }
        return name;
    }

    private static String checkCasesOfG(String name) {
        name = name.replace("gs", "хс");
        name = name.replace("gt", "хт");
        name = name.replace("eig", "ei");
        name = name.replace("eyg", "ey");
        name = name.replace("æg", "æ");
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "gj", vowel + "j");
            name = name.replace(vowel + "gi", vowel + "йi");
        }
        return name;
    }

    private static String checkVowels(String name) {
        name = name.replace("ei", "eй");
        name = name.replace("ey", "eй");
        name = name.replace("ang", "аунг");
        name = name.replace("ank", "аунк");
        name = name.replace("eng", "ейнг");
        name = name.replace("enk", "ейнк");
        name = name.replace("ong", "оунг");
        name = name.replace("onk", "оунк");
        name = name.replace("ung", "унг");
        name = name.replace("unk", "унк");
        name = name.replace("öng", "ейнг");
        name = name.replace("önk", "ейнк");
        for (String vowel : VOWELS) {
            name = name.replace(vowel + "e", vowel + "э");
            name = name.replace(vowel + "é", vowel + "э");
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.ICELANDIC.getName();
    }
}