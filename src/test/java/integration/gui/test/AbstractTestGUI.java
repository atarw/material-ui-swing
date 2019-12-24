package integration.gui.test;

import integration.gui.mock.DemoGUITest;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialLiteTheme;
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

import javax.swing.*;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public abstract class AbstractTestGUI extends AssertJSwingTestCaseTemplate {

    protected FrameFixture frame;
    protected MaterialTheme theme;

    @BeforeClass
    public static final void setUpOnce() {
        Assume.assumeFalse("Automated UI Test cannot be executed in headless environment", GraphicsEnvironment.isHeadless());
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public final void setUp() {
        this.setUpRobot();
        // initialize the graphical user interface
        DemoGUITest mainWindow = GuiActionRunner.execute(new GuiQuery<DemoGUITest>() {

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

    /**
     * Subclasses that need to clean up resources can do so in this method. Called as <strong>first action</strong> during {@link #tearDown()}.
     */
    protected void onTearDown() {
        // default: nothing more to tear down
    }
}
