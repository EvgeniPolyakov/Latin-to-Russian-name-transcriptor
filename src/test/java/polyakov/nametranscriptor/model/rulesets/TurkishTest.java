package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TurkishTest {

    @Test
    void transcribeName() {
        String text = "Eyyub Yayla Konya Ünye Yiğit Akyiğit Yıldırım Akyıldız Karadayı Yozgat Bayortaç " +
                "Yörük Yunus Niğde Divriği Bozdoğan Muğla Iğdır Hakkâri Elâzığ Bolat Hasan Ali Kaldırım Ömer Bayram " +
                "Okay Yokuşlu Çalhanoğlu Kaan Ayhan Ozan Tufan Enes Ünal Deniz Türüç Zeki Çelik Merih Demiral Berkay " +
                "Özcan Uğurcan Çakır Güven Yalçın Emre Kılınç Mert Müldür Yusuf Yazıcı Umut Meraş Ozan Kabak Altay " +
                "Bayındır Ahmed Kutucu Mert Çetin Arzu Karabulut Yağmur Uraz Fatma Şahin Ezgi Çağlar Didem Karagenç " +
                "Yaşam Göksu Hız Emine Ecem Esen Ebru Topçu Berna Yeniçeri İlayda Civelek Derya Arhan Ece " +
                "Türkoğlu Sadıkoğlu İpek Kaya Sedanur İncik Irem Eren Melike Öztürk Gamze Yaman Elif Keskin " +
                "Büşra Kuru Dilan Yeşim Taşkin Cansu Nur Pijamalı hasta yağız şoföre çabucak güvendi";
        String transcription = "Эйюб Яйла Конья Унье Йигит Акйигит Йылдырым Акйылдыз Карадайы Йозгат " +
                "Байортач Йорюк Юнус Нигде Дивриги Боздоган Мугла Ыгдыр Хаккяри Элязыг Болат Хасан Али Калдырым " +
                "Омер Байрам Окай Йокушлу Чалханоглу Каан Айхан Озан Туфан Энес Унал Дениз Тюрюч Зеки Челик Мерих " +
                "Демирал Беркай Озджан Угурджан Чакыр Гювен Ялчын Эмре Кылынч Мерт Мюлдюр Юсуф Языджы Умут Мераш Озан " +
                "Кабак Алтай Байындыр Ахмед Кутуджу Мерт Четин Арзу Карабулут Ягмур Ураз Фатма Шахин Эзги Чаглар Дидем " +
                "Карагенч Яшам Гексу Хыз Эмине Эджем Эсен Эбру Топчу Берна Еничери Илайда Дживелек Дерья Архан " +
                "Эдже Тюркоглу Садыкоглу Ипек Кая Седанур Инджик Ырем Эрен Мелике Озтюрк Гамзе Яман Элиф " +
                "Кескин Бюшра Куру Дилан Ешим Ташкин Джансу Нур Пижамалы хаста ягыз шофере чабуджак гювенди";
        Turkish service = new Turkish();

        String result = service.transcribeText(text, 0);
        assertNotNull(result);
        assertEquals(transcription, result);
    }
}