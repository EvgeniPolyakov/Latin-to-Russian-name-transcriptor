package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FinnishTest {

    @Test
    void transcribe() {
        String text = """
                anna alava aulanko maria sofia sylvia aarne aalto aavasaksa koillismaa aili kaitila aitolahti birgitta \
                backman borgå carita eric agricola cleve alice cederberg christer zacharias chorell chydenius \
                charlotta barck räckhals backas rydbeck stackelberg daniel doris davidson drumsö elina erkko espoo \
                lauerma raento joensuu kokemäenjoki terttu vieno helle sievänen kievi veteli eero eerikäinen eetula \
                teemu kitee seetrimäki leena veera eino eikkala eistilä veikko heikkonen heinola eufrosine eurola \
                eura teuvo peuranen teuva pyöreälä fredrik finnilä fiskars gabriel gunnar agricola gardberg grankulla \
                angeli heikki haahtela hamina ilmari itkonen inari vieno lievonen ylivieska iivo liisa siitonen \
                iisalmi yli-ii äikiä kälviä päiviö köyliö jalo seija jalava kajanti jalasjärvi lahja pohjala pohjanmaa \
                jaakko jaatinen jaakkima jermu jeskanen jepua töijensalo veljesmaa jeesiöjoki jirva jietajoki jirssi \
                poljinsuo toskalharji jiirva jorma keijo joki joensuu puijo viljo ahjopalo karjoniemi joonas \
                kajoonsaari majoola juho maiju junnila lajunen mujujärvi karjula kulju juuso juupajärvi jyrinkoski \
                ärjylä öljymäki jyykeä jyysjärvi järvinen poijärvi suojärvi suonsyrjä pöljä pärjänjoki vieljärvi \
                kuusjärvi jääski jäämeri jöns jöröjukka yrjö lötjönen syrjö jöökki äijöö kauko kalske kotka orvokki \
                kukkonen kokkola lauri saalasti aulanko salme tolppanen salpausselkä vilho siltanen helsinki pöljä \
                salpausselkä emil joel paul kalle ulla svalling mikko lampi maarianhamina emma lammio tammisaari niilo \
                nieminen naantali annikki kanninen päijänne outi orko outokumpu oiva koivisto voikkaa roope noopila \
                porvoo pekka tapola pori seppo tappurainen lappi qvintus risto torvinen rauma aarre \
                verronen arrakoski simo säisiö salo jussi kassinen nissilä tuulikki timonen turku terttu henttonen \
                uittamo unto uotila kumpula tuija uino puijo uuno uusitalo kainuu valto wartiovaara vantaa felix \
                axelsson saxby kyllikki yrjölä ylivieska kymmene yijälä lyyli kyyrö myyrmäki uusikaarlepyy yyteri \
                keikyä pöytyä kyösti yöntilä mauritz zacharias zilliacus åke åström åggelby åbo åland ämmälä ähtäri \
                ängskulla väinö jylhä ypäjä äikiä päivi käiväräinen päijänne äystö äyräpää mäyränen säynätsalo ääri \
                äänekoski haanpää kääriä vääksy yrjö östen könönen öljymäki pöljä sörnäinen överby höijer öintilä \
                töijensalo söyrinki öystilä röyttä vöyri höök ränsöö töölö""";
        String transcription = """
                анна алава ауланко мария софия сильвия аарне аалто аавасакса койллисмаа айли кайтила айтолахти \
                биргитта бакман борго карита эрик агрикола клеве алисе седерберг кристер сакариас корелль чюдениус \
                шарлотта барк рякхалс баккас рюдбекк стаккельберг даниель дорис давидсон друмсе элина эркко эспоо \
                лауэрма раэнто йоэнсуу кокемяэнйоки тертту виено хелле сиевянен киеви ветели ээро ээрикяйнен ээтула \
                теэму китеэ сеэтримяки лена вера эйно эйккала эйстиля вейкко хейкконен хейнола эуфросине эурола эура \
                теуво пеуранен теува пюереяля фредрик финниля фискарс габриель гуннар агрикола гардберг гранкулла \
                ангели хейкки хаахтела хамина ильмари итконен инари виено лиевонен юливиеска ииво лииса сиитонен \
                иисалми юли-ии эйкия кяльвия пяйвие кеулие яло сейя ялава каянти яласьярви лахья похьяла похьянмаа \
                яакко яатинен яаккима ерму есканен епуа тейенсало вельесмаа еэсиейоки йирва йиетайоки йирсси полйинсуо \
                тоскалхарйи йийрва йорма кеййо йоки йоэнсуу пуййо вильйо ахйопало карйониеми йоонас \
                кайоонсаари майоола юхо майю юннила лаюнен муюярви карьюла кулью юусо юупаярви йюринкоски эрьюля \
                ельюмяки йююкея йююсьярви ярвинен пойярви суоярви суонсюрья пелья пярьянйоки виельярви куусьярви \
                яяски яямери йенс йереюкка юрье летьенен сюрье йеекки эййее кауко калске котка орвокки кукконен \
                коккола лаури сааласти ауланко салме толппанен салпаусселькя вильхо сильтанен хельсинки пелья \
                салпаусселькя эмиль йоэль пауль калле улла сваллинг микко лампи маарианхамина эмма ламмио таммисаари \
                нийло ниеминен наантали анникки каннинен пяйянне оути орко оутокумпу ойва койвисто войккаа роопе \
                ноопила порвоо пекка тапола пори сеппо таппурайнен лаппи квинтус ристо торвинен раума аарре \
                верронен арракоски симо сяйсие сало юсси кассинен ниссиля тууликки тимонен турку тертту хенттонен \
                уйттамо унто уотила кумпула туйя уйно пуййо ууно ууситало кайнуу валто вартиоваара вантаа феликс \
                аксельссон саксбю кюлликки юрьеля юливиеска кюммене юйяля лююли кююре мююрмяки \
                уусикаарлепюю юютери кейкюя пеутюя кюести юентиля мауритс сакариас силлиакус оке острем оггельбю або \
                аланд эммяля эхтяри энгскулла вяйне йюльхя юпяя эйкия пяйви кяйвяряйнен пяйянне эусте эуряпяя мяурянен \
                сяунятсало ээри ээнекоски хаанпяя кяярия вяяксю юрье естен кененен ельюмяки пелья серняйнен евербю \
                хейер ейнтиля тейенсало сеуринки еустиля реуття веури хеек рянсее тееле""";
        Finnish service = new Finnish();

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