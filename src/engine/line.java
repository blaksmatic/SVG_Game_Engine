package engine;

/**
 * A engine.line has a string and a engine.character who speaks this engine.line. the default setting
 * is that the engine.line is the Voiceover.
 */
public class line {
    private character character_current;
    private String line;

    /**
     * The first situation is that we have a engine.character and his engine.line.
     * @param cha
     * @param newLine
     */
    public line(character cha, String newLine) {
        character_current = cha;
        line = newLine;
    }

    /**
     * The second situation is that we use the default engine.character: the voiceover
     * @param newLine
     */
    public line(String newLine) {
        character_current = new character("voice_over");
        line = newLine;
    }

    /**
     * return the engine.line in this engine.line
     * @return
     */
    public String get_line() {
        return line;
    }

    /**
     * Return the engine.character in this engine.line.
     * @return
     */
    public character get_character() {
        return character_current;
    }

}
