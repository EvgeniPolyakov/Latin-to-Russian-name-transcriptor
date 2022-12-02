package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GeorgianTest {

    @Test
    void transcribeName() {
        String text = "Ernest Akhalbedashvili Elguja Lobjanidze Jangveladze Sadjaia Shota Shalva " +
                "Ogbaidze Tsotne Patsatsia Tsira Tsetskhladze Khvicha Shubitidze Tornike Dzotsenidze Jimsheleishvili " +
                "Aptsiauri Tsalughelashvili Teimuraz Mjavanadze Davitashvili Tchigvaria Iashvili Tsinamdzgvrishvili " +
                "Tsatskrialashvili Mtchedlishvili Tskhomaria Lobzhanidze Basheleishvili Vazisubani Chokhatauri " +
                "Ochamchira Akhalkalaki Gurjaani Mtisdziri Javakheti Tskhenistsqali Mtisdziri Uplistsikhe";
        String transcription = "Эрнест Ахалбедашвили Элгуджа Лобжанидзе Джангвеладзе Саджая Шота " +
                "Шалва Огбаидзе Цотне Пацация Цира Цецхладзе Хвича Шубитидзе Торнике Дзоценидзе Джимшелеишвили " +
                "Апциаури Цалугелашвили Теймураз Мжаванадзе Давиташвили Чигвария Иашвили Цинамдзгвришвили " +
                "Цацкриалашвили Мчедлишвили Цхомария Лобжанидзе Башелеишвили Вазисубани Чохатаури Очамчира Ахалкалаки " +
                "Гурджаани Мтисдзири Джавахети Цхенисцкали Мтисдзири Уплисцихе";
        Georgian service = new Georgian();

        String result = service.transcribeText(text);
        assertNotNull(result);
        assertEquals(transcription, result);
    }
}