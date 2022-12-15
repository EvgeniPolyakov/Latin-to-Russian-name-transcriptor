package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SlovakTest {

    @Test
    void transcribe() {
        String text = """
                piu rožňava piešťany balát baláž svätý anton jablonický berčík kľúčovec dolný kubín ďurica \
                prievidza čepčeková slovenská mládež edo emanuel falťan hvorecký heľpa chalupka maloch mináč \
                minárik lojčiak kalinčiakovo hontianska vrbica zelienka juraj frejka jankovcová zajac kavuljak \
                jelenec jurová jozef kyjov kežmarok hollý lucký michal ľubeľa kráľová mladý budovateľ medzilaborce \
                nitra beňo kostroň kráľová jankovcová potôčky poprad ružomberok jurovský bakoš andraščík trnava \
                ružomberok veľký krtíš rybany chýlková hykeš rybák bielický kozuský meravý vážny azud filip baláž \
                rudolf božík richard hečko timotej jambor thomas kotlár adrián macejko urban mazanovský lukáš \
                sečanský samuel urgela tobias čongrády alex molčan adam danko adam gaži vladimír kaňuch sebastián \
                kóša šikula marián šmatlák dominik šnajder veliký bruno čerňanský aurel dávidík tomáš filipiak \
                alex fojtíček jakub kadák martin petro denis potoma mário strachan maxim kováč marko kelemen \
                ján krkoška murcko pišoja dominik saxa stanislav svetlošák trnovský tomáš tvrdý laura bieliková \
                andrea bogorová janka lukáčová rezeková desana dianišková droppová kaláberová viktória \
                kratochvílová viktória nagy katarína niňajová kristína panáková laura žemberyová lemešová \
                stela semanová alexandra tejová poláčiková michaela harvilová kristína tesáková karolína \
                bátkyová kristína tipulová""";
        String transcription = """
                пью рожнява пьештяны балат балаж светы антон яблоницки берчик ключовец долны кубин дюрица \
                прьевидза чепчекова словенска младеж эдо эмануэл фалтян гворецки гельпа халупка малох минач \
                минарик лойчак калинчаково гонтьянска врбица зельенка юрай фрейка янковцова заяц кавульяк \
                еленец юрова йозеф киев кежмарок голлы луцки михал любеля кралева млады будователь медзилаборце \
                нитра бене костронь кралева янковцова потуочки попрад ружомберок юровски бакош андрашчик трнава \
                ружомберок вельки кртиш рыбаны хилкова гикеш рыбак бьелицки козуски меравы важны азуд филип балаж \
                рудолф божик рихард гечко тимотей ямбор томас котлар адриан мацейко урбан мазановски лукаш \
                сечански самуэл ургела тобьяс чонграды алекс молчан адам данко адам гажи владимир канюх себастиан \
                коша шикула мариан шматлак доминик шнайдер велики бруно чернянски аурел давидик томаш филипьяк \
                алекс фойтичек якуб кадак мартин петро денис потома марио страхан максим ковач марко келемен \
                ян кркошка мурцко пишоя доминик сакса станислав светлошак трновски томаш тврды лаура бьеликова \
                андреа богорова янка лукачова резекова десана дьянишкова дроппова калаберова виктория \
                кратохвилова виктория наги катарина ниняева кристина панакова лаура жемберыова лемешова \
                стела семанова александра теева полачикова михаэла гарвилова кристина тесакова каролина \
                баткиова кристина типулова""";
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