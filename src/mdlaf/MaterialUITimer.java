package mdlaf;

import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MaterialUITimer implements MouseListener, ActionListener {

	private List<Color> colors;
	private JComponent component;
	private Timer timer;
	private int alpha;
	private int increment;

	public void mousePressed (MouseEvent me) {
		alpha = colors.size () - 1;
		increment = -1;
		timer.start ();

		alpha = 0;
		increment = 1;
		timer.start ();
	}

	public void mouseReleased (MouseEvent me) {

	}

	public void mouseClicked (MouseEvent me) {

	}

	public void mouseExited (MouseEvent me) {
		alpha = colors.size () - 1;
		increment = -1;
		timer.start ();
	}

	public void mouseEntered (MouseEvent me) {
		alpha = 0;
		increment = 1;
		timer.start ();
	}

	public void actionPerformed (ActionEvent ae) {
		alpha += increment;
		component.setBackground (colors.get (alpha));

		if (alpha == colors.size () - 1 || alpha == 0) {
			timer.stop ();
		}
	}

	protected MaterialUITimer (List<Color> colors, JComponent component, int interval) {
		this.colors = colors;
		this.component = component;

		this.component.addMouseListener (this);
		timer = new Timer (interval, this);
	}
}