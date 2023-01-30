package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum GermanNames {
    ANDREAS("andreas", "андреас"),
    ADRIEN("adrien", "адриен"),
    ALOIS("alois", "алоис"),
    ASTRID("astrid", "астрид"),
    BASTIAN("bastian", "бастиан"),
    BJORN("bjorn", "бьорн"),
    CARSTEN("carsten", "карстен"),
    CHARLOTTE("charlotte", "шарлотта"),
    CHIEMSEE("chiemsee", "кимзе"),
    CHRISTEL("christel", "кристель"),
    CHRISTIAN("christian", "кристиан"),
    CHRISTIANA("christiana", "кристиана"),
    CHRISTINE("christine", "кристине"),
    CRISTIAN("cristian", "кристиан"),
    CRISTIANA("cristiana", "кристиана"),
    CRISTINE("cristine", "кристине"),
    CHRISTOPH("christoph", "кристоф"),
    CHRISTOPHER("christopher", "кристофер"),
    DAMIEN("damien", "дамьен"),
    DANIEL("daniel", "даниэль"),
    DANIELA("daniela", "даниэла"),
    DANIELE("daniele", "даниэль"),
    DANIELLE("danielle", "даниэль"),
    EBERHARD("eberhard", "эберхард"),
    ETIENNE("etienne", "этьен"),
    FABIENNE("fabienne", "фабьен"),
    GABRIEL("gabriel", "габриэль"),
    GUIDO("guido", "гвидо"),
    GUSTAV("gustav", "густав"),
    HAMBURG("hamburg", "гамбург"),
    HORST("horst", "хорст"),
    JENS("jens", "йенс"),
    JORG("jorg", "йорг"),
    JUSTIN("justin", "юстин"),
    KARL("karl", "карл"),
    KARSTEN("karsten", "карстен"),
    KATJA("katja", "катя"),
    KERSTIN("kerstin", "керстин"),
    KONSTANTIN("konstantin", "константин"),
    LOUISA("louisa", "луиза"),
    LUCIEN("lucien", "люсьен"),
    LUIS("luis", "луис"),
    LUISA("luisa", "луиза"),
    MANUEL("manuel", "мануэль"),
    MANUELA("manuela", "мануэла"),
    MICHAEL("michael", "михаэль"),
    MICHAELA("michaela", "михаэла"),
    NIETZSCHE("nietzsche", "ницше"),
    OLIVER("oliver", "оливер"),
    RAFAEL("rafael", "рафаэль"),
    RAPHAEL("raphael", "рафаэль"),
    SASCHA("sascha", "саша"),
    SEBASTIAN("sebastian", "себастьян"),
    STEVE("steve", "стив"),
    SVEN("sven", "свен"),
    THORSTEN("thorsten", "торстен"),
    TORSTEN("torsten", "торстен"),
    VIVIEN("vivien", "вивиен"),
    XAVER("xaver", "ксавер");

    private final String latinName;
    private final String cyrillicName;

    GermanNames(String latinName, String cyrillicName) {
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