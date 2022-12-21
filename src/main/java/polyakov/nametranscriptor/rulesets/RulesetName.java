package polyakov.nametranscriptor.rulesets;

public enum RulesetName {
    ALBANIAN("Albania"),
    ARMENIAN("Armenia"),
    BELORUSSIAN("Belarus"),
    BOSNIAN("Bosnia and Herzegovina"),
    BULGARIAN("Bulgaria"),
    CHINESE("China"),
    CROATIAN("Croatia"),
    CZECH("Czechia"),
    CYPRIOT("Cyprus"),
    GEORGIAN("Georgia"),
    GREEK("Greece"),
    FRENCH("France"),
    KAZAKH("Kazakhstan"),
    MACEDONIAN("Northern Macedonia"),
    MONTENEGRIN("Montenegro"),
    MOLDOVAN("Moldova"),
    ROMANIAN("Romania"),
    PORTUGUESE("Portugal"),
    RUSSIAN("Russia"),
    SERBIAN("Serbia"),
    SLOVAK("Slovakia"),
    SLOVENIAN("Slovenia"),
    TURKISH("Turkey"),
    UKRAINIAN("Ukraine");

    private final String name;

    RulesetName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
