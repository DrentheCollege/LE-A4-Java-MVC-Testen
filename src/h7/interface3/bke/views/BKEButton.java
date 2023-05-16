package h7.interface3.bke.views;

import java.awt.Font;

import javax.swing.JButton;

public class BKEButton extends JButton {
	private int id;

	public int getId() {
		return id;
	}

	public BKEButton(int id) {
		this.setFont((new Font("Arial", Font.PLAIN, 40)));
		this.id = id;
		this.setText(" ");
	}

}
