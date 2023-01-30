package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AzeriTest {

    @Test
    void transcribe() {
        String text = """
                adam topalov eshgin ahmadov fakhri mammadli hamzaali mikayilov ibrahim aghayarov farzullayev maksud \
                dursunov mammad muradov murad alakbarov mammadov musayev musa nakhid ravil gafarov rufat abbasov \
                badalzade sadig shafiyev samir aghayev sanan aghalarov shahin shahniyarov ayhan arazli elmaddin \
                sultanov elnur ibragimov ismayil zulfugarli javidan rahimli jeyhun nuriyev khayal muradov mahammad \
                maharramov mahir hasanov ulvi gurbanli nijat abdullazade sabuhi abdullazade samir gurbanov sarjan \
                omarov turan valizada veysal rzayev vusal asgarov zamig aliyev alina aysun muradova aytaj feyzullayeva \
                fatima ahmadli hüseyn zahir jafarova lamia alizada leyla aghayeva milana rahimova nahida nurchin \
                tarverdizada parvin safaraliyeva samira ashırova turkan abdullayeva zuleykha zamanlı arzu aliyeva \
                aygun gurbanzade diana mammadova esra manya firangiz teymurova gultaj mammadaliyeva gunay mikayıl \
                bakarandze leyli gurbanova mana mollayeva narmin ismayilova nigar abdulova roza guliyeva vusala \
                hajiyeva elchin vugar emil elshan ramil elvin namik huseyn javid azer elkhan elshad ilgar kamil \
                arif azar eldaniz fazil kanan mehman mubariz rasim shahriyar vasif agil agshin araz eldar elman \
                gulnara ilham narmina nasimi seymur tofig adil aysel dilara dzhavid elehin elmar elmir elnara etikar \
                eyvaz faik farida fariz firuza ilkin kamal kamran khalig parvana parviz rafael rahid rahman rizvan \
                ruhid samad seyran talekh vafadar yasin zhala""";
        String transcription = """
                адам топалов эшгин ахмедов фахри мамедли хамзаали микаилов ибрахим агаяров фарзуллаев максуд дурсунов \
                мамед мурадов мурад алекперов мамедов мусаев муса нахид равиль гафаров руфат аббасов бадалзаде садиг \
                шафиев самир агаев санан агаларов шахин шахнияров айхан аразли эльмаддин султанов эльнур ибрагимов \
                исмаил зулфугарли джавидан рахимли джейхун нуриев хаял мурадов магомед махаррамов махир гасанов ульви \
                гурбанли ниджат абдуллазаде сабухи абдуллазаде самир гурбанов сарджан омаров туран вализаде вейсал \
                рзаев вусал аскеров замиг алиев алина айсун мурадова айтадж фейзуллаева фатима ахмедли гусейн захир \
                джафарова ламия ализаде лейла агаева милана рахимова нахида нурчин тарвердизаде парвин сафаралиева \
                самира ашырова туркан абдуллаева зулейха заманлы арзу алиева айгун гурбанзаде диана мамедова эсра \
                манья фирангиз теймурова гюльтадж мамедалиева гунай микаил бакарандзе лейли гурбанова мана моллаева \
                нармин исмайлова нигяр абдулова роза гулиева вусала хаджиева эльчин вугар эмиль эльшан рамиль эльвин \
                намик гусейн джавид азер эльхан эльшад ильгар камиль ариф азар эльданиз фазиль кянан мехман мубариз \
                расим шахрияр васиф агиль агшин араз эльдар эльман гюльнара ильхам нармина насими сеймур тофик адиль \
                айсель диляра джавид элехин эльмар эльмир эльнара этикар эйваз фаик фарида фариз фируза илькин кямал \
                кямран халиг парвана парвиз рафаэль рахид рахман ризван рухид самад сейран талех вафадар ясин жаля""";
        Azeri service = new Azeri();

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