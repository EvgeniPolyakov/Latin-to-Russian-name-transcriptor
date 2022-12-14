package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SlovakTest {

    @Test
    void transcribe() {
        String text = "piu rožňava piešťany balát baláž svätý anton jablonický berčík kľúčovec dolný kubín ďurica " +
                "prievidza čepčeková slovenská mládež edo emanuel falťan hvorecký heľpa chalupka maloch mináč " +
                "minárik lojčiak kalinčiakovo hontianska vrbica zelienka juraj frejka jankovcová zajac kavuljak " +
                "jelenec jurová jozef kyjov kežmarok hollý lucký michal ľubeľa kráľová mladý budovateľ medzilaborce " +
                "nitra beňo kostroň kráľová jankovcová potôčky poprad ružomberok jurovský bakoš andraščík trnava " +
                "ružomberok veľký krtíš rybany chýlková hykeš rybák bielický kozuský meravý vážny azud";
        String transcription = "пью рожнява пьештяны балат балаж светы антон яблоницки берчик ключовец долны кубин " +
                "дюрица прьевидза чепчекова словенска младеж эдо эмануэл фалтян гворецки гельпа халупка малох " +
                "минач минарик лойчак калинчаково гонтьянска врбица зельенка юрай фрейка янковцова заяц кавульяк " +
                "еленец юрова йозеф киев кежмарок голлы луцки михал любеля кралева млады будователь медзилаборце " +
                "нитра бене костронь кралева янковцова потуочки попрад ружомберок юровски бакош андрашчик трнава " +
                "ружомберок вельки кртиш рыбаны хилкова гикеш рыбак бьелицки козуски меравы важны азуд";
        Slovak service = new Slovak();

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