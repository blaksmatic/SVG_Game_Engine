package engine;

/**
 * This is a class for start menu. The spcial thing about start menu is that,
 * it has a title and has a link to the first screen.
 * the start menu also has the ability to set some global variable to the game.
 */
public class start_menu extends scene {
    public String title_name;
    public setting game_setting;

    /**
     * It extends the scene, because it can have choices
     *
     * @param start_name
     */
    public start_menu(String start_name) {
        super(start_name);
    }

    /**
     * Set the title of the game.
     * There can be several titles of the game, but there can be only one start menu
     *
     * @param title
     */
    public void set_title(String title) {
        title_name = title;
    }

    /**
     * Add a setting link to the start menu, so that we can acccess it from start menu
     *
     * @param set
     */
    public void connect_setting(setting set) {
        game_setting = set;
    }

    /**
     * return game_setting
     *
     * @return
     */
    public setting get_setting() {
        return game_setting;
    }

}
