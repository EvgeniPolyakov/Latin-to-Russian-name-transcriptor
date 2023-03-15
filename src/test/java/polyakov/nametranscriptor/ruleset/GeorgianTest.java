package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Georgian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GeorgianTest {

    @Test
    void transcribe() {
        String text = """
                ernest akhalbedashvili elguja lobjanidze jangveladze sadjaia shota shalva ogbaidze tsotne patsatsia \
                tsira tsetskhladze khvicha shubitidze tornike dzotsenidze jimsheleishvili aptsiauri tsalughelashvili \
                teimuraz mjavanadze davitashvili tchigvaria iashvili tsinamdzgvrishvili tsatskrialashvili \
                mtchedlishvili tskhomaria lobzhanidze basheleishvili vazisubani chokhatauri ochamchira akhalkalaki \
                gurjaani mtisdziri javakheti tskhenistsqali mtisdziri uplistsikhe""";
        String transcription = """
                эрнест ахалбедашвили элгуджа лобжанидзе джангвеладзе саджая шота шалва огбаидзе цотне пацация цира \
                цецхладзе хвича шубитидзе торнике дзоценидзе джимшелеишвили апциаури цалугелашвили теймураз \
                мжаванадзе давиташвили чигвария иашвили цинамдзгвришвили цацкриалашвили мчедлишвили цхомария \
                лобжанидзе башелеишвили вазисубани чохатаури очамчира ахалкалаки гурджаани мтисдзири джавахети \
                цхенисцкали мтисдзири уплисцихе""";
        Georgian service = new Georgian();

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