package h3.test;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Runner {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.add(new Controller());
		frame.pack();
	}
}