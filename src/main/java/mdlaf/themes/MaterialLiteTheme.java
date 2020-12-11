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

import mdlaf.shadows.DropShadowBorder;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialLiteTheme extends AbstractMaterialTheme {

    @Override
    protected void installBorders() {
        super.installBorders();

        //this.borderComboBox = MaterialBorders.roundedLineColorBorder(MaterialColors.COSMO_BLACK, this.getArchBorderComboBox());
        this.borderTable = MaterialBorders.LIGHT_LINE_BORDER;
        this.borderTableHeader = new BorderUIResource(
                new DropShadowBorder(this.backgroundPrimary, 5, 3, 0.4f, 12,
                        true, true, true, true));

        super.borderTitledBorder = MaterialBorders.LIGHT_LINE_BORDER;
    }

    @Override
    protected void installDefaultColor() {
        super.installDefaultColor();
        this.buttonDefaultTextColor = MaterialColors.WHITE;
        this.thumbDarkShadowColorScrollBar = MaterialColors.GRAY_500;
        this.thumbHighlightColorScrollBar = MaterialColors.GRAY_500;
        this.thumbShadowColorScrollBar = MaterialColors.GRAY_500;
        this.arrowButtonOnClickColorScrollBar = MaterialColors.GRAY_400;
        this.mouseHoverColorScrollBar = MaterialColors.GRAY_300;
        super.foregroundToolTip = MaterialColors.WHITE;
    }

    @Override
    protected void installColor() {
        this.backgroundPrimary = MaterialColors.WHITE;
        this.highlightBackgroundPrimary = MaterialColors.LIGHT_BLUE_300;

        this.textColor = MaterialColors.BLACK;
        this.disableTextColor = MaterialColors.GRAY_500;

        this.buttonBackgroundColor = MaterialColors.COSMO_LIGTH_GRAY;
        this.buttonBackgroundColorMouseHover = MaterialColors.COSMO_DARK_GRAY;
        this.buttonDefaultBackgroundColorMouseHover = MaterialColors.LIGHT_BLUE_200;
        this.buttonDefaultBackgroundColor = MaterialColors.LIGHT_BLUE_400;
        this.buttonDisabledBackground = MaterialColors.COSMO_DARK_GRAY;
        this.buttonFocusColor = MaterialColors.GRAY_900;
        this.buttonDefaultFocusColor = MaterialColors.GRAY_200;
        this.buttonBorderColor = MaterialColors.COSMO_MEDIUM_GRAY;
        this.buttonColorHighlight = MaterialColors.GRAY_400;

        this.selectedInDropDownBackgroundComboBox = MaterialColors.COSMO_LIGTH_BLUE;
        this.selectedForegroundComboBox = MaterialColors.BLACK;

        this.menuBackground = MaterialColors.WHITE;
        this.menuBackgroundMouseHover = MaterialColors.GRAY_400;

        this.arrowButtonColorScrollBar = MaterialColors.GRAY_200;
        this.trackColorScrollBar = MaterialColors.GRAY_200;
        this.thumbColorScrollBar = MaterialColors.GRAY_500;

        this.trackColorSlider = MaterialColors.BLACK;
        this.haloColorSlider = MaterialColors.bleach(MaterialColors.LIGHT_BLUE_400, 0.5f);

        this.highlightColorTabbedPane = MaterialColors.GRAY_200;
        this.borderHighlightColorTabbedPane = MaterialColors.GRAY_300;
        this.focusColorLineTabbedPane = MaterialColors.COSMO_BLUE;
        this.disableColorTabTabbedPane = MaterialColors.COSMO_STRONG_GRAY;

        this.backgroundTable = MaterialColors.WHITE;
        this.backgroundTableHeader = MaterialColors.GRAY_200;
        this.selectionBackgroundTable = MaterialColors.COSMO_LIGTH_BLUE;
        this.gridColorTable = MaterialColors.GRAY_200;
        this.alternateRowBackgroundTable = MaterialColors.GRAY_300;

        this.backgroundTextField = MaterialColors.GRAY_200;
        this.inactiveForegroundTextField = MaterialColors.GRAY_800;
        this.inactiveBackgroundTextField = MaterialColors.GRAY_200;
        this.selectionBackgroundTextField = MaterialColors.LIGHT_BLUE_400;
        this.selectionForegroundTextField = MaterialColors.BLACK;
        super.disabledBackgroudnTextField = MaterialColors.GRAY_300;
        super.disabledForegroundTextField = MaterialColors.GRAY_700;
        this.inactiveColorLineTextField = MaterialColors.BLACK;
        this.activeColorLineTextField = MaterialColors.LIGHT_BLUE_400;

        this.mouseHoverButtonColorSpinner = MaterialColors.GRAY_400;

        this.titleBackgroundGradientStartTaskPane = MaterialColors.GRAY_300;
        this.titleBackgroundGradientEndTaskPane = MaterialColors.GRAY_500;
        this.titleOverTaskPane = MaterialColors.LIGHT_BLUE_500;
        this.specialTitleOverTaskPane = MaterialColors.LIGHT_BLUE_500;
        this.backgroundTaskPane = MaterialColors.WHITE;
        this.borderColorTaskPane = MaterialColors.WHITE;
        this.contentBackgroundTaskPane = MaterialColors.WHITE;

        this.selectionBackgroundList = MaterialColors.COSMO_LIGTH_BLUE;
        this.selectionForegroundList = MaterialColors.BLACK;

        this.backgroundProgressBar = MaterialColors.COSMO_LIGTH_BLUE;
        this.foregroundProgressBar = MaterialColors.COSMO_BLUE;

        this.withoutIconSelectedBackgroundToggleButton = MaterialColors.COSMO_DARK_GRAY;
        this.withoutIconSelectedForegoundToggleButton = MaterialColors.BLACK;
        this.withoutIconBackgroundToggleButton = MaterialColors.GRAY_300;
        this.withoutIconForegroundToggleButton = MaterialColors.BLACK;

        this.colorDividierSplitPane = MaterialColors.COSMO_DARK_GRAY;
        this.colorDividierFocusSplitPane = MaterialColors.COSMO_BLUE;

        super.backgroundSeparator = MaterialColors.GRAY_300;
        super.foregroundSeparator = MaterialColors.GRAY_300;

        super.titleColorTaskPane = MaterialColors.BLACK;
        super.backgroundToolTip = MaterialColors.GRAY_500;
    }

    @Override
    public void installUIDefault(UIDefaults table) {
        super.installUIDefault(table);
    }

    @Override
    public String getName() {
        return "Material Lite";
    }
}
