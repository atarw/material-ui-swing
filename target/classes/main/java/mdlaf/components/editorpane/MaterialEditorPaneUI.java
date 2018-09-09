package mdlaf.components.editorpane;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicEditorPaneUI;

/**
 * @author https://github.com/vincenzopalazzo
 */

public class MaterialEditorPaneUI extends BasicEditorPaneUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialEditorPaneUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
	}
}
