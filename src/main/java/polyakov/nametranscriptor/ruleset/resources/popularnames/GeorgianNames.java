package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum GeorgianNames {
    ALEKSANDRE("aleksandre", "александр"),
    DAVIT("davit", "давид"),
    DIMITRI("dimitri", "дмитрий"),
    MIKHEIL("mikheil", "михаил"),
    GIORGI("giorgi", "георгий"),
    IRAKLI("irakli", "ираклий"),
    SOFIO("sofio", "софия"),
    TEIMURAZ("teimuraz", "теймураз"),
    VAXTANG("vaxtang", "вахтанг");

    private final String latinName;
    private final String cyrillicName;

    GeorgianNames(String latinName, String cyrillicName) {
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