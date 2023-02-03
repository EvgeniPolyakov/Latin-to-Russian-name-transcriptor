package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum ItalianNames {
    ADRIAN("adrian", "адриан"),
    ADRIANA("adriana", "адриана"),
    ADRIANO("adriano", "адриано"),
    ARIANNA("arianna", "арианна"),
    AURELIANO("aureliano", "аурелиано"),
    BENIAMINO("beniamino", "беньямино"),
    CHRISTIAN("christian", "кристиан"),
    CHRISTIANA("christiana", "кристиана"),
    CRISTIAN("cristian", "кристиан"),
    CRISTIANA("cristiana", "кристиана"),
    DAI("dai", "даи"),
    DANIEL("daniel", "даниэл"),
    DAMIAN("damian", "дамиан"),
    DAMIANA("damiana", "дамиана"),
    DANIELE("daniele", "даниэле"),
    DANIELA("daniela", "даниэла"),
    DANIELLA("daniella", "даниэлла"),
    DEI("dei", "деи"),
    DIANA("diana", "диана"),
    DIEGO("diego", "диего"),
    DUI("dui", "дуи"),
    ELIA("elia", "элиа"),
    EMILIANO("emiliano", "эмилиано"),
    EZEQUIEL("ezequiel", "эзекьель"),
    FABIAN("fabian", "фабиан"),
    FABIANA("fabiana", "фабиана"),
    FRIULI("friuli", "фриули"),
    GABRIEL("gabriel", "габриэл"),
    GABRIELE("gabriele", "габриэле"),
    GIANLUIGI("gianluigi", "джанулиджи"),
    GUIDO("guido", "гвидо"),
    GUILHERME("guilherme", "гильерме"),
    LUCIA("lucia", "лючия"),
    LUIGI("luigi", "луиджи"),
    MARIANA("mariana", "мариана"),
    MARIANNA("marianna", "марианна"),
    MARIANO("mariano", "мариано"),
    MATIAS("matias", "матиас"),
    MIRIAM("miriam", "мириам"),
    NADIA("nadia", "надя"),
    PIERLUIGI("pierluigi", "пьерлуиджи"),
    SANTIAGO("santiago", "сантьяго"),
    SEBASTIANO("sebastiano", "себастьяно"),
    THIAGO("thiago", "тьяго"),
    TIAGO("tiago", "тьяго"),
    TIZIANA("tiziana", "тициана"),
    VIVIANA("viviana", "вивиана");

    private final String latinName;
    private final String cyrillicName;

    ItalianNames(String latinName, String cyrillicName) {
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