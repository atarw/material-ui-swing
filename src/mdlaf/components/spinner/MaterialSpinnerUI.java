package mdlaf.components.spinner;

import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class MaterialSpinnerUI extends BasicSpinnerUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialSpinnerUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JSpinner spinner = (JSpinner) c;
		spinner.setOpaque (false);
		spinner.setFont (MaterialFonts.REGULAR);
		spinner.setBackground (Color.WHITE);
		spinner.setForeground (Color.BLACK);
		spinner.setBorder (MaterialBorders.LIGHT_LINE_BORDER);
	}

	@Override
	protected JComponent createEditor () {
		JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) super.createEditor ();
		editor.getTextField ().setUI (new MaterialTextFieldUI (false));

		return editor;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected Component createNextButton () {
		JButton button = new JButton (new ImageIcon (MaterialImages.UP_ARROW));

		button.setOpaque (true);
		button.setBackground (MaterialColors.LIGHT_GRAY);
		button.setBorder (BorderFactory.createEmptyBorder ());
		installNextButtonListeners (button);

		return button;
	}

	@Override
	protected Component createPreviousButton () {
		JButton button = new JButton (new ImageIcon (MaterialImages.DOWN_ARROW));

		button.setOpaque (true);
		button.setBackground (MaterialColors.LIGHT_GRAY);
		button.setBorder (BorderFactory.createEmptyBorder ());
		installPreviousButtonListeners (button);

		return button;
	}
}
