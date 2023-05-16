package h3.test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JPanel implements PropertyChangeListener{
	private JLabel display;

	public View() {
		display = new JLabel("text");
		this.add(display);
	}

	public void setDisplay(String text) {
		display.setText(text);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("counter")) {
			setDisplay(evt.getNewValue().toString());
		}
	}
}
