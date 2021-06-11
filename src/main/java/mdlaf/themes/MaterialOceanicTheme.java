/*
 * MIT License
 *
 * Copyright (c) 2019-2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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
package mdlaf.themes;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import mdlaf.shadows.DropShadowBorder;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialImageFactory;
import mdlaf.utils.icons.MaterialIconFont;

/**
 * @author https://github.com/vincenzopalazzo
 *     <p>https://www.material-theme.com/docs/reference/color-palette/#material-themes
 */
public class MaterialOceanicTheme extends AbstractMaterialTheme {

  private ColorUIResource selectedBackground = new ColorUIResource(50, 66, 74);

  @Override
  protected void installIcons() {
    super.installIcons();

    this.selectedCheckBoxIconSelectionRowTable =
        MaterialImageFactory.getInstance()
            .getImage(MaterialIconFont.CHECK_BOX, highlightBackgroundPrimary);
    this.unselectedCheckBoxIconSelectionRowTable =
        MaterialImageFactory.getInstance()
            .getImage(MaterialIconFont.CHECK_BOX_OUTLINE_BLANK, highlightBackgroundPrimary);

    this.selectedCheckBoxIconTable =
        MaterialImageFactory.getInstance()
            .getImage(MaterialIconFont.CHECK_BOX, highlightBackgroundPrimary);
    this.unselectedCheckBoxIconTable =
        MaterialImageFactory.getInstance()
            .getImage(MaterialIconFont.CHECK_BOX_OUTLINE_BLANK, highlightBackgroundPrimary);

    this.unselectedCheckBoxIcon =
        MaterialImageFactory.getInstance()
            .getImage(MaterialIconFont.CHECK_BOX_OUTLINE_BLANK, textColor);
  }

