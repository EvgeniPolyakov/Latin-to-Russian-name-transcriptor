package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RussianTest {

    @Test
    void transcribe() {
        String text = """
                yuri schennikov borshchevoi keldysh shakhiya chechnya rodnya babayevski yagaylo aypetri yula yuretsky \
                uygurets rayonniy gor'ky yogurt zhokhina komsomol'skoye bokii tikhy pologiy igor olga iaroslav yuriev \
                kolomyts yulia zapotichnaya elvira ziyastinova sadzhaya shamsiddin shanbiev breytveyt \
                besserdechnaya tsvilikhovski fazyax chayandyar""";
        String transcription = """
                юрий щенников борщевой келдыш шахия чечня родня бабаевский ягайло айпетри юла юрецкий \
                уйгурец районный горький йогурт жохина комсомольское бокий тихий пологий игорь ольга ярослав юриев \
                коломыц юлия запотичная эльвира зиястинова саджая шамсиддин шанбиев брейтвейт \
                бессердечная цвилиховский фазякс чаяндяр""";
        Russian service = new Russian();

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