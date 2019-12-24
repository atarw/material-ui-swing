package mdlaf.themes;

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
public class JMarsDarkTheme extends AbstractMaterialTheme {

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
        borderMenuBar = new BorderUIResource(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(225, 156, 43)));
        borderPopupMenu = new BorderUIResource(BorderFactory.createLineBorder(backgroundPrimary, 1));
        borderSpinner = new BorderUIResource(BorderFactory.createLineBorder(backgroundPrimary, 1));
        borderSlider = new BorderUIResource(BorderFactory.createCompoundBorder(borderSpinner, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        cellBorderTableHeader = new BorderUIResource(BorderFactory.createCompoundBorder(
                borderSpinner,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        borderToolBar = borderSpinner;

        borderDialogRootPane = borderSpinner;

        borderProgressBar = borderSpinner;

        this.borderComboBox = MaterialBorders.roundedLineColorBorder(MaterialColors.WHITE, 12);
        this.borderTable = borderSpinner;
        this.borderTableHeader = borderSpinner;
    }

    @Override
    protected void installColor() {
        this.backgroundPrimary = new ColorUIResource(45, 48, 56);
        this.highlightBackgroundPrimary = new ColorUIResource(66,179,176);

        this.textColor = new ColorUIResource(255, 255, 255);
        this.disableTextColor = new ColorUIResource(170, 170, 170);

        this.buttonBackgroundColor = new ColorUIResource(45, 48, 56);
        this.buttonBackgroundColorMouseHover = new ColorUIResource(81, 86, 101);
        this.buttonTextColor = MaterialColors.WHITE;
        this.buttonDefaultBackgroundColorMouseHover = new ColorUIResource(23, 137, 134);
        this.buttonDefaultBackgroundColor = new ColorUIResource(66,179,176);
        this.buttonDefaultTextColor = MaterialColors.WHITE;
        this.buttonDisabledBackground = new ColorUIResource(66,69,76);
        this.buttonDisabledForeground = MaterialColors.GRAY_500;
        this.buttonFocusColor = MaterialColors.WHITE;
        this.buttonDefaultFocusColor = MaterialColors.BLACK;
        this.buttonBorderColor = MaterialColors.WHITE;
        this.buttonColorHighlight = buttonBackgroundColorMouseHover;

        this.selectedInDropDownBackgroundComboBox = new ColorUIResource(249, 192, 98);
        this.selectedForegroundComboBox = MaterialColors.BLACK;

        this.menuBackground = backgroundPrimary;
        this.menuBackgroundMouseHover = buttonBackgroundColorMouseHover;
        this.menuTextColor = MaterialColors.WHITE;
        this.menuDisableBackground = MaterialColors.TRANSPANENT;

        this.arrowButtonBackgroundSpinner = buttonBackgroundColor;
        this.mouseHoverButtonColorSpinner = buttonBackgroundColorMouseHover;

        this.arrowButtonColorScrollBar = buttonBackgroundColor;
        this.trackColorScrollBar = new ColorUIResource(81, 86, 101);
        this.thumbColorScrollBar = new ColorUIResource(155,155,155);
        this.thumbDarkShadowColorScrollBar = thumbColorScrollBar;
        this.thumbHighlightColorScrollBar = thumbColorScrollBar;
        this.thumbShadowColorScrollBar = thumbColorScrollBar;
        this.arrowButtonOnClickColorScrollBar = buttonBackgroundColorMouseHover;
        this.mouseHoverColorScrollBar = thumbColorScrollBar;

        this.trackColorSlider = new ColorUIResource(119, 119, 119);
        this.haloColorSlider = MaterialColors.bleach(new Color(249, 192, 98), 0.2f);

        this.highlightColorTabbedPane = new ColorUIResource(45,48,56);
        this.borderHighlightColorTabbedPane = new ColorUIResource(45,48,56);
        this.focusColorLineTabbedPane = new ColorUIResource(249, 192, 98);
        this.disableColorTabTabbedPane = new ColorUIResource(170,170,170);

        this.backgroundTable = new ColorUIResource(45,48,56);
        this.backgroundTableHeader = new ColorUIResource(66,179,176);
        this.foregroundTable = textColor;
        this.foregroundTableHeader = textColor;
        this.selectionBackgroundTable = new ColorUIResource(126, 132, 153);
        this.selectionForegroundTable = textColor;
        this.gridColorTable = new ColorUIResource(151,151,151);
        this.alternateRowBackgroundTable = new ColorUIResource(59, 62, 69);

        this.dockingBackgroundToolBar = MaterialColors.LIGHT_GREEN_A100;
        this.floatingBackgroundToolBar = MaterialColors.GRAY_200;

        this.selectionBackgroundTree = new ColorUIResource(81, 86, 101);
        this.selectionBorderColorTree = selectionBackgroundTree;

        this.backgroundTextField = new ColorUIResource(81, 86, 101);
        this.inactiveForegroundTextField = MaterialColors.WHITE;
        this.inactiveBackgroundTextField = new ColorUIResource(81, 86, 101);
        this.selectionBackgroundTextField = new ColorUIResource(249, 192, 98);
        this.selectionForegroundTextField = MaterialColors.BLACK;
        this.inactiveColorLineTextField = MaterialColors.WHITE;
        this.activeColorLineTextField = new ColorUIResource(249, 192, 98);;

        this.titleBackgroundGradientStartTaskPane = MaterialColors.GRAY_300;
        this.titleBackgroundGradientEndTaskPane = MaterialColors.GRAY_500;
        this.titleOverTaskPane = MaterialColors.WHITE;
        this.specialTitleOverTaskPane = MaterialColors.WHITE;
        this.backgroundTaskPane = backgroundPrimary;
        this.borderColorTaskPane = backgroundTaskPane;
        this.contentBackgroundTaskPane = backgroundPrimary;

        this.selectionBackgroundList = new ColorUIResource(249, 192, 9);
        this.selectionForegroundList = MaterialColors.BLACK;

        this.backgroundProgressBar = new ColorUIResource(81, 86, 101);
        this.foregroundProgressBar = MaterialColors.WHITE;
    }

    @Override
    public void installUIDefault(UIDefaults table) {
        super.installUIDefault(table);

        table.put("TabbedPane[contentBorder].enableTop", true);
        table.put("TabbedPane[contentBorder].enableLeaf", false);
        table.put("TabbedPane[contentBorder].enableRight", false);
        table.put("TabbedPane[contentBorder].enableBottom", false);
    }

    @Override
    public String getName() {
        return "JMars Dark";
    }
}
