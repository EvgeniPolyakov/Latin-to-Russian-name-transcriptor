package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Brazilian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BrazilianTest {

    @Test
    void transcribe() {
        String text = """
                adalmo carvalhal maria meã maracanã covilhã ruivães magalhães são tristão joão farminhão branco curral \
                cidadela victória monção chapa cachaça domingo évora eugénio edgardo manuel peneda friestas janeiro \
                daniel de sá diogo bernardes gomes eanes zurara montes verdes os sales palma cima cáceres costa e \
                silva manica e sofala fausto gustavo gilberto magdalena guilhermino horta bahia isabel cintra boim \
                jaime niteroi maiorga baião campia sabóia viana iaco maiorga vimioso leio papagaio loios antónio \
                vinicius iuira bocaiúva jorge leonam silva miran lomba bomfim nélson minho antónio novidades \
                josé joaquim soares quadros século manoel carvalho simões couto moura sousa palma sophia cinqüenta \
                queluz monserrate trancoso vasco novas nascimento passo fundo tomas theo urbano guilhermino agüeiro \
                garanhuns viriato xavier corixa máximo maximalista felix extrema hygino euryalo nazaré luizmina""";
        String transcription = """
                адалмо карвальял мария меан маракана ковильян руйвайнс магальяйнс сан тристан жоао фарминьян бранко \
                куррал сидадела витория монсан шапа кашаса доминго эвора эуженио эдгардо мануэл пенеда фриестас жанейро \
                даниел ди са диого бернардис гомис эанис зурара монтис вердис ос салис палма сима касерис коста и \
                силва маника и софала фаусто густаво жилберто мадалена гильермино орта баия изабел синтра боин жайми \
                нитерой майорга байан кампия сабоя виана иако майорга вимиозо лейо папагайо лойос антонио винисиус \
                иуйра бокаюва жоржи леонам силва миран ломба бонфин нелсон миньо антонио новидадис жозе жуакин \
                суарис куадрос секуло мануэл карвальо симойнс кото мора соза палма софия синкуэнта келус \
                монсеррати транкозо васко новас насименто пасо фундо томас тео урбано гильермино агуэйро гараньюнс \
                вириато шавиер кориша масимо максималиста фелис эстрема ижино эуриало назаре луйзмина""";
        String names = """
                raffael robinho david luiz lucas leiva fernando claudemir eric juan jesus júnior caiçara phellype \
                gabriel silva vagner fred naldo alex telles isael wanderson ailton pedro henrique alef diego carlos \
                fransérgio tiquinho soares kenedy matheus bruno viana pablo santos lucas cunha carlinhos raphinha \
                caju galeno joão victor sidcley murilo costa rafael ratão ribeiro wendel davidson kaio duarte eric \
                ramírez arthur cabral evangelista santos gabriel martinelli eduardo william paulo otávio ronaldo \
                guiaro zé rivaldo abedi fábio lúcio lincoln césar rodolfo wender vandinho jussiê eller jorginho \
                geder fininho caca aílton eudi edson leandro castán marcio gláuber berti mattos neto lenny manduca""";
        String nameTranscription = """
                раффаэл робиньо давид луис лукас лейва фернандо клаудемир эрик жуан жезус жуниор кайсара феллипи \
                габриел силва вагнер фред налдо алекс теллис изаэл вандерсон айлтон педро энрике алеф диего карлос \
                франсержио тикиньо суарис кенеди матеус бруно виана пабло сантос лукас кунья карлиньос рафинья кажу \
                галено жоао витор сидклей мурило коста рафаэл ратан рибейро вендел давидсон кайо дуарти эрик рамирес \
                артур кабрал эванжелиста сантос габриел мартинелли эдуардо виллиам пауло отавио роналдо гиаро зе \
                ривалдо абеди фабио лусио линколн сезар родолфо вендер вандиньо жусие эллер жоржиньо жедер \
                фининьо кака аилтон эуди эдсон леандро кастан марсио глаубер берти маттос нето ленни мандука""";
        checkTranscription(text, transcription);
        checkTranscription(names, nameTranscription);
    }

    private static void checkTranscription(String text, String transcription) {
        Brazilian service = new Brazilian();
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