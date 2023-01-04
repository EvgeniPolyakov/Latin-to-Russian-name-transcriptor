package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MoldovanTest {

    @Test
    void transcribe() {
        String text = """
                bondarciuc iaser țurcan ianoș brînză cebotari priganiuc mîrza vdovcencov iourii erhan ciornîi \
                coceanovschi ștefania rotari fiodor iapără șmalenea musteaţă serghei tatiana peșterean laşcencov \
                cojocari calmațui iliniuc șumchin scoarţă coşciug gînsari panteleiciuc cucereavenco japalău reabciuk \
                oxana dicusar darenscaia nichita murovanîi corneencov andronachi repineţchii nagornîi cazacu corneliu \
                țîbuleac gurjui ionuț ciobanu jupanova ciumacenco ojehovschii cucereavîi evghenii zămosteanu jitariuc \
                victoria vîctărău dijinari andrei macoviiciuc anatolie aurel cătălin constantin dumitru eugenia \
                eugeniu eric eduard edward evgheni evghenia evghenii ghenadie gheorghe ianina iaroslav iouri igor \
                liviu ludmila marcela mihai mihail nadejda natalia nicolae nicolai olesea olga ruslan semion sergei \
                serghei serghey sergiu tatiana valerii valeriu vasile veaceslav vitalii vitaliy cojocari""";
        String transcription = """
                бондарчук ясер цуркан янош брынзэ чеботарь приганюк мырза вдовченков юрий ерхан чорный кочановский \
                штефания ротарь федор япэрэ шмаленя мустяцэ сергей татьяна пештерян лащенков кожокарь калмацуй илинюк \
                шумкин скоарцэ кощуг гынсарь пантелейчук кучерявенко жапалэу рябчук оксана дикусар даренская никита \
                мурованый корнеенков андронаки репинецкий нагорный казаку корнелиу цыбуляк гуржуй йонуц чобану жупанова \
                чумаченко ожеховский кучерявый евгений зэмостяну житарюк виктория выктэрэу дижинарь андрей маковийчук \
                анатолий аурел кэтэлин константин думитру эуджения эуджениу эрик эдуард эдвард евгений евгения евгений \
                геннадий георге янина ярослав юрий игорь ливиу людмила марчела михай михаил надежда наталия николае \
                николай олеся ольга руслан семен сергей сергей сергей серджу татьяна валерий валериу василе вячеслав \
                виталий виталий кожокарь""";
        Moldovan service = new Moldovan();

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