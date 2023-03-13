import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FractalsLab extends JPanel implements ActionListener {

	public void paint(Graphics g) {

		super.paintComponent(g); // do not remove

	} // end of paint curly do not delete

	public void concentricCircles(int x, int y, int width, Graphics g) {
			
	}

	// do not touch
	public FractalsLab() {
		JFrame frame = new JFrame("Fractals");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		Timer t = new Timer(16, this);
		t.start();
		frame.setVisible(true);
	}// end of MainFrame

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	} // end of actionPerformed curly do not delete

	public static void main(String[] arg) {
		FractalsLab f = new FractalsLab();
	}

}//end of class curly - do not delete
