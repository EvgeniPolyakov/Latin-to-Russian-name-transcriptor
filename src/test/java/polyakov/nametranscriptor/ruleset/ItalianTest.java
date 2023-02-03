package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ItalianTest {

    @Test
    void transcribe() {
        String text = """
                ancona anna bologna modigliani bari corriere cesare nabucco lecce zecchi boccaccio gucci cherubini \
                chianti chirico lucia ciociaria domodossola davide palermo raffaele enrico forli filippo guttuso \
                germanetto messaggero lamborghini agira golgi guardi guarneri guido giulio giorgione borgia chioggia \
                fogli modigliani oglio agnana hotel iriarte luigi catena dei lagorai perreira goito sergio baiardo \
                iacurso giustizia ceriale adriano moravia arischia bianca iesolo chievo daniele unie tiepolo pompeii \
                iolanda oriolo iudrio eustachio verrocchio piozzi iudrio marrubiu fiumicino chiusi friuli jacuzzi \
                jannacci jerzu joppolo jolanda di savoia juventus kappa labriola malpighi follonica reggio nell emilia \
                monza maria oristano palermo paolo aquara quasimodo rimini rita savona sdobba paese besnate scesta \
                bosco schio scherzo scisciano sciascia treviso tomaso umberto chiusi venezia vito artabax venezia \
                potenza zampano zacconi bozzole san nazzaro mezzogoro bataglia soghia oggi pagliuca oieiaiaie""";
        String transcription = """
                анкона анна болонья модильяни бари коррьере чезаре набукко лечче дзекки боккаччо гуччи керубини кьянти \
                кирико лючия чочария домодоссола давиде палермо раффаэле энрико форли филиппо гуттузо джерманетто \
                мессаджеро ламборгини аджира гольджи гуарди гуарнери гвидо джулио джорджоне борджа кьоджа фольи \
                модильяни ольо аньяна отель ирьярте луиджи катена деи лагорай перрейра гойто серджо баярдо якурсо \
                джустиция чериале адриано моравия арискья бьянка езоло кьево даниэле уние тьеполо помпеи йоланда \
                ориоло юдрио эустакьо верроккьо пьоцци юдрио маррубиу фьюмичино кьюзи фриули якуцци янначчи ерцу \
                йопполо йоланда ди савоя ювентус каппа лабриола мальпиги фоллоника реджо нель эмилия монца мария \
                ористано палермо паоло акуара квазимодо римини рита савона сдобба паэзе безнате шеста боско скьо \
                скерцо шишано шаша тревизо томазо умберто кьюзи венеция вито артабакс венеция потенца дзампано \
                дзаккони боццоле сан наццаро меццогоро баталья согья оджи пальюка оеяяе""";
        Italian service = new Italian();

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