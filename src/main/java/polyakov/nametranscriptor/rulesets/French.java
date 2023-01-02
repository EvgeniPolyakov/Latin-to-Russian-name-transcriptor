package polyakov.nametranscriptor.rulesets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.rulesets.names.FrenchNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static polyakov.nametranscriptor.rulesets.customrules.French.*;

@Component
public class French implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkPrimaryCases(name);
        name = checkStarters(name);
        name = checkVowels(name);
        name = checkConsonants(name);
        name = checkEndings(name);
        name = checkCombinations(name);
        name = checkSingleChars(name);
        return postcheck(name);
    }

    private String checkPrimaryCases(String name) {
        name = name.replace("gueuil", "гейль");
        name = name.replace("gueil", "гейль");
        name = name.replace("cueuil", "сейль");
        name = name.replace("cueil", "сейль");
        for (String aou : AOU_VOWELS) {
            name = name.replace("cc" + aou, "кк" + aou);
            name = name.replace("c" + aou, "к" + aou);
            name = name.replace("ge" + aou, "ж" + aou);
        }
        name = name.replace("guen", "ген");
        for (String eiy : EIY_VOWELS) {
            name = name.replace("sc" + eiy, "с" + eiy);
            name = name.replace("gu" + eiy, "г" + eiy);
            name = name.replace("g" + eiy, "ж" + eiy);
            name = name.replace("c" + eiy, "с" + eiy);
        }
        name = name.replace("aé", "аэ");
        name = name.replace("aë", "аэ");
        name = name.replace("iai", "ье");
        name = name.replace("oun", "ун");
        name = name.replace("oum", "ум");
        name = name.replace("ein", "эн");
        name = name.replace("eau", "о");
        name = name.replace("au", "о");
        name = name.replace("ea", "а");
        name = checkVilleCases(name);
        if (name.startsWith("eu")) {
            name = name.replaceFirst("eu", "э");
        }
        name = name.replace("eu", "е");
        return name;
    }

    private String checkSingleChars(String name) {
        name = name.replace("a", "а");
        name = name.replace("à", "а");
        name = name.replace("â", "а");
        name = name.replace("b", "б");
        name = name.replace("c", "к");
        name = name.replace("ç", "с");
        name = name.replace("d", "д");
        name = name.replace("e", "е");
        name = name.replace("é", "е");
        name = name.replace("ë", "э");
        name = name.replace("è", "е");
        name = name.replace("ê", "е");
        name = name.replace("f", "ф");
        name = name.replace("g", "г");
        name = name.replace("h", "");
        name = name.replace("i", "и");
        name = name.replace("î", "и");
        name = name.replace("ï", "и");
        name = name.replace("j", "ж");
        name = name.replace("k", "к");
        name = name.replace("l", "ль");
        name = name.replace("m", "м");
        name = name.replace("n", "н");
        name = name.replace("o", "о");
        name = name.replace("ô", "о");
        name = name.replace("œ", "е");
        name = name.replace("p", "п");
        name = name.replace("r", "р");
        name = name.replace("s", "с");
        name = name.replace("t", "т");
        name = name.replace("u", "ю");
        name = name.replace("û", "ю");
        name = name.replace("v", "в");
        name = name.replace("w", "в");
        name = name.replace("y", "и");
        name = name.replace("x", "кс");
        name = name.replace("z", "з");
        return name;
    }

    private String checkCombinations(String name) {
        name = name.replace("ville", "виль");
        name = name.replace("vийe", "виль");
        name = name.replace("aille", "ай");
        name = name.replace("aill", "ай");
        name = name.replace("ilh", "ий");
        for (String v : VOWELS) {
            name = name.replace(v + "il", v + "й");
            name = name.replace("l" + v, "л" + v);
        }
        name = name.replace("tion", "сьон");
        name = name.replace("tioux", "сью");
        name = name.replace("rr", "рр");
        name = name.replace("gnou", "нью");
        name = name.replace("gnoù", "нью");
        name = name.replace("gnoû", "нью");
        name = name.replace("riэu", "рье");
        name = name.replace("riэr", "рье");
        name = name.replace("liэu", "лье");
        name = name.replace("liэr", "лье");
        name = name.replace("ien", "ьян");
        name = name.replace("iou", "ью");
        name = name.replace("ioù", "ью");
        name = name.replace("ioû", "ью");
        name = name.replace("gna", "нья");
        name = name.replace("gn", "нь");
        name = name.replace("aim", "ен");
        name = name.replace("aiм", "ен");
        name = name.replace("aэн", "ен");
        name = name.replace("ays", "аи");
        name = name.replace("aye", "ей");
        name = name.replace("tioux", "сью");
        name = name.replace("ai", "е");
        name = name.replace("ey", "е");
        name = name.replace("inn", "инн");
        name = name.replace("oë", "оэ");
        name = name.replace("ph", "ф");
        name = name.replace("oэн", "уэн");
        name = name.replace("oiэ", "уа");
        name = name.replace("sch", "ш");
        name = name.replace("sш", "ш");
        name = name.replace("tch", "ч");
        name = name.replace("tш", "ч");
        name = name.replace("sc", "ск");
        name = name.replace("oi", "уа");
        name = name.replace("oî", "уа");
        name = name.replace("oи", "уа");
        name = name.replace("oy", "уа");
        name = name.replace("quэ", "ке");
        name = name.replace("qu", "к");
        name = name.replace("ls", "льз");
        name = name.replace("lh", "л");
        name = name.replace("ld", "д");
        name = name.replace("ln", "н");
        name = name.replace("lл", "лл");
        name = name.replace("iay", "е");
        name = name.replace("ay", "е");
        name = name.replace("aэ", "a");
        name = name.replace("aon", "ан");
        name = name.replace("am", "ан");
        name = name.replace("cqu", "к");
        name = name.replace("cq", "к");
        name = name.replace("ck", "к");
        name = name.replace("eî", "е");
        name = name.replace("ei", "е");
        name = name.replace("iэn", "ьян");
        name = name.replace("imm", "имм");
        name = name.replace("imм", "имм");
        name = name.replace("ymm", "имм");
        name = name.replace("ymм", "имм");
        name = name.replace("im", "ем");
        name = name.replace("iм", "ем");
        name = name.replace("ym", "ем");
        name = name.replace("yм", "ем");
        name = name.replace("umm", "юмм");
        name = name.replace("umм", "юмм");
        name = name.replace("umb", "емб");
        name = name.replace("ump", "емп");
        name = name.replace("unn", "юнн");
        name = name.replace("un", "ен");
        name = name.replace("œu", "е");
        name = name.replace("ia", "ья");
        name = name.replace("in", "ен");
        name = name.replace("en", "ан");
        name = name.replace("cc", "кс");
        name = name.replace("ch", "к");
        name = name.replace("ou", "у");
        name = name.replace("où", "у");
        name = name.replace("oû", "у");
        name = name.replace("iэu", "ье");
        name = name.replace("iэû", "ье");
        name = name.replace("iэ", "ье");
        name = name.replace("ie", "ье");
        name = name.replace("iе", "ье");
        name = name.replace("iou", "ью");
        name = name.replace("io", "ьо");
        name = name.replace("iо", "ьо");
        name = name.replace("eû", "е");
        name = name.replace("hен", "эн");
        name = checkL(name);
        return name;
    }

    private String checkVowels(String name) {
        for (String vowel : VOWELS) {
            for (Map.Entry<String, String> av : AFTER_VOWELS.entrySet()) {
                name = name.replace(vowel + av.getKey(), vowel + av.getValue());
            }
            for (Map.Entry<String, String> bv : BEFORE_VOWELS.entrySet()) {
                name = name.replace(bv.getKey() + vowel, bv.getValue() + vowel);
            }
            if (!vowel.equals("i")) {
                name = name.replace(vowel + "e", vowel + "э");
                name = name.replace(vowel + "un", vowel + "эн");
            }
            if (name.startsWith("em" + vowel)) {
                name = name.replace("em" + vowel, "эм" + vowel);
            }
            if (name.startsWith("en" + vowel)) {
                name = name.replace("en" + vowel, "эн" + vowel);
            }
            if (name.endsWith(vowel + "c")) {
                String sub = name.substring(0, name.length() - 1);
                name = sub + "к";
            }
            if (name.endsWith(vowel + "g")) {
                String sub = name.substring(0, name.length() - 1);
                name = sub + "г";
            }
            name = name.replace("y" + vowel, "й" + vowel);
        }
        return name;
    }

    private String checkConsonants(String name) {
        name = checkBMPCases(name);
        if (name.startsWith("im") || name.startsWith("ym")) {
            name = name.replaceFirst("im", "им");
            name = name.replaceFirst("ym", "им");
        }
        for (String vowel1 : VOWELS) {
            for (String vowel2 : VOWELS) {
                name = name.replace(vowel1 + "s" + vowel2, vowel1 + "з" + vowel2);
                name = name.replace(vowel1 + "sь", vowel1 + "зь");
                name = name.replace(vowel1 + "ill" + vowel2, vowel1 + "й" + vowel2);
            }
        }
        for (String vowel1 : VOWELS) {
            name = name.replace("ill" + vowel1, "ий" + vowel1);
        }
        return name;
    }

    private String checkStarters(String name) {
        for (Map.Entry<String, String> starter : FIRST_TIER_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                name = name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        for (Map.Entry<String, String> starter : SECOND_TIER_STARTERS.entrySet()) {
            if (name.startsWith(starter.getKey())) {
                name = name.replaceFirst(starter.getKey(), starter.getValue());
            }
        }
        if (name.startsWith("in") && !name.startsWith("inn")) {
            name = name.replaceFirst("in", "эн");
        }
        return name;
    }

    private String checkEndings(String name) {
        if (name.endsWith("уайes") || name.endsWith("уайés")) {
            name = name.substring(0, name.length() - 3);
            return name;
        }
        for (Map.Entry<String, String> e : FIRST_TIER_ENDINGS.entrySet()) {
            if (name.endsWith(e.getKey())) {
                String sub = name.substring(0, name.length() - e.getKey().length());
                name = sub + e.getValue();
                return name;
            }
        }
        for (Map.Entry<String, String> e : SECOND_TIER_ENDINGS.entrySet()) {
            if (name.endsWith(e.getKey())) {
                String sub = name.substring(0, name.length() - e.getKey().length());
                name = sub + e.getValue();
                return name;
            }
        }
        for (Map.Entry<String, String> e : THIRD_TIER_ENDINGS.entrySet()) {
            if (name.endsWith(e.getKey())) {
                String sub = name.substring(0, name.length() - e.getKey().length());
                name = sub + e.getValue();
                return name;
            }
        }
        if (name.endsWith("ien")) {
            String sub = name.substring(0, name.length() - 3);
            name = sub + "ьен";
            return name;
        }
        for (String e : EMPTY_ENDINGS) {
            if (name.endsWith(e)) {
                name = StringUtils.chop(name);
                return name;
            }
        }
        return name;
    }

    private static String checkBMPCases(String name) {
        for (String bmp : BM_CONSONANTS) {
            for (Map.Entry<String, String> precedingPart : BEFORE_BMP.entrySet()) {
                name = name.replace(precedingPart.getKey() + bmp, precedingPart.getValue() + bmp);
            }
            if (name.startsWith("im" + bmp)) {
                name = name.replaceFirst("im" + bmp, "эм" + bmp);
            }
            if (name.startsWith("ym" + bmp)) {
                name = name.replaceFirst("ym" + bmp, "эм" + bmp);
            }
        }
        for (Map.Entry<String, String> precedingPart : BEFORE_BMP.entrySet()) {
            if (!name.endsWith(precedingPart.getKey() + "p")) {
                name = name.replace(precedingPart.getKey() + "p", precedingPart.getValue() + "p");
            }
            if (name.startsWith("im" + "p")) {
                name = name.replaceFirst("im" + "p", "эм" + "p");
            }
            if (name.startsWith("ym" + "p")) {
                name = name.replaceFirst("ym" + "p", "эм" + "p");
            }
        }
        return name;
    }

    private String checkL(String name) {
        name = name.replace("lа", "ла");
        name = name.replace("lе", "ле");
        name = name.replace("lи", "ли");
        name = name.replace("lо", "ло");
        name = name.replace("lу", "лу");
        name = name.replace("lэ", "лэ");
        name = name.replace("lю", "лю");
        name = name.replace("lя", "ля");
        name = name.replace("lь", "ль");
        return name;
    }

    private String checkVilleCases(String name) {
        name = name.replace("villeur", "виллер");
        name = name.replace("villeut", "виллет");
        name = name.replace("villeuz", "вилле");
        name = name.replace("viller", "виллер");
        name = name.replace("villet", "виллет");
        name = name.replace("villez", "вилле");
        for (String vowel : VOWELS) {
            name = name.replace("ville" + vowel, "виллe" + vowel);
            name = name.replace("vийe" + vowel, "виллe" + vowel);
        }
        if (name.endsWith("ville")) {
            String sub = name.substring(0, name.length() - 5);
            name = sub + "виль";
        }
        return name;
    }

    private String postcheck(String name) {
        name = name.replace("аь", "ай");
        name = name.replace("еь", "ей");
        name = name.replace("иь", "ий");
        name = name.replace("оь", "ой");
        name = name.replace("уь", "уй");
        name = name.replace("эь", "эй");
        name = name.replace("юь", "юй");
        name = name.replace("яь", "яй");
        name = name.replace("льль", "лль");
        return name;
    }

    protected Optional<String> checkPopularNames(String name) {
        return Arrays.stream(FrenchNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(FrenchNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.FRENCH.getName();
    }
}