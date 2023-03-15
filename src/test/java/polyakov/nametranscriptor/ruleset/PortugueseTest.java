package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Portuguese;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PortugueseTest {

    @Test
    void transcribe() {
        String text = """
                adalmo carvalhal maria meã maracanã covilhã ruivães magalhães são paulo tristão joão farminhão branco \
                curral cidadela victória monção chapa cachaça domingo évora eugénio edgardo manuel peneda friestas \
                janeiro daniel de sá diogo bernardes gomes eanes zurara montes verdes os sales palma cima cáceres \
                costa e silva manica e sofala fausto gustavo gilberto magdalena guilhermino horta bahia isabel cintra \
                boim jaime niteroi maiorga baião campia sabóia maxial viana iaco maiorga vimioso leio papagaio loios \
                antónio vinicius iuira bocaiúva jorge leonam silva miran lomba bomfim joaquim nélson minho antónio \
                novidades josé joaquim soares quadros século manoel carvalho simões couto moura sousa palma sophia \
                cinqüenta queluz monserrate trancoso vasco novas nascimento passo fundo tomas theo urbano guilhermino \
                agüeiro garanhuns viriato xavier corixa máximo maximalista felix extrema hygino euryalo nazaré luizmina""";
        String transcription = """
                адалму карвальял мария меан маракана ковильян руйвайнш магальяйнш сан паулу триштан жуан фарминьян \
                бранку куррал сидадела витория монсан шапа кашаса домингу эвора эужениу эдгарду мануэл пенеда фриешташ \
                жанейру даниел де са диогу бернардеш гомеш эанеш зурара монтеш вердеш уш салеш палма сима касереш \
                кошта и силва маника и софала фаушту гуштаву жилберту мадалена гильермину орта баия изабел синтра \
                боин жайме нитерой майорга байан кампия сабоя машиал виана иаку майорга вимиозу лею папагаю лоюш \
                антониу винисиуш иуйра бокаюва жорже леонам силва миран ломба бонфин жуакин нелсон минью антониу \
                новидадеш жозе жуакин суареш куадруш секулу мануэл карвалью симойнш коту мора соза палма софия \
                синкуэнта келуш монсеррате транкозу вашку новаш нашсименту пасу фунду томаш теу урбану гильермину \
                агуэйру гараньюнш вириату шавиер кориша масиму максималишта фелиш эштрема ижину эуриалу назаре луйжмина""";
        String names = """
                diogo monteiro luis gomes gustavo varela henrique arreiol guilherme santos marlon junior rodrigo \
                ribeiro afonso moreira joão veloso rafael rego gonçalves alfa baldé gonçalo francisco machado josé \
                rodrigues conceição diogo fernandes ivan lima leonardo barroso ronaldo camará almeida fábio silva \
                bruno tavares daniel paulo bernardo samuel soares tomás esteves araújo batalha filipe cruz rêgo \
                famana quizera pedro alves pedro brazão tiago gerson sousa luisa oliveira bras victória ferreira inês \
                simas carolina leonor faria maria francisca bruna ramos isabel cardoso ana carolina ferreira marta \
                melão cristiana martins gabriela vinhas lara leonete correia mafalda mariano andreia bravo pinto \
                cunha beatriz cameirão campino teles telma encarnação bárbara rosa sofia moreira albuquerque inês \
                barge vera cid sónia joana andreia jacinto luana marques alexandra leitão""";
        String nameTranscription = """
                диогу монтейру луиш гомеш гуштаву варела энрике аррейол гильерме сантуш марлон жуниор родригу \
                рибейру афонсу морейра жуан велозу рафаэл регу гонсалвеш алфа балде гонсалу франсишку машаду жозе \
                родригеш консейсан диогу фернандеш иван лима леонарду баррозу роналду камара алмейда фабиу силва \
                бруну тавареш даниел паулу бернарду самуэл суареш томаш эштевеш араужу баталья филипе круш регу \
                фамана кизера педру алвеш педру бразан тьягу жерсон соза луиза оливейра браш витория феррейра инеш \
                симаш каролина леонор фария мария франсишка бруна рамуш изабел кардозу ана каролина феррейра марта \
                мелан криштиана мартинш габриела виньяш лара леонете коррея мафалда мариану андрея браву пинту кунья \
                беатриш камейран кампину телеш телма энкарнасан барбара роза софия морейра албукерке инеш барже вера \
                сид сония жуана андрея жасинту луана маркеш алешандра лейтан""";
        checkTranscription(text, transcription);
        checkTranscription(names, nameTranscription);
    }

    private static void checkTranscription(String text, String transcription) {
        Portuguese service = new Portuguese();
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