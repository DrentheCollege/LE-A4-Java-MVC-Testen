package h3.test;

public class ModelDefect {
	Integer counter = 42; //zou 0 moeten zijn
	
	public ModelDefect() {
	}

	public Integer getCounter() {
		return 12; //eigenlijk moet counter teruggegeven worden
	}

	public void increase() {
		counter += 5;
	}
}