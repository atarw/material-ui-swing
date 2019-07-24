package integration.gui.test;

import mdlaf.utils.MaterialColors;
import org.assertj.swing.fixture.JButtonFixture;
import org.junit.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialButtonTest extends AbstractTestGUI {

    @Test
    public void testButtonColorBackgroundDefoultWhenIsClicked() {
        JButtonFixture buttonDefoult = frame.button("buttonDefault");
        buttonDefoult.background().requireEqualTo(MaterialColors.LIGHT_BLUE_500);
        buttonDefoult.click();
        buttonDefoult.background().requireEqualTo(MaterialColors.LIGHT_BLUE_500);
    }

    @Test
    public void testButtonUndoColorBackgroundWhenIsClicked() {
        JButtonFixture buttonUndo = frame.button("buttonUndo");
        buttonUndo.background().requireEqualTo(MaterialColors.GRAY_200);
    }

    @Test
    public void testButtonNormalColorBackgroundWhenIsClicked() {
        JButtonFixture buttonUndo = frame.button("buttonNormal");
        buttonUndo.background().requireEqualTo(MaterialColors.GRAY_200);
        buttonUndo.click();
        buttonUndo.background().requireEqualTo(MaterialColors.GRAY_200);
    }

    @Test
    public void testButtonDisableColorBackgroundForegroundWithChangeStatus() {
        JButtonFixture buttonDisabled = frame.button("buttonDisabled");
        buttonDisabled.background().requireEqualTo(MaterialColors.COSMO_LIGHT_ORANGE);
        buttonDisabled.foreground().requireEqualTo(MaterialColors.COSMO_BLACK);
        buttonDisabled.click();
        buttonDisabled.background().requireEqualTo(MaterialColors.COSMO_DARK_GRAY);
        buttonDisabled.foreground().requireEqualTo(MaterialColors.BLACK);
    }

    @Test
    public void testButtonUndoColorBackgroundWithChangeStatus() {
        JButtonFixture buttonUndo = frame.button("buttonUndo");
        buttonUndo.background().requireEqualTo(MaterialColors.GRAY_200);
        buttonUndo.foreground().requireEqualTo(MaterialColors.COSMO_BLACK);
        buttonUndo.click();
        buttonUndo.background().requireEqualTo(MaterialColors.COSMO_DARK_GRAY);
        buttonUndo.foreground().requireEqualTo(MaterialColors.BLACK);
    }

    //Test button focus

    @Test
    public void testButtonNormalColorBackgroundWhenIsFocused() {
        JButtonFixture buttonUndo = frame.button("buttonNormal");
        buttonUndo.background().requireEqualTo(MaterialColors.GRAY_200);
        buttonUndo.foreground().requireEqualTo(MaterialColors.COSMO_BLACK);
        buttonUndo.focus();
        buttonUndo.background().requireEqualTo(MaterialColors.GRAY_200);
        buttonUndo.foreground().requireEqualTo(MaterialColors.COSMO_BLACK);
    }

    @Test
    public void testButtonColorBackgroundDefoultWhenIsFocused() {
        JButtonFixture buttonDefoult = frame.button("buttonDefault");
        buttonDefoult.background().requireEqualTo(MaterialColors.LIGHT_BLUE_500);
        buttonDefoult.foreground().requireEqualTo(MaterialColors.WHITE);
        buttonDefoult.focus();
        buttonDefoult.background().requireEqualTo(MaterialColors.LIGHT_BLUE_500);
        buttonDefoult.foreground().requireEqualTo(MaterialColors.WHITE);
    }

    @Test
    public void testButtonDisableColorBackgroundForegroundWhenIsFocused() {
        JButtonFixture buttonDisabled = frame.button("buttonDisabled");
        buttonDisabled.background().requireEqualTo(MaterialColors.COSMO_LIGHT_ORANGE);
        buttonDisabled.foreground().requireEqualTo(MaterialColors.COSMO_BLACK);
        buttonDisabled.focus();
        buttonDisabled.background().requireEqualTo(MaterialColors.COSMO_LIGHT_ORANGE);
        buttonDisabled.foreground().requireEqualTo(MaterialColors.COSMO_BLACK);
    }

}
