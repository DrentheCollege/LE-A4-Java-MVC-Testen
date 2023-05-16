package h5.interface1.v3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestFrame extends JFrame {

	public TestFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(100, 120);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JButton jbKlik1 = new JButton("klik 1");
		jbKlik1.addActionListener(new Klik1ActionListener());
		panel.add(jbKlik1);
		this.add(panel);

		JButton jbKlik2 = new JButton("klik 2");
		jbKlik2.addActionListener(new Klik2ActionListener());
		panel.add(jbKlik2);
		this.add(panel);

		this.setVisible(true);
	}
	
	class Klik1ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("1");
		}
		
	}

	class Klik2ActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("2");
		}
		
	}
}
