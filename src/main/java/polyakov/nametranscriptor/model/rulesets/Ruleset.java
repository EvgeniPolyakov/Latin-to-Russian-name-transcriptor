package polyakov.nametranscriptor.model.rulesets;

public abstract class Ruleset {
    private static final String REGEX = "[!#@%^:;+._,?|/{}~&№ ]";

    public String transcribeText(String text, int mode) {
        String[] names = text.split(String.format("(?=%s)|(?<=%s)", REGEX, REGEX));
        StringBuilder result = new StringBuilder();
        for (String w : names) {
            boolean isAllCaps = checkAllCaps(w);
            if (isAllCaps) {
                w = w.toLowerCase();
            }
            String transcription = transcribeName(w, mode);
            if (isAllCaps) {
                transcription = transcription.toUpperCase();
            }
            result.append(transcription);
        }
        return result.toString();
    }

    private boolean checkAllCaps(String w) {
        return (w.equals(w.toUpperCase()));
    }

    abstract String transcribeName(String text, int mode);
}