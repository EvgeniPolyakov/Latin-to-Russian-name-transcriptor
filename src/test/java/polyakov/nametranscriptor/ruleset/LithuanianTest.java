package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Lithuanian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LithuanianTest {

    @Test
    void transcribe() {
        String text = """
                adakavas prialgava eglė doveika vėgėlė haliampolis hilda ignalina pailgiai uikiai eiguliai saliamonas \
                ieva liepinis toliotas kasiulis mačiuika jecaitė pajiesis gudjonienė pjūkla kalnalis stulpinaite \
                vilnius plokščiai ščalnys chonjielpene žiačiulbješ jonjolvė fągęzįjy arnold kol žebrauskas žygimantas \
                baltrūnas deimantas rimpa linas zingertas eimantas abramavičius motiejus meinardas mikulėnas nojus \
                stankevičius deividas dovydaitis nedas labukas kristupas mantinis karolis masevičius artemijus \
                tutyškinas modestas vainikaitis dominykas valeckas ervinas vilkaitis deitonas vinckus titas aukštuolis \
                džiugas raudonius edgaras utkus renatas banevičius matas vareika uzėla raulinaitis paura titas \
                milašius matas kubilius kipras kažukolovas gudelis gudaitis čepulis arijus bražinskas jonas bičkus \
                arnold baulin dovilė dockaitė meda šeškutė erika šupelytė gabija valiukevičiūtė alina špakovskaja \
                rugilė butkutė rimantė jonušaitė tereza romanovskaja austė bernotaitė aušrinė bikutė eva gecevičiūtė \
                iveta inčytė neonila ivanovskaja laura kubiliūtė gabija sinkevičiūtė ugnė slankauskaitė donata \
                švarcaitė ligita toropovaitė veronika zelenina livija gedgaudaitė emilija kaselytė agneta patilskyte \
                urtė šmigelskaitė vitovskytė simona bagavičiūtė bajorinaitė gintarė blažytė deventinaitė danielė \
                kalendauskaitė rugilė lygnugarytė monika markevičiūtė kamilė pranulytė gabrielė ragauskaitė loreta \
                rogačiova vaida rutkauskaitė silvija šafronovič sarkanaitė lnilnolnelniulnialnylnalntlnulnelnelne""";
        String transcription = """
                адакавас прялгава эгле довейка вегеле халямполис хилда игналина пайльгяй уйкяй эйгуляй салямонас ева \
                лепинис толетас касюлис мачюйка ецайте паесис гудйонене пьюкла калналис стульпинайте вильнюс плокщяй \
                щальнис хоньельпене жячюльбьяш йонйольве фагезийи арнольд коль жебраускас жигимантас балтрунас \
                деймантас римпа линас зингертас эймантас абрамавичюс мотеюс мейнардас микуленас ноюс станкявичюс \
                дейвидас довидайтис недас лабукас криступас мантинис каролис масявичюс артемиюс тутишкинас модестас \
                вайникайтис доминикас валецкас эрвинас вилкайтис дейтонас винцкус титас аукштуолис джюгас раудонюс \
                эдгарас уткус ренатас банявичюс матас варейка узела раулинайтис паура титас милашюс матас кубилюс \
                кипрас кажуколовас гуделис гудайтис чепулис ариюс бражинскас йонас бичкус арнольд баулин довиле \
                доцкайте меда шешкуте эрика шупелите габия валюкявичюте алина шпаковская ругиле буткуте риманте \
                йонушайте тереза романовская аусте бернотайте аушрине бикуте эва гецявичюте ивета инчите неонила \
                ивановская лаура кубилюте габия синкявичюте угне сланкаускайте доната шварцайте лигита тороповайте \
                вероника зеленина ливия гедгаудайте эмилия каселите агнета патилските урте шмигелскайте витовските \
                симона багавичюте байоринайте гинтаре блажите девентинайте даниэле календаускайте ругиле лигнугарите \
                моника маркявичюте камиле пранулите габриэле рагаускайте лорета рогачева вайда руткаускайте сильвия \
                шафронович сарканайте льнилнольнельнюльняльнилналнтлнульнельнельне""";
        Lithuanian service = new Lithuanian();

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