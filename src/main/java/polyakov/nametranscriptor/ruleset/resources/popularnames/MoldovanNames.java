package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum MoldovanNames {
    AFANASIE("afanasie", "афанасий"),
    ALEXANDRU("alexandru", "александр"),
    ADRIAN("adrian", "адриан"),
    ADRIANA("adriana", "адриана"),
    ANATOLIE("anatolie", "анатолий"),
    ANDRIAN("andrian", "андриан"),
    ARCADIE("arcadie", "аркадий"),
    CORNELIU("corneliu", "корнелий"),
    CRISTIAN("cristian", "кристиан"),
    DANIEL ("daniel", "даниел"),
    DANIELA("daniela", "даниела"),
    DIANA("diana", "диана"),
    DIONIS("dionis", "дионис"),
    DMITRIE("dmitrie", "дмитрий"),
    EDUARD("eduard", "эдуард"),
    EDWARD("edward", "эдвард"),
    EVGHENI("evgheni", "евгений"),
    EUGENIU("eugeniu", "евгений"),
    GABRIEL("gabriel", "габриел"),
    GABRIELA("gabriela", "габриела"),
    GIORGI("giorgi", "георгий"),
    GHENADIE("ghenadie", "геннадий"),
    GENADIE("genadie", "геннадий"),
    GHENNADIE("ghennadie", "геннадий"),
    GENNADIE("gennadie", "геннадий"),
    DUMTIRU("dumitru", "дмитрий"),
    IULIANA("iuliana", "юлиана"),
    ILIE("ilie", "илья"),
    IURIE("iurie", "ирий"),
    LILIANA("liliana", "лилиана"),
    LIVIU ("liviu ", "ливиу"),
    MARIUS("marius", "мариус"),
    MIHAIL("mihail", "михаил"),
    OCTAVIAN("octavian", "октавиан"),
    SERGIU("sergiu", "сергей"),
    SERGHEI("serghei", "сергей"),
    SERGHEY("serghey", "сергей"),
    VALERIU("valeriu", "валерий"),
    VIOLETA("violeta", "виолета"),
    VIOREL("viorel", "виорел"),
    VITALIE("vitalie", "виталий");

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