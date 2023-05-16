package h3.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.*;

public class Controller extends JPanel {

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	JButton clickButton;
	private View view;
	protected Model model;

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

	public void reset() {
		model.reset();
		
	}

}