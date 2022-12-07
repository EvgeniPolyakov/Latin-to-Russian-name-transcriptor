package polyakov.nametranscriptor.model.rulesets;

public interface Ruleset {

    String transcribe(String text, int mode);
}