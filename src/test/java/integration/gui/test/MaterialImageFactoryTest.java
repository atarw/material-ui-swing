package integration.gui.test;

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import junit.framework.TestCase;
import mdlaf.utils.MaterialImageFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

//TODO write the with assertj
public class MaterialImageFactoryTest extends AbstractTestGUI{

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialImageFactory.class);

    @Test
    public void testIconFontSwingIconsOne() throws Throwable{
        Icon icon = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
        TestCase.assertNotNull(icon);
    }

    @Test
    public void testIconFontSwingIconsTwo()  throws Throwable{
        Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
        Icon iconTwo = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
        TestCase.assertEquals(iconOne, iconTwo);
    }

    @Test
    public void testIconFontSwingIconsThree() throws Throwable{
        Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
        Icon iconTwo = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, Color.BLUE);
        TestCase.assertNotSame(iconOne, iconTwo);
    }

    @Test
    public void testIconFontSwingIconsFour() throws Throwable{
        Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 20, Color.BLUE);
        Icon iconTwo = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, Color.BLUE);
        TestCase.assertEquals(iconOne, iconTwo);
    }

    @Test
    public void testIconFontSwingExceptionOne() throws Throwable{
        try{
            Icon iconOne = MaterialImageFactory.getInstance().getImage(null, 20, Color.BLUE);
            TestCase.fail("without exceptions");
        }catch (IllegalArgumentException e){
            LOGGER.debug(e.getMessage());
            TestCase.assertTrue(e.getMessage().contains("Icon code"));
            TestCase.assertFalse(e.getMessage().contains("Dimension"));
        }
    }

    @Test
    public void testIconFontSwingExceptionTwo() throws Throwable{
        try{
            Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT, -20, Color.BLUE);
            TestCase.fail("without exceptions");
        }catch (IllegalArgumentException e){
            LOGGER.debug(e.getMessage());
            TestCase.assertFalse(e.getMessage().contains("Icon code"));
            TestCase.assertTrue(e.getMessage().contains("Dimension"));
        }
    }

    @Test
    public void testIconFontSwingExceptionThree() throws Throwable{
        try{
            Icon iconOne = MaterialImageFactory.getInstance().getImage(null, -20, Color.BLUE);
            TestCase.fail("without exceptions");
        }catch (IllegalArgumentException e){
            LOGGER.debug(e.getMessage());
            TestCase.assertTrue(e.getMessage().contains("Icon code"));
            TestCase.assertTrue(e.getMessage().contains("Dimension"));
        }
    }
}
