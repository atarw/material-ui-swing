package mdlaf.components.spinner;

import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;
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
		spinner.setFont (UIManager.getFont ("Spinner.font"));
		spinner.setBackground (UIManager.getColor ("Spinner.background"));
		spinner.setForeground (UIManager.getColor ("Spinner.foreground"));
		spinner.setBorder (UIManager.getBorder ("Spinner.border"));
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
		Icon icon = UIManager.getIcon ("Spinner.nextButtonIcon");
		JButton button;
		if (icon != null) {
			button = new JButton (icon);
		}
		else {
			button = new BasicArrowButton (SwingConstants.NORTH);
		}
		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("Spinner.arrowButtonBackground"));
		button.setBorder (UIManager.getBorder ("Spinner.arrowButtonBorder"));
		installNextButtonListeners (button);

		return button;
	}

	@Override
	protected Component createPreviousButton () {
		Icon icon = UIManager.getIcon ("Spinner.previousButtonIcon");
		JButton button;
		if (icon != null) {
			button = new JButton (icon);
		}
		else {
			button = new BasicArrowButton (SwingConstants.SOUTH);
		}

		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("Spinner.arrowButtonBackground"));
		button.setBorder (UIManager.getBorder ("Spinner.arrowButtonBorder"));
		installPreviousButtonListeners (button);

		return button;
	}
}
