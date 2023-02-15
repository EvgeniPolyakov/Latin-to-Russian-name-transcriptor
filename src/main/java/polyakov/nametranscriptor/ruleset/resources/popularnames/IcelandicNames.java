package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum IcelandicNames {
    BAKKAFLOI("bakkaflói", "баккафлоуи"),
    ELLA("ella", "элла"),
    ELLI("elli", "элли"),
    FAXAFLOI("faxaflói", "фахсафлоуи"),
    HERADSFLOI("héraðsflói", "хьерадсфлоуи"),
    STEFAN("stefán", "стефаун");

    private final String latinName;
    private final String cyrillicName;

    IcelandicNames(String latinName, String cyrillicName) {
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