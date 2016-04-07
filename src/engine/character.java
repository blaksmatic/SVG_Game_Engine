package engine;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * A engine.character is an important unit in AVG game. A engine.character has his/her name
 * A engine.character has his own pictures/or doesn't have any picture. If there is no picture, system will give him
 * default picture.
 * A engine.character has his own status. If necessary, such as the LOVE for the main_character
 * A Main_character is also a engine.character.
 */
public class character {

    private String c_name;//the engine.character name
    private ArrayList<String> c_picture;//the path for the engine.character pictures
    private int current_picture_index;// current engine.character picture index
    private Hashtable<String, Integer> c_status;//the status of this engine.character


    private String default_picture;

    /**
     * This constructor initialize the engine.character.
     * The engine.character must have a name. We will also initialize other status here
     *
     * @param name
     */
    public character(String name) {
        //every engine.character must have a name. it doesn't need to be unique.
        c_name = name;
        c_status = new Hashtable<String, Integer>();
        c_picture = new ArrayList<String>();
        current_picture_index = -1;
        default_picture = "engine_data/default_character_pic.jpg";
    }

    /**
     * Return the name of the engine.character. The name is allowed to change.
     *
     * @return c_name
     */
    public String get_name() {
        return c_name;
    }

    /**
     * This function changes the current name to new_name
     * This function will only be used in test, because the games will not allow
     * users to change their engine.character's name.
     *
     * @param new_name
     */
    public void set_name(String new_name) {
        c_name = new_name;
    }

    /**
     * This function returns the current picture of the engine.character.
     * if there is no picture for the current engine.character, return the default one.
     *
     * @return the path of the current picture for the engine.character.
     */
    public String get_current_c_picture() {
        if (current_picture_index == -1) {
            return default_picture;
        } else
            return c_picture.get(current_picture_index);
    }

    public void add_c_picture(String new_path) {
        c_picture.add(new_path);
        if (current_picture_index == -1) {
            current_picture_index = 0;
        }
    }

    /**
     * This function adds new status for the engine.character. By default, the number will be 0.
     * So there is a polymorphous function here
     *
     * @param new_st
     * @param number
     */
    public void add_new_status(String new_st, int number) {
        c_status.put(new_st, number);
    }

    /**
     * The brother of the function above.
     * Initial status is set to 0
     *
     * @param new_st
     */
    public void add_new_status(String new_st) {
        c_status.put(new_st, 0);
    }

    /**
     * This function updates the status of a engine.character. the status can be added and deduced, depending
     * on how the engine.character is set up.
     * If there is no such variable, then do not update it.
     *
     * @param key
     * @param num
     * @param add
     * @return
     */
    public boolean update_status(String key, int num, boolean add) {
        if (c_status.containsKey(key)) {
            if (add) {
                c_status.put(key, c_status.get(key) + num);
            } else
                c_status.put(key, c_status.get(key) - num);
            return true;
        } else
            return false;
    }

    /**
     * Compare if two engine.character is the same. In most of AVG games, engine.character must have different names.
     * It is also for the simplicity, or else I will make different ID's for different people.
     *
     * @param another
     * @return
     */
    @Override
    public boolean equals(Object another) {
        if (another == null) {
            return false;
        }
        if (another instanceof character) {
            character another_char = (character) another;
            if (another_char.get_name().equals(this.get_name())) {
                return true;
            } else
                return false;
        } else return false;
    }

    /**
     * This function saves all status into a string, and output to the outside.
     * This function prepares for the save function, and also works for the test.
     * <p/>
     * character_name
     * NAME
     * character_pictures
     * pic1
     * pic2
     * pic3
     * character_status
     * status1
     * value1
     * status2
     * value2
     * end
     *
     * @return
     */
    public String save_character() {
        StringBuilder sb = new StringBuilder();
        sb.append("character_name,");
        sb.append(c_name);
        sb.append(",character_pictures,");
        for (String pic : c_picture) {
            sb.append(pic);
            sb.append(",");
        }
        sb.append("character_status,");
        for (Map.Entry<String, Integer> status_entry : c_status.entrySet()) {
            sb.append(status_entry.getKey());
            sb.append(",");
            sb.append(status_entry.getValue());
            sb.append(",");
        }
        sb.append("end_token");
        return sb.toString();
    }


    /**
     * This function converts the saving file into a character. With this function and the previous function,
     * we can save the character as well as load a character.
     *
     * @param load_file
     * @return
     */
    public static character load_character(String load_file) {
        String[] tokens = load_file.split(",");
        character new_character = new character(tokens[1]);
        //now starts the character picture list
        int i = 3;
        while (!tokens[i].equals("character_status")) {
            new_character.add_c_picture(tokens[i]);
            i++;
        }
        i++;//now starts the status list
        while (!tokens[i].equals("end_token")) {
            new_character.add_new_status(tokens[i], Integer.parseInt(tokens[i + 1]));
            i = i + 2;
        }
        return new_character;
    }
}
