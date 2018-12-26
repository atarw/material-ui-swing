package mdlaf.components.textpane;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextPaneUI;

/**
 * @author https://github.com/vincenzopalazzo
 */

public class MaterialTextPaneUI extends BasicTextPaneUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTextPaneUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
	}
}
