package unittest;

import junit.framework.TestCase;
import mdlaf.utils.MaterialFontFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.swing.plaf.FontUIResource;
import java.awt.*;

import static java.awt.GraphicsEnvironment.isHeadless;
import static org.junit.Assume.assumeFalse;

@RunWith(JUnit4.class)
public class MaterialFontFactoryTest {

    private static final String PATH = "/fonts/noto-sans/";
    private static final String BOLD_NAME = "NotoSans-Bold.ttf";
    private static final String REGULAR_NAME = "NotoSans-Regular.ttf";
    private static final String MEDIUM_NAME = "NotoSans-Medium.ttf";
    private static final String ITALIC_NAME = "NotoSans-Italic.ttf";

    @BeforeClass
    public static void beforeClass() throws Exception {
        assumeFalse("Font tests can't run in headless env.", isHeadless());
    }

    @Test
    public void testWithString(){
        Font fontOne = MaterialFontFactory.getInstance().getFontWithPath(PATH + BOLD_NAME);
        Font fontTwo = MaterialFontFactory.getInstance().getFontWithPath(PATH + BOLD_NAME);
        TestCase.assertNotNull(fontOne);
        TestCase.assertNotNull(fontTwo);
        TestCase.assertEquals(fontOne, fontTwo);
        TestCase.assertTrue(fontOne instanceof FontUIResource);
        TestCase.assertTrue(fontTwo instanceof FontUIResource);
    }

    @Test
    public void testWithInputStream(){
        Font fontOne = MaterialFontFactory.getInstance().getFontWithStream(getClass().getResourceAsStream(PATH + BOLD_NAME));
        Font fontTwo = MaterialFontFactory.getInstance().getFontWithStream(getClass().getResourceAsStream(PATH + BOLD_NAME));
        TestCase.assertNotNull(fontOne);
        TestCase.assertNotNull(fontTwo);
        TestCase.assertEquals(fontOne, fontTwo);
        TestCase.assertTrue(fontOne instanceof FontUIResource);
        TestCase.assertTrue(fontTwo instanceof FontUIResource);
    }

    @Test
    public void testWithDefaultCall(){
        Font fontOne = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD);
        Font fontTwo = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD);
        TestCase.assertNotNull(fontOne);
        TestCase.assertNotNull(fontTwo);
        TestCase.assertEquals(fontOne, fontTwo);
        TestCase.assertTrue(fontOne instanceof FontUIResource);
        TestCase.assertTrue(fontTwo instanceof FontUIResource);
    }
}
