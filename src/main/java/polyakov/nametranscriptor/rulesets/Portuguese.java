package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.rulesets.names.PortugueseNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.rulesets.customrules.Portuguese.*;

@Component
public class Portuguese implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkPrimaryCases(name);
        name = checkStart(name);
        name = checkEnd(name);
        name = checkVowels(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return name;
    }

    private String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("à", "а");
        name = name.replace("á", "а");
        name = name.replace("â", "а");
        name = name.replace("ã", "ан");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("ç", "с");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("é", "е");
        name = name.replace("ê", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "х");
        name = name.replace("i", "и");
        name = name.replace("j", "ж");
        name = name.replace("k", "к");
        name = name.replace("l", "л");
        name = name.replace("m", "н");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("ó", "о");
        name = name.replace("ô", "о");
        name = name.replace("p", "п");
        name = name.replace("q", "к");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("u", "у");
        name = name.replace("ü", "у");
        name = name.replace("ú", "у");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("x", "ш");
        name = name.replace("z", "з");
        return name;
    }

    private String checkCombinations(String name) {
        name = name.replace("ãу", "ан");
        name = name.replace("ãэ", "айн");
        name = name.replace("ou", "о");
        name = name.replace("oa", "уа");
        name = name.replace("oe", "уэ");
        name = name.replace("oэ", "уэ");
        name = name.replace("ge", "жe");
        name = name.replace("gé", "жe");
        name = name.replace("gê", "жe");
        name = name.replace("gi", "жi");
        name = name.replace("sce", "шсе");
        name = name.replace("sci", "шси");
        name = name.replace("ce", "сe");
        name = name.replace("cé", "сe");
        name = name.replace("cê", "сe");
        name = name.replace("ci", "сi");
        name = name.replace("ch", "ш");
        name = name.replace("cb", "б");
        name = name.replace("cd", "д");
        name = name.replace("cp", "п");
        name = name.replace("ct", "т");
        name = name.replace("iu", "иу");
        name = name.replace("lh", "ль");
        name = name.replace("nh", "нь");
        name = name.replace("nã", "на");
        name = name.replace("mb", "мб");
        name = name.replace("mp", "мп");
        name = name.replace("õэ", "ойн");
        name = name.replace("sp", "шп");
        name = name.replace("st", "шт");
        name = name.replace("sc", "шк");
        name = name.replace("sq", "шк");
        name = name.replace("th", "т");
        name = name.replace("ph", "ф");
        for (String vc : VOICED_CONSONANTS) {
            name = name.replace("z" + vc, "ж" + vc);
            name = name.replace("s" + vc, "з" + vc);
        }
        return name;
    }

    private String checkPrimaryCases(String name) {
        name = name.replace("y", "i");
        name = name.replace("gue", "гe");
        name = name.replace("gui", "гi");
        name = name.replace("que", "кe");
        name = name.replace("qui", "кi");
        name = name.replace("maxim", "максим");
        name = name.replace("máxim", "масим");
        return name;
    }

    private String checkStart(String name) {
        if (name.startsWith("h")) {
            name = name.substring(1);
        }
        for (Map.Entry<String, String> e : STARTERS.entrySet()) {
            if (name.startsWith(e.getKey())) {
                name = name.replaceFirst(e.getKey(), e.getValue());
            }
        }
        for (String vowel : VOWELS) {
            if (name.startsWith("ex" + vowel)) {
                name = name.replaceFirst("ex" + vowel, "эз" + vowel);
            }
        }
        return name;
    }

    private String checkEnd(String name) {
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> eav : ENDINGS_AFTER_VOWELS.entrySet()) {
                if (name.endsWith(vowel + eav.getKey())) {
                    String sub = name.substring(0, name.length() - eav.getKey().length());
                    name = sub + eav.getValue();
                }
            }
        }
        if (name.endsWith("ios")) {
            String sub = name.substring(0, name.length() - 3);
            name = sub + "иуш";
        }
        if (name.endsWith("os")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "уш";
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                name = sub + ending.getValue();
            }
        }
        if (name.endsWith("m")) {
            String sub = name.substring(0, name.length() - 1);
            name = sub + "м";
        }
        return name;
    }

    private String checkVowels(String name) {
        for (String vowel : VOWELS) {
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel + "ss" + vowel2, vowel + "с" + vowel2);
                name = name.replace(vowel + "s" + vowel2, vowel + "з" + vowel2);
                name = name.replace(vowel + "z" + vowel2, vowel + "з" + vowel2);
                name = name.replace(vowel + "h" + vowel2, vowel + vowel2);
            }
            for (Map.Entry<String, String> bv : BEFORE_VOWELS.entrySet()) {
                name = name.replace(bv.getKey() + vowel, bv.getValue() + vowel);
            }
            for (Map.Entry<String, String> av : AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + av.getKey(), vowel + av.getValue());
                if (!vowel.equals("i")) {
                    name = name.replace(vowel + "e", vowel + "э");
                }
            }
            name = name.replace(vowel + "i", vowel + "й");
        }
        for (String sc : SOFT_CONSONANTS) {
            for (Map.Entry<String, String> sf : SOFTENED_VOWELS.entrySet()) {
                name = name.replace(sc + sf.getKey(), sc + sf.getValue());
            }
            name = name.replace(sc + "ãу", sc + "ян");
            name = name.replace(sc + "ã", sc + "ян");
        }
        return name;
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(PortugueseNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(PortugueseNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.PORTUGUESE.getName();
    }
}