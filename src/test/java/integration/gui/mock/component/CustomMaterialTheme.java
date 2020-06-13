package integration.gui.mock.component;

import mdlaf.themes.AbstractMaterialTheme;
import mdlaf.utils.MaterialColors;

public class CustomMaterialTheme extends AbstractMaterialTheme {

    @Override
    protected void installColor() {
        this.backgroundPrimary = MaterialColors.COSMO_STRONG_GRAY;
        this.highlightBackgroundPrimary = MaterialColors.COSMO_ORANGE;
        this.textColor = MaterialColors.COSMO_BLACK;
    }

    @Override
    public String getName() {
        return "CustomMaterialTheme";
    }
}
