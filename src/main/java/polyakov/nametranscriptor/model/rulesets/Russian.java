package polyakov.nametranscriptor.model.rulesets;

import java.util.*;

public class Russian extends Ruleset {
    private static final Map<String, String> ENDINGS = Map.ofEntries(
            Map.entry("sky", "ский"),
            Map.entry("ski", "ский"),
            Map.entry("skiy", "ский"),
            Map.entry("ii", "ий")
    );
    private static final List<String> CUSTOM_ENDINGS = List.of("y", "iy", "ii", "yy");

    @Override
    protected String transcribeName(String name, int mode) {
        Optional<String> os = checkPopularNames(name);
        if (os.isPresent()) {
            name = os.get();
        }
        name = checkCustomCases(name);
        if (name.startsWith("e")) {
            name = name.replaceFirst("e", "э");
        }
        if (name.startsWith("E")) {
            name = name.replaceFirst("E", "Э");
        }
        name = checkCombinations(name);
        name = name.replace("a", "а");
        name = name.replace("A", "А");
        name = name.replace("b", "б");
        name = name.replace("B", "Б");
        name = name.replace("d", "д");
        name = name.replace("D", "Д");
        name = name.replace("e", "е");
        name = name.replace("E", "Е");
        name = name.replace("f", "ф");
        name = name.replace("F", "Ф");
        name = name.replace("g", "г");
        name = name.replace("G", "Г");
        name = name.replace("i", "и");
        name = name.replace("I", "И");
        name = name.replace("k", "к");
        name = name.replace("K", "К");
        name = name.replace("h", "х");
        name = name.replace("H", "Х");
        name = name.replace("l", "л");
        name = name.replace("L", "Л");
        name = name.replace("m", "м");
        name = name.replace("M", "М");
        name = name.replace("n", "н");
        name = name.replace("N", "Н");
        name = name.replace("o", "о");
        name = name.replace("O", "О");
        name = name.replace("p", "п");
        name = name.replace("P", "П");
        name = name.replace("r", "р");
        name = name.replace("R", "Р");
        name = name.replace("s", "с");
        name = name.replace("S", "С");
        name = name.replace("t", "т");
        name = name.replace("T", "Т");
        name = name.replace("u", "у");
        name = name.replace("U", "У");
        name = name.replace("v", "в");
        name = name.replace("V", "В");
        name = name.replace("y", "ы");
        name = name.replace("Y", "Й");
        name = name.replace("x", "кс");
        name = name.replace("X", "Кс");
        name = name.replace("z", "з");
        name = name.replace("Z", "З");
        name = name.replace("'", "ь");
        return postcheck(name);
    }

    private String postcheck(String name) {
        if (name.endsWith("иы")) {
            name = name.replace("иы", "ий");
        }
        return name;
    }

    private static String checkCombinations(String name) {
        name = name.replace("sch", "щ");
        name = name.replace("sch", "щ");
        name = name.replace("Sch", "Щ");
        name = name.replace("shch", "щ");
        name = name.replace("Shch", "Щ");
        name = name.replace("sh", "ш");
        name = name.replace("Sh", "Ш");
        name = name.replace("ch", "ч");
        name = name.replace("Ch", "Ч");
        name = name.replace("Ia", "Я");
        name = name.replace("iya", "ия");
        name = name.replace("ya", "я");
        name = name.replace("aye", "ае");
        name = name.replace("ay", "ай");
        name = name.replace("Ya", "Я");
        name = name.replace("Ay", "Ай");
        name = name.replace("Ai", "Ай");
        name = name.replace("yu", "ю");
        name = name.replace("uy", "уй");
        name = name.replace("Yu", "Ю");
        name = name.replace("Uy", "Уй");
        name = name.replace("ye", "е");
        name = name.replace("ey", "ей");
        name = name.replace("Ye", "Е");
        name = name.replace("Ey", "Эй");
        name = name.replace("yo", "йо");
        name = name.replace("oy", "ой");
        name = name.replace("Yo", "Йо");
        name = name.replace("Oy", "Ой");
        name = name.replace("yi", "ьи");
        name = name.replace("ei", "ей");
        name = name.replace("oi", "ой");
        name = name.replace("ui", "уй");
        name = name.replace("ts", "ц");
        name = name.replace("Ts", "Ц");
        name = name.replace("zh", "ж");
        name = name.replace("Zh", "Ж");
        name = name.replace("kh", "х");
        name = name.replace("Kh", "Х");
        return name;
    }

    private Optional<String> checkPopularNames(String name) {
        return Arrays.stream(RussianNames.values())
                .filter(s -> s.getLatinName().equalsIgnoreCase(name.toLowerCase()))
                .findAny()
                .map(RussianNames::getCyrillicName);
    }

    protected String checkCustomCases(String name) {
        name = name.replace("j", "y");
        name = name.replace("J", "Y");
        name = name.replace("tsky", "цкий");
        for (Map.Entry<String, String> s : ENDINGS.entrySet()) {
            if (name.endsWith(s.getKey())) {
                name = name.replace(s.getKey(), s.getValue());
            }
        }
        for (String s : CUSTOM_ENDINGS) {
            if (name.length() > 1 && name.endsWith(s)) {
                if (
                        name.charAt(name.length() - (s.length() + 1)) == 'v' ||
                                name.charAt(name.length() - (s.length() + 1)) == 'l' ||
                                name.charAt(name.length() - (s.length() + 1)) == 's' ||
                                name.charAt(name.length() - (s.length() + 1)) == 'd' ||
                                name.charAt(name.length() - (s.length() + 1)) == 'm' ||
                                name.charAt(name.length() - (s.length() + 1)) == 'b' ||
                                name.charAt(name.length() - (s.length() + 1)) == 'n'
                ) {
                    String substring = name.substring(0, name.length() - s.length());
                    name = substring + "ый";
                }
                if (
                        name.charAt(name.length() - (s.length() + 1)) == 'g' ||
                        name.charAt(name.length() - (s.length() + 1)) == 'k' ||
                        name.charAt(name.length() - (s.length() + 1)) == 'h'
                ) {
                    String substring = name.substring(0, name.length() - s.length());
                    name = substring + "ий";
                }
            }
        }
        return name;
    }
}