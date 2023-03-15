package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Bulgarian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BulgarianTest {

    @Test
    void transcribe() {
        String text = """
                popadiyn serkan yusein čiži yanis karabelyov stefan nikolay krastev ventsislav kerchev stoycho uštya \
                nasko milev koshtû kostadinov petko daniel naumov tonislav yordanov angel lyaskov kaloyan krastev \
                antonio georgiev andrea hristov georgi yomov hristiyan vasilev lachezar hristo anatoli gospodinov \
                kristiyan yuliyan nikola iliev peshtera belyovo brakovtsi jonkovo zmeyovo milcho angelov minchev \
                orachev galabov aleksandar lyubenov borislav tsonev radoslav hristofor hubchev antonio vutov stoev \
                yanis karabelyov stefan nikolay lazar terziev tsvetelin chunchukov mihail mihaylov bozhidar kraev \
                ventsislav kerchev stoycho atanasov petar kristiyan katsarev dimitar velkovski nasko milev zhivko \
                hadzhiev krasimir vladimir semerdzhiev trayanov tasev yomov kristiyana dimitrova stoyanova stoycheva \
                zornitsa todorova yana yordanova maria dikelova bozhidara vanesa kristiana elena karakoleva \
                naydenova mayya yoanna stefanova ekaterina zheleva yanitsa aleksandra goranova nedret viktoriya \
                naydenova shopska aleksandra yaneva silviya viktoria gabriela naydenova beleva iliycheva palagacheva \
                silvia dzhaleva ekaterina roshchin roschin""";
        String transcription = """
                попадийн серкан юсейн чижи янис карабелев стефан николай крастев венцислав керчев стойчо уштя наско \
                милев коштю костадинов петко даниел наумов тонислав йорданов ангел лясков калоян крастев антонио \
                георгиев андреа христов георгий йомов християн василев лачезар христо анатолий господинов кристиян \
                юлиян никола илиев пештера белево браковци йонково змеево милчо ангелов минчев орачев галабов \
                александр любенов борислав цонев радослав христофор хубчев антонио вутов стоев янис карабелев стефан \
                николай лазар терзиев цветелин чунчуков михаил михайлов божидар краев венцислав керчев стойчо \
                атанасов петар кристиян кацарев димитар велковски наско милев живко хаджиев красимир владимир \
                семерджиев траянов тасев йомов кристияна димитрова стоянова стойчева зорница тодорова яна йорданова \
                мария дикелова божидара ванеса кристиана елена караколева найденова майя йоанна стефанова \
                екатерина желева яница александра горанова недрет виктория найденова шопска александра янева сильвия \
                виктория габриела найденова белева илийчева палагачева сильвия джалева екатерина рошчин росчин""";
        Bulgarian service = new Bulgarian();

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