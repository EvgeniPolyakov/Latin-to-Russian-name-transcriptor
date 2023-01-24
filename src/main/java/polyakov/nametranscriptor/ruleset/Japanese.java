package polyakov.nametranscriptor.ruleset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Japanese implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = StringUtils.stripAccents(name);
        name = checkCombinations(name, mode);
        name = checkSingleChars(name);
        return mapStandardChars(name);
    }

    private static String checkCombinations(String name, int mode) {
        name = name.replace("ō", "o");
        name = name.replace("ū", "u");
        name = name.replace("oo", "о");
        name = name.replace("ou", "o");
        name = name.replace("sha", "ся");
        if (mode == 1) {
            name = name.replace("sho", "сё");
            name = name.replace("cho", "тё");
            name = name.replace("yo", "ё");
            name = name.replace("jo", "дзё");
        }
        name = name.replace("sho", "се");
        name = name.replace("cho", "те");
        name = name.replace("yo", "е");
        name = name.replace("jo", "дзе");
        name = name.replace("shu", "сю");
        name = name.replace("sh", "с");
        name = name.replace("tsu", "цу");
        name = name.replace("cha", "тя");
        name = name.replace("chu", "тю");
        name = name.replace("ch", "т");
        name = name.replace("n'", "нъ");
        name = name.replace("n’", "нъ");
        name = name.replace("nm", "мм");
        name = name.replace("np", "мп");
        name = name.replace("nb", "мб");
        name = name.replace("wo", "о");
        name = name.replace("ya", "я");
        name = name.replace("yu", "ю");
        name = name.replace("ai", "ай");
        name = name.replace("ui", "уй");
        name = name.replace("ei", "эй");
        name = name.replace("oi", "ой");
        name = name.replace("ji", "дзи");
        name = name.replace("zu", "дзу");
        name = name.replace("ze", "дзэ");
        name = name.replace("zo", "дзо");
        name = name.replace("ja", "дзя");
        name = name.replace("ju", "дзю");
        return name;
    }

    private static String checkSingleChars(String name) {
        name = name.replace("l", "р");
        name = name.replace("j", "дз");
        name = name.replace("z", "дз");
        name = name.replace("e", "э");
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.JAPANESE.getName();
    }
}