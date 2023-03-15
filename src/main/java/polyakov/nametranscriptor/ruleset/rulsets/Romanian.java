package polyakov.nametranscriptor.ruleset.rulsets;

import org.springframework.stereotype.Component;
import polyakov.nametranscriptor.ruleset.DefaultRuleset;
import polyakov.nametranscriptor.ruleset.RulesetName;

import java.util.Map;

import static polyakov.nametranscriptor.ruleset.resources.wordparts.Romanian.*;

@Component
public class Romanian extends DefaultRuleset {

    @Override
    public String transcribe(String name, int mode) {
        name = checkCustomCases(name);
        name = mapSingleChars(name);
        return mapStandardChars(name);
    }

    private static String mapSingleChars(String name) {
        name = name.replace("ă", "э");
        name = name.replace("â", "ы");
        name = name.replace("c", "к");
        name = name.replace("î", "ы");
        name = name.replace("î", "и");
        name = name.replace("j", "ж");
        name = name.replace("l", "л");
        name = name.replace("ș", "ш");
        name = name.replace("ş", "ш");
        name = name.replace("ț", "ц");
        name = name.replace("ţ", "ц");
        name = name.replace("x", "кс");
        name = name.replace("y", "и");
        return name;
    }

    protected String checkCustomCases(String name) {
        name = name.replace("ii", "ий");
        name = name.replace("îi", "ый");
        name = checkStart(name);
        name = name.replace("cea", "ча");
        name = name.replace("cia", "ча");
        name = name.replace("cio", "чо");
        name = name.replace("ciu", "чу");
        name = name.replace("gea", "джа");
        name = name.replace("gia", "джа");
        name = name.replace("geo", "джо");
        name = name.replace("gio", "джо");
        name = name.replace("giu", "джу");
        name = name.replace("ea", "я");
        if (name.contains("i")) {
            name = checkIotation(name);
        }
        name = checkEndings(name, ENDINGS);
        name = checkConsonants(name);
        name = name.replace("ia", "ья");
        name = name.replace("ie", "ье");
        name = name.replace("io", "ьо");
        name = name.replace("iu", "ью");
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

    private static String checkIotation(String name) {
        for (Map.Entry<String, String> vowel : VOWELS.entrySet()) {
            for (Map.Entry<String, String> ip : IOTATED_PARTS.entrySet()) {
                name = name.replace(vowel.getKey() + ip.getKey(), vowel.getValue() + ip.getValue());
            }
            name = name.replace(vowel.getKey() + "i", vowel.getValue() + "й");
        }
        return name;
    }

    private static String checkConsonants(String name) {
        for (Map.Entry<String, String> consonant : CUSTOM_CONSONANTS.entrySet()) {
            for (String vowel : UTILITY_VOWELS) {
                name = name.replace(consonant.getKey() + vowel, consonant.getValue() + vowel);
            }
        }
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.ROMANIAN.getName();
    }
}
