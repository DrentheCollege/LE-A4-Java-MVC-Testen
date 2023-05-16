package h2.variant2;

import java.beans.*;
import javax.swing.*;

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
