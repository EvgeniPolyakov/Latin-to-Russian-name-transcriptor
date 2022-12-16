package polyakov.nametranscriptor.rulesets;

public interface Ruleset {

    String transcribe(String text, int mode);

    String getName();
}