package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GreekTest {

    @Test
    void transcribeName() {
        String text = "Istiaia Vaios Karyai Kameni Yerakini Yides Pyrgi Giannitsa Achilleas Alkaios Emilios " +
                "Vagionia Panagiouda Zagliveri Gkana Anchialos Karditsa Krieza Nea Psara Richea " +
                "Evdokia Evvoikos Achaia Tria Kalymnos Mpampis Papaioannou Tsalouchidis Lyratzis Giakoumakis " +
                "Xanthi Veria Smolikas Kazantzakis Tsatsos Chalkida Onassis Tsiartas Chatzigiannidou Stogiannis " +
                "Ieroklis Georgogiannis Papagiannakis Georgios Konstantinos Ioannis Nikolaos Dimitrios Christos " +
                "Vasilios Panagiotis Antonios Athanasios Apostolos Alexandros Dimitris Anastasios Theodoros Nikos " +
                "Evangelos Andreas Ilias Kostas Emmanouil Vasilis Michail Petros Giannis Maria Stavros Angelos " +
                "Pavlos Spiridon Stefanos Stelios Takis Thomas Eleni Stylianos Vasileios Panayotis Pantelis " +
                "Charalambos Kiriakos Loukas Michalis Sotirios Thanasis Aristidis Asterios Charalampos Elias Fotios " +
                "Giorgios Grigorios Grigoris Lakis Mimis Nicolaos Periklis Sotiris Spyridon Tasos Vassilios Alexios " +
                "Anastasia Dionisios Efstratios Efthymios Eleftherios Kyriaki Lazaros Leonidas Mihail Mihalis Minas " +
                "Paraskevas Savas Sofia Sokratis Theocharis Theofanis Vangelis Vassiliki Zafiris Achileas Andreas";
        String transcription = "Истиея Вейос Карье Камени Еракини Йидес Пирьи Янница Ахиллеас Алкейос Эмилиос " +
                "Вайония Панаюда Загливери Гана Анхиалос Кардица Криеза Неа Псара Рихея Эвдокия " +
                "Эввоикос Ахея Триа Калимнос Бамбис Папаиоанну Цалухидис Лирадзис Якумакис Ксанти Верия Змоликас " +
                "Казандзакис Цацос Халкида Онассис Циартас Хадзиянниду Стояннис Иероклис Георгояннис Папаяннакис Йоргос " +
                "Константинос Яннис Николаос Димитриос Христос Василиос Панайотис Антониос Атанасиос Апостолос " +
                "Александрос Димитрис Анастасиос Теодорос Никос Эвангелос Андреас Илиас Костас Эммануил Василис " +
                "Михаил Петрос Яннис Мария Ставрос Ангелос Павлос Спиридон Стефанос Стелиос Такис Томас Элени " +
                "Стилианос Василиос Панайотис Пантелис Хараламбос Кириакос Лукас Михалис Сотириос Танасис Аристидис " +
                "Астериос Хараламбос Элиас Фотиос Йоргос Григориос Григорис Лакис Мимис Николаос Периклис Сотирис " +
                "Спиридон Тасос Вассилиос Алексиос Анастасия Дионисиос Эфстратиос Эфтимиос Элефтериос Кириаки " +
                "Лазарос Леонидас Михаил Михалис Минас Параскевас Савас София Сократис Теохарис Теофанис " +
                "Вангелис Вассилики Зафирис Ахилеас Андреас";
        Greek service = new Greek();

        String result = service.transcribeText(text, 0);
        assertNotNull(result);
        assertEquals(transcription, result);
    }
}