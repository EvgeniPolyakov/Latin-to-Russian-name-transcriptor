package polyakov.nametranscriptor.rulesets.rulesets;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.rulesets.Macedonian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MacedonianTest {

    @Test
    void transcribe() {
        String text = """
                ljalje ljiljo ljulj njanje njinjo njunj ljamčevski cvetan čurlinov samir azizi riste josifovski ivan \
                zafirovski saško ristov ina milošeska adjimanova ilčo udovaliev mojsov blagojče ljamčevski blerton \
                sheji bojan miovski david denkovski davor zdravkovski enis fazlagić filip antovski jani atanasov \
                kristijan ackovski kristijan trapanovski mario ilievski marko alchevski marko gjorgjievski martin \
                stojanov nikola serafimov oliver stoimenovski risto jankov slave markoski todor todoroski tomche \
                grozdanovski viktor krstevski aleksandra jovanovska ana milchevska angela zafirovska anida jahji \
                berna kabakchi bojana petkova brikena shakiri dajana ristovska edina sulejmani era stableva jana \
                luba zvrlevska kristina mojsoska mia golovska olivera cokleska radica velkova sanja perchinkovska \
                tea bozhinoska teodora nikolovska viktorija nedeva""";
        String transcription = """
                ляле лиле люль няне нине нюнь лямчевски цветан чурлинов самир азизи ристе йосифовски иван зафировски \
                сашко ристов ина милошеска аджиманова илчо удовалиев мойсов благойче лямчевски блертон шейи боян \
                миовски давид денковски давор здравковски энис фазлагич филип антовски яни атанасов кристиян ацковски \
                кристиян трапановски марио илиевски марко алчевски марко джерджиевски мартин стоянов никола серафимов \
                оливер стойменовски ристо янков славе маркоски тодор тодороски томче гроздановски виктор крстевски \
                александра йовановска ана милчевска ангела зафировска анида яхьи берна кабакчи бояна петкова брикена \
                шакири даяна ристовска эдина сулеймани эра стаблева яна луба зврлевска кристина мойсоска миа головска \
                оливера цоклеска радица велкова саня перчинковска теа божиноска теодора николовска виктория недева""";
        Macedonian service = new Macedonian();

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