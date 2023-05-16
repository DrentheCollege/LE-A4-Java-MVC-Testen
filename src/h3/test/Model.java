package h3.test;

public class Model {
	int counter = 0;
	public Model() {
	}

	public int getCounter() {
		return counter;
	}

	protected void setCounter(int counter) {
		this.counter = counter;
	}

	void reset() {
		setCounter(0);
	}
}