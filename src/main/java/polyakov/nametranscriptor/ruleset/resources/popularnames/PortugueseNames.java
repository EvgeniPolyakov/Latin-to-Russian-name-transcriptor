package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum PortugueseNames {
    ALEX("alex", "алекс"),
    BRASILIA("brasília", "бразилиа"),
    DO("do", "ду"),
    DOS("dos", "душ"),
    E("e", "и"),
    JOAAO("joão", "жуан"),
    JOAO("joao", "жуан"),
    O("o", "у"),
    OS("os", "уш"),
    LUIS("luis", "луиш"),
    LUISA("luisa", "луиза"),
    LUIZ("luiz", "луиш"),
    MAGDALENA("magdalena", "мадалена"),
    RIA("ria", "риа"),
    TIAGO("tiago", "тьягу");

    private final String latinName;
    private final String cyrillicName;

    PortugueseNames(String latinName, String cyrillicName) {
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