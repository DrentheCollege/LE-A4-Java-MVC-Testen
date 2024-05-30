package h3.test;

import java.beans.*;

public class Controller {

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	Model model;

	public Controller() {
		model = new Model();
	}

	public void doIncrease() {
		Integer oldValue = model.getCounter();
		model.increase();
		pcs.firePropertyChange("counter", oldValue, model.getCounter());
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

}