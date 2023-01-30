package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LatvianTest {

    @Test
    void transcribe() {
        String text = """
                pļaviņas auce stučka ērgļi alkezers špoģi jānis talsi laima ozoli livani kalnciems rūjiena jaunķemeri \
                murjāņi vjazgini jēkabpils naujene vecjērcēni jikteri kalnaji skabji josti majori jūrmala vecjūdaži \
                dīķmalas ģoķis aļķis cepļupe buļļezers ļauļēni buļļuciems kalniņš pļaviņas puņņi mežotne ķoņi oviši \
                dundaga ļūbaste spaļupe džūkste jevgenijs jevgeņijs jevgēnijs jevgēņijs vjačeslavs""";
        String transcription = """
                плявиняс ауце стучка эргли алкэзерс шпоги янис талси лайма озолы ливаны калнциемс руйиена яункемери \
                мурьяни вьязгины екабпилс науене вецьерцены йиктери калнайи скабьи йости майори юрмала вецьюдажи \
                дикьмалас гекис алькис цепльупе булльэзерс ляулены буллюциемс калныньш плявиняс пунни межотне кени \
                овиши дундага любасте спальупе джуксте евгений евгений евгений евгений вячеслав""";
        Latvian service = new Latvian();

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