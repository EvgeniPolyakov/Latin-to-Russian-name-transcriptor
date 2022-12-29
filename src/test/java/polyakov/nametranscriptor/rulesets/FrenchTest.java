package polyakov.nametranscriptor.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FrenchTest {

    @Test
    void transcribe() {
        String text = """
                yeuse lauraët liart cognac bayard chaillac troyat caen nationale d aéronautique air france calais saint \
                nazaire épiais raspail chénérailles ain aincourt aingoulaincourt saintes paramé ham camp pamfou \
                damville thaon l etape artaud claude aymé du bellay bruliay layon pays de bray bateau lavoir camus \
                francis mont blanc franc marc leclerc besançon accord occidental christian auch boucq aspects de la \
                gounod richard angoulême charles jacques villedieu edmond oueste rené richelieu écommoy eno \
                citroën fougères dépêche bordeaux eiffel beine aureille einvaux ouestembert emile château d yquem \
                inghem alençon lorient science et vie parisien lucien agen eugène peuple ambérieux verneuil eymoutiers \
                aveyron pleyel foucault auguste germain cherbourg georges leggewie agnesse boulogne guillaume guy \
                hachette cahiers du cinéma ici baïze adelaïeau daumier villedieu montesquieu soleil rambouiller tilly \
                villon viller aureille camille image imling climbach dimbsthal imphy pantine innerver ingres hadouin \
                cahingt romorantin michelin jaouen kessel gilbert léon sauldre chaulnes arnould herbault milhaud \
                graulhet guillaume riom inghem léon rhône œutrange sacré cœur citroën antoine foi pointe louvre lognou \
                troyes oyeu pierre fécamp philippe quinet jacques renoir roger eymoutiers serrault perrault serge \
                alexis jaurès fouras callas cahu lavoisier jacques tours sceaux scapin boussenard scherer rousseau \
                bresson daudet goncourt tchéky tchavolo libération jeantioux leumbres lunan huningue orgueuil brunnen \
                unverre mehun hundling châteaudun belseunce lebrun victor verlaine gwénaël watteau beauville \
                villedubert villejuif villers villey le sec villerville villette anthon villez xanrey xavier exilles \
                xaronval auxerre villeurbane yeuse hyevr pleyel yves alyn jamyn vierzon mawlaz""";
        String transcription = """
                йез лораэ льяр коньяк байар шайак труайа кан насьональ д аэронотик эр франс кале сен назер эпье распай \
                шенерай эн энкур энгуленкур сен параме ам кан панфу данвиль тан л этап арто клод эме дю белле брюлье \
                лайон паи де бре бато лавуар камю франсис мон блан фран мар леклер безансон аккор оксиданталь кристиан \
                ош бук аспе де ла гуно ришар ангулем шарль жак вильдье эдмон уэст рене ришелье экоммуа эно \
                ситроэн фужер депеш бордо эйффель бэн орей энво уэстамбер эмиль шато д икем энгем алансон лорьян сьянс \
                э ви паризьен люсьен ажен эжен пепль амберье верней эмутье аверон плейель фуко огюст жермен шербур \
                жорж легжеви аньесс булонь гийом ги ашетт кайе дю синема иси баиз аделайо домье вильдье монтескье \
                солей рамбуйер тийи вийон виллер орей камиль имаж имлен клембаш дембсталь эмфи пантин иннервер энгр \
                адуэн каэнг роморантен мишлен жауэн кессель жильбер леон содр шон арну эрбо мийо гроле гийом рьом \
                энгем леон рона этранж сакре кер ситроэн антуан фуа пуэнт лувр лонью труа уайе пьер фекан филипп кине \
                жак ренуар рожер эмутье серро перро серж алексис жорес фура калла каю лавуазье жак тур со скапен \
                буссенар шерер руссо брессон доде гонкур чеки чаволо либерасьон жансью лембр люнан юненг оргейль \
                брюннен энверр меэн эндлен шатоден бельзенс лебрен виктор верлен гвенаэль ватто бовиль вильдюбер \
                вильжюиф виллер вилле ле сек виллервиль виллетт антон вилле ксанре ксавье эксилль ксаронваль осер \
                виллербан йез йевр плейель ив ален жамен вьерзон мавлаз""";
        French service = new French();

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