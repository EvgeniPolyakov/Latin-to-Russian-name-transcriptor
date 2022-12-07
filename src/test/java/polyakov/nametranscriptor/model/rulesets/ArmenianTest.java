package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArmenianTest {

    @Test
    void transcribe() {
        String text = "Volodya Samsonyan Arman Nersesyan Arjanik Ghubasaryan Gevorg Tarakhchyan Sahradyan " +
                "Arsen Galstyan Narek Alaverdyan Vahan Sargsyan Mirzoyan Grenik Petrosyan Muradyan " +
                "Sergey Mkrtchyan Harutyun Melkonyan Petros Manukyan Vahagn Kolozyan Narek Grigoryan Arman Ghazaryan " +
                "Narek Aghasaryan Artak Asatryan Zhirayr Shaghoyan Erik Vardanyan Derenik Sargsyan Davit Nalbandyan " +
                "Mikhail Muradyan Grigorii Matevosian Albert Khachumyan Nikolas Melikian Armen Hovhannesyan Erik " +
                "Azizyan Vahan Bichakhchyan Sadoyan Geghamyan Erik Gharibyan Gharibyan Armen Asilyan Armen " +
                "Hovhannes Harutyunyan Karen Melkonyan Petrosyan Abraham Portugalyan Sargise Hambardzumyan";
        String transcription = "Володя Самсонян Арман Нерсесян Арджаник Губасарян Геворг Тарахчян Сахрадян " +
                "Арсен Галстян Нарек Алавердян Ваан Саргсян Мирзоян Греник Петросян Мурадян Сергей " +
                "Мкртчян Арутюн Мелконян Петрос Манукян Ваагн Колозян Нарек Григорян Арман Казарян Нарек Агасарян " +
                "Артак Асатрян Жирайр Шагоян Эрик Варданян Дереник Саргсян Давид Налбандян Михаил Мурадян Григорий " +
                "Матевосян Альберт Хачумян Николас Меликян Армен Оганесян Эрик Азизян Ваан Бичахчян Садоян Гегамян " +
                "Эрик Гарибян Гарибян Армен Асилян Армен Оганес Арутюнян Карен Мелконян Петросян Абраам Португалян " +
                "Саркис Амбарцумян";
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