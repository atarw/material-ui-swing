package mdlaf.themes;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialFontFactory;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialLiteTheme extends AbstractMaterialTheme {

    @Override
    public void installTheme() {
        installColor();
        installFont();
    }

    @Override
    protected void installFont(){
        this.fontBold = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD);
        this.fontItalic = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.ITALIC);
        this.fontMedium = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.MEDIUM);
        this.fontRegular = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR);
    }

    @Override
    protected void installColor() {
        this.backgroundPrimary = MaterialColors.WHITE;
        this.highlightBackgroundPrimary = MaterialColors.LIGHT_BLUE_300;

        this.textColor = MaterialColors.BLACK;
        this.disableTextColor = MaterialColors.GRAY_500;

        this.buttonBackgroundColor = MaterialColors.COSMO_MEDIUM_GRAY;
        this.buttonBackgroundColorMouseHover = MaterialColors.COSMO_LIGTH_GRAY;
        this.buttonTextColor = MaterialColors.BLACK;
        this.buttonDefaultBackgroundColorMouseHover = MaterialColors.LIGHT_BLUE_200;
        this.buttonDefaultBackgroundColor = MaterialColors.LIGHT_BLUE_400;
        this.buttonDefaultTextColor = MaterialColors.WHITE;

        this.menuBackground = MaterialColors.WHITE;
        this.menuBackgroundMouseHover = MaterialColors.GRAY_400;
        this.menuTextColor = MaterialColors.BLACK;
        this.menuDisableBackground = MaterialColors.TRANSPANENT;

    }

    @Override
    public String getName() {
        return "Material Lite";
    }
}
