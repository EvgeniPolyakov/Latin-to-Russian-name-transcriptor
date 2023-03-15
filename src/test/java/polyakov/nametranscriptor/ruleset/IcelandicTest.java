package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Icelandic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IcelandicTest {

    @Test
    void transcribe() {
        String text = """
                akranes anna langanes laufey sauðárkrókur auður páll barði drangey böðvar helgi dyrhólaey edda engey \
                drangey andrés friðrik hafstein ólafur ingólfur ólöf keflavík hrafn höfn álftafjörður garðar gisli \
                egill skagi finnbogi skipalægi ófeigsfjörður guðrún guðmundur hákon hrólfur hjálmar thoroddsen \
                thorsteinsson indriði einar ívar jón fljótshlíð jakob eyjar hjalti friðþjófur björn kári kiddi \
                eiríksson benedikt pálína laufey aðalbjörg blöndal hallgrímur eyjafjallajökull halldór ella elli \
                margrét nanna þorsteinn brjánn oddur lóa pétur skipseyri ragnar árni arnarnes bjarni örn örlygur \
                snorri rósa trausti gunnar þuriður unnur tungumúli magnús faxaflói bryndís akureyri eysteinn signý \
                zoega þórbergur öræfi ægir sölvi höfn göngu hrólfur""";
        String transcription = """
                акранес анна лаунганес лейвей сейдауркроукюр эйдюр паудль барди драунгей бедвар хельги дирхоулаэй эдда \
                эйнгей драунгей андрьес фридрик хафстейн оулавюр ингоульвюр оулев кеблавик храбн хебн аультафьордюр \
                гардар гисли эйидль скайи финнбойи скипалайи оувейхсфьордюр гвюдрун гвюдмюндюр хаукон хроульвюр \
                хьяульмар тороддсен торстейнссон индриди эйнар ивар йоун фльоутсхлид якоб эйяр хьяльти фридтьоувюр \
                бьодн каури кидди эйрихссон бенедихт паулина лейвей адальбьорг блендаль хадльгримюр эйяфьядлаекюдль \
                халльдоур элла элли маргрьет нанна торстейдн брьяудн оддюр лоуа пьетюр скифсейри рагнар аудни аднаднес \
                бьядни эдн эдлигюр снорри роуса трейсти гюннар тюридюр уннюр тунгюмули магнус фахсафлоуи бриндис \
                акюрейри эйстейдн сигни соэга тоурбергюр эрайви айир сельви хебн гейнгю хроульвюр""";
        Icelandic service = new Icelandic();

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