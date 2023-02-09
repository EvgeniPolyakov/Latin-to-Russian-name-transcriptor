package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum HungarianNames {

    ANTAL("antal", "антал"),
    SZABOLCS("szabolcs", "саболч"),
    ZOLTAN("zoltan", "золтан"),
    ZSOLT("zsolt", "жолт");

    private final String latinName;
    private final String cyrillicName;

    HungarianNames(String latinName, String cyrillicName) {
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