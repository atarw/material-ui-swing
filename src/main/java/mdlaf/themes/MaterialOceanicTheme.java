/*
 * MIT License
 *
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
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
import mdlaf.utils.MaterialFontFactory;
import mdlaf.utils.MaterialImageFactory;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialOceanicTheme extends AbstractMaterialTheme {

    @Override
    public void installTheme() {
        installColor();
        installFonts();
        installBorders();
        installIcons();
    }

    @Override
    protected void installFonts(){
        this.fontBold = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD);
        this.fontItalic = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.ITALIC);
        this.fontMedium = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.MEDIUM);
        this.fontRegular = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR);
    }

    @Override
    protected void installIcons() {
        this.selectedCheckBoxIcon = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CHECKED_WHITE_BOX);
        this.unselectedCheckBoxIcon = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.UNCHECKED_WHITE_BOX);

        this.selectedRadioButtonIcon = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RADIO_BUTTON_WHITE_ON);
        this.unselectedRadioButtonIcon = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RADIO_BUTTON_WHITE_OFF);

        this.selectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CHECKED_WHITE_BOX);
        this.unselectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.UNCHECKED_WHITE_BOX);
        this.selectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CHECKED_BLACK_BOX);
        this.unselectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.UNCHECKED_BLACK_BOX);

        this.closedIconTree = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RIGHT_ARROW);
        this.openIconTree = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.DOWN_ARROW);

        this.yesCollapsedTaskPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.YES_COLLAPSED);
        this.noCollapsedTaskPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.NO_COLLAPSED);

        this.warningIconOptionPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.WARNING);
        this.errorIconIconOptionPane =  MaterialImageFactory.getInstance().getImage(MaterialImageFactory.ERROR);
        this.questionIconOptionPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.QUESTION);
        this.informationIconOptionPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.INFORMATION);

        this.iconComputerFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.COMPUTER_WHITE);
        this.iconDirectoryFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FOLDER_WHITE);
        this.iconFileFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FILE_WHITE);
        this.iconFloppyDriveFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FLOPPY_DRIVE_WHITE);
        this.iconHardDriveFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.HARD_DRIVE_WHITE);
        this.iconHomeFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.HOME_WHITE);
        this.iconListFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.LIST_WHITE);
        this.iconDetailsFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.DETAILS_WHITE);
        this.iconNewFolderFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.NEW_FOLDER_WHITE);
        this.iconUpFolderFileChooser = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.BACK_ARROW_WHITE);
    }

    @Override
    protected void installBorders() {
        super.installBorders();
        borderMenuBar = new BorderUIResource(new DropShadowBorder(Color.DARK_GRAY, 10, 4, 0.3f, 12,
                false, false, true, false));
        //borderMenuBar = new BorderUIResource(BorderFactory.createLineBorder(this.menuBackground, 1));;
        borderPopupMenu = MaterialBorders.OCEAN_LINE_BORDER;
        borderSpinner = MaterialBorders.OCEAN_LINE_BORDER;
        borderSlider = new BorderUIResource(BorderFactory.createCompoundBorder(MaterialBorders.DARK_LINE_BORDER, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        cellBorderTableHeader = new BorderUIResource(BorderFactory.createCompoundBorder(
                MaterialBorders.DARK_LINE_BORDER,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        borderToolBar = MaterialBorders.OCEAN_LINE_BORDER;

        borderDialogRootPane = MaterialBorders.OCEAN_LINE_BORDER;

        borderProgressBar = MaterialBorders.OCEAN_LINE_BORDER;

        this.borderComboBox = MaterialBorders.roundedLineColorBorder(MaterialColors.WHITE, 12);
        this.borderTable = MaterialBorders.OCEAN_LINE_BORDER;
        this.borderTableHeader = MaterialBorders.OCEAN_LINE_BORDER;
    }

    @Override
    protected void installColor() {
        this.backgroundPrimary = MaterialColors.DARKLY_STRONG_BLUE;
        this.highlightBackgroundPrimary = MaterialColors.LIME_A400;

        this.textColor = MaterialColors.WHITE;
        this.disableTextColor = MaterialColors.GRAY_500;

        this.buttonBackgroundColor = MaterialColors.DARKLY_STRONG_BLUE;
        this.buttonBackgroundColorMouseHover = MaterialColors.DARKLY_BLUE;
        this.buttonTextColor = MaterialColors.WHITE;
        this.buttonDefaultBackgroundColorMouseHover = MaterialColors.LIME_200;
        this.buttonDefaultBackgroundColor = MaterialColors.LIME_A200;
        this.buttonDefaultTextColor = MaterialColors.BLACK;
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
        this.menuTextColor = MaterialColors.WHITE;
        this.menuDisableBackground = MaterialColors.TRANSPANENT;

        this.arrowButtonBackgroundSpinner = MaterialColors.DARKLY_STRONG_BLUE;
        this.mouseHoverButtonColorSpinner = MaterialColors.DARKLY_BLUE;

        this.arrowButtonColorScrollBar = MaterialColors.DARKLY_STRONG_BLUE;
        this.trackColorScrollBar = MaterialColors.DARKLY_BLUE;
        this.thumbColorScrollBar = MaterialColors.GRAY_500;
        this.thumbDarkShadowColorScrollBar = MaterialColors.GRAY_500;
        this.thumbHighlightColorScrollBar = MaterialColors.GRAY_500;
        this.thumbShadowColorScrollBar = MaterialColors.GRAY_500;
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
        this.foregroundTable = MaterialColors.WHITE;
        this.foregroundTableHeader = MaterialColors.LIME_A400;
        this.selectionBackgroundTable = MaterialColors.LIME_A100;
        this.selectionForegroundTable = MaterialColors.BLACK;
        this.gridColorTable = MaterialColors.COSMO_BLACK;
        this.alternateRowBackgroundTable = MaterialColors.DARKLY_BLUE;

        this.dockingBackgroundToolBar = MaterialColors.LIGHT_GREEN_A100;
        this.floatingBackgroundToolBar = MaterialColors.GRAY_200;

        this.selectionBackgroundTree = MaterialColors.DARKLY_BLUE;
        this.selectionBorderColorTree = MaterialColors.LIME_A400;

        this.backgroundTextField = MaterialColors.DARKLY_BLUE;
        this.inactiveForegroundTextField = MaterialColors.WHITE;
        this.inactiveBackgroundTextField = MaterialColors.DARKLY_BLUE;
        this.selectionBackgroundTextField = MaterialColors.LIME_A100;
        this.selectionForegroundTextField = MaterialColors.BLACK;
        this.inactiveColorLineTextField = MaterialColors.WHITE;
        this.activeColorLineTextField = MaterialColors.LIME_A400;

        this.titleBackgroundGradientStartTaskPane = MaterialColors.GRAY_300;
        this.titleBackgroundGradientEndTaskPane = MaterialColors.GRAY_500;
        this.titleOverTaskPane = MaterialColors.WHITE;
        this.specialTitleOverTaskPane = MaterialColors.WHITE;
        this.backgroundTaskPane = MaterialColors.DARKLY_STRONG_BLUE;
        this.borderColorTaskPane = MaterialColors.DARKLY_STRONG_BLUE;
        this.contentBackgroundTaskPane = MaterialColors.DARKLY_STRONG_BLUE;

        this.selectionBackgroundList = MaterialColors.DARKLY_BLUE;
        this.selectionForegroundList = MaterialColors.WHITE;

        this.backgroundProgressBar = MaterialColors.DARKLY_BLUE;
        this.foregroundProgressBar = MaterialColors.LIME_A400;
    }

    @Override
    public void installUIDefault(UIDefaults table) {
        super.installUIDefault(table);

        table.put("TabbedPane[contentBorder].enableTop", false);
        table.put("TabbedPane[contentBorder].enableLeaf", false);
        table.put("TabbedPane[contentBorder].enableRight", false);
        table.put("TabbedPane[contentBorder].enableBottom", false);
    }

    @Override
    public String getName() {
        return "Material Dark";
    }
}
