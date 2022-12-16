package polyakov.nametranscriptor.rulesets.rulesets;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.rulesets.Ukrainian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UkrainianTest {

    @Test
    void transcribe() {
        String text = """
                alushta andrii borshchahivka borysenko vinnytsia volodymyr bohdan zghurskyi galagan gorgany donetsk \
                dmytro rivne oleh yenakiieve haievych zhytomyr zhanna zhezheliv zakarpattia kazymyrchuk medvyn \
                mykhailenko ivankiv ivashchenko yizhakevych yosypivka stryi oleksii kyiv kovalenko lebedyn leonid \
                marynych nizhyn nataliia odesa onyshchenko poltava petro reshetylivka rybchynskyi sumy solomiia \
                ternopil trots uliana fastiv filipchuk kharkiv khrystyna bila tserkva stetsenko chernivtsi shevchenko \
                shostka kyshenky shcherbukhy hoshcha harashchenko yurii koriukivka yahotyn yaroshenko kostiantyn \
                znamianka feodosiia""";
        String transcription = """
                алушта андрий борщагивка борисенко винниця владимир богдан згурский галаган горгани донецк дмитрий \
                ривне олег енакиеве гаевич житомир жанна жежелив закарпаття казимирчук медвин михайленко иванкив \
                иващенко ижакевич йосипивка стрий алексей кийв коваленко лебедин леонид маринич нижин наталия одеса \
                онищенко полтава петр решетиливка рибчинский суми соломия тернопил троц уляна фастив филипчук харкив \
                христина била церква стеценко чернивци шевченко шостка кишенки щербухи гоща гаращенко юрий корюкивка \
                яготин ярошенко константин знамянка феодосия""";
        Ukrainian service = new Ukrainian();

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