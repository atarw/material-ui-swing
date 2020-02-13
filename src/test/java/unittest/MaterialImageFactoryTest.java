package integration.gui.test.unittest;

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import junit.framework.TestCase;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialImageFactory;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class MaterialImageFactoryTest {

    @Test
    public void testIconFontSwingIconsOne(){
        Icon icon = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
        TestCase.assertNotNull(icon);
    }

    @Test
    public void testIconFontSwingIconsTwo(){
        Icon iconOne = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
        Icon iconTwo = MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_DOWN, 25, Color.BLUE);
        TestCase.assertEquals(iconOne, iconTwo);
    }
}
