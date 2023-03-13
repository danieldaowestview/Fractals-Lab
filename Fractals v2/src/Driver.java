import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	/* Attributes a.k.a. Instance Variables */
	int w = 800, h = 800;

	public void paint(Graphics g) {
		super.paintComponent(g);
		//rings(g, 200, 0, 0);
		clover(g, 200, 0, 0);

	}// end of paint method - put code above for anything dealing with drawing -

	public void clover(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);
		if (radius > 1) {
			// recursively call the method if radius is > 1
			rings(g, radius - 10, x + 10, y + 10);
		}

	}

	public void rings(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);

		// each call to the method would draw another ring
		if (radius > 1) {
			// recursively call the method if radius is > 1
			rings(g, radius - 10, x + 10, y + 10);
		}

	}

	/**
	 * Update the positions of the ball and paddle. Update the scores, counter and
	 * time
	 */
	public void update() {

	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/* Instantiate any attributes here (instance variables */
	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(w, h);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

}
