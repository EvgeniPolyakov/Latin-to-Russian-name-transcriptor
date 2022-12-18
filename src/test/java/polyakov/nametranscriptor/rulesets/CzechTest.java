package polyakov.nametranscriptor.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CzechTest {

    @Test
    void transcribe() {
        String text = """
                majerová kňažek hornictví pichlík čaloud šeďkova ďubinka sládek emanuel anděl grafek praha \
                flajšhans krejčí dolejší balajka ondřej janeček svojanov kavuljak jelínková jirák zajíc ljikar \
                kušljič jovsa kyjov aljo jůza havel bohumil palkosková lucký kostroň vodňany netoušek ťopan \
                dobroslav bedřich třeblícký svitava netoušek mathesius thůnová baťha ulehlová ťopan vitězslav \
                weber xaverová mlyňany heyrovský rybák poděbrady třeblícký kozuský zrzavý važný jůza žižka \
                chýlková hykeš aneta fojtíková petra tauberová anna dlasková eva rychtarová kateřina bužková \
                hloupá tereza krejčiříková kateřina svitková sara vršatová sára juračková simona pacandová \
                michaela jablončíková eva kristýnová bažoutová klára janštová veronika kinclová tereza vacková \
                cermanová adam benada filip firbacher dominik fišer šimon gabriel dominik hasala jan holzer \
                ladislav krobot penner matěj radosta jan vokřínek karel žilák matyáš kozák david jan kodýdek vít \
                kolář daniel kosek jakub markovič tomáš vlček adam vrba jáchym šíp radek vítek denis kryštof \
                daněk jakub drozd radek fojt matěj hadaš david jambor daniel milan šimoník filip uriča vágner \
                vecheta martin vitík patrik vydra denis višinský matteo burgo michal černák martin zentrich""";
        String transcription = """
                маерова княжек горництви пихлик чалоуд шедькова дюбинка сладек эмануэл андел графек прага флайшганс \
                крейчи долейши балайка ондржей янечек своянов кавульяк елинкова йирак зайиц льикар кушльич йовса киев \
                алье юза гавел богумил палкоскова луцки костронь водняны нетоушек тепан доброслав бедржих тршеблицки \
                свитава нетоушек матесиус тунова батьга улеглова тепан витезслав вебер ксаверова млыняны гейровски \
                рыбак подебрады тршеблицки козуски зрзавы важны юза жижка хилкова гикеш анета фойтикова петра \
                тауберова анна дласкова эва рыхтарова катержина бужкова глоупа тереза крейчиржикова катержина свиткова \
                сара вршатова сара юрачкова симона пацандова михаэла яблончикова эва кристынова бажоутова клара \
                янштова вероника кинцлова тереза вацкова церманова адам бенада филип фирбахер доминик фишер шимон \
                габриэл доминик гасала ян голзер ладислав кробот пеннер матей радоста ян вокршинек карел жилак матиаш \
                козак давид ян кодыдек вит коларж даниэл косек якуб маркович томаш влчек адам врба яхим шип радек \
                витек денис крыштоф данек якуб дрозд радек фойт матей гадаш давид ямбор даниэл милан шимоник филип \
                урича вагнер вехета мартин витик патрик выдра денис вишински маттео бурго михал чернак мартин зентрих""";
        Czech service = new Czech();

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