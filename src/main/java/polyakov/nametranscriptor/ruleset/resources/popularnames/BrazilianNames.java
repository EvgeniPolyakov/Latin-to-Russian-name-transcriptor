package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum BrazilianNames {
    ALEX("alex", "алекс"),
    BRASILIA("brasilia", "бразилиа"),
    DO("do", "до"),
    DOS("dos", "дос"),
    E("e", "и"),
    JOAO("joao", "жоао"),
    O("o", "о"),
    OS("os", "ос"),
    LUIS("luis", "луис"),
    LUISA("luisa", "луиза"),
    LUIZ("luiz", "луис"),
    MAGDALENA("magdalena", "мадалена"),
    RIA("ria", "риа"),
    TIAGO("tiago", "тьяго");

    private final String latinName;
    private final String cyrillicName;

    BrazilianNames(String latinName, String cyrillicName) {
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