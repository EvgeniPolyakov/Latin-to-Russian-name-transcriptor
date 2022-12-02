package polyakov.nametranscriptor.model.rulesets;

public class Georgian extends Russian {

    @Override
    protected String checkCustomCases(String name) {
        if (name.endsWith("aia")) {
            name = name.replace("aia", "ая");
        }
        if (name.endsWith("ia")) {
            name = name.replace("ia", "ия");
        }
        if (name.equals("Davit")) {
            name = "Давид";
        }
        if (name.equals("davit")) {
            name = "давид";
        }
        name = name.replace("ikheil", "ихаил");
        name = name.replace("Giorg", "Георг");
        name = name.replace("Giorgi", "Георгий");
        name = name.replace("giorg", "георг");
        name = name.replace("giorgi", "георгий");
        name = name.replace("eimuraz", "еймураз");
        name = name.replace("Mja", "Мжа");
        name = name.replace("mja", "мжа");
        name = name.replace("Bja", "бжа");
        name = name.replace("bja", "бжа");
        name = name.replace("Q", "К");
        name = name.replace("q", "к");
        name = name.replace("ia", "иа");
        name = name.replace("Ia", "Иа");
        name = name.replace("ai", "аи");
        name = name.replace("ei", "еи");
        name = name.replace("dj", "дж");
        name = name.replace("Dj", "Дж");
        name = name.replace("j", "дж");
        name = name.replace("J", "Дж");
        name = name.replace("ghe", "ге");
        name = name.replace("Ghe", "Ге");
        name = name.replace("Tch", "Ч");
        name = name.replace("tch", "ч");
        return name;
    }
}
