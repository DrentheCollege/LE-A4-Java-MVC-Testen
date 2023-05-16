package h5.interface1.v4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestFrame extends JFrame {
	
	JPanel panel;

	public TestFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(100, 120);
		this.setLocationRelativeTo(null);

		panel = new JPanel();

		addButton("klik 1", new Klik1ActionListener());
		addButton("klik 2", new Klik2ActionListener());

		this.setVisible(true);
	}

	private void addButton(String text, ActionListener actionListener) {
		JButton jbKlik = new JButton(text);
		jbKlik.addActionListener(actionListener);
		panel.add(jbKlik);
		this.add(panel);
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
