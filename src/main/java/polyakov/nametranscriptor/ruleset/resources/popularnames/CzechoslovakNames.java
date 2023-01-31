package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum CzechoslovakNames {
    ADRIAN("adrian", "адриан"),
    ADRIANA("adriana", "адриана"),
    ADRIEN("adrien", "адриен"),
    ANTONIO("antonio", "антонио"),
    BIBIANA("bibiana", "бибиана"),
    CHRISTIAN("christian", "кристиан"),
    CHRISTIANA("christiana", "кристиана"),
    CRISTIAN("cristian", "кристиан"),
    CRISTIANA("cristiana", "кристиана"),
    DAMIAN("damian", "дамиан"),
    DAMIANA("damiana", "дамиана"),
    DANIEL("daniel", "даниэл"),
    DANIELA("daniela", "даниэла"),
    DANIELE("daniele", "даниэл"),
    DANIELLE("danielle", "даниэл"),
    DIANA("diana", "диана"),
    FABIAN("fabian", "фабиан"),
    FABIANA("fabiana", "фабиана"),
    GABRIEL("gabriel", "габриэл"),
    GABRIELA("gabriela", "габриэла"),
    HENRIETE("henrieta", "генриете"),
    JULIAN("julian", "юлиан"),
    JULIANA("juliana", "юлиана"),
    JULIUS("julius", "юлиус"),
    KRISTIAN("kristian", "кристиан"),
    KRISZTIAN("krisztian", "кристиан"),
    LIANA("liana", "лиана"),
    LUCIE("lucie", "луцие"),
    MARIAN("marian", "мариан"),
    MARIANA("mariana", "мариана"),
    MARIANNA("marianna", "марианна"),
    MARIE("marie", "марие"),
    MARIO("mario", "марио"),
    MAXIMILIAN("maximilian", "максимилиан"),
    MIRIAM("miriam", "мириам"),
    NATALIE("natalie", "наталие"),
    SEBASTIAN("sebastian", "себастиан"),
    TEREZIE("terezie", "терезие"),
    VALERIAN("valerian", "валериан"),
    VIKTORIE("viktorie", "викторие");

    private final String latinName;
    private final String cyrillicName;

    CzechoslovakNames(String latinName, String cyrillicName) {
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