package polyakov.nametranscriptor.rulesets.names;

public enum AlbanianNames {
    DUKAGJINI("dukagjini", "дукаджини"),
    FIER("fier", "фиери"),
    FUSHE("fushë", "фуше"),
    GJAKOVA("gjakova", "гьякова"),
    GJIROKASTER("gjirokastër", "гирокастра"),
    GRAMSH("gramsh", "грамши"),
    KAMEZ("kamëz", "камза"),
    KASTRIOTI("kastrioti", "кастриот"),
    KOLE("kolë", "кола"),
    LAC("laç", "лячи"),
    LIPJANI("lipjani", "липлян"),
    PESHKOPI("peshkopi", "пешкопия"),
    PRIZRENI("prizreni", "призрен"),
    RAHOVECI("rahoveci", "раховац"),
    SARANDE("sarandë", "саранда");

    private final String latinName;
    private final String cyrillicName;

    AlbanianNames(String latinName, String cyrillicName) {
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