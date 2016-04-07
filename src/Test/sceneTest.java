package Test;

import engine.scene;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 4/6/16.
 */
public class sceneTest {

    @Test
    public void testSet_bg_picture() throws Exception {
        scene test = new scene("test_scene");
        test.set_bg_picture("engine_data/default_bg.jpg");
        assertTrue(test.get_bg_pic().equals("engine_data/default_bg.jpg"));
    }

    @Test
    public void testGet_name() throws Exception {
        scene test = new scene("test_scene");
        assertTrue(test.get_name().equals("test_scene"));
    }

    @Test
    public void testGet_bg_pic() throws Exception {
        scene test = new scene("test_scene");
        test.set_bg_picture("engine_data/default_bg.jpg");
        test.set_bg_picture("engine_data/default_bg2.jpg");
        assertTrue(test.get_bg_pic().equals("engine_data/default_bg2.jpg"));
    }

    @Test
    public void testGet_choice() throws Exception {
        scene another = new scene("another_scene");
        scene another2 = new scene("another_scene2");
        scene test = new scene("test_scene");
        test.set_bg_picture("engine_data/default_bg.jpg");
        test.add_choices(another);
        test.add_choices(another2);
        assertTrue(test.get_choice("another_scene2").get_name().equals("another_scene2"));

        //test add same name scene
        scene another3 = new scene("another_scene3");
        scene another4 = new scene("another_scene3");
        scene test2 = new scene("test_scene");
        test2.set_bg_picture("engine_data/default_bg.jpg");
        test2.add_choices(another3);
        assertFalse(test2.add_choices(another4));
    }


}