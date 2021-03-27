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

/**
 * Reference: https://www.material-theme.com/docs/reference/color-palette
 *
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialLiteTheme extends AbstractMaterialTheme {

  @Override
  protected void installBorders() {
    super.installBorders();

    this.borderTable = MaterialBorders.LIGHT_LINE_BORDER;
    this.borderTableHeader =
        new BorderUIResource(
            new DropShadowBorder(this.backgroundPrimary, 5, 3, 0.4f, 12, true, true, true, true));

    super.borderTitledBorder = MaterialBorders.LIGHT_LINE_BORDER;
  }

  @Override
  protected void installDefaultColor() {
    super.installDefaultColor();
    this.buttonDisabledForeground = this.disableTextColor;
    /* this.buttonDefaultTextColor = MaterialColors.WHITE;
    this.thumbDarkShadowColorScrollBar = MaterialColors.GRAY_500;
    this.thumbHighlightColorScrollBar = MaterialColors.GRAY_500;
    this.thumbShadowColorScrollBar = MaterialColors.GRAY_500;
    this.arrowButtonOnClickColorScrollBar = MaterialColors.GRAY_400;
    this.mouseHoverColorScrollBar = MaterialColors.GRAY_300;
    super.foregroundToolTip = MaterialColors.WHITE; */
    super.titleColorTaskPane = this.textColor;
    super.backgroundToolTip = this.disableTextColor;
  }

  @Override
  protected void installColor() {
    ColorUIResource secondBackground = new ColorUIResource(238, 238, 238);
    ColorUIResource disableBackground = new ColorUIResource(210, 212, 213);
    ColorUIResource accentColor = new ColorUIResource(231, 231, 232);
    ColorUIResource selectedForeground = new ColorUIResource(84, 110, 122);
    ColorUIResource selectedBackground = new ColorUIResource(220, 239, 237);
    this.backgroundPrimary = new ColorUIResource(240, 240, 240);
    this.highlightBackgroundPrimary = new ColorUIResource(0, 188, 212);

    this.textColor = new ColorUIResource(84, 110, 122);
    this.disableTextColor = new ColorUIResource(148, 167, 176);

    this.buttonBackgroundColor = new ColorUIResource(243, 244, 245);
    this.buttonBackgroundColorMouseHover = new ColorUIResource(231, 231, 232);
    this.buttonDefaultBackgroundColorMouseHover = this.buttonBackgroundColorMouseHover;
    this.buttonDefaultBackgroundColor = secondBackground;
    this.buttonDisabledBackground = disableBackground;
    this.buttonFocusColor = this.buttonBackgroundColor;
    this.buttonDefaultFocusColor = this.buttonFocusColor;
    this.buttonBorderColor = new ColorUIResource(211, 225, 232);
    this.buttonColorHighlight = selectedBackground;

    this.selectedInDropDownBackgroundComboBox = this.buttonBackgroundColorMouseHover;
    this.selectedForegroundComboBox = this.textColor;

    this.menuBackground = this.backgroundPrimary;
    this.menuBackgroundMouseHover = this.buttonBackgroundColorMouseHover;

    this.arrowButtonColorScrollBar = this.buttonBackgroundColor;
    this.trackColorScrollBar = accentColor;
    this.thumbColorScrollBar = disableBackground;

    this.trackColorSlider = this.textColor;
    this.haloColorSlider = MaterialColors.bleach(this.highlightBackgroundPrimary, 0.5f);

    this.highlightColorTabbedPane = this.buttonColorHighlight;
    this.borderHighlightColorTabbedPane = this.buttonColorHighlight;
    this.focusColorLineTabbedPane = this.highlightBackgroundPrimary;
    this.disableColorTabTabbedPane = disableBackground;

    this.backgroundTable = this.backgroundPrimary;
    this.backgroundTableHeader = this.backgroundPrimary;
    this.selectionBackgroundTable = this.buttonBackgroundColorMouseHover;
    this.gridColorTable = this.backgroundPrimary;
    this.alternateRowBackgroundTable = this.backgroundPrimary;

    this.backgroundTextField = accentColor;
    this.inactiveForegroundTextField = this.textColor;
    this.inactiveBackgroundTextField = accentColor;
    this.selectionBackgroundTextField = selectedBackground;
    this.selectionForegroundTextField = selectedForeground;
    super.disabledBackgroudnTextField = disableBackground;
    super.disabledForegroundTextField = this.disableTextColor;
    this.inactiveColorLineTextField = this.textColor;
    this.activeColorLineTextField = this.highlightBackgroundPrimary;

    this.mouseHoverButtonColorSpinner = this.buttonBackgroundColorMouseHover;
    this.titleBackgroundGradientStartTaskPane = secondBackground;
    this.titleBackgroundGradientEndTaskPane = secondBackground;
    this.titleOverTaskPane = selectedForeground;
    this.specialTitleOverTaskPane = selectedForeground;
    this.backgroundTaskPane = this.backgroundPrimary;
    this.borderColorTaskPane = new ColorUIResource(211, 225, 232);
    this.contentBackgroundTaskPane = secondBackground;

    this.selectionBackgroundList = selectedBackground;
    this.selectionForegroundList = selectedForeground;

    this.backgroundProgressBar = disableBackground;
    this.foregroundProgressBar = this.highlightBackgroundPrimary;

    this.withoutIconSelectedBackgroundToggleButton = MaterialColors.COSMO_DARK_GRAY;
    this.withoutIconSelectedForegoundToggleButton = MaterialColors.BLACK;
    this.withoutIconBackgroundToggleButton = MaterialColors.GRAY_300;
    this.withoutIconForegroundToggleButton = MaterialColors.BLACK;

    this.colorDividierSplitPane = MaterialColors.COSMO_DARK_GRAY;
    this.colorDividierFocusSplitPane = selectedBackground;

    super.backgroundSeparator = MaterialColors.GRAY_300;
    super.foregroundSeparator = MaterialColors.GRAY_300;
  }

  @Override
  public void installUIDefault(UIDefaults table) {
    super.installUIDefault(table);
  }

  @Override
  public String getName() {
    return "Material Lite";
  }

  @Override
  public boolean getButtonBorderEnableToAll() {
    return true;
  }

  @Override
  public boolean getButtonBorderEnable() {
    return true;
  }
}
