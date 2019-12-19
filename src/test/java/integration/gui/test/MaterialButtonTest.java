package integration.gui.test;

import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialTheme;
import mdlaf.utils.MaterialColors;
import org.assertj.swing.fixture.JButtonFixture;
import org.junit.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialButtonTest extends AbstractTestGUI {


    @Test
    public void testButtonColorBackgroundDefaultWhenIsClicked() {
        JButtonFixture buttonDefault = frame.button("buttonDefault");
        buttonDefault.background().requireEqualTo(theme.getButtonDefaultBackgroundColor());
        buttonDefault.click();
        buttonDefault.background().requireEqualTo(theme.getButtonDefaultBackgroundColor());
    }

    @Test
    public void testButtonUndoColorBackgroundWhenIsClicked() {
        JButtonFixture buttonUndo = frame.button("buttonUndo");
        buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
    }

    @Test
    public void testButtonNormalColorBackgroundWhenIsClicked() {
        JButtonFixture buttonUndo = frame.button("buttonNormal");
        buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
        buttonUndo.click();
        buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
    }

    @Test
    public void testButtonDisableColorBackgroundForegroundWithChangeStatus() {
        JButtonFixture buttonDisabled = frame.button("buttonDisabled");
        buttonDisabled.background().requireEqualTo(MaterialColors.COSMO_LIGHT_ORANGE);
        buttonDisabled.foreground().requireEqualTo(theme.getButtonTextColor());
        buttonDisabled.click();
        buttonDisabled.background().requireEqualTo(theme.getButtonDisabledBackground());
        buttonDisabled.foreground().requireNotEqualTo(theme.getButtonTextColor());
    }

    @Test
    public void testButtonUndoColorBackgroundWithChangeStatus() {
        JButtonFixture buttonUndo = frame.button("buttonUndo");
        buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
        buttonUndo.foreground().requireEqualTo(theme.getButtonTextColor());
        buttonUndo.click();
        buttonUndo.background().requireEqualTo(theme.getButtonDisabledBackground());
        buttonUndo.foreground().requireNotEqualTo(theme.getButtonTextColor());
    }

    //Test button focus

    @Test
    public void testButtonNormalColorBackgroundWhenIsFocused() {
        JButtonFixture buttonUndo = frame.button("buttonNormal");
        buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
        buttonUndo.foreground().requireEqualTo(theme.getButtonTextColor());
        buttonUndo.focus();
        buttonUndo.background().requireEqualTo(theme.getButtonBackgroundColor());
        buttonUndo.foreground().requireEqualTo(theme.getButtonTextColor());
    }

    @Test
    public void testButtonColorBackgroundDefaultWhenIsFocused() {
        JButtonFixture buttonDefault = frame.button("buttonDefault");
        buttonDefault.background().requireEqualTo(theme.getButtonDefaultBackgroundColor());
        buttonDefault.foreground().requireEqualTo(theme.getButtonDefaultTextColor());
        buttonDefault.focus();
        buttonDefault.background().requireEqualTo(theme.getButtonDefaultBackgroundColor());
        buttonDefault.foreground().requireEqualTo(theme.getButtonDefaultTextColor());
    }
}
