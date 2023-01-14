package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GreekTest {

    @Test
    void transcribe() {
        String text = """
                istiaia vaios karyai kameni yerakini yides pyrgi giannitsa achilleas alkaios emilios vagionia \
                panagiouda zagliveri gkana anchialos karditsa krieza nea psara richea evdokia evvoikos achaia tria \
                kalymnos mpampis papaioannou tsalouchidis lyratzis giakoumakis xanthi veria smolikas kazantzakis \
                tsatsos chalkida onassis tsiartas chatzigiannidou stogiannis ieroklis georgogiannis papagiannakis \
                georgios konstantinos ioannis nikolaos dimitrios christos vasilios panagiotis antonios athanasios \
                apostolos alexandros dimitris anastasios theodoros nikos evangelos andreas ilias kostas emmanouil \
                vasilis michail petros giannis maria stavros angelos pavlos spiridon stefanos stelios takis thomas \
                eleni stylianos vasileios panayotis pantelis charalambos kiriakos loukas michalis sotirios thanasis \
                aristidis asterios charalampos elias fotios giorgios grigorios grigoris lakis mimis nicolaos periklis \
                sotiris spyridon tasos vassilios alexios anastasia dionisios efstratios efthymios eleftherios kyriaki \
                lazaros leonidas mihail mihalis minas paraskevas savas sofia sokratis theocharis theofanis vangelis \
                vassiliki zafiris achileas andreas goi gói goï goí""";
        String transcription = """
                истиея вейос карье камени еракини йидес пирьи янница ахиллеас алкейос эмилиос вайония панаюда \
                загливери гана анхиалос кардица криеза неа псара рихея эвдокия эввоикос ахея триа калимнос бамбис \
                папаиоанну цалухидис лирадзис якумакис ксанти верия змоликас казандзакис цацос халкида онассис \
                циартас хадзиянниду стояннис иероклис георгояннис папаяннакис йоргос константинос яннис николаос \
                димитриос христос василиос панайотис антониос атанасиос апостолос александрос димитрис анастасиос \
                теодорос никос эвангелос андреас илиас костас эммануил василис михаил петрос яннис мария ставрос \
                ангелос павлос спиридон стефанос стелиос такис томас элени стилианос василиос панайотис пантелис \
                хараламбос кириакос лукас михалис сотириос танасис аристидис астериос хараламбос элиас фотиос йоргос \
                григориос григорис лакис мимис николаос периклис сотирис спиридон тасос вассилиос алексиос анастасия \
                дионисиос эфстратиос эфтимиос элефтериос кириаки лазарос леонидас михаил михалис минас параскевас \
                савас софия сократис теохарис теофанис вангелис вассилики зафирис ахилеас андреас гои гои гои гои""";
        Greek service = new Greek();

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