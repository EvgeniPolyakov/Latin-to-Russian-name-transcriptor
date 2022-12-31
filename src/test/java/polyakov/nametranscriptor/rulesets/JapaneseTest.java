package polyakov.nametranscriptor.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JapaneseTest {

    @Test
    void transcribe() {
        String text = """
                eiji kawashima miki yamane shogo taniguchi ko itakura yuto nagatomo wataru endo gaku shibasaki ritsu \
                dōan kaoru mitoma takumi minamino takefusa kubo shūichi gonda hidemasa morita jun'ya ito daichi kamada \
                takehiro tomiyasu ao tanaka takuma asano hiroki sakai shuto machino ayase ueda maya yoshida yuki soma \
                daizen maeda hiroki ito hajime moriyasu andon gemba genchi gembutsu goesu hansei heijunka hoshin kanri \
                jidōka kairyō kaizen kamban mono to jouhou no nagarezu muda mura muri nemavashi oobeya poka yoke \
                seiketsu seiri seisō seiton shitsuke tsurube rōmaji fujisan ocha otya chiji tizi chijimu tizimu""";
        String transcription = """
                эйдзи кавасима мики яманэ сего танигути ко итакура юто нагатомо ватару эндо гаку сибасаки рицу доан \
                каору митома такуми минамино такэфуса кубо сюити гонда хидэмаса морита дзюнъя ито дайти камада \
                такэхиро томиясу ао танака такума асано хироки сакай сюто матино аясэ уэда мая есида юки сома дайдзэн \
                маэда хироки ито хадзимэ мориясу андон гэмба гэнти гэмбуцу гоэсу хансэй хэйдзюнка хосин канри дзидока \
                кайре кайдзэн камбан моно то дзехо но нагарэдзу муда мура мури нэмаваси обэя пока екэ сэйкэцу сэйри \
                сэйсо сэйтон сицукэ цурубэ ромадзи фудзисан отя отя тидзи тидзи тидзиму тидзиму""";
        Japanese service = new Japanese();

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