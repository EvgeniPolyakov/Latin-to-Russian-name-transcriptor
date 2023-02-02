package polyakov.nametranscriptor.ruleset;

public enum RulesetName {
    ALBANIAN("Albanian"),
    ARMENIAN("Armenian"),
    AZERI("Azeri"),
    BRAZILIAN("Brazilian"),
    BULGARIAN("Bulgarian"),
    CHINESE("Chinese"),
    CZECH("Czech"),
    ESTONIAN("Estonian"),
    DUTCH("Dutch"),
    FRENCH("French"),
    FINNISH("Finnish"),
    GEORGIAN("Georgian"),
    GERMAN("German"),
    GREEK("Greek"),
    HEBREW("Hebrew"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    KAZAKH("Kazakh"),
    LATVIAN("Latvian"),
    LITHUANIAN("Lithuanian"),
    MACEDONIAN("Macedonian"),
    MOLDOVAN("Moldovan"),
    POLISH("Polish"),
    PORTUGUESE("Portuguese"),
    ROMANIAN("Romanian"),
    RUSSIAN("Russian"),
    SERBOCROAT("Serbocroat"),
    SLOVAK("Slovak"),
    SPANISH("Spanish"),
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
