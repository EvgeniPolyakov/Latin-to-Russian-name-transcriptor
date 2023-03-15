package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Hebrew;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HebrewTest {

    @Test
    void transcribe() {
        String text = """ 
                gleekman ollo egall oukovich yitzchak youtoub khryashch tsoph israel katz miri regev yariv levin yoav \
                galant nir barkat gila gamliel avi dichter galit distel atbaryan haim katz eli cohen tzachi hanegbi \
                ofir akunis yuval amsalem amir ohana ofir katz eti atiya yoav kisch david bitan keren barak shlomo \
                miki zohar orly abekasis keti shitrit fateen mulla may golan yair lapid meir cohen elazar levy meirav \
                ben ari ram ben barak yoav segalovich boaz toporovsky lahav hertzano vladimir beliak ron katz nira \
                shpak yaakov margi yoav ben tzur michael haim biton moshe arbel yinon azulai moshe abutbul uriel buso \
                benny gantz michael biton alon schuster eitan ginzburg yael ron ben moshe merav michaeli gilad kariv \
                efrat ram shefa ibtisam maraana moshe gafni uri maklev meir porush yaakov asher yisrael eichler \
                yitzhak pindros naftali bennett matan kahana""";
        String transcription = """
                гликман олло эгалль укович ицхак ютуб хрьящ цоф исраэль кац мири регев ярив левин йоав галант нир \
                баркат гила гамлиэль ави дихтер галит дистель атбарьян хаим кац эли коэн цахи ханегби офир акунис \
                юваль амсалем амир охана офир кац эти атия йоав киш давид битан керен барак шломо мики зохар орли \
                абекасис кети шитрит фатин мулла май голан яир лапид меир коэн элазар леви мейрав бен ари рам бен \
                барак йоав сегалович боаз топоровски лахав херцано владимир белиак рон кац нира шпак яаков марги йоав \
                бен цур михаэль хаим битон моше арбель инон азулай моше абутбуль уриэль бусо бенни ганц михаэль битон \
                алон шустер эйтан гинзбург яэль рон бен моше мерав михаэли гилад карив эфрат рам шефа ибтисам мараана \
                моше гафни ури маклев меир поруш яаков ашер исраэль эйхлер ицхак пиндрос нафтали беннетт матан кахана""";
        Hebrew service = new Hebrew();

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