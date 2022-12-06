package polyakov.nametranscriptor.model.rulesets.names;

public enum GreekNames {
    NEA("Nea", "Неа"),
    GEORGIOS("Georgios", "Йоргос"),
    GEORGOS("Georgos", "Йоргос"),
    GIORGIOS("Giorgios", "Йоргос"),
    GIORGOS("Giorgos", "Йоргос"),
    ELIAS("Elias", "Элиас"),
    TRIA("Tria", "Триа"),
    VASILEIOS("Vasileios", "Василиос"),
    VASSILEIOS("Vassileios", "Вассилиос"),
    VASILIOS("Vasilios", "Василиос"),
    VASSILIOS("Vassilios", "Вассилиос"),
    VASILIS("Vasilis", "Василис"),
    ILIAS("Ilias", "Илиас");

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