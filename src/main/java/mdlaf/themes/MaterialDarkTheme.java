package mdlaf.themes;

import mdlaf.utils.MaterialColors;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialDarkTheme extends AbstractMaterialTheme{

    @Override
    public void installTheme() {

        this.backgroundPrimary = MaterialColors.GRAY_800;
        this.highlightBackgroundPrimary = MaterialColors.LIGHT_BLUE_300;

        this.textColor = MaterialColors.WHITE;
        this.disableTextColor = MaterialColors.GRAY_300;

        this.buttonBackgroundColor = MaterialColors.COSMO_BLACK;
        this.buttonBackgroundColorMouseHover = MaterialColors.COSMO_BLACK;
        this.buttonTextColor = MaterialColors.WHITE;
        this.buttonDefaultBackgroundColorMouseHover = MaterialColors.LIME_A400;
        this.buttonDefaultBackgroundColor = MaterialColors.LIME_A700;
        this.buttonDefaultTextColor = MaterialColors.BLACK;

        this.menuBackground = MaterialColors.GRAY_900;
        this.menuBackgroundMouseHover = MaterialColors.GRAY_700;
        this.menuTextColor = MaterialColors.WHITE;
        this.menuDisableBackground = MaterialColors.TRANSPANENT;
    }

    @Override
    protected void installFonts() {

    }

    @Override
    protected void installColor() {

    }

    @Override
    public String getName() {
        return "Material Dark";
    }
}
