package polyakov.nametranscriptor.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArmenianTest {

    @Test
    void transcribe() {
        String text = """
                volodya samsonyan arman nersesyan arjanik ghubasaryan gevorg tarakhchyan sahradyan arsen galstyan \
                narek alaverdyan vahan sargsyan mirzoyan grenik petrosyan muradyan sergey mkrtchyan harutyun \
                melkonyan petros manukyan vahagn kolozyan grigoryan arman ghazaryan narek aghasaryan artak asatryan \
                zhirayr shaghoyan erik vardanyan derenik sargsyan davit nalbandyan mikhail muradyan grigorii \
                matevosian albert khachumyan nikolas melikian armen hovhannesyan erik azizyan vahan bichakhchyan \
                sadoyan geghamyan erik gharibyan gharibyan armen asilyan armen hovhannes harutyunyan karen melkonyan \
                petrosyan abraham portugalyan sargise hambardzumyan""";
        String transcription = """
                володя самсонян арман нерсесян арджаник губасарян геворг тарахчян сахрадян арсен галстян нарек \
                алавердян ваан саргсян мирзоян греник петросян мурадян сергей мкртчян арутюн мелконян петрос манукян \
                ваагн колозян григорян арман казарян нарек агасарян артак асатрян жирайр шагоян эрик варданян дереник \
                саргсян давид налбандян михаил мурадян григорий матевосян альберт хачумян николас меликян армен \
                оганесян эрик азизян ваан бичахчян садоян гегамян эрик гарибян гарибян армен асилян армен оганес \
                арутюнян карен мелконян петросян абраам португалян саркис амбарцумян""";
        Armenian service = new Armenian();

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