package integration.gui.mock.uiexample.button;

import mdlaf.themes.AbstractMaterialTheme;
import mdlaf.utils.MaterialColors;

public class MaterialCustomTheme extends AbstractMaterialTheme {

  @Override
  protected void installColor() {
    this.backgroundPrimary = MaterialColors.COSMO_STRONG_GRAY;
    this.highlightBackgroundPrimary = MaterialColors.COSMO_ORANGE;
    this.textColor = MaterialColors.COSMO_BLACK;
    // TODO You should be implement all propriety.
    // Please use the JavaDoc to find all propriety.

  }

  // Implement Contained button
  @Override
  public boolean getButtonBorderEnable() {
    return false;
  }

  @Override
  public boolean getButtonBorderEnableToAll() {
    return false;
  }

  @Override
  public String getName() {
    return "CustomMaterialTheme";
  }
}
