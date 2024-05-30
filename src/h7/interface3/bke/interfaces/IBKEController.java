package h7.interface3.bke.interfaces;

import java.beans.PropertyChangeListener;

public interface IBKEController {
	public final static String BUTTON = "button";
	public final static String RESULT = "result";
	public static final String FINISHED = "Game over";
	public static final String TURNS = "Beurt";
	public static final String PLAYER = "Speler";
	public static final String WINNERIS = "Winnaar is";

	void addPropertyChangeListener(PropertyChangeListener view);
	void setModel(IBKEModel model);
	void setClicked(int id);
	
}
