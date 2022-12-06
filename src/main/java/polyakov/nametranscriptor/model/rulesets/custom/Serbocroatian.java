package polyakov.nametranscriptor.model.rulesets.custom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Serbocroatian {
    public static final List<String> VOWELS = List.of("a", "A", "e", "E", "i", "I", "o", "O", "u", "U");
    public static final Map<String, String> J_CASES_AFTER_VOWELS = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("ji", "и"),
            Map.entry("jo", "йо"),
            Map.entry("ju", "ю")
    );
    public static final Map<String, String> J_CASES_AFTER_CONSONANTS = Map.ofEntries(
            Map.entry("ja", "ья"),
            Map.entry("je", "ье"),
            Map.entry("ji", "ьи"),
            Map.entry("jo", "ьо"),
            Map.entry("ju", "ью")
    );
    public static final Map<String, String> J_FIRST_CASE = Map.ofEntries(
            Map.entry("ja", "я"),
            Map.entry("je", "е"),
            Map.entry("ji", "и"),
            Map.entry("jo", "йо"),
            Map.entry("ju", "ю"),
            Map.entry("Ja", "Я"),
            Map.entry("Je", "Е"),
            Map.entry("Ji", "И"),
            Map.entry("Jo", "Йо"),
            Map.entry("Ju", "Ю")
    );
    public static final Map<String, String> UTILITY_CONSONANTS = Map.ofEntries(
            Map.entry("Dj", "Дж"),
            Map.entry("dj", "дж"),
            Map.entry("Đ", "Дж"),
            Map.entry("đ", "дж"),
            Map.entry("Lj", "Л"),
            Map.entry("lj", "л"),
            Map.entry("Nj", "Н"),
            Map.entry("nj", "н")
    );
    public static final Map<String, String> VOWELS_FOR_UTILITY_CONSONANTS = Map.ofEntries(
            Map.entry("a", "я"),
            Map.entry("e", "е"),
            Map.entry("i", "и"),
            Map.entry("o", "е"),
            Map.entry("u", "ю")
    );
}
