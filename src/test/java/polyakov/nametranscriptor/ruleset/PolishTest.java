package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PolishTest {

    @Test
    void transcribe() {
        String text = """
                adam stępowska notecka puszcza bądkowo dąbkowo bogdan solec cirlić chamiec życie maciej chrzciciel \
                czerniatowicz derdowski dzianisz niedźwiedź dżunkowski eugeniusz celina stępowski wałęsa filip gotard \
                huta mińsk mazowiecki gliwicki kanał antoni zosia adrian marian dziąba ciąpała związkowiec ciągło \
                wojciech ciępka piękna ziobro ciołek piórków siucice przyjaciółka mariusz andrzej jacek osjaków \
                jączkowski zajączkowo gjądła jedlinka kopjewski jębrzycki chajęcki kyrljęcik joniec maciejowice \
                celjowski juliusz balcerzak lacaz ląpowice przegląd lorentowicz lubecki łodyński jakóbik roman \
                krzysztof rzytka stanisław frycz szymon szczawiej cieślak śniadowo kościńska rzeczywistość radość \
                żołnierz wolności boleścin władysław szymon krystyna ksawery dołowy świeży bujny pyry zbigniew \
                brzeźniak haźlach źródłowski żorż ignacy golly cackowski ciastek czarnecka stec bołtuć""";
        String transcription = """
                адам стемповская нотецкая пуща бондково домбково богдан солец цирлиць хамец жице мацей хшцицель \
                чернятович дердовский дзяниш недзведзь джунковский эугениуш целина стемповский валенса филип готард \
                хута миньск мазовецкий гливицкий канал антоний зося адриан мариан дземба циомпала звензковец ционгло \
                войцех цемпка пенкна зебро циолек пюркув сюцице пшияцулка мариуш анджей яцек осьякув йончковский \
                заенчково гьондла едлинка копьевский ембжицкий хаенцкий кырльенцик йонец мацеевице цельовский юлиуш \
                бальцежак ляцаз лемповице пшегленд лерентович любецкий лодыньский якубик роман кшиштоф житка \
                станислав фрыч шимон щавей цесляк снядово косьциньская жечивистость радость жолнеж вольносьци \
                болесьцин владислав шимон кристина ксаверий доловы свежи буйны пыры збигнев бжезняк хазлях \
                зьрудловский жорж игнацы голли цацковский цястек чарнецкая стец болтуць""";
        Polish service = new Polish();

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