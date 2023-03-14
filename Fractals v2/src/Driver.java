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
		// rings(g, 200, 0, 0);
		// clover(g, 200, 0, 0);
		// squares(g, 100, 250, 250);
		triangles(g, 200, 200, 200);

	}// end of paint method - put code above for anything dealing with drawing -

	public void clover(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		// Top half
		g.drawOval(x, y, radius, radius);
		g.drawOval(x + radius, y, radius, radius);
		g.drawOval(x, y + radius, radius, radius);
		g.drawOval(x + radius, y + radius, radius, radius);
		if (radius > 1) {
			// recursively call the method if radius is > 1
			clover(g, radius - 10, x + 10, y + 10);
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

	public void squares(Graphics g, int width, int x, int y) {
		g.drawRect(x, y, width + 100, width + 100);
		g.drawRect(x + 200, y, width - 10, width - 10);
		g.drawRect(x - 200, y, width, width);
		g.drawRect(x, y + 200, width, width);
		g.drawRect(x - 200, y + 200, width, width);
		g.drawRect(x + 200, y + 200, width, width);
		g.drawRect(x + 200, y - 200, width, width);
		g.drawRect(x - 200, y - 200, width, width);
		g.drawRect(x, y - 200, width, width);
		if (width > 1) {
			squares(g, width - 10, x + 10, y + 10);
		}
	}

	public void triangles(Graphics g, int length, int x, int y) {
		g.drawLine(x, y, x + length, y);
		g.drawLine(x, y, x + length / 2, (int) (y - (Math.pow(3, 1 / 2) * length / 2)));
		g.drawLine(x + length, y, x + length / 2, (int) (y - (Math.pow(3, 1 / 2) * length / 2)));
		
		g.drawLine(x + length / 4, (int) (y - (Math.pow(3, 1 / 2) * length / 4)), x + length / 2, y);
		g.drawLine(x + length / 4, (int) (y - (Math.pow(3, 1 / 2) * length / 4)), x + length * 3/4, (int) (y - (Math.pow(3, 1 / 2) * length / 4)));
		g.drawLine(x + length * 3/4, (int) (y - (Math.pow(3, 1 / 2) * length / 4)), x + length / 2, y);

		if(length > 1) {
			triangles(g, length / 2, x + length/2, y);
			triangles(g, length / 2, x, y);
			triangles(g, length / 2, x + length /4, y - (int) ((Math.pow(3, 1 / 2) * length / 4)));
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
