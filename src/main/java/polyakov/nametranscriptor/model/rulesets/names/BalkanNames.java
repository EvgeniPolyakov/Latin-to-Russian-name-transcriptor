package polyakov.nametranscriptor.model.rulesets.names;

public enum BalkanNames {
    NEMANJA("Nemanja", "Неманья"),
    CETINJE("Cetinje", "Цетинье");

    private final String latinName;
    private final String cyrillicName;

    BalkanNames(String latinName, String cyrillicName) {
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