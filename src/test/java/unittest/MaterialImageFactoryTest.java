package unittest;

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import junit.framework.TestCase;
import mdlaf.utils.MaterialImageFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

import static java.awt.GraphicsEnvironment.isHeadless;
import static org.junit.Assume.assumeFalse;

public class MaterialImageFactoryTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialImageFactory.class);

    @BeforeClass
    public static void beforeClass() throws Exception {
        assumeFalse("Image tests can't run in headless env.", isHeadless());
    }

    @Test
    public void testIconFontSwingIconsOne() throws Throwable{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Icon icon = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
                TestCase.assertNotNull(icon);
            }
        });
    }

    @Test
    public void testIconFontSwingIconsTwo()  throws Throwable{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
                Icon iconTwo = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
                TestCase.assertEquals(iconOne, iconTwo);
            }
        });
    }

    @Test
    public void testIconFontSwingIconsThree() throws Throwable{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
                Icon iconTwo = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, Color.BLUE);
                TestCase.assertNotSame(iconOne, iconTwo);
            }
        });
    }

    @Test
    public void testIconFontSwingIconsFour() throws Throwable{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 20, Color.BLUE);
                Icon iconTwo = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, Color.BLUE);
                TestCase.assertEquals(iconOne, iconTwo);
            }
        });
    }

    @Test
    public void testIconFontSwingExceptionOne() throws Throwable{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Icon iconOne = MaterialImageFactory.getInstance().getImage(null, 20, Color.BLUE);
                    TestCase.fail("without exceptions");
                }catch (IllegalArgumentException e){
                    LOGGER.debug(e.getMessage());
                    TestCase.assertTrue(e.getMessage().contains("Icon code"));
                    TestCase.assertFalse(e.getMessage().contains("Dimension"));
                }
            }
        });

    }

    @Test
    public void testIconFontSwingExceptionTwo() throws Throwable{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT, -20, Color.BLUE);
                    TestCase.fail("without exceptions");
                }catch (IllegalArgumentException e){
                    LOGGER.debug(e.getMessage());
                    TestCase.assertFalse(e.getMessage().contains("Icon code"));
                    TestCase.assertTrue(e.getMessage().contains("Dimension"));
                }
            }
        });
    }

    @Test
    public void testIconFontSwingExceptionThree() throws Throwable{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Icon iconOne = MaterialImageFactory.getInstance().getImage(null, -20, Color.BLUE);
                    TestCase.fail("without exceptions");
                }catch (IllegalArgumentException e){
                    LOGGER.debug(e.getMessage());
                    TestCase.assertTrue(e.getMessage().contains("Icon code"));
                    TestCase.assertTrue(e.getMessage().contains("Dimension"));
                }
            }
        });

    }
}
