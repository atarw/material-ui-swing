package mdlaf.components.textfield;

import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//TODO al clic sulla jtextfield cancellare quello che c'e scritto.
public class MaterialTextFieldUI extends BasicTextFieldUI implements FocusListener, PropertyChangeListener {

	private Color focusedBackground;
	private Color unfocusedBackground;
	private Color focusedSelectionBackground;
	private Color unfocusedSelectionBackground;
	private boolean drawLine;

	public MaterialTextFieldUI () {
		this (true);
	}

	public MaterialTextFieldUI (boolean drawLine) {
		super ();
		this.drawLine = drawLine;
	}

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTextFieldUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTextField textField = (JTextField) c;
		textField.setOpaque (false);
		textField.setBorder (drawLine ?
		                     BorderFactory.createEmptyBorder (5, 2, 10, 0) :
		                     BorderFactory.createEmptyBorder (2, 2, 2, 2));

		textField.setBackground (MaterialColors.LIGHT_BLUE_400);
		textField.setFont (MaterialFonts.REGULAR);

		this.focusedBackground = textField.getBackground ();
		this.unfocusedBackground = MaterialColors.GRAY_200;

		this.focusedSelectionBackground = MaterialColors.bleach (focusedBackground, 0.3f);
		this.unfocusedSelectionBackground = unfocusedBackground;
	}

	@Override
	protected void installListeners () {
		super.installListeners ();
		getComponent ().addFocusListener (this);
		getComponent ().addPropertyChangeListener (this);
	}

	@Override
	protected void installKeyboardActions () {
		super.installKeyboardActions ();

		Action selectAll = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				getComponent ().selectAll ();
			}
		};

		Action delete = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				if (getComponent ().getSelectedText () == null) {
					int pos = getComponent ().getCaretPosition () - 1;

					if (pos >= 0) {
						getComponent ().select (pos, pos + 1);
						getComponent ().replaceSelection ("");
					}
				}
				else {
					getComponent ().replaceSelection ("");
				}
			}
		};

		Action left = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				getComponent ().setCaretPosition (Math.max (0, getComponent ().getCaretPosition () - 1));
			}
		};

		Action right = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				getComponent ().setCaretPosition (Math.min (getComponent ().getText ().length (), getComponent ().getCaretPosition () + 1));
			}
		};

		Action enter = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				((JTextField) getComponent ()).postActionEvent ();
			}
		};

		// note getMenuShortcutKeyMask() is deprecated in Java 10 - change to getMenuShortcutKeyMaskEx()
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_A, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask ()), "selectAll");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_BACK_SPACE, 0), "delete");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_LEFT, 0), "left");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_RIGHT, 0), "right");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_ENTER, 0), "enter");

		getComponent ().getActionMap ().put ("selectAll", selectAll);
		getComponent ().getActionMap ().put ("delete", delete);
		getComponent ().getActionMap ().put ("left", left);
		getComponent ().getActionMap ().put ("right", right);
		getComponent ().getActionMap ().put ("enter", enter);
	}

	@Override
	public void paintSafely (Graphics g) {
		JTextField c = (JTextField) getComponent ();
		g = MaterialDrawingUtils.getAliasedGraphics (g);

		Color lineColor;

		if (getComponent ().hasFocus ()) {
			lineColor = focusedBackground;
			c.setSelectionColor (focusedSelectionBackground);
		}
		else {
			lineColor = unfocusedBackground;
			c.setSelectionColor (unfocusedSelectionBackground);
		}

		g.setColor (lineColor);
		getComponent ().setBackground (lineColor);

		if (drawLine) {
			int x = getComponent ().getInsets ().left;
			int y = getComponent ().getInsets ().top;
			int w = getComponent ().getWidth () - getComponent ().getInsets ().left - getComponent ().getInsets ().right;

			g.fillRect (x, c.getHeight () - y, w, 2);
		}

		super.paintSafely (g);
	}

	@Override
	public void paintBackground (final Graphics g) {
		super.paintBackground (MaterialDrawingUtils.getAliasedGraphics (g));
	}

	@Override
	public void focusGained (FocusEvent e) {
		e.getComponent ().setBackground (focusedBackground);
	}

	@Override
	public void focusLost (FocusEvent e) {
		e.getComponent ().setBackground (unfocusedBackground);
	}

	@Override
	public void propertyChange (PropertyChangeEvent pce) {
		super.propertyChange (pce);

		if (pce.getPropertyName ().equals ("background")) {
			Color newColor = (Color) pce.getNewValue ();

			if (!newColor.equals (focusedBackground) && !newColor.equals (unfocusedBackground)) {
				this.focusedBackground = (Color) pce.getNewValue ();
				this.focusedSelectionBackground = MaterialColors.bleach (this.focusedBackground, 0.3f);
			}
		}
	}
}