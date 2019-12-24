/*
 * MIT License
 *
 * Copyright (c) 2018 https://github.com/atarw
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
package mdlaf.components.password;

import mdlaf.components.textfield.MaterialComponentField;
import mdlaf.utils.MaterialDrawingUtils;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.text.Element;
import javax.swing.text.PasswordView;
import javax.swing.text.View;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialPasswordFieldUI extends MaterialComponentField{

	protected static final String ProprietyPrefix = "PasswordField";
	protected BasicPasswordFieldUI basicPasswordFieldUI = new BasicPasswordFieldUI();

	public MaterialPasswordFieldUI() {
		this(true);
	}

	public MaterialPasswordFieldUI(boolean drawLine) {
		super();
		this.drawLine = drawLine;
	}

	public static ComponentUI createUI(JComponent c) {
		return new MaterialPasswordFieldUI();
	}

	@Override
	protected String getPropertyPrefix() {
		return ProprietyPrefix;
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		basicPasswordFieldUI.installUI(c);
		JPasswordField passwordField = (JPasswordField) c;
		passwordField.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
		installMyDefaults(passwordField);
	}

	@Override
	protected void installDefaults() {
		super.installDefaults();
	}

	@Override
	public void uninstallUI(JComponent c) {
		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		basicPasswordFieldUI.uninstallUI(c);
		textComponent = null;
		super.uninstallUI(c);
	}

	@Override
	protected void uninstallDefaults() {
		super.uninstallDefaults();
		getComponent().setBorder(null);
	}

	@Override
	protected void installListeners() {
		super.installListeners();
		getComponent().addFocusListener(focusListenerColorLine);
		getComponent().addPropertyChangeListener(propertyChangeListener);
		propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
	}

	@Override
	protected void uninstallListeners() {
		getComponent().removeFocusListener(focusListenerColorLine);
		getComponent().removePropertyChangeListener(propertyChangeListener);
		propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
		super.uninstallListeners();
	}

	@Override
	protected void paintBackground(Graphics g) {
		super.paintBackground(MaterialDrawingUtils.getAliasedGraphics(g));
	}

	@Override
	public void paintSafely(Graphics g) {
		super.paintSafely(g);
		changeColorOnFocus(g);
		paintLine(g);
	}

	//Creating View
	@Override
	public View create(Element elem) {
		return new MaterialPasswordView(elem);
	}

	protected class MaterialPasswordView extends PasswordView {

		private MaterialPasswordView(Element elem) {
			super(elem);
		}

		// depreciated in Java 9 and above - replace method with float drawEchoCharacter(Graphics2D g, float x, float y, char c)
		@Override
		protected int drawEchoCharacter(Graphics g, int x, int y, char c) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			FontMetrics fm = g2.getFontMetrics();
			int r = fm.charWidth(c) - 2;

			//The line with the comment introduced this bug https://github.com/vincenzopalazzo/material-ui-swing/issues/72
			//g2.setPaint(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
			g2.fillOval(x + 1, y + 5 - fm.getAscent(), r, r);
			g2.dispose();

			return x + fm.charWidth(c);
		}
	}
}