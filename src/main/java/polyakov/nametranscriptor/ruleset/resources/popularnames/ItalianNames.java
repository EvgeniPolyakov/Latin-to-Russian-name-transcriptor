package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum ItalianNames {
    ADRIANA("adriana", "адриана"),
    ARIANNA("arianna", "арианна"),
    BENIAMINO("beniamino", "беньямино"),
    CHRISTIAN("christian", "кристиан"),
    CRISTIAN("cristian", "кристиан"),
    DAI("dai", "даи"),
    DANIEL("daniel", "даниел"),
    DAMIAN("damian", "дамиан"),
    DAMIANA("damiana", "дамиана"),
    DANIELE("daniele", "даниеле"),
    DANIELA("daniela", "даниела"),
    DANIELLA("daniella", "даниелла"),
    DEI("dei", "деи"),
    DIEGO("diego", "диего"),
    DUI("dui", "дуи"),
    ELIA("elia", "элиа"),
    EZEQUIEL("ezequiel", "эзекьель"),
    FABIANA("fabiana", "фабиана"),
    FRIULI("friuli", "фриули"),
    GABRIEL("gabriel", "габриел"),
    GABRIELE("gabriele", "габриеле"),
    GIANLUIGI("gianluigi", "джанулиджи"),
    GUIDO("guido", "гвидо"),
    GUILHERME("guilherme", "гильерме"),
    LUCIA("lucia", "лючия"),
    LUIGI("luigi", "луиджи"),
    MARIANA("mariana", "мариана"),
    MARIANNA("marianna", "марианна"),
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