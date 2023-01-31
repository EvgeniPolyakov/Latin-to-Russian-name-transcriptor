package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum SpanishNames {
    ADRIAN("adrian", "адриан"),
    ADRIANA("adriana", "адриана"),
    ADRIANO("adriano", "адриано"),
    ADRIEN("adrien", "адриен"),
    ARIADNA("ariadna", "ариадна"),
    AURELIANO("aureliano", "аурелиано"),
    ASIER("asier", "асиер"),
    CHRISTIAN("christian", "кристиан"),
    CHRISTIANA("christiana", "кристиана"),
    CRISTIAN("cristian", "кристиан"),
    CRISTIANA("cristiana", "кристиана"),
    DAMIAN("damian", "дамиан"),
    DAMIANA("damiana", "дамиана"),
    DANIEL("daniel", "даниэль"),
    DANIELA("daniela", "даниэла"),
    DIAS("dias", "диас"),
    DIAZ("diaz", "диас"),
    DIEGO("diego", "диего"),
    EMILIANO("emiliano", "эмилиано"),
    FABIAN("fabian", "фабиан"),
    FABIANA("fabiana", "фабиана"),
    FARIAS("farias", "фариас"),
    JULIAN("julian", "хулиан"),
    JULIANO("juliano", "хулиано"),
    GABRIEL("gabriel", "габриэль"),
    GABRIELA("gabriela", "габриэла"),
    GUADALAJARA("guadalajara", "гвадалахара"),
    GUATEMALA("guatemala", "гватемала"),
    HABANA("habana", "гавана"),
    HONDURAS("honduras", "гондурас"),
    IGLESIAS("iglesias", "иглесиас"),
    MARIANO("mariano", "мариано"),
    MATIAS("matias", "матиас"),
    MEJIAS("mejias", "мехиас"),
    MIRIAM("miriam", "мириам"),
    ORIOL("oriol", "ориоль"),
    VIVIR("vivir", "бибир"),
    URUGUAY("uruguay", "уругвай"),
    XABI("xabi", "хаби"),
    XABIER("xabier", "хабьер"),
    XAVI("xavi", "хави"),
    XAVIER("xavier", "хавьер");

    private final String latinName;
    private final String cyrillicName;

    SpanishNames(String latinName, String cyrillicName) {
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