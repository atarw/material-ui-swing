package unittest;

import integration.gui.test.AbstractTestGUI;
import mdlaf.utils.WrapperSwingUtilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.swing.*;

@RunWith(JUnit4.class)
public class WrapperSwingUtilitiesTest extends AbstractTestGUI {

    @Before
    public void initBeforeTest(){}

    @Test
    public void testInstanceMethodXXXXXNotNull(){
        //The thread is necessary because if you don't use a Swing tread, assert throw an exception
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JLabel label = new JLabel("foo");
                String string = WrapperSwingUtilities.getInstance().getClippedString(label, label.getFontMetrics(label.getFont()), label.getText(), 0);
                Assert.assertNotNull(string);
            }
        });
    }
}
