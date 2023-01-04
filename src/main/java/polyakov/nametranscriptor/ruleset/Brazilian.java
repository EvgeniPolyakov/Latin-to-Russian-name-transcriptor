package polyakov.nametranscriptor.ruleset;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.resources.popularnames.BrazilianNames;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

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
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkCustomCases(name);
        return super.transcribe(name, mode);
    }

    private String checkCustomCases(String name) {
        name = name.replace("y", "i");
        name = name.replace("gue", "ге");
        name = name.replace("gui", "ги");
        name = name.replace("que", "ке");
        name = name.replace("qui", "ки");
        for (String vowel : VOWELS) {
            if (name.endsWith(vowel + "ios")) {
                String sub = name.substring(0, name.length() - 3);
                name = sub + "йос";
            }
            if (name.endsWith(vowel + "os")) {
                String sub = name.substring(0, name.length() - 2);
                name = sub + "ос";
            }
        }
        if (name.endsWith("ios")) {
            String sub = name.substring(0, name.length() - 3);
            name = sub + "иос";
        }
        if (name.endsWith("os")) {
            String sub = name.substring(0, name.length() - 2);
            name = sub + "ос";
        }
        for (Map.Entry<String, String> ending : ENDINGS.entrySet()) {
            if (name.endsWith(ending.getKey())) {
                String sub = name.substring(0, name.length() - ending.getKey().length());
                name = sub + ending.getValue();
            }
        }
        if (name.endsWith("s")) {
            String sub = name.substring(0, name.length() - 1);
            name = sub + "с";
        }
        for (String sc : SOFT_CONSONANTS) {
            name = name.replace(sc + "ãи", sc + "яйн");
            name = name.replace(sc + "ãо", sc + "ян");
            name = name.replace(sc + "o", sc + "о");
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
        for (String vc : VOICED_CONSONANTS) {
            name = name.replace("z" + vc, "з" + vc);
            name = name.replace("s" + vc, "с" + vc);
        }
        return name;
    }

    @Override
    protected String checkSingleChars(String name) {
        name = name.replace("x", "с");
        return super.checkSingleChars(name);
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(BrazilianNames.values())
                .filter(s -> s.getLatinName().equals(name))
                .findAny()
                .map(BrazilianNames::getCyrillicName);
    }

    @Override
    public String getName() {
        return RulesetName.BRAZILIAN.getName();
    }
}