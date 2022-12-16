package polyakov.nametranscriptor.rulesets.rulesets;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.rulesets.Turkish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TurkishTest {

    @Test
    void transcribe() {
        String text = """
                eyyub yayla konya ünye yiğit akyiğit yıldırım akyıldız karadayı yozgat bayortaç yörük yunus niğde \
                divriği bozdoğan muğla ığdır hakkâri elâzığ bolat hasan ali kaldırım ömer bayram okay yokuşlu \
                çalhanoğlu kaan ayhan ozan tufan enes ünal deniz türüç zeki çelik merih demiral berkay özcan uğurcan \
                çakır güven yalçın emre kılınç mert müldür yusuf yazıcı umut meraş ozan kabak altay bayındır ahmed \
                kutucu mert çetin arzu karabulut yağmur uraz fatma şahin ezgi çağlar didem karagenç yaşam göksu hız \
                emine ecem esen ebru topçu berna yeniçeri ilayda civelek derya arhan ece türkoğlu sadıkoğlu ipek \
                kaya sedanur incik ırem eren melike öztürk gamze yaman elif keskin büşra kuru dilan yeşim taşkin \
                cansu nur pijamalı hasta yağız şoföre çabucak güvendi""";
        String transcription = """
                эйюб яйла конья унье йигит акйигит йылдырым акйылдыз карадайы йозгат байортач йорюк юнус нигде дивриги \
                боздоган мугла ыгдыр хаккяри элязыг болат хасан али калдырым омер байрам окай йокушлу чалханоглу \
                каан айхан озан туфан энес унал дениз тюрюч зеки челик мерих демирал беркай озджан угурджан чакыр \
                гювен ялчын эмре кылынч мерт мюлдюр юсуф языджы умут мераш озан кабак алтай байындыр ахмед кутуджу \
                мерт четин арзу карабулут ягмур ураз фатма шахин эзги чаглар дидем карагенч яшам гексу хыз эмине \
                эджем эсен эбру топчу берна еничери илайда дживелек дерья архан эдже тюркоглу садыкоглу ипек кая \
                седанур инджик ырем эрен мелике озтюрк гамзе яман элиф кескин бюшра куру дилан ешим ташкин джансу \
                нур пижамалы хаста ягыз шофере чабуджак гювенди""";
        Turkish service = new Turkish();

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