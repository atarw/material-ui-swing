package mdlaf.components.password;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.KeyStroke;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.text.Element;
import javax.swing.text.PasswordView;
import javax.swing.text.View;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MaterialPasswordFieldUI extends BasicPasswordFieldUI implements FocusListener, PropertyChangeListener {

	private Color focusedBackground;
	private Color unfocusedBackground;
	private Color focusedSelectionBackground;
	private Color unfocusedSelectionBackground;

	public static ComponentUI createUI (JComponent c) {
		return new MaterialPasswordFieldUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JPasswordField passwordField = (JPasswordField) c;
		passwordField.setOpaque (false);
		passwordField.setBorder (BorderFactory.createEmptyBorder (5, 2, 10, 0));
		passwordField.setBackground (MaterialColors.LIGHT_BLUE_400);

		this.focusedBackground = passwordField.getBackground ();
		this.unfocusedBackground = MaterialColors.GRAY_200;

		this.focusedSelectionBackground = MaterialColors.bleach (focusedBackground, 0.3f);
		this.unfocusedSelectionBackground = unfocusedBackground;
	}

	@Override
	protected void installListeners () {
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

		// note getMenuShortcutKeyMask() is deprecated in Java 10 - change to getMenuShortcutKeyMaskEx()
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_A, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask ()), "selectAll");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_BACK_SPACE, 0), "delete");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_LEFT, 0), "left");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_RIGHT, 0), "right");

		getComponent ().getActionMap ().put ("selectAll", selectAll);
		getComponent ().getActionMap ().put ("delete", delete);
		getComponent ().getActionMap ().put ("left", left);
		getComponent ().getActionMap ().put ("right", right);
	}

	@Override
	public void paintSafely (Graphics g) {
		JPasswordField c = (JPasswordField) getComponent ();
		g = MaterialDrawingUtils.getAliasedGraphics (g);

		if (getComponent ().hasFocus ()) {
			c.setBackground (focusedBackground);
			c.setSelectionColor (focusedSelectionBackground);
		}
		else {
			c.setBackground (unfocusedBackground);
			c.setSelectionColor (unfocusedSelectionBackground);
		}

		int x = getComponent ().getInsets ().left;
		int y = getComponent ().getInsets ().top;
		int w = getComponent ().getWidth () - getComponent ().getInsets ().left - getComponent ().getInsets ().right;

		g.setColor (c.getBackground ());
		g.fillRect (x, c.getHeight () - y, w, 2);

		super.paintSafely (g);
	}

	@Override
	public void paintBackground (Graphics g) {
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
		if (pce.getPropertyName ().equals ("background")) {
			Color newColor = (Color) pce.getNewValue ();

			if (!newColor.equals (focusedBackground) && !newColor.equals (unfocusedBackground)) {
				this.focusedBackground = (Color) pce.getNewValue ();
				this.focusedSelectionBackground = MaterialColors.bleach (this.focusedBackground, 0.3f);
			}
		}
	}

	@Override
	public View create (Element elem) {
		return new MaterialPasswordView (elem);
	}

	private static class MaterialPasswordView extends PasswordView {

		private MaterialPasswordView (Element elem) {
			super (elem);
		}

		// depreciated in Java 9 and above - replace method with float drawEchoCharacter(Graphics2D g, float x, float y, char c)
		@Override
		protected int drawEchoCharacter (Graphics g, int x, int y, char c) {
			Graphics2D g2 = (Graphics2D) g.create ();
			g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			FontMetrics fm = g2.getFontMetrics ();
			int r = fm.charWidth (c) - 2;

			g2.setPaint (Color.BLACK);
			g2.fillOval (x + 1, y + 5 - fm.getAscent (), r, r);
			g2.dispose ();

			return x + fm.charWidth (c);
		}
	}
}