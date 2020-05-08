/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import mdlaf.shadows.DropShadowBorder;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialImageFactory;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialOceanicTheme extends AbstractMaterialTheme{

    @Override
    protected void installIcons() {
        super.installIcons();

        this.selectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHECK_BOX,
                MaterialColors.COSMO_DARK_GRAY
        );
        this.unselectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHECK_BOX_OUTLINE_BLANK,
                MaterialColors.COSMO_DARK_GRAY
        );

        this.selectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHECK_BOX,
                highlightBackgroundPrimary
        );
        this.unselectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CHECK_BOX_OUTLINE_BLANK,
                highlightBackgroundPrimary
        );
    }

    @Override
    protected void installBorders() {
        super.installBorders();
        borderMenuBar = new BorderUIResource(new DropShadowBorder(Color.DARK_GRAY, 10, 4, 0.3f, 12,
                false, false, true, false));
        //borderMenuBar = new BorderUIResource(BorderFactory.createLineBorder(this.menuBackground, 1));;
        borderPopupMenu = MaterialBorders.OCEAN_LINE_BORDER;
        borderSpinner = new BorderUIResource(BorderFactory.createLineBorder(backgroundTextField));
        borderSlider = new BorderUIResource(BorderFactory.createCompoundBorder(MaterialBorders.DARK_LINE_BORDER, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        cellBorderTableHeader = new BorderUIResource(BorderFactory.createCompoundBorder(
                MaterialBorders.DARK_LINE_BORDER,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        borderToolBar = MaterialBorders.OCEAN_LINE_BORDER;

        borderDialogRootPane = MaterialBorders.LIGHT_SHADOW_BORDER;

        borderProgressBar = MaterialBorders.OCEAN_LINE_BORDER;

        this.borderComboBox = MaterialBorders.roundedLineColorBorder(MaterialColors.WHITE, this.getArchBorderComboBox());
        this.borderTable = MaterialBorders.OCEAN_LINE_BORDER;
        this.borderTableHeader = new BorderUIResource(
                new DropShadowBorder(this.backgroundPrimary, 5, 3, 0.4f, 12,
                        true, true, true, true));

        super.borderTitledBorder = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.WHITE));
    }

    @Override
    protected void installDefaultColor() {
        super.installDefaultColor();
        this.buttonDefaultTextColor = MaterialColors.BLACK;

        this.foregroundTableHeader = MaterialColors.LIME_A400;
        this.selectionForegroundTable = MaterialColors.BLACK;
    }

    @Override
    protected void installColor() {
        this.backgroundPrimary = MaterialColors.DARKLY_STRONG_BLUE;
        this.highlightBackgroundPrimary = MaterialColors.LIME_A400;

        this.textColor = MaterialColors.WHITE;
        this.disableTextColor = MaterialColors.GRAY_500;

        this.buttonBackgroundColor = MaterialColors.DARKLY_STRONG_BLUE;
        this.buttonBackgroundColorMouseHover = MaterialColors.DARKLY_BLUE;
        this.buttonDefaultBackgroundColorMouseHover = MaterialColors.LIME_200;
        this.buttonDefaultBackgroundColor = MaterialColors.LIME_A200;
        this.buttonDisabledBackground = MaterialColors.COSMO_DARK_GRAY;
        this.buttonDisabledForeground = MaterialColors.GRAY_500;
        this.buttonFocusColor = MaterialColors.WHITE;
        this.buttonDefaultFocusColor = MaterialColors.BLACK;
        this.buttonBorderColor = MaterialColors.GRAY_200;
        this.buttonColorHighlight = MaterialColors.GRAY_400;

        this.selectedInDropDownBackgroundComboBox = MaterialColors.LIME_A400;
        this.selectedForegroundComboBox = MaterialColors.BLACK;

        this.menuBackground = new ColorUIResource(31, 51, 71);
        this.menuBackgroundMouseHover = MaterialColors.DARKLY_BLUE;

        this.arrowButtonColorScrollBar = MaterialColors.DARKLY_STRONG_BLUE;
        this.trackColorScrollBar = MaterialColors.DARKLY_BLUE;
        this.thumbColorScrollBar = MaterialColors.GRAY_500;
        this.arrowButtonOnClickColorScrollBar = MaterialColors.DARKLY_BLUE;
        this.mouseHoverColorScrollBar = MaterialColors.GRAY_300;

        this.trackColorSlider = MaterialColors.DARKLY_BLUE;
        this.haloColorSlider = MaterialColors.bleach(MaterialColors.LIME_A200, 0.5f);

        this.highlightColorTabbedPane = MaterialColors.DARKLY_STRONG_BLUE;
        this.borderHighlightColorTabbedPane = MaterialColors.DARKLY_STRONG_BLUE;
        this.focusColorLineTabbedPane = MaterialColors.LIME_A400;
        this.disableColorTabTabbedPane = MaterialColors.COSMO_STRONG_GRAY;

        this.backgroundTable = MaterialColors.DARKLY_BLUE;
        this.backgroundTableHeader = MaterialColors.DARKLY_STRONG_BLUE;
        this.selectionBackgroundTable = MaterialColors.LIME_A100;
        this.gridColorTable = MaterialColors.COSMO_BLACK;
        this.alternateRowBackgroundTable = MaterialColors.DARKLY_STRONG_BLUE;

        this.dockingBackgroundToolBar = MaterialColors.LIGHT_GREEN_A100;
        this.floatingBackgroundToolBar = MaterialColors.GRAY_200;

        this.backgroundTextField = MaterialColors.DARKLY_BLUE;
        this.inactiveForegroundTextField = MaterialColors.WHITE;
        this.inactiveBackgroundTextField = MaterialColors.DARKLY_BLUE;
        this.selectionBackgroundTextField = MaterialColors.LIME_A100;
        this.selectionForegroundTextField = MaterialColors.BLACK;
        super.disabledBackgroudnTextField = MaterialColors.DARKLY_BLUE;
        super.disabledForegroundTextField = MaterialColors.GRAY_500;
        this.inactiveColorLineTextField = MaterialColors.WHITE;
        this.activeColorLineTextField = MaterialColors.LIME_A400;

        this.arrowButtonBackgroundSpinner = backgroundTextField;
        this.mouseHoverButtonColorSpinner = MaterialColors.DARKLY_STRONG_BLUE;

        this.titleBackgroundGradientStartTaskPane = MaterialColors.GRAY_300;
        this.titleBackgroundGradientEndTaskPane = MaterialColors.GRAY_500;
        this.titleOverTaskPane = highlightBackgroundPrimary;
        this.specialTitleOverTaskPane = MaterialColors.WHITE;
        this.backgroundTaskPane = MaterialColors.DARKLY_STRONG_BLUE;
        this.borderColorTaskPane = MaterialColors.DARKLY_STRONG_BLUE;
        this.contentBackgroundTaskPane = MaterialColors.DARKLY_STRONG_BLUE;

        this.selectionBackgroundList = MaterialColors.DARKLY_BLUE;
        this.selectionForegroundList = MaterialColors.WHITE;

        this.backgroundProgressBar = MaterialColors.DARKLY_BLUE;
        this.foregroundProgressBar = MaterialColors.LIME_A400;

        this.withoutIconSelectedBackgroundToggleButton = highlightBackgroundPrimary;
        this.withoutIconSelectedForegoundToggleButton = MaterialColors.BLACK;
        this.withoutIconBackgroundToggleButton = backgroundPrimary;
        this.withoutIconForegroundToggleButton = textColor;

        this.colorDividierSplitPane = MaterialColors.COSMO_DARK_GRAY;
        this.colorDividierFocusSplitPane = MaterialColors.LIME_A400;

        super.backgroundSeparator = MaterialColors.GRAY_300;
        super.foregroundSeparator = MaterialColors.GRAY_300;

        super.titleColorTaskPane = MaterialColors.BLACK;
    }

    @Override
    public void installUIDefault(UIDefaults table) {
        super.installUIDefault(table);
    }

    @Override
    public String getName() {
        return "Material Dark";
    }
}