  @Override
  protected void installBorders() {
    super.installBorders();
    borderMenuBar =
        new BorderUIResource(
            new DropShadowBorder(Color.DARK_GRAY, 10, 4, 0.3f, 12, false, false, true, false));
    // borderMenuBar = new BorderUIResource(BorderFactory.createLineBorder(this.menuBackground,
    // 1));;
    borderPopupMenu = MaterialBorders.OCEAN_LINE_BORDER;
    borderSpinner = new BorderUIResource(BorderFactory.createLineBorder(backgroundTextField));
    borderSlider =
        new BorderUIResource(
            BorderFactory.createCompoundBorder(
                MaterialBorders.DARK_LINE_BORDER, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
    cellBorderTableHeader =
        new BorderUIResource(
            BorderFactory.createCompoundBorder(
                MaterialBorders.DARK_LINE_BORDER, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    borderToolBar = MaterialBorders.OCEAN_LINE_BORDER;

    borderDialogRootPane = MaterialBorders.LIGHT_SHADOW_BORDER;

    borderProgressBar = MaterialBorders.OCEAN_LINE_BORDER;

    // this.borderComboBox = MaterialBorders.roundedLineColorBorder(MaterialColors.WHITE,
    // this.getArchBorderComboBox());
    this.borderTable = MaterialBorders.OCEAN_LINE_BORDER;
    this.borderTableHeader =
        new BorderUIResource(
            new DropShadowBorder(this.backgroundPrimary, 5, 3, 0.4f, 12, true, true, true, true));

    super.borderTitledBorder =
        new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.WHITE));
  }

  @Override
  protected void installDefaultColor() {
    super.installDefaultColor();
    this.buttonDefaultTextColor = this.textColor;

    this.foregroundTableHeader = this.textColor;
    this.selectionForegroundTable = this.highlightBackgroundPrimary;
  }

  @Override
  protected void installColor() {
    this.backgroundPrimary = new ColorUIResource(38, 50, 56);
    this.highlightBackgroundPrimary = new ColorUIResource(0, 150, 136);

    this.textColor = new ColorUIResource(176, 190, 197);
    this.disableTextColor = new ColorUIResource(65, 89, 103);

    this.buttonBackgroundColor = new ColorUIResource(46, 60, 67);
    this.buttonBackgroundColorMouseHover = new ColorUIResource(84, 110, 122);
    this.buttonDefaultBackgroundColorMouseHover = new ColorUIResource(84, 110, 122);
    this.buttonDefaultBackgroundColor = new ColorUIResource(50, 66, 74);
    this.buttonDisabledBackground = this.buttonBackgroundColor;
    this.buttonDisabledForeground = this.disableTextColor;
    this.buttonFocusColor = this.buttonBackgroundColorMouseHover;
    this.buttonDefaultFocusColor = this.buttonDefaultBackgroundColorMouseHover;
    this.buttonBorderColor = this.buttonBackgroundColor;
    this.buttonColorHighlight = this.buttonBackgroundColorMouseHover;

    this.selectedInDropDownBackgroundComboBox = this.buttonBackgroundColorMouseHover;
    this.selectedForegroundComboBox = this.textColor;

    this.menuBackground = this.backgroundPrimary;
    this.menuBackgroundMouseHover = selectedBackground;

    this.arrowButtonColorScrollBar = this.buttonBackgroundColor;
    this.trackColorScrollBar = new ColorUIResource(30, 39, 44);
    this.thumbColorScrollBar = selectedBackground;
    this.arrowButtonOnClickColorScrollBar = this.buttonBackgroundColorMouseHover;
    this.mouseHoverColorScrollBar = this.buttonBackgroundColorMouseHover;

    this.trackColorSlider = this.highlightBackgroundPrimary;
    this.haloColorSlider = MaterialColors.bleach(this.highlightBackgroundPrimary, 0.5f);

    this.highlightColorTabbedPane = this.highlightBackgroundPrimary;
    this.borderHighlightColorTabbedPane = this.highlightBackgroundPrimary;
    this.focusColorLineTabbedPane = this.highlightBackgroundPrimary;
    this.disableColorTabTabbedPane = MaterialColors.COSMO_STRONG_GRAY;

    this.backgroundTable = new ColorUIResource(30, 39, 44);
    this.backgroundTableHeader = new ColorUIResource(30, 39, 44);
    this.selectionBackgroundTable = selectedBackground;
    this.gridColorTable = new ColorUIResource(30, 39, 44);
    this.alternateRowBackgroundTable = null; // To disable it

    this.backgroundTextField = this.backgroundPrimary;
    this.inactiveForegroundTextField = this.textColor;
    this.inactiveBackgroundTextField = this.backgroundTextField;
    this.selectionBackgroundTextField = this.highlightBackgroundPrimary;
    this.selectionForegroundTextField = this.textColor;
    super.disabledBackgroudnTextField = new ColorUIResource(65, 89, 103);
    super.disabledForegroundTextField = this.disableTextColor;
    this.inactiveColorLineTextField = this.textColor;
    this.activeColorLineTextField = this.highlightColorTabbedPane;

    this.arrowButtonBackgroundSpinner = backgroundTextField;
    this.mouseHoverButtonColorSpinner = this.buttonBackgroundColorMouseHover;

    this.titleBackgroundGradientStartTaskPane = this.backgroundPrimary;
    this.titleBackgroundGradientEndTaskPane = this.highlightBackgroundPrimary;
    this.titleOverTaskPane = highlightBackgroundPrimary;
    this.specialTitleOverTaskPane = this.textColor;
    this.backgroundTaskPane = this.highlightBackgroundPrimary;
    this.borderColorTaskPane = new ColorUIResource(65, 89, 103);
    this.contentBackgroundTaskPane = this.backgroundTaskPane;

    this.selectionBackgroundList = this.selectionBackgroundTable;
    this.selectionForegroundList = this.selectionForegroundTable;

    this.backgroundProgressBar = new ColorUIResource(30, 39, 44);
    this.foregroundProgressBar = this.highlightBackgroundPrimary;

    this.withoutIconSelectedBackgroundToggleButton = highlightBackgroundPrimary;
    this.withoutIconSelectedForegoundToggleButton = MaterialColors.BLACK;
    this.withoutIconBackgroundToggleButton = backgroundPrimary;
    this.withoutIconForegroundToggleButton = textColor;

    this.colorDividierSplitPane = MaterialColors.COSMO_DARK_GRAY;
    this.colorDividierFocusSplitPane = MaterialColors.LIME_A400;

    super.backgroundSeparator = MaterialColors.GRAY_300;
    super.foregroundSeparator = MaterialColors.GRAY_300;

    super.titleColorTaskPane = MaterialColors.BLACK;

    super.backgroundToolTip = super.menuBackground;
  }

  @Override
  public void installUIDefault(UIDefaults table) {
    super.installUIDefault(table);
  }

  @Override
  public String getName() {
    return "Material Oceanic";
  }

  @Override
  public boolean getButtonBorderEnable() {
    return false;
  }

  @Override
  public int getArchBorderComboBox() {
    return 0;
  }
}
