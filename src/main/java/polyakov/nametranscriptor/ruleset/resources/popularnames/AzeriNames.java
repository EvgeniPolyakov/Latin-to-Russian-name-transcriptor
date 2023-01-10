package polyakov.nametranscriptor.ruleset.resources.popularnames;

public enum AzeriNames {
    AKBAR("akbar", "акпер"),
    AKHMAD("akhmad", "ахмед"),
    ALAKBAR("alakbar", "алекпер"),
    AHMAD("ahmad", "ахмед"),
    AYDIN("aydin", "айдын"),
    ASGAR("asgar", "аскер"),
    DILAR("dilar", "диляр"),
    ELGUN("elgun", "эльгюн"),
    FAIG("faig", "фаик"),
    FIKRAT("fikrat", "фикрет"),
    GULAGA("gulaga", "гюлага"),
    GULAGHA("gulagha", "гюлага"),
    GULTAJ("gultaj", "гюльтадж"),
    GULNARA("gulnara", "гюльнара"),
    ISGANDAR("isgandar", "искандер"),
    ISMAYIL("ismayil", "исмаил"),
    ISMAYILOV("ismayilov", "исмайлов"),
    ISMAYILOVA("ismayilova", "исмайлова"),
    HASAN("hasan", "гасан"),
    HUSEYN("huseyn", "гусейн"),
    HUUSEYN("hüseyn", "гусейн"),
    KAMAL("kamal", "кямал"),
    KAMRAN("kamran", "кямран"),
    KANAN("kanan", "кянан"),
    KAPAZ("kapaz", "кяпаз"),
    LAMAN("laman", "ляман"),
    LAMIA("lamia", "ламия"),
    MAGAMAD("magamad", "магомед"),
    MAHAMMAD("mahammad", "магомед"),
    MIKAYIL("mikayil", "микаил"),
    MIKAYIIL("mikayıl", "микаил"),
    NAILA("naila", "наиля"),
    NIGAR("nigar", "нигяр"),
    MAMAD("mamad", "мамед"),
    MAMMAD("mammad", "мамед"),
    NAHIG("nahig", ""),
    NAMIG("namig", ""),
    NATIG("natig", ""),
    RAFIG("rafig", ""),
    TOFIG("tofig", "тофик"),
    ULVI("ulvi", "ульви"),
    ZIRA("zira", "зиря"),
    ZHALA("zhala", "жаля");

    private final String latinName;
    private final String cyrillicName;

    AzeriNames(String latinName, String cyrillicName) {
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