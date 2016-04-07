package engine;

/**
 * This class is the setting of the game. Including the version, game name, and other
 * variables. it can be accessed in the start menu and can be changed in its own panel.
 */
public class setting {
    private boolean R18;
    private double version;
    private boolean auto_scroll;

    /**
     * Initialize the settings. Auto scroll is disabled
     */
    public setting() {
        R18 = false;
        version = 1.0;
        auto_scroll = false;
    }

    /**
     * Get the status of  R18 in this game
     * @return
     */
    public boolean get_R18() {
        return R18;
    }

    /**
     * Set R18, if necessary.
     * @param v18
     */
    public void set_R18(boolean v18) {
        R18 = v18;
    }

    /**
     * Get the version number of the game.
     * @return
     */
    public double get_version() {
        return version;
    }

    /**
     * Set the version number of the game
     * @param next_version
     */
    public void set_version(double next_version) {
        version = next_version;
    }

    /**
     * Get the scroll status of the game: whether the coversation is auto-scrolling or not.
     * @return
     */
    public boolean get_scroll_status() {
        return auto_scroll;
    }

    /**
     * Set the scrolling status of the game.
     * @param scroll
     * @return
     */
    public void set_scroll(boolean scroll) {
        auto_scroll = scroll;
    }
}
