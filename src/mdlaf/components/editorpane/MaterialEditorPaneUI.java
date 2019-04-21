package mdlaf.components.editorpane;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialFontFactory;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicEditorPaneUI;
import javax.swing.text.EditorKit;
import javax.swing.text.JTextComponent;
import java.awt.*;

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

	@Override
	protected void paintBackground(Graphics g) {
		super.paintBackground(MaterialDrawingUtils.getAliasedGraphics(g));
	}

	@Override
	protected void installDefaults() {
		super.installDefaults();
	}
}
