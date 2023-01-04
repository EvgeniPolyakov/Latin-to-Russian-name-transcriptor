package polyakov.nametranscriptor.ruleset;

public interface Ruleset {

    String transcribe(String text, int mode);

    String getName();
}