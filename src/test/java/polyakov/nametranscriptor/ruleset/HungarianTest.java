package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Hungarian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HungarianTest {

    @Test
    void transcribe() {
        String text = """
                magyaratád agárdi nagyállás báby cuca peczely eckhardt fejercse dad egri éri nagyerdő kemenyik tüskés \
                elfer gyoma meggy mihály kossuth bolyai ajka pocsaj naszürjhedy jakab folyás borjád adorjánháza \
                felsőjárás kisjakabfalva jéke jékely fejercse jianu jókai kissomlyó hejőbába juhasz varjúlapos \
                kisjustus kalász kőhalmi gőböljárás kemenyik nyáregyháza nyúl katona öttömös balatonőszöd mezőörs \
                kisszőllős ilosvai andrássy jánossomorja oszkár resznek ortutay osváth pakolitz delitzsch gyugy tyukod \
                újfehértó nagyút üzemi gyüre benamy géza zsigmond richárd lászló istván zoltán józsef gábor zsolt \
                péter jános attila tamás sándor tibor csaba ferenc györgy imre krisztián andrás béla lajos miklós \
                gyula robert antal szabolcs andrea károly mihály norbert pál ákos anita viktor balázs katalin arpad \
                endre erzsebet gergely géza kálmán roland róbert szilard ádám aniko dezső edit erika ernö flórián \
                gabriella gusztáv laszlo levente maria mihaly szilvia tünde zsuzsanna adam agnes andras annamaria \
                beata denes edina ernő eva gaba gyözö ildiko iván judit krisztina milán márton reka vilmos almos anett \
                angéla antonia aranka aurél balint balász barbara barnabas benő bertalan boldizsár brigitta bálint \
                csilla daniel david dezsö donat dorottya dénes elek eleonora emil emö ervin gizella greta gyöngyi \
                györgyi henrik ibolya ignac illés ilona imrene gábor jakab jenöne julianna józsek klara kristóf \
                laszlone lázár mariusz maté melinda miklós mikály monika nikolet orsolya peter pétere rezso rita \
                rozalia rudolf silvia szabo szilveszter thomas timea tóth zalán zita áron éva""";
        String transcription = """
                мадьяратад агарди надьяллаш баби цуца пецей экхардт фейерче дад эгри эри надьэрде кеменьик тюшкеш \
                эльфер дьема меддь михай кошут бояи айка почай насюрихедь якаб фояш борьяд адорьянхаза фельшеяраш \
                кишьякабфальва еке екей фейерче йиану йокаи кишомьо хейебаба юхас варьюлапош кишьюштуш калас \
                кехальми гебельяраш кеменьик ньяредьхаза ньюль катона эттемеш балатонесед мезеэрш кишселлеш илошваи \
                андраши яношоморья оскар реснек ортутаи ошват паколиц делич дьюдь тьюкод уйфехерто надьют иземи дьюре \
                бенами геза жигмонд рихард ласло иштван золтан йожеф габор жолт петер янош аттила тамаш шандор тибор \
                чаба ференц дьердь имре кристиан андраш бела лайош миклош дьюла роберт антал саболч андреа карой михай \
                норберт паль акош анита виктор балаж каталин арпад эндре эржебет гергей геза кальман роланд роберт \
                силард адам анико деже эдит эрика эрне флориан габриелла густав ласло левенте мария михай сильвия \
                тюнде жужанна адам агнеш андраш аннамария беата денеш эдина эрне эва габа дьезе ильдико иван юдит \
                кристина милан мартон река вильмош альмош анетт ангела антония аранка аурель балинт балас барбара \
                барнабаш бене берталан больдижар бригитта балинт чилла даниель давид деже донат дороттья денеш элек \
                элеонора эмиль эме эрвин гизелла грета дьендьи дьердьи хенрик ибоя игнац иллеш илона имрене габор якаб \
                енене юлианна йожек клара криштоф ласлоне лазар мариус мате мелинда миклош микай моника николет оршоя \
                петер петере режо рита розалия рудольф шильвия сабо сильвестер томаш тимеа тот залан зита арон эва""";
        Hungarian service = new Hungarian();

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