package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum FinnishNames {

    ABO("åbo", "або"),
    ALAND("åland", "аланд"),
    ALBERT("albert", "альберт"),
    ALFRED("alfred", "альфред"),
    ARNOLD("arnold", "арнольд"),
    CHARLOTTA("charlotta", "шарлотта"),
    CHARLOTTE("charlotte", "шарлотте"),
    HOLGER("holger", "хольгер"),
    LEENA("leena", "лена"),
    NIILO("niilo", "нийло"),
    OSVALD("osvald", "освальд"),
    RALF("ralf", "ральф"),
    ROLF("rolf", "рольф"),
    SYLVIA("sylvia", "сильвия"),
    VALDEMAR("valdemar", "вальдемар"),
    VEERA("veera", "вера");

    private final String latinName;
    private final String cyrillicName;

    FinnishNames(String latinName, String cyrillicName) {
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