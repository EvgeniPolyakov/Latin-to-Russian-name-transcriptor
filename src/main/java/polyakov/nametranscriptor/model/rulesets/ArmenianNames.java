package polyakov.nametranscriptor.model.rulesets;

public enum ArmenianNames {
    ALBERT("Albert" , "Альберт"),
    ANAHIT("Anahit" , "Анаит"),
    ANGELA("Angela" , "Анжела"),
    DAVIT("Davit", "Давид"),
    EDWARD("Edward" , "Эдуард"),
    JORA("Jora" , "Жора"),
    HAKOB("Hakob", "Акоп"),
    HAYK("Hayk" , "Гайк"),
    HASMIK("Hasmik" , "Асмик"),
    HENRIKH("Henrikh" , "Генрих"),
    HENRIK("Henrik" , "Генрих"),
    HENRI("Henri" , "Генри"),
    HAMLET("Hamlet" , "Гамлет"),
    HRACH("Hrach" , "Грач"),
    LIOVA("Liova" , "Лева"),
    LYOVA("Lyova" , "Лева"),
    MARIAM("Mariam" , "Мариам"),
    MERY("Mery" , "Мери"),
    MHER("Mher" , "Мгер"),
    NELLY("Nelly" , "Нелли"),
    SARGISE("Sargise" , "Саркис"),
    SARGIS("Sargis" , "Саркис"),
    VAHAGN("Vahagn" , "Ваагн"),
    VAHAN("Vahan" , "Ваан"),
    VAHE("Vahe" , "Ваге");

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