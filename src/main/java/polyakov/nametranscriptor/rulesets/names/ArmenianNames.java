package polyakov.nametranscriptor.rulesets.names;

public enum ArmenianNames {
    ALBERT("albert", "альберт"),
    ANAHIT("anahit", "анаит"),
    ANGELA("angela", "анжела"),
    DAVIT("davit", "давид"),
    EDWARD("edward", "эдуард"),
    JORA("jora", "жора"),
    HAKOB("hakob", "акоп"),
    HAYK("hayk", "гайк"),
    HASMIK("hasmik", "асмик"),
    HENRIKH("henrikh", "генрих"),
    HENRIK("henrik", "генрих"),
    HENRI("henri", "генри"),
    HAMLET("hamlet", "гамлет"),
    HRACH("hrach", "грач"),
    HRACHIA("hrachia", "грачья"),
    HRACHYA("hrachya", "грачья"),
    LIOVA("liova", "лева"),
    LYOVA("lyova", "лева"),
    MARIAM("mariam", "мариам"),
    MERY("mery", "мери"),
    MHER("mher", "мгер"),
    NELLY("nelly", "нелли"),
    SARGISE("sargise", "саркис"),
    SARGIS("sargis", "саркис"),
    VAHAGN("vahagn", "ваагн"),
    VAHAN("vahan", "ваан"),
    VAHE("vahe", "ваге");

    private final String latinName;
    private final String cyrillicName;

    ArmenianNames(String latinName, String cyrillicName) {
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