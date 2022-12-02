package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RussianTest {

    @Test
    void transcribeName() {
        String text = "AabBdD eEfF gGiI Kk hHlL MmNnoOpP RrSstTuU vVyYxXzZ Schennikov Borshchevoi Keldysh Shakhiya " +
                "Chechnya rodnya Babayevski Yagaylo Aypetri yula Yuretsky Uygurets rayonniy Gor'ky yogurt Zhokhina " +
                "Komsomol'skoye Bokii tikhy pologiy igor Olga Iaroslav Yuriev Yuri Kolomyts Yulia Zapotichnaya " +
                "Elvira Ziyastinova Sadzhaya Shamsiddin Shanbiev Breytveyt Besserdechnaya Tsvilikhovski Fazyax";
        String transcription = "АабБдД эЕфФ гГиИ Кк хХлЛ МмНноОпП РрСстТуУ вВыЙксКсзЗ Щенников Борщевой Келдыш Шахия " +
                "Чечня родня Бабаевский Ягайло Айпетри юла Юрецкий Уйгурец районный Горький йогурт Жохина " +
                "Комсомольское Бокий тихий пологий Игорь Ольга Ярослав Юриев Юрий Коломыц Юлия Запотичная Эльвира " +
                "Зиястинова Саджая Шамсиддин Шанбиев Брейтвейт Бессердечная Цвилиховский Фазякс";
        Russian service = new Russian();

        String result = service.transcribeText(text);
        assertNotNull(result);
        assertEquals(transcription, result);
    }
}