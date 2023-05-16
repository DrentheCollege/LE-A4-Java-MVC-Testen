package h5.interface1.v2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestFrame extends JFrame {

	public TestFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(100, 100);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JButton jbKlik = new JButton("klik");
		jbKlik.addActionListener(new KlikActionListener());
		panel.add(jbKlik);
		this.add(panel);

		this.setVisible(true);
	}
	
	class KlikActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("klik");
		}
		
	}

}
