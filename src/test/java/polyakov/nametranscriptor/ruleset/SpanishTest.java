package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;
import polyakov.nametranscriptor.ruleset.rulsets.Spanish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpanishTest {

    @Test
    void transcribe() {
        String text = """
                arauco valladolid acuña benito habana cesar tulancingo salce costa rica veracruz ecatepec chinchilla \
                chihuahua madrid durango dzemul ensenada fuente torreón campeche fernando ángel gijón nogales gómez \
                guanajuato grande huelva hermosillo mahide honduras atahualpa teotihuacan imuris buenos aires almeida \
                galicia santiago riaño arriaga amplación aureliano julián bahía mejía garcía días farías aguascalientes \
                piedad viedma pliego riera corrientes priego la hierra daniel rosario riola nacional concepción ciudad \
                teziutlán jiutepec juan jalisco jhonny akumal tikal luis acapulco miguel trujillo valles carbellino \
                mendoza santander zúñiga logroño peña osmeña omelio orizaba pedro qispe quero quintana roo zoquiapan \
                quezon quito gaspar reynosa herrera corrida solsona ancash ushuaia toledo timoteo andratx atxondo \
                atzitzihuacán ujué buey guanajuato coahuila nicaragua caballuco guatemala guadalajara uruguay guerrero \
                querétaro quito aguilar camagüey san luis huichapan vicente vivir walamo ex ejido borox guadalupe y \
                calvo hidalgo costilla gallaga madryn monterrey guaymas yanga nayarit playa sayago toya ayerbe xavier \
                tulyehualco yoro banyoles yucatán pérez zacatecas zihuatanejo de azueta gabriel ezequiel guilliermo""";
        String transcription = """
                арауко вальядолид акунья бенито гавана сесар тулансинго сальсе коста рика веракрус экатепек чинчилья \
                чиуауа мадрид дуранго цемуль энсенада фуэнте торреон кампече фернандо анхель хихон ногалес гомес \
                гуанахуато гранде уэльва эрмосильо маиде гондурас атауальпа теотиуакан имурис буэнос айрес альмейда \
                галисия сантьяго рианьо арриага ампласьон аурелиано хулиан баия мехия гарсия диас фариас агуаскальентес \
                пьедад вьедма пльего риера корриентес приего ла ерра даниэль росарио риола насьональ консепсьон сьюдад \
                тесьютлан хьютепек хуан халиско джонни акумаль тикаль луис акапулько мигель трухильо вальес карбельино \
                мендоса сантандер суньига логроньо пенья осменья омелио орисаба педро киспе керо кинтана роо сокьяпан \
                кесон кито гаспар рейноса эррера коррида сольсона анкаш ушуайя толедо тимотео андрач ачондо ацициуакан \
                ухуэ буэй гуанахуато коауила никарагуа кабальюко гватемала гвадалахара уругвай герреро керетаро кито \
                агилар камагуэй сан луис уичапан висенте бибир валамо экс эхидо борокс гуадалупе и кальво идальго \
                костилья гальяга мадрин монтеррей гуаймас янга найярит плайя сайяго тойя аербе хавьер тульеуалько йоро \
                баньолес юкатан перес сакатекас сиуатанехо де асуэта габриэль эсекьель гильермо""";
        Spanish service = new Spanish();

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