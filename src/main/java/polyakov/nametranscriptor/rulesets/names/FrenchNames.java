package polyakov.nametranscriptor.rulesets.names;

public enum FrenchNames {
    AUXERRE("auxerre", "осер"),
    CAMILLE("camille", "камиль"),
    CHRISTIAN("christian", "кристиан"),
    D("d", "д"),
    DE("de", "де"),
    DES("des", "де"),
    L("l", "л"),
    LE("le", "ле"),
    MICHELEN("michelin", "мишлен"),
    PAYS("pays", "паи"),
    PIERRE("pierre", "пьер"),
    RAYNAL("raynal", "рейналь"),
    RHONE("rhône", "рона"),
    RHONE2("rhone", "рона"),
    VILLENEUVE("villeneuve", "вильнев");

    private final String latinName;
    private final String cyrillicName;

    FrenchNames(String latinName, String cyrillicName) {
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