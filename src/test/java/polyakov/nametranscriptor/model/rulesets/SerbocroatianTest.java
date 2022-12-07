package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SerbocroatianTest {

    @Test
    void transcribe() {
        String text = "Gojazni đačić s biciklom drži hmelj i finu vatu u džepu nošnje Ajšo, lepoto i čežnjo za " +
                "ljubav srca moga dođi u Hadžiće na kafu Nemanja Adja Jalja Ibenja Boja Evđa Vegđe điđo Đuđu Đođa " +
                "Gižo Žugda Deklinj Zezkolju Jeja Jije Joji Jujo Mokje Komji Lupjo Polju Ljalje Ljelja Ljiljo Ljolji " +
                "Ljulju Njanje Njenja Njinjo Njonji Njunju Nora Ranic Cučić Čufeč Ćohidž Džaftec Tihas Sudžu Djadje " +
                "Djedja Djidjo Djodji Djudju";
        String transcription = "Гоязни джячич с бициклом држи хмель и фину вату у джепу ношне Айшо, лепото и чежне " +
                "за любав срца мога доджи у Хаджиче на кафу Неманья Аджя Яля Ибеня Боя Эвджя Вегдже джидже Джюджю " +
                "Джеджя Гижо Жугда Деклинь Зезколю Ея Ие Йои Юйо Мокье Комьи Лупьо Полю Ляле Леля Лиле Лели Люлю " +
                "Няне Неня Нине Нени Нюню Нора Раниц Цучич Чуфеч Чохидж Джафтец Тихас Суджу Джядже Джеджя Джидже " +
                "Джеджи Джюджю";
        Serbocroatian service = new Serbocroatian();

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