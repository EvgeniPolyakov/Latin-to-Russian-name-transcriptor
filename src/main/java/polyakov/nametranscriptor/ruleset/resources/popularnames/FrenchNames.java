package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum FrenchNames {
    AUXERRE("auxerre", "осер"),
    BEN("ben", "бен"),
    BENJAMIN("benjamin", "бенжамен"),
    CAMILLE("camille", "камиль"),
    CATERINE("caterine", "катрин"),
    CATHERINE("catherine", "катрин"),
    CHRISTIAN("christian", "кристиан"),
    CYRILLE("cyrille", "сириль"),
    D("d", "д"),
    DANIEL("daniel", "даниэль"),
    DANIELLE("danielle", "даниэль"),
    DAVID("david", "давид"),
    DE("de", "де"),
    DES("des", "де"),
    ETIENNE("etienne", "этьен"),
    FABIENNE("fabienne", "фабьен"),
    FLORIAN("florian", "флориан"),
    GABRIEL("gabriel", "габриэль"),
    GABRIELLE("gabrielle", "габриэль"),
    JOCELYN("jocelyn", "жослен"),
    JUDICAEL("judicael ", "жюдикаэль"),
    ISMAEL("ismael", "исмаэль"),
    KYLIAN("kylian", "килиан"),
    L("l", "л"),
    LE("le", "ле"),
    LILLIAN("lilian", "лилиан"),
    MAELYS("maelys", "маэлис"),
    MAELLE("maelle", "маэль"),
    MAEVA("maeva", "маэва"),
    MAEVANE("maevane", "маэван"),
    MARC("marc", "марк"),
    MARIELLE("marielle", "мариэль"),
    MARIO("mario", "марио"),
    MARION("marion", "марион"),
    MICHAEL("michael", "мишель"),
    MICKAEL("mickael", "микаэль"),
    MICKAELLA("mickaella", "микаэлла"),
    MICHELIN("michelin", "мишлен"),
    NATHANIEL("nathanael", "натаниэль"),
    NICOLAS("nicolas", "николя"),
    PAYS("pays", "паи"),
    PIERRE("pierre", "пьер"),
    RAPHAEL("raphael", "рафаэль"),
    RAYMOND("raymond", "раймон"),
    RAYNAL("raynal", "рейналь"),
    RHONE("rhone", "рона"),
    SAEL("sael", "саэль"),
    VILLENEUVE("villeneuve", "вильнев"),
    WIELFRIED("wielfried", "вильфрид"),
    WILLEM("willem", "виллем"),
    WILLIAM("william", "вильям");

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