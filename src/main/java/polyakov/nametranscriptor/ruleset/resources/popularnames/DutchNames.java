package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum DutchNames {
    BOSCH("bosch", "босх"),
    DYCK("dyck", "дейк"),
    MAASTRICHT("maastricht", "маастрихт"),
    NIUEW("nieuw", "ньив"),
    HOUBEN("houben", "хубен"),
    PLOUMEN("ploumen", "плумен"),
    VANDENBROUCKE("vandenbroucke", "ванденбрукке"),
    ROSENDAAL("roosendaal", "розендал"),
    SCHIPHOL("schiphol", "схипхол");

    private final String latinName;
    private final String cyrillicName;

    DutchNames(String latinName, String cyrillicName) {
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