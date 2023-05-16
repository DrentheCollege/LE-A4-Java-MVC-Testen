package h7.interface3.bke.interfaces;

import java.beans.PropertyChangeListener;

public interface Controller {

	void addPropertyChangeListener(PropertyChangeListener view);
	void setModel(Model model);
	void setClicked(int id);
	
}
