package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RomanianTest {

    @Test
    void transcribe() {
        String text = "Ada Făcăeni Târgu Mureș Barbu Cezar Camil Mircea Chișinău Tecuci Cioran Ciurel Dan Eugen " +
                "Nicolae Ezeriș Băneasa Aref Geta Grigore Gong Caragea Borgia George Gheorghe Geoagiu Mihu " +
                "Irina Matei Botoșani Traian Demian Sofia Iernut Ploiești Miersig Ilie Cocorăștii Colț Viile " +
                "Întorsura Cîmpeni Cîineni Ion Ghiolț Iuda Porumboiu Iuliuș Ovidiu Cujmir Virgil Manole Nana Teofil " +
                "Petre Petru Sanda Izvoarele Șercaia Tatu Cheț Ury Victor Alexandru Hydro Zoe Înjurând " +
                "pițigăiat zoofobul comandă vexat whisky și tequila";
        String transcription = "Ада Фэкэени Тыргу Муреш Барбу Чезар Камил Мирча Кишинэу Текуч Чоран Чурел Дан " +
                "Эуджен Николае Езериш Бэняса Ареф Джета Григоре Гонг Караджа Борджа Джордже Георге Джоаджу " +
                "Миху Ирина Матей Ботошани Траян Демьян София Ернут Плоешти Мьерсиг Илие Кокорэштий Колц " +
                "Вийле Ынторсура Кымпени Кыйнени Йон Гьолц Юда Порумбою Юльюш Овидиу Кужмир Вирджил Маноле Нана " +
                "Теофил Петре Петру Санда Извоареле Шеркая Тату Кец Ури Виктор Александру Хидро Зое Ынжурынд " +
                "пицигэят зоофобул командэ вексат вхиски ши текуйла";
        Romanian service = new Romanian();

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