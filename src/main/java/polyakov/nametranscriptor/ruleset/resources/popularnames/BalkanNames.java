package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum BalkanNames {
    BENJAMIN("benjamin", "беньямин"),
    CETINJE("cetinje", "цетинье"),
    GLORIA("gloria", "глория"),
    DANJEL("danjel", "даньел"),
    FRANJO("franjo", "франьо"),
    IVICIA("ivicia", "ивиция"),
    LIA("lia", "лия"),
    LUCIA("lucia", "луция"),
    MIA("mia", "мия"),
    MARIA("maria", "мария"),
    MELANIA("melania", "мелания"),
    NATALIA("natalia", "наталия"),
    NEMANJA("nemanja", "неманья"),
    PIA("pia", "пия"),
    TIA("tia", "тия"),
    RUNJE("runje", "рунье"),
    SOFIA("sofia", "софия"),
    VRANJES("vranjes", "враньеш");

    private final String latinName;
    private final String cyrillicName;

    BalkanNames(String latinName, String cyrillicName) {
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