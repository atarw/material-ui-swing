package mdlaf.components.editorpane;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialEditorPaneUI extends BasicEditorPaneUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialEditorPaneUI ();
	}

	@Override
	protected void paintBackground(Graphics g) {
		super.paintBackground(MaterialDrawingUtils.getAliasedGraphics(g));
	}
}
