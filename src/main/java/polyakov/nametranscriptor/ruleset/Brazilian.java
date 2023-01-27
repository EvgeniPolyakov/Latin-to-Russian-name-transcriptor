package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.BrazilianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Portuguese.*;

@Component
public class Brazilian extends Portuguese {
    private static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("es", "ис"),
            Map.entry("иm", "ин"),
            Map.entry("e", "и"),
            Map.entry("o", "о"),
            Map.entry("x", "с"),
            Map.entry("z", "с")
    );

    @Override
    public String transcribe(String name, int mode) {
        name = checkName(name);
        name = checkVowels(name);
        name = checkEndings(name);
        name = checkConsonants(name);
        return super.transcribe(name, mode);
    }

    private static String checkVowels(String name) {
        name = name.replace("y", "i");
        name = name.replace("gue", "ге");
        name = name.replace("gui", "ги");
        name = name.replace("que", "ке");
        name = name.replace("qui", "ки");
        for (String vowel : VOWELS) {
            if (name.endsWith(vowel + "ios")) {
                return name.substring(0, name.length() - 3) + "йос";
            }
            if (name.endsWith(vowel + "os")) {
                return name.substring(0, name.length() - 2) + "ос";
            }
        }
        if (name.endsWith("ios")) {
            return name.substring(0, name.length() - 3) + "иос";
        }
        if (name.endsWith("os")) {
            name = name.substring(0, name.length() - 2) + "ос";
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
        if (name.endsWith("s")) {
            return name.substring(0, name.length() - 1) + "с";
        }
        return name;
    }

    private static String checkConsonants(String name) {
        for (String consonant : SOFT_CONSONANTS) {
            name = name.replace(consonant + "ãи", consonant + "яйн");
            name = name.replace(consonant + "ãо", consonant + "ян");
            name = name.replace(consonant + "o", consonant + "о");
        }
        name = name.replace("ãо", "ан");
        name = name.replace("ãи", "айн");
        name = name.replace("gи", "жи");
        name = name.replace("õи", "ойн");
        name = name.replace("sce", "се");
        name = name.replace("sci", "си");
        name = name.replace("sp", "сп");
        name = name.replace("st", "ст");
        name = name.replace("sc", "ск");
        name = name.replace("sq", "ск");
        name = name.replace("zp", "сп");
        name = name.replace("zt", "ст");
        name = name.replace("zc", "ск");
        name = name.replace("zq", "ск");
        for (String consonant : VOICED_CONSONANTS) {
            name = name.replace("z" + consonant, "з" + consonant);
            name = name.replace("s" + consonant, "с" + consonant);
        }
        return name;
    }

    private static String checkName(String name) {
        Map<String, String> names = Arrays.stream(BrazilianNames.values())
                .collect(Collectors.toMap(BrazilianNames::getLatinName, BrazilianNames::getCyrillicName));
        return Optional.ofNullable(names.get(name)).orElse(name);
    }

    @Override
    protected String mapSingleChars(String name) {
        name = name.replace("x", "с");
        return super.mapSingleChars(name);
    }

    @Override
    public String getName() {
        return RulesetName.BRAZILIAN.getName();
    }
}