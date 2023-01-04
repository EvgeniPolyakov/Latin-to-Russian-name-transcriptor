package polyakov.nametranscriptor.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ChineseTest {

    @Test
    void transcribe() {
        String text = """
                han jiaqi peng peng huang zihao wu shaocong jiang shenglong zhu chenjie jiang guangtai wen jiabao xu \
                haofeng he yupeng liang shaowen su shihao tao qianglong dai wai tsun liu ruofan xu yue chen guokang \
                huang jiahui yao xuchen liu zhurun tan long fang hao xu jie hu mingxuan zhao jiwei zhang zhenlin zhou \
                peng ren junfei liu chuanxing shen zijie zhou qi lu wenbo wang shaojie wu qian huainan anhui kaifeng \
                tiananmen guangchang changsha chen boda yuan shikai huang zunxian tianjin lu xun wang chuqin lao kang""";
        String transcription = """
                хань цзяци пэн пэн хуан цзыхао у шаоцун цзян шэнлун чжу чэньцзе цзян гуантай вэнь цзябао сюй хаофэн \
                хэ юйпэн лян шаовэнь су шихао тао цянлун дай вай цунь лю жофань сюй юэ чэнь гокан хуан цзяхуэй яо \
                сюйчэнь лю чжужунь тань лун фан хао сюй цзе ху минсюань чжао цзивэй чжан чжэньлинь чжоу пэн жэнь \
                цзюньфэй лю чуаньсин шэнь цзыцзе чжоу ци лу вэньбо ван шаоцзе у цянь хуайнань аньхуэй кайфэн \
                тяньаньмэнь гуанчан чанша чэнь бода юань шикай хуан цзуньсянь тяньцзинь лу сюнь ван чуцинь лао кан""";
        Chinese service = new Chinese();

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