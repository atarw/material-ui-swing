package integration.gui.test;

import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialTheme;
import mdlaf.utils.MaterialColors;
import org.assertj.swing.core.KeyPressInfo;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.Assert;
import org.junit.Test;

import static java.awt.Event.ENTER;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialPasswordFieldTest extends AbstractTestGUI{

    /*
        This test tested the issue
        https://github.com/atarw/material-ui-swing/issues/84
     */
    @Test
    public void testActionListenerTextField(){
        JTextComponentFixture passwordField = frame.textBox("passwordField");
        passwordField.background().requireEqualTo(theme.getBackgroundTextField());
        Assert.assertTrue(passwordField.text().isEmpty());
        passwordField.pressAndReleaseKey(KeyPressInfo.keyCode(ENTER));
        Assert.assertTrue(passwordField.text().contains("password"));
    }
}
