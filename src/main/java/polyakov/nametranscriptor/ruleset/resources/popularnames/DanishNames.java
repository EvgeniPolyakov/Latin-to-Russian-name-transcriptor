package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum DanishNames {
    RRR("", ""),
    RONDE("rønde", "ренде");

    private final String latinName;
    private final String cyrillicName;

    DanishNames(String latinName, String cyrillicName) {
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