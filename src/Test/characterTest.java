package Test;


import engine.character;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

/**
 * The test for character
 */


/**
 * * character_name
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
 * end_token
 */
public class characterTest {

    @org.junit.Test
    public void testGet_current_c_picture() throws Exception {
        character test_c = new character("test");
        String to_print = test_c.save_character();
        System.out.println(to_print);
        assertTrue(to_print.equals("character_name,test,character_pictures,character_status,end_token"));
    }

    @org.junit.Test
    public void testAdd_new_status() throws Exception {
        character test_c = new character("test");
        test_c.add_new_status("battle", 10);
        test_c.add_new_status("leap");
        String to_print = test_c.save_character();
        System.out.println(to_print);
        //the hash table may be different every time
        assertTrue(to_print.equals("character_name,test,character_pictures,character_status,battle,10,leap,0,end_token")
                || to_print.equals("character_name,test,character_pictures,character_status,leap,0,battle,10,end_token"));
    }

    @org.junit.Test
    public void testUpdate_status() throws Exception {
        character test_c = new character("test");
        test_c.add_new_status("battle", 10);
        test_c.update_status("battle", 20, true);
        test_c.update_status("battle", 5, false);
        String to_print = test_c.save_character();
        System.out.println(to_print);
        assertTrue(to_print.equals("character_name,test,character_pictures,character_status,battle,25,end_token"));
    }

    @org.junit.Test
    public void testSave_character() throws Exception {
        character test_c = new character("test");
        test_c.add_new_status("battle", 50);
        String to_print = test_c.save_character();
        System.out.println(to_print);
        assertTrue(to_print.equals("character_name,test,character_pictures,character_status,battle,50,end_token"));

    }

    @org.junit.Test
    public void testLoad_character() throws Exception {
        character test_c = new character("test");
        test_c.add_new_status("battle", 50);
        test_c.add_new_status("fun", 20);
        test_c.add_c_picture("engine_data/monkey.jpg");
        test_c.add_c_picture("engine_data/dog.jpg");
        String to_print = test_c.save_character();
        character test_2 = character.load_character(to_print);
        String to_print_2 = test_2.save_character();
        assertTrue(to_print.equals(to_print_2));
    }
}


