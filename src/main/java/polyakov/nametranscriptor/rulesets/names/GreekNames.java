package polyakov.nametranscriptor.rulesets.names;

public enum GreekNames {
    NEA("nea", "неа"),
    GEORGIOS("georgios", "йоргос"),
    GEORGOS("georgos", "йоргос"),
    GIORGIOS("giorgios", "йоргос"),
    GIORGOS("giorgos", "йоргос"),
    ELIAS("elias", "элиас"),
    TRIA("tria", "триа"),
    VASILEIOS("vasileios", "василиос"),
    VASSILEIOS("vassileios", "вассилиос"),
    VASILIOS("vasilios", "василиос"),
    VASSILIOS("vassilios", "вассилиос"),
    VASILIS("vasilis", "василис"),
    ILIAS("ilias", "илиас");

    private final String latinName;
    private final String cyrillicName;

    GreekNames(String latinName, String cyrillicName) {
        this.latinName = latinName;
        this.cyrillicName = cyrillicName;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getCyrillicName() {
        return cyrillicName;
    }
}