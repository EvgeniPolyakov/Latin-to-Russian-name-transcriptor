package polyakov.nametranscriptor.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GermanTest {

    @Test
    void transcribe() {
        String text = """
                barbara aachen maria borussia käthe dähre ärzen häusler aeschenbacher baedeker aichinger aystetten \
                bach clemens cilli erich charlotte chiemsee christian buchholz eichhorn hochhuth eichhorn achslach \
                weichselboden dick becker lembeck mickhausen glücksburg dolmar dhron andreas spree hofsee zschopau \
                weihenstephan erkner bauer eisenerzer alpen beier eulenberg meyrink heyda falkenberg grimm burgkmair \
                hörnle behling ehenfeld hohenlohe hamburg inn rainer diez biehla marienberg jade jehserig jöhstadt \
                jiedlitz bujendorf anjun niedernjesa oberjettingen kalksee landsberg wulf ellerbach böll tellkoppe \
                magdeburg nebel naumann oltes koopmann ohne öttinger köpenick ahrenviöl oetker oelze oie oybin zwickau \
                papststein joseph ephram quedlinburg regenberger starhemberg semper hans handelsblatt schiller \
                schtschedrin spiegel strausberg mutterstadt lessing grossringe vohenstrauss ludwigsstadt großbarkau \
                trude theo nationalzeitung tatschow marchwitza buckowitz netzsch tzscheetzsch nietzsche uhlberg ulm \
                überweg klützer uenze adenauer duisburg duingen volkmar wagner treptow axel xaver thyssen ryck zeidler""";
        String transcription = """
                барбара ахен мария боруссия кете дере эрцен хойслер эшенбахер бедекер айхингер айштеттен бах клеменс \
                цилли эрих шарлотта кимзе кристиан буххольц айххорн хоххут айххорн акслах вайксельбоден дик беккер \
                лембек микхаузен глюксбург дольмар дрон андреас шпре хофзе чопау вайхенштефан эркнер бауэр айзенерцер \
                альпен байер ойленберг майринк хайда фалькенберг гримм бургмайр хернле белинг ээнфельд хоэнлоэ гамбург \
                инн райнер диц била мариенберг яде езериг йештадт йидлиц буендорф аньюн нидерньеза оберьеттинген \
                калькзе ландсберг вульф эллербах белль теллькоппе магдебург небель науман ольтес копман оне эттингер \
                кепеник аренфиель эткер эльце ойе ойбин цвиккау папстштайн йозеф эфрам кведлинбург регенбергер \
                штаремберг земпер ханс хандельсблатт шиллер щедрин шпигель штраусберг муттерштадт лессинг гроссринге \
                фоэнштраусс людвигсштадт гросбаркау труде тео национальцайтунг тачов мархвитца букковиц неч чеч ницше \
                ульберг ульм ибервег клютцер инце аденауэр дуйсбург дуйнген фолькмар вагнер трептов аксель ксавер \
                тиссен рик цайдлер""";
        German service = new German();

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