package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CzechTest {

    @Test
    void transcribe() {
        String text = "majerová kňažek hornictví pichlík čaloud šeďkova ďubinka sládek emanuel anděl grafek praha " +
                "flajšhans krejčí dolejší balajka ondřej janeček svojanov kavuljak jelínková jirák zajíc ljikar " +
                "kušljič jovsa kyjov aljo jůza havel bohumil palkosková lucký kostroň vodňany netoušek ťopan " +
                "dobroslav bedřich třeblícký svitava netoušek mathesius thůnová baťha ulehlová ťopan vitězslav " +
                "weber xaverová mlyňany heyrovský rybák poděbrady třeblícký kozuský zrzavý važný jůza žižka " +
                "chýlková hykeš";
        String transcription = "маерова княжек горництви пихлик чалоуд шедькова дюбинка сладек эмануэл андел " +
                "графек прага флайшганс крейчи долейши балайка ондржей янечек своянов кавульяк елинкова йирак " +
                "зайиц льикар кушльич йовса киев алье юза гавел богумил палкоскова луцки костронь водняны " +
                "нетоушек тепан доброслав бедржих тршеблицки свитава нетоушек матесиус тунова батьга улеглова " +
                "тепан витезслав вебер ксаверова млыняны гейровски рыбак подебрады тршеблицки козуски " +
                "зрзавы важны юза жижка хилкова гикеш";
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