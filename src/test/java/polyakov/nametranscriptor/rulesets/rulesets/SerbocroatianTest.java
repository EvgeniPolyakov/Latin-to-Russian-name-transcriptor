package polyakov.nametranscriptor.rulesets.rulesets;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.rulesets.Serbian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SerbocroatianTest {

    @Test
    void transcribe() {
        String text = """
                gojazni đačić s biciklom drži hmelj i finu vatu u džepu nošnje ajšo, lepoto i čežnjo za ljubav srca \
                moga dođi u hadžiće na kafu nemanja adja jalja ibenja boja evđa vegđe điđo đuđu đođa gižo žugda \
                deklinj zezkolju jeja jije joji jujo mokje komji lupjo polju ljalje ljelja ljiljo ljolji ljulju \
                njanje njenja njinjo njonji njunju nora ranic cučić čufeč ćohidž džaftec tihas sudžu djadje djedja \
                djidjo djodji djudju""";
        String transcription = """
                гоязни джячич с бициклом држи хмель и фину вату у джепу ношне айшо, лепото и чежне за любав срца \
                мога доджи у хаджиче на кафу неманья аджя яля ибеня боя эвджя вегдже джидже джюджю джеджя гижо жугда \
                деклинь зезколю ея ие йои юйо мокье комьи лупьо полю ляле леля лиле лели люлю \
                няне неня нине нени нюню нора раниц цучич чуфеч чохидж джафтец тихас суджу джядже джеджя \
                джидже джеджи джюджю""";
        Serbian service = new Serbian();

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