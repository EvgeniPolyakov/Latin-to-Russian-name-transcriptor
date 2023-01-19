package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum HebrewNames {

    AYA("aya", "айя"),
    BEEROT("beerot", "беерот"),
    COHEN("cohen", "коэн"),
    GUY("guy", "гай"),
    NAIM("naim", "наим"),
    WAIL("wail", "ваиль"),
    YAIR("yair", "яир"),
    ZEEV("zeev", "зеев");

    private final String latinName;
    private final String cyrillicName;

    HebrewNames(String latinName, String cyrillicName) {
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