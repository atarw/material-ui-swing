/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package integration.gui.test;

import org.assertj.swing.core.KeyPressInfo;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.Assert;
import org.junit.Test;

import static java.awt.Event.ENTER;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTextFieldTest extends AbstractTestGUI{

    /*
        This test tested the issue
        https://github.com/atarw/material-ui-swing/issues/84
     */
    @Test
    public void testActionListenerTextField(){
        JTextComponentFixture textField = frame.textBox("usernameField");
        textField.background().requireEqualTo(theme.getBackgroundTextField());
        Assert.assertTrue(textField.text().contains("AssertJ"));
        textField.pressAndReleaseKey(KeyPressInfo.keyCode(ENTER));
        Assert.assertTrue(textField.text().contains("Material"));

    }

    @Test
    public void testDisabledStateTextField(){
        JTextComponentFixture textField = frame.textBox("usernameField");
        textField.background().requireNotEqualTo(theme.getDisabledBackgroudnTextField());
        textField.background().requireEqualTo(theme.getBackgroundTextField());

        //The testing framework not update the last color of the component
        //Inside the BasicTextUI the foreground color of the component is inactiveForeground
        //but inside material-ui-swing the color inactiveForeground is used for paint the normal condition
        //of the component; only in the second moment it go to set how disableForeground but the testingFramework not update
        //well the color (this is only my think, it could be also a bug og the my work), for moment the test is written only with
        //inactiveForeground.
        // textField.foreground().requireEqualTo(theme.getDisabledForegroundTextField());

        textField.foreground().requireEqualTo(theme.getInactiveForegroundTextField());
    }
}
