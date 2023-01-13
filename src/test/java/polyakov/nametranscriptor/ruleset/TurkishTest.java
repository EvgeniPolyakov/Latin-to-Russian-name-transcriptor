package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TurkishTest {

    @Test
    void transcribe() {
        String text = """
                abdussamed karnuçu atakan akyol atalay babacan batuhan özdemir bekir gökçimen berkay görmez berke özer \
                doğucan haspolat enes i̇lkin ercan şirin hasan adıgüzel kerem kesgin malik karaahmet mehmet üzümcü \
                muhammet can tuncer mutlu aksu dogan onur taha takir abdullah doğan bahadir çiloğlu birhan vatansever \
                emirhan aydoğan emre mor enes ünal ertuğrul ersoy furkan ünver hayrullah alıcı mehmet karadağ karakoç \
                okan çelik sabit yılmaz savaş polat tarık çetin übeyd adıyaman uğur tezel zeki zübeyir kaya aleyna \
                gültekin berivan içen cansu gürel didem dülber ebru şahin ece tekmen elanur düz elif keskin ezgi otlu \
                kevser gündoğdu leyla ilter mesude alayont mine okaytu nilay güreler özge tosun rabiya isgi sadakat \
                nazlı saygılı selin türkoğlu susanne firat sude nur sözüdoğru tülay ateş ayça tekmen aylin dişli ayşe \
                taslak ayşenur büyükçiğer bahar güvenç damla bozyel dilara arslan fadime kurnaz funda payan gülbahar \
                hilal çetinkaya i̇layda civelek pelin tekneci dişli sivrikaya serra çağan şevval alpavut zeynep erdoğan \
                tülay ateş eyyub yayla konya ünye yiğit akyiğit yıldırım akyıldız karadayı yozgat bayortaç yörük yunus \
                niğde divriği bozdoğan elazığ muğla iğdır hakkâri elâzığ""";
        String transcription = """
                абдуссамед карнучу атакан акьол аталай бабаджан батухан оздемир бекир гекчимен беркай гермез берке \
                озер догуджан хасполат энес и̇лкин эрджан ширин хасан адыгюзел керем кесгин малик караахмет мехмет \
                узюмджю мухаммет джан тунджер мутлу аксу доган онур таха такир абдуллах доган бахадир чилоглу бирхан \
                ватансевер эмирхан айдоган эмре мор энес унал эртугрул эрсой фуркан унвер хайруллах алыджы мехмет \
                карадаг каракоч окан челик сабит йылмаз саваш полат тарык четин убейд адыяман угур тезел зеки зюбейир \
                кая алейна гюлтекин бериван ичен джансу гюрел дидем дюлбер эбру шахин эдже текмен эланур дюз элиф \
                кескин эзги отлу кевсер гюндогду лейла илтер месуде алайонт мине окайту нилай гюрелер озге тосун \
                рабия исги садакат назлы сайгылы селин тюркоглу сусанне фират суде нур сезюдогру тюлай атеш айча \
                текмен айлин дишли айше таслак айшенур буюкчигер бахар гювенч дамла бозьел дилара арслан фадиме \
                курназ фунда паян гюлбахар хилал четинкая и̇лайда дживелек пелин текнеджи дишли сиврикая серра чаган \
                шеввал алпавут зейнеп эрдоган тюлай атеш эйюб яйла конья унье йигит акйигит йылдырым акйылдыз карадайы \
                йозгат байортач йорюк юнус нигде дивриги боздоган элазыг мугла игдыр хаккяри элязыг""";
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