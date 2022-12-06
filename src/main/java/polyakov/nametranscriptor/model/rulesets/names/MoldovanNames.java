package polyakov.nametranscriptor.model.rulesets.names;

public enum MoldovanNames {
    ANATOLIE("Anatolie", "Анатолий"),
    EDUARD("Eduard", "Эдуард"),
    EDWARD("Edward", "Эдвард"),
    EVGHENI("Evgheni", "Евгений"),
    GHENADIE("Ghenadie", "Геннадий"),
    GENADIE("Genadie", "Геннадий"),
    GHENNADIE("Ghennadie", "Геннадий"),
    GENNADIE("Gennadie", "Геннадий"),
    MIHAIL("Mihail", "Михаил"),
    SERGHEI("Serghei", "Сергей"),
    SERGHEY("Serghey", "Сергей");

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