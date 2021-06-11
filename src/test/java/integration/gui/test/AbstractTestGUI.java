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

import integration.gui.mock.DemoGUITest;
import java.awt.*;
import javax.swing.*;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialTheme;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;

/** @author https://github.com/vincenzopalazzo */
public abstract class AbstractTestGUI extends AssertJSwingTestCaseTemplate {

  protected FrameFixture frame;
  protected MaterialTheme theme;

  @BeforeClass
  public static final void setUpOnce() {
    Assume.assumeFalse(
        "Automated UI Test cannot be executed in headless environment",
        GraphicsEnvironment.isHeadless());
    FailOnThreadViolationRepaintManager.install();
  }

  @Before
  public final void setUp() {
    this.setUpRobot();
    onBeforeGuiSetUp();
    // initialize the graphical user interface
    DemoGUITest mainWindow =
        GuiActionRunner.execute(
            new GuiQuery<DemoGUITest>() {

              @Override
              protected DemoGUITest executeInEDT() throws Exception {
                DemoGUITest demoGUITest = new DemoGUITest();
                demoGUITest.initComponent();
                return demoGUITest;
              }
            });
    this.frame = new FrameFixture(this.robot(), mainWindow);
    this.frame.show();
    onSetUp();
    LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
    if (lookAndFeel instanceof MaterialLookAndFeel) {
      MaterialLookAndFeel materialLookAndFeel = (MaterialLookAndFeel) lookAndFeel;
      theme = materialLookAndFeel.getTheme();
    } else {
      throw new Error("Material l&f didn't set");
    }
  }

  protected void onBeforeGuiSetUp() {
    // default: everything is already configured
  }

  protected void onSetUp() {
    // default: everything is already set up
  }

  @After
  public final void tearDown() {
    try {
      onTearDown();
      this.frame = null;
    } finally {
      cleanUp();
    }
  }

  protected void onTearDown() {
    // default: nothing more to tear down
  }
}
