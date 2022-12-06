package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MoldovanTest {

    @Test
    void transcribeName() {
        String text = "Bondarciuc Iaser Țurcan Ianoș Brînză Cebotari Priganiuc Mîrza Vdovcencov " +
                "Iourii Erhan Ciornîi Coceanovschi Ștefania Rotari Fiodor Iapără Șmalenea Musteaţă Serghei Tatiana " +
                "Peșterean Laşcencov Cojocari Calmațui Iliniuc Șumchin Scoarţă Coşciug Gînsari " +
                "Panteleiciuc Cucereavenco Japalău Reabciuk Oxana Dicusar Darenscaia Nichita Murovanîi Corneencov " +
                "Andronachi Repineţchii Nagornîi Cazacu Corneliu Țîbuleac Gurjui Ionuț Ciobanu Jupanova " +
                "Ciumacenco Ojehovschii Cucereavîi Evghenii Zămosteanu Jitariuc Victoria Vîctărău " +
                "Dijinari Andrei Macoviiciuc Anatolie Aurel Cătălin Constantin Dumitru Eugenia Eugeniu Eric Eduard " +
                "Edward Evgheni Evghenia Evghenii Ghenadie Gheorghe Ianina Iaroslav Iouri Igor Liviu Ludmila " +
                "Marcela Mihai Mihail Nadejda Natalia Nicolae Nicolai Olesea Olga Ruslan Semion Sergei Serghei " +
                "Serghey Sergiu Tatiana Valerii Valeriu Vasile Veaceslav Vitalii Vitaliy Cojocari";
        String transcription = "Бондарчук Ясер Цуркан Янош Брынзэ Чеботарь Приганюк Мырза Вдовченков " +
                "Юрий Ерхан Чорный Кочановский Штефания Ротарь Федор Япэрэ Шмаленя Мустяцэ Сергей Татьяна " +
                "Пештерян Лащенков Кожокарь Калмацуй Илинюк Шумкин Скоарцэ Кощуг Гынсарь Пантелейчук " +
                "Кучерявенко Жапалэу Рябчук Оксана Дикусар Даренская Никита Мурованый Корнеенков Андронаки " +
                "Репинецкий Нагорный Казаку Корнелиу Цыбуляк Гуржуй Йонуц Чобану Жупанова Чумаченко Ожеховский " +
                "Кучерявый Евгений Зэмостяну Житарюк Виктория Выктэрэу Дижинарь Андрей Маковийчук Анатолий " +
                "Аурел Кэтэлин Константин Думитру Эуджения Эуджениу Эрик Эдуард Эдвард Евгений Евгения Евгений " +
                "Геннадий Георге Янина Ярослав Юрий Игорь Ливиу Людмила Марчела Михай Михаил Надежда Наталия Николае " +
                "Николай Олеся Ольга Руслан Семен Сергей Сергей Сергей Серджу Татьяна Валерий Валериу Василе " +
                "Вячеслав Виталий Виталий Кожокарь";
        Moldovan service = new Moldovan();

        String result = service.transcribeText(text, 0);
        assertNotNull(result);
        assertEquals(transcription, result);
    }
}