package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum EstonianNames {

    METSAAARE("metsaääre", "метсаээре"),
    TALLINN("tallinn", "таллин"),
    PIKASILLA("pikasilla", "пикасилла");

    private final String latinName;
    private final String cyrillicName;

    EstonianNames(String latinName, String cyrillicName) {
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