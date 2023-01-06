package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EstonianTest {

    @Test
    void transcribe() {
        String text = """
                assamalla vabriku kodila hiiemetsa venevere laeva esna eeriku mustvee filmi koonga hargla tihemetsa \
                keila pöide siim kaija jensen heljo joa juminda järva jaani jördi jõgeva kokora rakke lille paldiski \
                meremäe kõnnu oonurme kaansoo parapalu kapp soela mõisaküla õismäe võru jõõpre lõõdla äriküla märjamaa \
                ääsmäe metsaääre otepää sääre ördi möldri ööbiku söödi ühtri rüütel küüni üüdibe šahti zalesje zoo \
                maneeži zaretšje selištše wõrk saxby aaspere tabivere vändra fosfori lagedi lihula pirita iisaku \
                jakobson vajangu pojengi ajo joosu pajusti kuivajõe jõõpre jägala veskijärve jäärja jääger jöödri \
                jöörandi jüriküla jürsi jüüsiku ahja kärje kaljuste mustjala kolk kont rägavere erra sauga nissi nursi \
                kose lüganuse küttejõu jõesuu vaivara süvahavva õngu pärnu jõelähtme äksi ärina päärn jõeäär äärma \
                pöide möldre pöörna jüriöö ööbiku sürgavere ülemiste küüni üüdibe""";
        String transcription = """
                асамалла вабрику кодила хийеметса веневере лаэва эсна ээрику муствеэ филми коонга харгла тихеметса \
                кейла пейде сийм кайя енсен хельо йоа юминда ярва яани йерди йыгева кокора ракке лилле палдиски \
                меремяэ кынну оонурме каансоо парапалу капп соэла мыйзакюла ыйсмяэ выру йыыпре лыыдла эрикюла мярьямаа \
                ээсмяэ метсаээре отепя сяэре эрди мелдри ээбику сеэди юхтри рюйтель кюйни юйдибе шахти залесье зоо \
                манеэжи заречье селище вырк саксбю ааспере табивере вяндра фосфори лагеди лихула пирита ийзаку якобсон \
                ваянгу поенги айо йоозу паюсти куйвайыэ йыыпре ягала вескиярве яэрья яэгер йеэдри йеэранди юрикюла \
                юрси юйзику ахья кярье кальюсте мустьяла колк конт рягавере эрра сауга ниси нурси козе люганузе \
                кюттейыу йыэсуу вайвара сювахавва ынгу пярну йыэляхтме экси эрина пяэрн йыэяэр ээрма пейде мелдре \
                пеэрна юриеэ ээбику сюргавере юлемисте кюйни юйдибе""";
        Estonian service = new Estonian();

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