package polyakov.nametranscriptor.rulesets.rulesets;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.rulesets.Kazakh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class KazakhTest {

    @Test
    void transcribe() {
        String text = """
                alexandr shirobokov alisher rakhimzhanov arsen azatov askar satyshev vadim yakovlev adil galymzhan \
                kenzhebek danil ankudinov daniil somov daniyar dulatov daniyar urda dias kushkumbayev yegor tkachenko \
                zhannur kukeyev miras amantayev khalmatov nikita pivkin roman chirkov sultan askarov adilet kuanysh \
                janaidar dobay aibar janaozen alexandr shirobokov alen aimanov arsen azatov baizhan madelkhan vladimir \
                biryukov vladislav butyrin damir kassabulat zhassulan yerzhigit kakhramon khassanov konstantin puzanov \
                lev kurgin magzhan baurzhan nurgaini buribayev tenizbay abdurakhmanov yuri akhanov aida artykbay \
                aidana kuztay alexandra burova alina khassanova alina shalmukhanbetova sailaubekkyzy aruzhan orazbekova \
                kubessova assemgul aruova bagully gulim kenzhetay gulmira tashmet zhansaya kopzhanova leila sadykova \
                burdakova nazerke shalmukhanbetova elvira narbek smagulova zhautikova serikbay ainur jabylbayeva aisha \
                sadykova anastassiya nizamutdinova angelina portnova flyut arailym orynbassarova assem zhaksymbay \
                ayazhan akhmoldanova yekaterina yelisseyeva kamila akshalova kundyz kozhakhmet amirbek nadezhda \
                ivanyuk olga volkova rano akbayeva shynar sharapidenova schuchinsk""";
                String transcription = """
                александр широбоков алишер рахимжанов арсен азатов аскар сатышев вадим яковлев адиль галымжан кенжебек \
                данил анкудинов даниил сомов данияр дулатов данияр урда диас кушкумбаев егор ткаченко жаннур кукеев \
                мирас амантаев халматов никита пивкин роман чирков султан аскаров адилет куаныш жанайдар добай айбар \
                жанаозен александр широбоков ален айманов арсен азатов байжан маделхан владимир бирюков владислав \
                бутырин дамир касабулат жасулан ержигит кахрамон хасанов константин пузанов лев кургин магжан бауржан \
                нургайни бурибаев тенизбай абдурахманов юрий аханов аида артыкбай айдана кузтай александра бурова \
                алина хасанова алина шалмуханбетова сайлаубеккызы аружан оразбекова кубесова асемгуль аруова багуллы \
                гулим кенжетай гульмира ташмет жансая копжанова лейла садыкова бурдакова назерке шалмуханбетова \
                эльвира нарбек смагулова жаутикова серикбай айнур жабылбаева айша садыкова анастасия низамутдинова \
                ангелина портнова флют арайлым орынбасарова асем жаксымбай аяжан ахмолданова екатерина елисеева камила \
                акшалова кундыз кожахмет амирбек надежда иванюк ольга волкова рано акбаева шынар шарапиденова щучинск""";
        Kazakh service = new Kazakh();

        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(service.transcribe(w, 0)).append(" ");
        }
        String result = sb.toString().trim();
        assertNotNull(sb);
        assertEquals(transcription, result);
    }
}
