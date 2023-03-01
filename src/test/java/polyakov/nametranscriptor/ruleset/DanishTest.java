package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DanishTest {

    @Test
    void transcribe() {
        String text = """
                dannebrog aagaard bøe cecil clasonsborg carlottenlund frechen christian richard odd nordskov nørgaard \
                bradser odde egir clausen dallie dyb bejen kregme teglstrup hegn ejlinge frifelt stigenas gjedser \
                tiphede hjalmar hjort hvass henningsen kujegrund gjeller kjelst jammerbugt bjarni jensen jelling \
                hulbjerg bjærggård jonstrup bjollerup julebæk storjuvre jystrup jølby bjørnen krokau kjelst \
                kjerteminde clausen hjalf abell harald keldshoved dødlefelde bjolderup haldum hildagrund mammen \
                nannerup randers hjortlund brandsbøl spandet rønde almindingen troels pårup tiphede quartusgrund \
                rørdal bording ågård nordskov sassens nordsjælland otterup thy stationsby ugelhuse vadum tavs ovtrup \
                tolv wredeslund voxlev yderby nyborg zastrov æblesten næstved ørum nørgaard fejø løgsted løgsten \
                øjesø bøjden ågård""";
        String transcription = """
                даннеброг огор бе сесиль класонсборг карлоттенлунн фрекен кристиан рикар одд норсков нергор брасер \
                одде эгир клаусен даллие дюб байен крайме тайльструп хайн айлинге фрифельт стигенас гесер типхеде \
                яльмар йорт васс хеннингсен куйегрунн геллер кельст яммербугт бьярни йенсен йеллинг хульбьерг бьерггор \
                йонструп бьоллеруп юлебек сторьювре йюструп йельбю бьернен крокау кельст кертеминне клаусен яльф \
                абелль харалль келльсховед дедлефелле бьоллеруп хальдум хильдагрунн маммен наннеруп раннерс йортлунн \
                браннсбель спаннет ренде альминдинген троэльс поруп типхеде квартусгрунн рердаль бординг огор норсков \
                сассенс норшелланн оттеруп тю сташонсбю угельхусе вадум тавс овтруп толь вредеслунн вокслев идербю \
                нюборг састров эблестен нествед эрум нергор файе лойстед лойстен ойесе бойден огор""";
        Danish service = new Danish();

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