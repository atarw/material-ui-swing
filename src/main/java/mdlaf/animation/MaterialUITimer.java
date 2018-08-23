package mdlaf.animation;

import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MaterialUITimer implements MouseListener, ActionListener {

	private Color from, to;
	private boolean forward;
	private int alpha, steps;
	private int[] forwardDeltas, backwardDeltas;

	private JComponent component;
	private Timer timer;

	protected MaterialUITimer (JComponent component, Color to, int steps, int interval) {
		this.from = component.getBackground ();
		this.to = to;

		this.forwardDeltas = new int[4];
		this.backwardDeltas = new int[4];

		forwardDeltas[0] = (from.getRed () - to.getRed ()) / steps;
		forwardDeltas[1] = (from.getGreen () - to.getGreen ()) / steps;
		forwardDeltas[2] = (from.getBlue () - to.getBlue ()) / steps;
		forwardDeltas[3] = (from.getAlpha () - to.getAlpha ()) / steps;

		backwardDeltas[0] = (to.getRed () - from.getRed ()) / steps;
		backwardDeltas[1] = (to.getGreen () - from.getGreen ()) / steps;
		backwardDeltas[2] = (to.getBlue () - from.getBlue ()) / steps;
		backwardDeltas[3] = (to.getAlpha () - from.getAlpha ()) / steps;

		this.steps = steps;

		this.component = component;
		this.component.addMouseListener (this);
		timer = new Timer (interval, this);
	}

	private Color nextColor () {
		int rValue = from.getRed () - alpha * forwardDeltas[0];
		int gValue = from.getGreen () - alpha * forwardDeltas[1];
		int bValue = from.getBlue () - alpha * forwardDeltas[2];
		int aValue = from.getAlpha () - alpha * forwardDeltas[3];

		return new Color (rValue, gValue, bValue, aValue);
	}

	private Color previousColor () {
		int rValue = to.getRed () - (steps - alpha) * backwardDeltas[0];
		int gValue = to.getGreen () - (steps - alpha) * backwardDeltas[1];
		int bValue = to.getBlue () - (steps - alpha) * backwardDeltas[2];
		int aValue = to.getAlpha () - (steps - alpha) * backwardDeltas[3];

		return new Color (rValue, gValue, bValue, aValue);
	}

	@Override
	public void mousePressed (MouseEvent me) {
		alpha = steps - 1;
		forward = false;
		timer.start ();

		alpha = 0;
		forward = true;
		timer.start ();
	}

	@Override
	public void mouseReleased (MouseEvent me) {

	}

	@Override
	public void mouseClicked (MouseEvent me) {

	}

	@Override
	public void mouseExited (MouseEvent me) {
		alpha = steps - 1;
		forward = false;
		timer.start ();
	}

	@Override
	public void mouseEntered (MouseEvent me) {
		alpha = 0;
		forward = true;
		timer.start ();
	}

	@Override
	public void actionPerformed (ActionEvent ae) {
		if (forward) {
			component.setBackground (nextColor ());
			++alpha;
		}
		else {
			component.setBackground (previousColor ());
			--alpha;
		}

		if (alpha == steps + 1 || alpha == -1) {
			timer.stop ();
		}
	}
}