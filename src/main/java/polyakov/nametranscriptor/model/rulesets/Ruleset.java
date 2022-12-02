package polyakov.nametranscriptor.model.rulesets;

public abstract class Ruleset {

    public String transcribeText(String text) {
        String[] names = text.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : names) {
            String transcription = transcribeName(w);
            result.append(transcription).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    abstract String transcribeName(String text);
}