package engine;

import java.util.ArrayList;

/**
 * This class works as a single engine.scene in the game
 * A engine.scene is the basic unit in a game.
 * A engine.scene starts from one picture, and ends at another picture
 * A engine.scene have have long story, but only one picture is allowed
 * A engine.scene is only one branch. That is, if the player has chosen a choice,
 * even if the background picture doesn't change, it is another engine.scene.
 * <p/>
 * <p/>
 * ##################################
 * #
 * # #This is my picture
 * #
 * #
 * # #This is my conversations
 * ##################################
 */
public class scene {
    private String scene_name;
    private String bg_picture;
    private ArrayList<scene> choices;
    private ArrayList<character> characters;
    private ArrayList<String> lines;

    public scene(String name) {
        scene_name = name;
        bg_picture = "engine_data/default_scene_bg.jpg";
        choices = new ArrayList<scene>();
        lines = new ArrayList<String>();
        characters = new ArrayList<character>();
    }

    /**
     * This function sets a background picture for the engine.scene.
     * It will overwrite the previous picture.
     *
     * @param path
     */
    public void set_bg_picture(String path) {
        bg_picture = path;
    }

    /**
     * add new characters into this engine.scene. The main purpose of characters is that
     * we can use their background pictures and change their status (such as if they are dead)
     *
     * @param new_character
     */
    public void add_character(character new_character) {
        characters.add(new_character);
    }

    /**
     * add a choice to the current engine.scene, which is like a linked list
     * so that users can choose the next engine.scene and go to the next engine.scene
     * The name of the choices must be different, or else it will not be added
     *
     * @param next_scene
     */
    public boolean add_choices(scene next_scene) {
        String next_name = next_scene.get_name();
        if (get_choice(next_name) != null) {
            return false;
        }
        choices.add(next_scene);
        return true;
    }

    /**
     * return the name of the engine.scene.
     *
     * @return
     */
    public String get_name() {
        return scene_name;
    }

    /**
     * return the path of the background picture.
     *
     * @return
     */
    public String get_bg_pic() {
        return bg_picture;
    }

    /**
     * get a engine.scene by its name. This function will only be used in the test and the loading part of the game
     * For the normal cut engine.scene, we will use the function above.
     *
     * @param scene_name
     */
    public scene get_choice(String scene_name) {
        for (scene this_scene : choices) {
            if (this_scene.get_name().equals(scene_name)) {
                return this_scene;
            }
        }
        //this situation will not happen, theoretically.
        return null;
    }


    /**
     * This function adds a new engine.line into this engine.scene. All the historical engine.line is preserved.
     * It is the update method
     *
     * @param new_line
     */
    public void add_line(String new_line) {
        this.lines.add(new_line);
    }

    /**
     * This method will clean the lines and add new lines to it. it will be used in engine's text editor.
     *
     * @param new_line
     */
    public void overwrite_line(String new_line) {
        lines = new ArrayList<String>();
        lines.add(new_line);
    }

    /**
     * This function return lines, one by one.
     *
     * @return
     */
    public ArrayList<String> get_lines() {
        return lines;
    }


}
