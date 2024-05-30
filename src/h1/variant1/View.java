package h1.variant1;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class View extends JFrame {
	private JLabel display;
	JButton clickButton;
	Controller controller;
	
	public View() {
		controller = new Controller(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 200);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		display = new JLabel("text");
		this.add(display);
		
		clickButton = new JButton("+1");
		clickButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.doIncrease();
			}
		});
		this.add(clickButton);
		
		this.pack();		
	}

	public void setDisplay(String text) {
		display.setText(text);
	}
}
