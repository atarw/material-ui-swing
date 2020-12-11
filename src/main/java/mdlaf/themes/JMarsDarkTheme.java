/**
 * MIT License
 *
 * Copyright (c) 2019-2021 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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
import mdlaf.utils.MaterialImageFactory;
import mdlaf.utils.icons.MaterialIconFont;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class JMarsDarkTheme extends AbstractMaterialTheme {

    @Override
    protected void installIcons() {
        super.installIcons();
        this.selectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX,
                MaterialColors.WHITE
        );
        this.unselectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX_OUTLINE_BLANK,
                MaterialColors.WHITE
        );

        this.selectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX,
                highlightBackgroundPrimary
        );
        this.unselectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX_OUTLINE_BLANK,
                highlightBackgroundPrimary
        );
    }

    @Override
    protected void installBorders() {
        super.installBorders();
        borderMenuBar = new BorderUIResource(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(225, 156, 43)));
        borderPopupMenu = new BorderUIResource(BorderFactory.createLineBorder(backgroundPrimary));
        borderSpinner = new BorderUIResource(BorderFactory.createLineBorder(backgroundTextField));
        borderSlider = new BorderUIResource(BorderFactory.createCompoundBorder(borderSpinner, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        cellBorderTableHeader = new BorderUIResource(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(backgroundTableHeader),
                BorderFactory.createEmptyBorder(5,10,5,10)));
        borderToolBar = borderSpinner;

        borderDialogRootPane = MaterialBorders.LIGHT_SHADOW_BORDER;

        borderProgressBar = borderSpinner;

       // this.borderComboBox = MaterialBorders.roundedLineColorBorder(MaterialColors.WHITE, this.getArchBorderComboBox());
        this.borderTable = borderSpinner;
        this.borderTableHeader = new BorderUIResource(
                new DropShadowBorder(this.backgroundPrimary, 5, 3, 0.4f, 12,
                        true, true, true, true));

        super.borderTitledBorder = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.WHITE));

        super.titleColorTaskPane = MaterialColors.BLACK;
    }

    @Override
    protected void installColor() {
        this.backgroundPrimary = new ColorUIResource(45, 48, 56);
        this.highlightBackgroundPrimary = new ColorUIResource(66,179,176);

        this.textColor = new ColorUIResource(255, 255, 255);
        this.disableTextColor = new ColorUIResource(170, 170, 170);

        this.buttonBackgroundColor = new ColorUIResource(45, 48, 56);
        this.buttonBackgroundColorMouseHover = new ColorUIResource(81, 86, 101);
        this.buttonDefaultBackgroundColorMouseHover = new ColorUIResource(23, 137, 134);
        this.buttonDefaultBackgroundColor = new ColorUIResource(66,179,176);
        this.buttonDisabledBackground = new ColorUIResource(66,69,76);

        this.buttonFocusColor = buttonDefaultBackgroundColor;
        this.buttonDefaultFocusColor = MaterialColors.WHITE;
        this.buttonBorderColor = MaterialColors.WHITE;
        this.buttonColorHighlight = buttonBackgroundColorMouseHover;

        this.selectedInDropDownBackgroundComboBox = new ColorUIResource(249, 192, 98);
        this.selectedForegroundComboBox = MaterialColors.BLACK;

        this.menuBackground = new ColorUIResource(59,62,69);
        this.menuBackgroundMouseHover = new ColorUIResource(249, 192, 98);

        this.trackColorScrollBar = new ColorUIResource(81, 86, 101);
        this.thumbColorScrollBar = new ColorUIResource(155,155,155);

        this.trackColorSlider = new ColorUIResource(119, 119, 119);
        this.haloColorSlider = MaterialColors.bleach(new Color(249, 192, 98), 0.2f);

        this.mouseHoverButtonColorSpinner = backgroundPrimary;

        this.highlightColorTabbedPane = new ColorUIResource(45,48,56);
        this.borderHighlightColorTabbedPane = new ColorUIResource(45,48,56);
        this.focusColorLineTabbedPane = new ColorUIResource(249, 192, 98);
        this.disableColorTabTabbedPane = new ColorUIResource(170,170,170);

        this.backgroundTable = new ColorUIResource(45,48,56);
        this.backgroundTableHeader = new ColorUIResource(66,179,176);
        this.selectionBackgroundTable = new ColorUIResource(126, 132, 153);
        this.gridColorTable = new ColorUIResource(151,151,151);
        this.alternateRowBackgroundTable = new ColorUIResource(59, 62, 69);

        this.backgroundTextField = new ColorUIResource(81, 86, 101);
        this.inactiveForegroundTextField = MaterialColors.WHITE;
        this.inactiveBackgroundTextField = new ColorUIResource(81, 86, 101);
        this.selectionBackgroundTextField = new ColorUIResource(249, 192, 98);
        super.disabledBackgroudnTextField = new ColorUIResource(94,94,94);
        super.disabledForegroundTextField = new ColorUIResource(170,170,170);
        this.selectionForegroundTextField = MaterialColors.BLACK;
        this.inactiveColorLineTextField = MaterialColors.WHITE;
        this.activeColorLineTextField = new ColorUIResource(249, 192, 98);

        this.titleBackgroundGradientStartTaskPane = MaterialColors.GRAY_300;
        this.titleBackgroundGradientEndTaskPane = MaterialColors.GRAY_500;
        this.titleOverTaskPane = new ColorUIResource(249, 192, 98);
        this.specialTitleOverTaskPane = MaterialColors.WHITE;

        this.selectionBackgroundList = new ColorUIResource(249, 192, 98);
        this.selectionForegroundList = MaterialColors.BLACK;

        this.backgroundProgressBar = new ColorUIResource(81, 86, 101);
        this.foregroundProgressBar = MaterialColors.WHITE;

        this.withoutIconSelectedForegoundToggleButton = MaterialColors.BLACK;
        this.withoutIconForegroundToggleButton = MaterialColors.WHITE;

        this.colorDividierSplitPane = MaterialColors.COSMO_DARK_GRAY;
        this.colorDividierFocusSplitPane = new ColorUIResource(249, 192, 98);

        super.backgroundSeparator = MaterialColors.GRAY_300;
        super.foregroundSeparator = MaterialColors.GRAY_300;

        super.backgroundToolTip = backgroundPrimary;
    }

    @Override
    protected void installDefaultColor() {
        super.installDefaultColor();
    }

    @Override
    public void installUIDefault(UIDefaults table) {
        super.installUIDefault(table);
        table.put("Menu.selectionForeground", MaterialColors.BLACK);
        table.put("MenuItem.selectionForeground", MaterialColors.BLACK);
    }

    @Override
    public String getName() {
        return "JMars Dark";
    }

    @Override
    public int getArcButton() {
        return 0;
    }

    @Override
    public int getArchBorderComboBox() {
        return 0;
    }
}
