package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Albanian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AlbanianTest {

    @Test
    void transcribe() {
        String text = """
                livadhja kthella gjegjani lura laçi vlora bubullima mollaj perrenjas zerqani mjeda topojani krutja \
                vau i dejës pajova deklinj jeja jije joji jujo mokje komji llupjo pogju gjagje gjegja gjigjo gjogji \
                gjugju njanje njenja njinjo njonji njunju naim frashëri naum veqilharxhi enver halil hoxha fatjon \
                idromeno berat burreli durrës kukës patos pogradec shkodër elbasan vlorë kavajë korçë krujë kuçovë \
                lezhë lushnjë tiranë klinë pejë agjë ënjë ollqë beqiri cikalleshi preka fejzulla zajsar elio zalli \
                arber bytyqi pjeshka kristian dervishi nerguti eljon toci endri zenelaj shpendi daniel hysaj klevis \
                bebeziqi rejan alivoda cipi redon dragoshi kumbulla rezart halili enes isufi kalaj erald gjirokastër \
                malaj pjetri alia jurgen celhaka kristian frroku marsel ismailgeci karica muçi samuel nezha pasha \
                avullija gjergji hamonikaj hyska qose amanda bilali aglia iliadhi klesjana kledja sula matilda alda \
                blinishta suzane diana mbaresa cemeri marie gjata kacorri rexhina cerkini riselda leba esi lufo \
                esmeralda xhilda xhymerti metalla elsaida mucejani alketa rragami armela gjergji lleshi rizallaraj \
                kalaja kostaj mucellari kejsi saliaj drenasi deçani dragash zveçani kosova mitrovicë leposaviq besiana""";
        String transcription = """
                ливадья ктела гегяни люра лячи влера бубулима молай перреняс зеркяни мьеда топояни крутья вау и дейес \
                пайова деклинь ея йие йойи юйо мокье комьи лупьо погю гяге гегя гиге геги гюгю няне неня нине нени \
                нюню наим фрашери наум векильхарджи энвер халиль ходжа фатьон идромено берат буррели дуррес кукес \
                патос поградец шкодер эльбасан влера кавая корча круя кучова лежа люшня тирана клина пея агя эня олкя \
                бекири цикалеши прека фейзула зайсар элио зали арбер бютюки пьешка кристиан дервиши нергути эльон тоци \
                эндри зенеляй шпенди даниэль хюсай клевис бебезики реян аливода ципи редон драгоши кумбула резарт \
                халили энес исуфи каляй эральд гирокастра маляй пьетри алиа юрген цельхака кристиан фрроку марсель \
                исмаильгеци карица мучи самуэль нежа паша авулия герги хамоникай хюска кесе аманда биляли аглиа \
                илиади клесьяна кледья суля матильда альда блиништа сузане диана мбареса цемери мариэ гята кацорри \
                реджина церкини рисельда леба эси люфо эсмеральда джильда джюмерти метала эльсаида муцеяни алькета \
                ррагами армеля герги леши ризаларай каляя костай муцелари кейси салиай дренаси дечани драгаш \
                звечани косова митровица лепосавич бесиана""";
        Albanian service = new Albanian();

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