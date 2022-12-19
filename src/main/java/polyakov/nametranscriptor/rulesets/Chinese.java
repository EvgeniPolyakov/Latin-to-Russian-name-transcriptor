package polyakov.nametranscriptor.rulesets;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Ruleset {

    @Override
    public String transcribe(String name, int mode) {
        name = name.replace("zuo", "цзо");
        name = name.replace("zun", "цзунь");
        name = name.replace("zui", "цзуй");
        name = name.replace("zuan", "цзуань");
        name = name.replace("zu", "цзу");
        name = name.replace("zou", "цзоу");
        name = name.replace("zong", "цзун");
        name = name.replace("zi", "цзы");
        name = name.replace("zhuo", "чжо");
        name = name.replace("zhun", "чжунь");
        name = name.replace("zhui", "чжуй");
        name = name.replace("zhuang", "чжуан");
        name = name.replace("zhuan", "чжуань");
        name = name.replace("zhuai", "чжуай");
        name = name.replace("zhua", "чжуа");
        name = name.replace("zhu", "чжу");
        name = name.replace("zhou", "чжоу");
        name = name.replace("zhong", "чжун");
        name = name.replace("zhi", "чжи");
        name = name.replace("zheng", "чжэн");
        name = name.replace("zhen", "чжэнь");
        name = name.replace("zhei", "чжэй");
        name = name.replace("zhe", "чжэ");
        name = name.replace("zhao", "чжао");
        name = name.replace("zhang", "чжан");
        name = name.replace("zhan", "чжань");
        name = name.replace("zhai", "чжай");
        name = name.replace("zha", "чжа");
        name = name.replace("zeng", "цзэн");
        name = name.replace("zen", "цзэнь");
        name = name.replace("zem", "цзэм");
        name = name.replace("zei", "цзэй");
        name = name.replace("ze", "цзэ");
        name = name.replace("zao", "цзао");
        name = name.replace("zang", "цзан");
        name = name.replace("zan", "цзань");
        name = name.replace("zai", "цзай");
        name = name.replace("za", "цза");
        name = name.replace("yun", "юнь");
        name = name.replace("yue", "юэ");
        name = name.replace("yuan", "юань");
        name = name.replace("yu", "юй");
        name = name.replace("you", "ю");
        name = name.replace("yong", "юн");
        name = name.replace("yo", "йо, ё");
        name = name.replace("ying", "ин");
        name = name.replace("yin", "инь");
        name = name.replace("yi", "и");
        name = name.replace("ye", "е");
        name = name.replace("yao", "яо");
        name = name.replace("yang", "ян");
        name = name.replace("yan", "янь");
        name = name.replace("yai", "яй");
        name = name.replace("ya", "я");
        name = name.replace("xun", "сюнь");
        name = name.replace("xue", "сюэ");
        name = name.replace("xuan", "сюань");
        name = name.replace("xu", "сюй");
        name = name.replace("xiu", "сю");
        name = name.replace("xiong", "сюн");
        name = name.replace("xing", "син");
        name = name.replace("xin", "синь");
        name = name.replace("xie", "се");
        name = name.replace("xiao", "сяо");
        name = name.replace("xiang", "сян");
        name = name.replace("xian", "сянь");
        name = name.replace("xia", "ся");
        name = name.replace("xi", "си");
        name = name.replace("wu", "у");
        name = name.replace("wo", "во");
        name = name.replace("weng", "вэн");
        name = name.replace("wen", "вэнь");
        name = name.replace("wei", "вэй");
        name = name.replace("wao", "вао");
        name = name.replace("wang", "ван");
        name = name.replace("wan", "вань");
        name = name.replace("wai", "вай");
        name = name.replace("wa", "ва");
        name = name.replace("tsuo", "цо");
        name = name.replace("tsun", "цунь");
        name = name.replace("tsui", "цуй");
        name = name.replace("tsuan", "цуань");
        name = name.replace("tsu", "цу");
        name = name.replace("tsou", "цоу");
        name = name.replace("tsong", "цун");
        name = name.replace("tsing", "цин");
        name = name.replace("tsie", "це");
        name = name.replace("tsiao", "цяо");
        name = name.replace("tsiang", "цян");
        name = name.replace("tsian", "цянь");
        name = name.replace("tsi", "ци");
        name = name.replace("tuo", "то");
        name = name.replace("tun", "тунь");
        name = name.replace("tui", "туй");
        name = name.replace("tuan", "туань");
        name = name.replace("tu", "ту");
        name = name.replace("tou", "тоу");
        name = name.replace("tong", "тун");
        name = name.replace("ting", "тин");
        name = name.replace("tie", "те");
        name = name.replace("tiao", "тяо");
        name = name.replace("tiang", "тян");
        name = name.replace("tian", "тянь");
        name = name.replace("ti", "ти");
        name = name.replace("teng", "тэн");
        name = name.replace("ten", "тэнь");
        name = name.replace("tei", "тэй");
        name = name.replace("te", "тэ");
        name = name.replace("tao", "тао");
        name = name.replace("tang", "тан");
        name = name.replace("tan", "тань");
        name = name.replace("tai", "тай");
        name = name.replace("ta", "та");
        name = name.replace("suo", "со");
        name = name.replace("sun", "сунь");
        name = name.replace("sui", "суй");
        name = name.replace("suan", "суань");
        name = name.replace("su", "су");
        name = name.replace("sou", "соу");
        name = name.replace("song", "сун");
        name = name.replace("si", "сы");
        name = name.replace("shuo", "шо");
        name = name.replace("shun", "шунь");
        name = name.replace("shui", "шуй");
        name = name.replace("shuang", "шуан");
        name = name.replace("shuan", "шуань");
        name = name.replace("shuai", "шуай");
        name = name.replace("shua", "шуа");
        name = name.replace("shu", "шу");
        name = name.replace("shou", "шоу");
        name = name.replace("shi", "ши");
        name = name.replace("sheng", "шэн");
        name = name.replace("shen", "шэнь");
        name = name.replace("shei", "шэй");
        name = name.replace("she", "шэ");
        name = name.replace("shao", "шао");
        name = name.replace("shang", "шан");
        name = name.replace("shan", "шань");
        name = name.replace("shai", "шай");
        name = name.replace("sha", "ша");
        name = name.replace("seng", "сэн");
        name = name.replace("sen", "сэнь");
        name = name.replace("sei", "сэй");
        name = name.replace("se", "сэ");
        name = name.replace("sao", "сао");
        name = name.replace("sang", "сан");
        name = name.replace("san", "сань");
        name = name.replace("sai", "сай");
        name = name.replace("sa", "са");
        name = name.replace("ruo", "жо");
        name = name.replace("run", "жунь");
        name = name.replace("rui", "жуй");
        name = name.replace("ruan", "жуань");
        name = name.replace("rua", "жуа");
        name = name.replace("ru", "жу");
        name = name.replace("rou", "жоу");
        name = name.replace("rong", "жун");
        name = name.replace("ri", "жи");
        name = name.replace("reng", "жэн");
        name = name.replace("ren", "жэнь");
        name = name.replace("rem", "жэм");
        name = name.replace("re", "жэ");
        name = name.replace("rao", "жао");
        name = name.replace("rang", "жан");
        name = name.replace("ran", "жань");
        name = name.replace("qun", "цюнь");
        name = name.replace("que", "цюэ");
        name = name.replace("quan", "цюань");
        name = name.replace("qu", "цюй");
        name = name.replace("qiu", "цю");
        name = name.replace("qiong", "цюн");
        name = name.replace("qing", "цин");
        name = name.replace("qin", "цинь");
        name = name.replace("qie", "це");
        name = name.replace("qiao", "цяо");
        name = name.replace("qiang", "цян");
        name = name.replace("qian", "цянь");
        name = name.replace("qia", "ця");
        name = name.replace("qi", "ци");
        name = name.replace("pu", "пу");
        name = name.replace("pou", "поу");
        name = name.replace("po", "по");
        name = name.replace("ping", "пин");
        name = name.replace("pin", "пинь");
        name = name.replace("pie", "пе");
        name = name.replace("piao", "пяо");
        name = name.replace("piang", "пян");
        name = name.replace("pian", "пянь");
        name = name.replace("pi", "пи");
        name = name.replace("peng", "пэн");
        name = name.replace("pen", "пэнь");
        name = name.replace("pei", "пэй");
        name = name.replace("pao", "пао");
        name = name.replace("pang", "пан");
        name = name.replace("pan", "пань");
        name = name.replace("pai", "пай");
        name = name.replace("pa", "па");
        name = name.replace("nuo", "но");
        name = name.replace("nun", "нунь");
        name = name.replace("nüe", "нюэ");
        name = name.replace("nuan", "нуань");
        name = name.replace("nü", "нюй");
        name = name.replace("nu", "ну");
        name = name.replace("nou", "ноу");
        name = name.replace("nong", "нун");
        name = name.replace("niu", "ню");
        name = name.replace("ning", "нин");
        name = name.replace("nin", "нинь");
        name = name.replace("nie", "не");
        name = name.replace("niao", "няо");
        name = name.replace("niang", "нян");
        name = name.replace("nian", "нянь");
        name = name.replace("nia", "ня");
        name = name.replace("ni", "ни");
        name = name.replace("neng", "нэн");
        name = name.replace("nen", "нэнь");
        name = name.replace("nei", "нэй");
        name = name.replace("ne", "нэ");
        name = name.replace("nao", "нао");
        name = name.replace("nang", "нан");
        name = name.replace("nan", "нань");
        name = name.replace("nai", "най");
        name = name.replace("mu", "му");
        name = name.replace("mou", "моу");
        name = name.replace("mo", "мо");
        name = name.replace("mm", "мм");
        name = name.replace("miu", "мю");
        name = name.replace("ming", "мин");
        name = name.replace("min", "минь");
        name = name.replace("mie", "ме");
        name = name.replace("miao", "мяо");
        name = name.replace("mian", "мянь");
        name = name.replace("mi", "ми");
        name = name.replace("meng", "мэн");
        name = name.replace("men", "мэнь");
        name = name.replace("mei", "мэй");
        name = name.replace("mao", "мао");
        name = name.replace("mang", "ман");
        name = name.replace("man", "мань");
        name = name.replace("mai", "май");
        name = name.replace("ma", "ма");
        name = name.replace("luo", "ло");
        name = name.replace("lün", "люнь");
        name = name.replace("lun", "лунь");
        name = name.replace("lüe", "люэ");
        name = name.replace("lüan", "люань");
        name = name.replace("luan", "луань");
        name = name.replace("lü", "люй");
        name = name.replace("lu", "лу");
        name = name.replace("lou", "лоу");
        name = name.replace("long", "лун");
        name = name.replace("lo", "ло");
        name = name.replace("liu", "лю");
        name = name.replace("ling", "лин");
        name = name.replace("lin", "линь");
        name = name.replace("lie", "ле");
        name = name.replace("liao", "ляо");
        name = name.replace("liang", "лян");
        name = name.replace("lian", "лянь");
        name = name.replace("lia", "ля");
        name = name.replace("li", "ли");
        name = name.replace("leng", "лэн");
        name = name.replace("lei", "лэй");
        name = name.replace("le", "лэ");
        name = name.replace("lao", "лао");
        name = name.replace("lang", "лан");
        name = name.replace("lan", "лань");
        name = name.replace("lai", "лай");
        name = name.replace("la", "ла");
        name = name.replace("kuo", "ко");
        name = name.replace("kung", "кун");
        name = name.replace("kun", "кунь");
        name = name.replace("kui", "куй");
        name = name.replace("kuang", "куан");
        name = name.replace("kuan", "куань");
        name = name.replace("kuai", "куай");
        name = name.replace("kua", "куа");
        name = name.replace("ku", "ку");
        name = name.replace("kou", "коу");
        name = name.replace("kong", "кун");
        name = name.replace("keng", "кэн");
        name = name.replace("ken", "кэнь");
        name = name.replace("kei", "кэй");
        name = name.replace("ke", "кэ");
        name = name.replace("kao", "као");
        name = name.replace("kang", "кан");
        name = name.replace("kan", "кань");
        name = name.replace("kai", "кай");
        name = name.replace("ka", "ка");
        name = name.replace("jun", "цзюнь");
        name = name.replace("jue", "цзюэ");
        name = name.replace("juan", "цзюань");
        name = name.replace("ju", "цзюй");
        name = name.replace("jiu", "цзю");
        name = name.replace("jiong", "цзюн");
        name = name.replace("jing", "цзин");
        name = name.replace("jin", "цзинь");
        name = name.replace("jie", "цзе");
        name = name.replace("jiao", "цзяо");
        name = name.replace("jiang", "цзян");
        name = name.replace("jian", "цзянь");
        name = name.replace("jia", "цзя");
        name = name.replace("ji", "цзи");
        name = name.replace("guo", "го");
        name = name.replace("gun", "гунь");
        name = name.replace("gui", "гуй");
        name = name.replace("guang", "гуан");
        name = name.replace("guan", "гуань");
        name = name.replace("guai", "гуай");
        name = name.replace("gua", "гуа");
        name = name.replace("gu", "гу");
        name = name.replace("gou", "гоу");
        name = name.replace("gong", "гун");
        name = name.replace("go", "го");
        name = name.replace("geng", "гэн");
        name = name.replace("gen", "гэнь");
        name = name.replace("gei", "гэй");
        name = name.replace("ge", "гэ");
        name = name.replace("gao", "гао");
        name = name.replace("gang", "ган");
        name = name.replace("gan", "гань");
        name = name.replace("gai", "гай");
        name = name.replace("ga", "га");
        name = name.replace("fu", "фу");
        name = name.replace("fou", "фоу");
        name = name.replace("fo", "фо");
        name = name.replace("fiao", "фяо");
        name = name.replace("feng", "фэн");
        name = name.replace("fen", "фэнь");
        name = name.replace("fei", "фэй");
        name = name.replace("fang", "фан");
        name = name.replace("fan", "фань");
        name = name.replace("fa", "фа");
        name = name.replace("er", "эр");
        name = name.replace("duo", "до");
        name = name.replace("dun", "дунь");
        name = name.replace("dui", "дуй");
        name = name.replace("duan", "дуань");
        name = name.replace("du", "ду");
        name = name.replace("dou", "доу");
        name = name.replace("dong", "дун");
        name = name.replace("diu", "дю");
        name = name.replace("ding", "дин");
        name = name.replace("die", "де");
        name = name.replace("diao", "дяо");
        name = name.replace("diang", "дян");
        name = name.replace("dian", "дянь");
        name = name.replace("dia", "дя");
        name = name.replace("di", "ди");
        name = name.replace("deng", "дэн");
        name = name.replace("den", "дэнь");
        name = name.replace("dei", "дэй");
        name = name.replace("de", "дэ");
        name = name.replace("dao", "дао");
        name = name.replace("dang", "дан");
        name = name.replace("dan", "дань");
        name = name.replace("dai", "дай");
        name = name.replace("da", "да");
        name = name.replace("cuo", "цо");
        name = name.replace("cun", "цунь");
        name = name.replace("cui", "цуй");
        name = name.replace("cuan", "цуань");
        name = name.replace("cu", "цу");
        name = name.replace("cou", "цоу");
        name = name.replace("cong", "цун");
        name = name.replace("ci", "цы");
        name = name.replace("chuo", "чо");
        name = name.replace("chun", "чунь");
        name = name.replace("chui", "чуй");
        name = name.replace("hun", "хунь");
        name = name.replace("hui", "хуэй");
        name = name.replace("chuang", "чуан");
        name = name.replace("chuan", "чуань");
        name = name.replace("chuai", "чуай");
        name = name.replace("chua", "чуа");
        name = name.replace("chu", "чу");
        name = name.replace("chou", "чоу");
        name = name.replace("chong", "чун");
        name = name.replace("chi", "чи");
        name = name.replace("cheng", "чэн");
        name = name.replace("chen", "чэнь");
        name = name.replace("che", "чэ");
        name = name.replace("chao", "чао");
        name = name.replace("chang", "чан");
        name = name.replace("chan", "чань");
        name = name.replace("chai", "чай");
        name = name.replace("cha", "ча");
        name = name.replace("ceng", "цэн");
        name = name.replace("cen", "цэнь");
        name = name.replace("cei", "цэй");
        name = name.replace("ce", "цэ");
        name = name.replace("cao", "цао");
        name = name.replace("cang", "цан");
        name = name.replace("can", "цань");
        name = name.replace("cai", "цай");
        name = name.replace("ca", "ца");
        name = name.replace("huang", "хуан");
        name = name.replace("huan", "хуань");
        name = name.replace("huai", "хуай");
        name = name.replace("hua", "хуа");
        name = name.replace("hng", "хн");
        name = name.replace("hm", "хм");
        name = name.replace("huo", "хо");
        name = name.replace("hu", "ху");
        name = name.replace("hou", "хоу");
        name = name.replace("hong", "хун");
        name = name.replace("heng", "хэн");
        name = name.replace("hen", "хэнь");
        name = name.replace("hei", "хэй");
        name = name.replace("he", "хэ");
        name = name.replace("hao", "хао");
        name = name.replace("hang", "хан");
        name = name.replace("han", "хань");
        name = name.replace("hai", "хай");
        name = name.replace("ha", "ха");
        name = name.replace("bu", "бу");
        name = name.replace("bo", "бо");
        name = name.replace("bing", "бин");
        name = name.replace("bin", "бинь");
        name = name.replace("bie", "бе");
        name = name.replace("biao", "бяо");
        name = name.replace("bian", "бянь");
        name = name.replace("bi", "би");
        name = name.replace("beng", "бэн");
        name = name.replace("ben", "бэнь");
        name = name.replace("bei", "бэй");
        name = name.replace("bao", "бао");
        name = name.replace("bang", "бан");
        name = name.replace("ban", "бань");
        name = name.replace("bai", "бай");
        name = name.replace("ba", "ба");
        name = name.replace("eng", "эн");
        name = name.replace("en", "энь");
        name = name.replace("ei", "эй");
        name = name.replace("ê", "эй");
        name = name.replace("ao", "ао");
        name = name.replace("ang", "ан");
        name = name.replace("an", "ань");
        name = name.replace("ai", "ай");
        name = name.replace("ng", "н");
        name = name.replace("na", "на");
        name = name.replace("me", "мэ");
        name = name.replace("e", "э");
        name = name.replace("ou", "оу");
        name = name.replace("m", "м");
        name = name.replace("o", "о");
        name = name.replace("n", "нь");
        name = name.replace("a", "а");
        return name;
    }

    @Override
    public String getName() {
        return RulesetName.CHINESE.getName();
    }
}