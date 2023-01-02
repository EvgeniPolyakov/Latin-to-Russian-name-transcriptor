package polyakov.nametranscriptor.rulesets;

public enum RulesetName {
    ALBANIAN("Albanian"),
    ARMENIAN("Armenian"),
    BRAZILIAN("Brazilian"),
    BULGARIAN("Bulgarian"),
    CHINESE("Chinese"),
    CZECH("Czech"),
    FRENCH("French"),
    GEORGIAN("Georgian"),
    GERMAN("German"),
    GREEK("Greek"),
    JAPANESE("Japanese"),
    KAZAKH("Kazakh"),
    LATVIAN("Latvian"),
    MACEDONIAN("Macedonian"),
    MOLDOVAN("Moldovan"),
    PORTUGUESE("Portuguese"),
    ROMANIAN("Romanian"),
    RUSSIAN("Russian"),
    SERBOCROAT("Serbocroat"),
    SLOVAK("Slovak"),
    TURKISH("Turkish"),
    UKRAINIAN("Ukrainian");

    private final String name;

    RulesetName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
