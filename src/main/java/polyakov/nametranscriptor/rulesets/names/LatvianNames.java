package polyakov.nametranscriptor.rulesets.names;

public enum LatvianNames {

    ALEKSANDRS("aleksandrs", "александр"),
    ALEKSEJS("aleksejs", "алексей"),
    ANDREJS("andrejs", "андрей"),
    ANTONS("antons", "антон"),
    ARTJOMS("artjoms", "артем"),
    BOGDANS("dogdans", "богдан"),
    BORISS("boriss", "борис"),
    GEORGIJS("georgijs", "георгий"),
    DANIILS("daniils", "даниил"),
    DENISS("deniss", "денис"),
    DMITRIJS("dmitrijs", "дмитрий"),
    FILIPS("filips", "филип"),
    FILIPPS("filipps", "филипп"),
    GENADIJS("genadijs", "генадий"),
    GLEBS("glebs", "глеб"),
    GRIGORIJS("grigorijs", "григорий"),
    IGORS("igors", "игорь"),
    IVANS("ivans", "иван"),
    JEVGENIJS("jevgenijs", "евгений"),
    JEVGENNIJS("jevgeņijs", "евгений"),
    JEVGEENIJS("jevgēnijs", "евгений"),
    JEVGEENNIJS("jevgēņijs", "евгений"),
    JURIJS("jurijs", "юрий"),
    KALNINS("kalniņš", "калныньш"),
    KIRILS("kirils", "кирил"),
    KIRILLS("kirills", "кирилл"),
    KONSTANTINS("konstantins", "константин"),
    LEONIDS("leonids", "леонид"),
    MAKSIMS("maksims", "максим"),
    MIHAILS("mihails", "михаил"),
    NIKOLAJS("nikolajs", "николай"),
    OLEGS("olegs", "олег"),
    OLLEGS("oļegs", "олег"),
    OLGA("olga", "ольга"),
    PAAVELS("pāvels", "павел"),
    PAVELS("pavels", "павел"),
    PJOTRS("pjotrs", "петр"),
    ROMANS("romans", "роман"),
    RUSLANS("ruslans", "руслан"),
    SERGEJS("sergejs", "сергей"),
    TAISIJA("taisija", "таисия"),
    VADIMS("vadims", "вадим"),
    VALENTINS("valentins", "валентин"),
    VALERIJS("valerijs", "валерий"),
    VALEERIJS("valērijs", "валерий"),
    VJACHESLAVS("vjačeslavs", "вячеслав"),
    VIKTORS("viktors", "виктор"),
    VITAALIJS("vitālijs", "виталий"),
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