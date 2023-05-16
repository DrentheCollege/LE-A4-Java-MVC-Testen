package h3.test;

public class ModelDefect {
	int counter = 42; //zou 0 moeten zijn
	public ModelDefect() {
	}

	public int getCounter() {
		return 12; //eigenlijk moet counter teruggegeven worden
	}

	protected void setCounter(int counter) {
		this.counter = counter+5; // dit moet counter zijn
	}

	void reset() {
		setCounter(1); // deze moet op 0 gezet worden
	}
}