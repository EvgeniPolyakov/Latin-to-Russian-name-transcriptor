package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RomanianTest {

    @Test
    void transcribe() {
        String text = """
                ada făcăeni târgu mureș barbu cezar camil mircea chișinău tecuci cioran ciurel dan eugen nicolae \
                ezeriș băneasa aref geta grigore gong caragea borgia george gheorghe geoagiu mihu irina matei botoșani \
                traian demian sofia iernut ploiești miersig ilie cocorăștii colț viile întorsura cîmpeni cîineni ion \
                ghiolț iuda porumboiu iuliuș ovidiu cujmir virgil manole nana teofil petre petru sanda izvoarele zoe \
                șercaia tatu cheț ury victor alexandru hydro înjurând pițigăiat zoofobul comandă vexat și tequila""";
        String transcription = """
                ада фэкэени тыргу муреш барбу чезар камил мирча кишинэу текуч чоран чурел дан эуджен николае \
                езериш бэняса ареф джета григоре гонг караджа борджа джордже георге джоаджу миху ирина матей ботошани \
                траян демьян софия ернут плоешти мьерсиг илие кокорэштий колц вийле ынторсура кымпени кыйнени йон \
                гьолц юда порумбою юльюш овидиу кужмир вирджил маноле нана теофил петре петру санда извоареле зое \
                шеркая тату кец ури виктор александру хидро ынжурынд пицигэят зоофобул командэ вексат ши текуйла""";
        Romanian service = new Romanian();

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