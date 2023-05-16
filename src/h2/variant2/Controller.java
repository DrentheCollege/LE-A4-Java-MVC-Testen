package h2.variant2;

import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class Controller extends JPanel {

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	JButton clickButton;
	private View view;
	private Model model;

	public Controller() {
		model = new Model();
		view = new View();
		addPropertyChangeListener(view);
		this.add(view);
		clickButton = new JButton("+1");
		clickButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				increase();
			}
		});
		this.add(clickButton);
	}

	public void increase() {
		int oldValue = model.getCounter();
		model.setCounter(oldValue+1);
		pcs.firePropertyChange("counter", oldValue, model.getCounter());
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

}