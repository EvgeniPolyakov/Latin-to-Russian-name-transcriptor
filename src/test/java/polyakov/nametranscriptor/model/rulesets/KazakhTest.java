package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class KazakhTest {

    @Test
    void transcribeName() {
        String text = "Alexandr Shirobokov Alisher Rakhimzhanov Arsen Azatov Askar Satyshev Vadim Yakovlev " +
                "Galymzhan Kenzhebek Danil Ankudinov Daniil Somov Daniyar Dulatov Daniyar Urda Dias Kushkumbayev " +
                "Yegor Tkachenko Zhannur Kukeyev Miras Amantayev Khalmatov Nikita Pivkin Roman Chirkov " +
                "Sultan Askarov Adilet Kuanysh Adil Janaidar Dobay Aibar Janaozen Alexandr Shirobokov " +
                "Alen Aimanov Arsen Azatov Baizhan Madelkhan Vladimir Biryukov Vladislav Butyrin Damir Kassabulat " +
                "Zhassulan Yerzhigit Kakhramon Khassanov Konstantin Puzanov Lev Kurgin Magzhan Baurzhan Nurgaini " +
                "Buribayev Tenizbay Abdurakhmanov Yuri Akhanov Aida Artykbay Aidana Kuztay Alexandra Burova Alina " +
                "Khassanova Alina Shalmukhanbetova Sailaubekkyzy Aruzhan Orazbekova Kubessova Assemgul Aruova " +
                "Bagully Gulim Kenzhetay Gulmira Tashmet Zhansaya Kopzhanova Leila Sadykova Burdakova Nazerke " +
                "Shalmukhanbetova Elvira Narbek Smagulova Zhautikova Serikbay Ainur Jabylbayeva " +
                "Aisha Sadykova Anastassiya Nizamutdinova Angelina Portnova Flyut Arailym Orynbassarova Assem " +
                "Zhaksymbay Ayazhan Akhmoldanova Yekaterina Yelisseyeva Kamila Akshalova Kundyz Kozhakhmet Amirbek " +
                "Nadezhda Ivanyuk Olga Volkova Rano Akbayeva Shynar Sharapidenova Schuchinsk";
        String transcription = "Александр Широбоков Алишер Рахимжанов Арсен Азатов Аскар Сатышев Вадим Яковлев " +
                "Галымжан Кенжебек Данил Анкудинов Даниил Сомов Данияр Дулатов Данияр Урда Диас Кушкумбаев Егор " +
                "Ткаченко Жаннур Кукеев Мирас Амантаев Халматов Никита Пивкин Роман Чирков Султан Аскаров " +
                "Адилет Куаныш Адиль Жанайдар Добай Айбар Жанаозен Александр Широбоков Ален Айманов Арсен " +
                "Азатов Байжан Маделхан Владимир Бирюков Владислав Бутырин Дамир Касабулат Жасулан Ержигит Кахрамон " +
                "Хасанов Константин Пузанов Лев Кургин Магжан Бауржан Нургайни Бурибаев Тенизбай Абдурахманов Юрий " +
                "Аханов Аида Артыкбай Айдана Кузтай Александра Бурова Алина Хасанова Алина Шалмуханбетова " +
                "Сайлаубеккызы Аружан Оразбекова Кубесова Асемгуль Аруова Багуллы Гулим Кенжетай Гульмира Ташмет " +
                "Жансая Копжанова Лейла Садыкова Бурдакова Назерке Шалмуханбетова Эльвира Нарбек Смагулова Жаутикова " +
                "Серикбай Айнур Жабылбаева Айша Садыкова Анастасия Низамутдинова Ангелина Портнова Флют Арайлым " +
                "Орынбасарова Асем Жаксымбай Аяжан Ахмолданова Екатерина Елисеева Камила Акшалова Кундыз Кожахмет " +
                "Амирбек Надежда Иванюк Ольга Волкова Рано Акбаева Шынар Шарапиденова Щучинск";
        Kazakh service = new Kazakh();

        String result = service.transcribe(text, 0);
        assertNotNull(result);
        assertEquals(transcription, result);
    }
}
