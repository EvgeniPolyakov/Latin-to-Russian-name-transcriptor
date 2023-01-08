package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DutchTest {

    @Test
    void transcribe() {
        String text = """
                haasse aerstens aäron paauwe makaay aize aaigem israël blaeu baeyens aikema oekraïne auda brauwer \
                babberik arcen coolen accent acht schildpad jackijst jonckheere kerckhof berckx keienburg eeden zeeen \
                zeeegel deeëd reëer boib boïb taeit bouwer goug gouwg eeud leeuwarden eyskens eiskens eijskens \
                heiplaat heijplaat heyplaat euwe beunke bogaerdt beningha haasse beth ilp giekerk saskia ijssel gijsen \
                stedelijk ostaijen janhagelhoek mirjam tjetjerk joost tjonger joure junne anjum gorkum alfen buiskool \
                limburg notter coolen boeke boeicop hottois ooijer oudenbosch zutphen quedlenberg cruquius beesel \
                schildpad heesch bergschenhoek hertogenbosch sjoerd florensz tonsel ureterp buntinx burum bueckelaer \
                buizman veldhoven willem goebow hellouw axel amby gybeland van dyck hey zuidland berghuis kuyt sontje \
                hansen jana hoever manhoef dirk proper calvin raatsie mohamed tein troost steven van der sloot syb \
                van ottele joost de schutter braaf twan van der zeeuw tijs velthuis koen oostenbrink tijn daverveld \
                myron boadu thomas buitink fabian de keijzer lutsharel geertruida robin lathouwers kik pierie jasper \
                schendelaar ian smeulers van hoeven baijings leuchter kirsten van de westeringh lotte van veldhoven \
                lieske carleer gwyneth hendriks lotte jansen dinkla naomi hilhorst sarah jongbloed julia kagie \
                nienhuis ravensbergen nikita tromp jonna van de velde roos van der veen van diemen isa van eester \
                moisa van koot sterre kroezen wieke kaptein fieke kroese roos van eijk tolhoek melissa schilder \
                rutgers sanne peereboom bo anna op de weegh femke liefting lotte keukelaar isa kardinaal hanna \
                huizenga emma frijns quinty dupon""";
        String transcription = """
                хассе арстенс аарон пауэ макай айзе айгем исраэл блау байенс айкема украине ауда брауэр бабберик арсен \
                колен аксент ахт схилдпад яккейст йонкхере керкхоф беркс кейенбюрг эден зеен зеегел деед реер бойб \
                боиб тайт бауэр гауг гауг эуд леуварден эйскенс эйскенс эйскенс хейплат хейплат хейплат эйве бенке \
                богардт бенинга хассе бет илп гикерк саския эйссел гейсен стеделейк остайен янхагелхук мирьям тьетьерк \
                йост тьонгер яуре юнне аньюм горкюм алфен бейскол лимбюрг ноттер колен буке буйкоп хоттойс ойер \
                ауденбос зютфен кведленберг крюквиус бесел схилдпад хес бергсенхук хертогенбос шурд флоренс тонсел \
                уретерп бюнтинкс бюрюм бейккелар бейзман велдховен виллем губо хеллау аксел амби гибеланд ван дейк \
                хей зейдланд бергейс кейт сонтье хансен яна хувер манхуф дирк пропер калвин ратси мохамед тейн \
                трост стевен ван дер слот сиб ван оттеле йост де схюттер браф тван ван дер зеу тейс велтхейс кун \
                остенбринк тейн давервелд мирон боадю тхомас бейтинк фабиян де кейзер лютсхарел гертрейда робин \
                латхауэрс кик пири яспер сенделар иян смелерс ван хувен байингс лехтер кирстен ван де вестеринг лотте \
                ван велдховен лиске карлер гвинет хендрикс лотте янсен динкла наоми хилхорст сара йонгблуд юлия каги \
                нинхейс равенсберген никита тромп йонна ван де велде рос ван дер вен ван димен иса ван эстер мойса ван \
                кот стерре крузен вике каптейн фике крусе рос ван эйк толхук мелисса схилдер рютгерс санне перебом бо \
                анна оп де вег фемке лифтинг лотте кекелар иса кардинал ханна хейзенга эмма фрейнс квинти дюпон""";
        Dutch service = new Dutch();

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