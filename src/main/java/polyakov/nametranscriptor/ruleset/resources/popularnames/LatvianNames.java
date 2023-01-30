package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum LatvianNames {

    ALEKSANDRS("aleksandrs", "александр"),
    ALEKSEJS("aleksejs", "алексей"),
    ANDREJS("andrejs", "андрей"),
    ANTONS("antons", "антон"),
    ARTJOMS("artjoms", "артем"),
    BOGDANS("bogdans", "богдан"),
    BORISS("boriss", "борис"),
    GEORGIJS("georgijs", "георгий"),
    DANIILS("daniils", "даниил"),
    DENISS("deniss", "денис"),
    DMITRIJS("dmitrijs", "дмитрий"),
    FILIPS("filips", "филип"),
    FILIPPS("filipps", "филипп"),
    GENADIJS("genadijs", "генадий"),
    GENNADIJS("gennadijs", "геннадий"),
    GLEBS("glebs", "глеб"),
    GRIGORIJS("grigorijs", "григорий"),
    IGORS("igors", "игорь"),
    IVANS("ivans", "иван"),
    JEVGENIJS("jevgenijs", "евгений"),
    JURIJS("jurijs", "юрий"),
    KALNINS("kalnins", "калныньш"),
    KIRILS("kirils", "кирил"),
    KIRILLS("kirills", "кирилл"),
    KONSTANTINS("konstantins", "константин"),
    LEONIDS("leonids", "леонид"),
    MAKSIMS("maksims", "максим"),
    MIHAILS("mihails", "михаил"),
    NIKOLAJS("nikolajs", "николай"),
    OLEGS("olegs", "олег"),
    OLGA("olga", "ольга"),
    PAVELS("pavels", "павел"),
    PJOTRS("pjotrs", "петр"),
    ROMANS("romans", "роман"),
    RUSLANS("ruslans", "руслан"),
    SERGEJS("sergejs", "сергей"),
    TAISIJA("taisija", "таисия"),
    VADIMS("vadims", "вадим"),
    VALENTINS("valentins", "валентин"),
    VALERIJS("valerijs", "валерий"),
    VJACHESLAVS("vjaceslavs", "вячеслав"),
    VIKTORS("viktors", "виктор"),
    VITALIJS("vitalijs", "виталий"),
    VLADIMIRS("vladimirs", "владимир"),
    VLADISLAVS("vladislavs", "владислав");

    private final String latinName;
    private final String cyrillicName;

    LatvianNames(String latinName, String cyrillicName) {
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