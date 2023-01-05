package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum LithuanianNames {

    ADRIAN("adrian", "адриан"),
    ADRIANA("adriana", "адриана"),
    GABRIELE("gabriele", "габриэле"),
    GABRIELEE("gabrielė", "габриэле"),
    GABRIELIS("gabrielis", "габриэлис"),
    GABRIELIUS("gabrielius", "габриэлюс"),
    DANIEL("daniel", "даниэль"),
    DANIELE("daniele", "даниэле"),
    DANIELEE("danielė", "даниэле"),
    DANIELIUS("danielius", "даниэлюс"),
    DIANA("diana", "диана"),
    MAKSIMILIAN("maksimilian", "максимилиан"),
    MAKSIMILIANAS("maksimilianas", "максимилианас"),
    MATIAS("matias", "матиас"),
    VIOLETA("violeta", "виолета");

    private final String latinName;
    private final String cyrillicName;

    LithuanianNames(String latinName, String cyrillicName) {
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