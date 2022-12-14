package polyakov.nametranscriptor.model.rulesets.names;

public enum UkrainianNames {
    ADRIAN("adrian", "адриан"),
    ADRIANA("adriana", "адриана"),
    ANDRIY("andriy", "андрей"),
    BOGHDAN("boghdan", "богдан"),
    BOHDAN("bohdan", "богдан"),
    BORYS("borys", "борис"),
    DANYIL("danyil", "даниил"),
    DANYLO("danylo", "даниил"),
    DARYNA("daryna", "дарина"),
    DENYS("denys", "денис"),
    DIANA("diana", "диана"),
    DYANA("dyana", "диана"),
    DMITRYI("dmitryi", "дмитрий"),
    DMYTRO("dmytro", "дмитрий"),
    EVGEN("evgen", "евгений"),
    EVHEN("evhen", "евгений"),
    FEDIR("fedir", "федор"),
    GANNA("ganna", "анна"),
    GENNADIY("gennadiy", "геннадий"),
    HALYNA("halyna", "галина"),
    IHOR("ihor", "игорь"),
    IRYNA("iryna", "ирина"),
    KATERYNA("kateryna", "екатерина"),
    KONSTYANTYN("konstyantyn", "константин"),
    KONSTIANTYN("konstiantyn", "константин"),
    KONSTYANTIN("konstyantin", "константин"),
    KONSTIANTIN("konstiantin", "константин"),
    KOSTYANTYN("kostyantyn", "константин"),
    KOSTIANTYN("kostiantyn", "константин"),
    KOSTYANTIN("kostyantin", "константин"),
    KOSTIANTIN("kostiantin", "константин"),
    KRISTIAN("kristian", "кристиан"),
    KRYSTIAN("krystian", "кристиан"),
    KYRYLO("kyrylo", "кирилл"),
    MAKSYM("maksym", "максим"),
    MAKSYMILIAN("maksymilian", "максимилиан"),
    MAXYMILIAN("maxymilian", "максимилиан"),
    MARYAN("maryan", "марьян"),
    MARYNA("maryna", "марина"),
    MATVIY("matviy", "матвей"),
    MAXYM("maxym", "максим"),
    MYKHAILO("mykhailo", "михаил"),
    MYKHAYIO("mykhayio", "михаил"),
    MYKOLA("mykola", "николай"),
    NADIYA("nadiya", "надежда"),
    NADIIA("nadiia", "надежда"),
    NYKOLA("nykola", "николай"),
    OLEH("oleh", "олег"),
    OLEKSANDER("oleksander", "александр"),
    OLEKSANDR("oleksandr", "александр"),
    OLEKSIY("oleksiy", "алексей"),
    OLEKSII("oleksii", "алексей"),
    OLEKSI("oleksi", "алексей"),
    OLEKSY("oleksy", "алексей"),
    OLENA("olena", "елена"),
    OLEXANDER("olexander", "александр"),
    OLEXANDR("olexandr", "александр"),
    OLEXANDRA("olexandra", "александра"),
    OLEXIY("olexiy", "алексей"),
    OLEXII("olexii", "алексей"),
    OLEXI("olexi", "алексей"),
    OLEXY("olexy", "алексей"),
    PAVLO("pavlo", "павел"),
    PETRO("petro", "петр"),
    SERGIY("sergiy", "сергей"),
    SERHIY("serhiy", "сергей"),
    SVITLANA("svitlana", "светлана"),
    TETYANA("tetyana", "татьяна"),
    VADYM("vadym", "вадим"),
    VALENTYNA("valentyna", "валентина"),
    VASYL("vasyl", "василий"),
    VENIAMIN("veniamin", "вениамин"),
    VICTOR("victor", "виктор"),
    VIKTOR("viktor", "виктор"),
    VOLODYMYR("volodymyr", "владимир"),
    YAKIV("yakiv", "яков"),
    YAROSLAV("yaroslav", "ярослав"),
    YEVGEN("yevgen", "евгений"),
    YEVHEN("yevhen", "евгений"),
    YUKHIM("yukhim", "ефим"),
    YUKHYM("yukhym", "ефим");


    private final String latinName;
    private final String cyrillicName;

    UkrainianNames(String latinName, String cyrillicName) {
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