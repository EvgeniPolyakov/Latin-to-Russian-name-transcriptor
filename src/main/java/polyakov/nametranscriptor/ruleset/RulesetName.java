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
    DANISH("Danish"),
    DUTCH("Dutch"),
    FRENCH("French"),
    FINNISH("Finnish"),
    GEORGIAN("Georgian"),
    GERMAN("German"),
    GREEK("Greek"),
    HEBREW("Hebrew"),
    HUNGARIAN("Hungarian"),
    ICELANDIC("Icelandic"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    KAZAKH("Kazakh"),
    LATVIAN("Latvian"),
    LITHUANIAN("Lithuanian"),
    MACEDONIAN("Macedonian"),
    MOLDOVAN("Moldovan"),
    NORWEGIAN("Norwegian"),
    POLISH("Polish"),
    PORTUGUESE("Portuguese"),
    ROMANIAN("Romanian"),
    RUSSIAN("Russian"),
    SERBOCROAT("Serbocroat"),
    SLOVAK("Slovak"),
    SPANISH("Spanish"),
    SWEDISH("Swedish"),
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
