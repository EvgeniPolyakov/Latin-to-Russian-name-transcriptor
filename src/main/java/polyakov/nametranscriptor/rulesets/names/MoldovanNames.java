package polyakov.nametranscriptor.rulesets.names;

public enum MoldovanNames {
    ANATOLIE("anatolie", "анатолий"),
    EDUARD("eduard", "эдуард"),
    EDWARD("edward", "эдвард"),
    EVGHENI("evgheni", "евгений"),
    GHENADIE("ghenadie", "геннадий"),
    GENADIE("genadie", "геннадий"),
    GHENNADIE("ghennadie", "геннадий"),
    GENNADIE("gennadie", "геннадий"),
    MIHAIL("mihail", "михаил"),
    SERGHEI("serghei", "сергей"),
    SERGHEY("serghey", "сергей");

    private final String latinName;
    private final String cyrillicName;

    MoldovanNames(String latinName, String cyrillicName) {
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