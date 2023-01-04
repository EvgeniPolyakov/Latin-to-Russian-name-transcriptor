package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum BalkanNames {
    NEMANJA("nemanja", "неманья"),
    CETINJE("cetinje", "цетинье");

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