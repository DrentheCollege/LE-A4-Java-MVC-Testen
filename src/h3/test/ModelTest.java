package h3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ModelTest {
	@Test
	public void testCreate() {
		Model model = new Model();
		assertEquals("Create test", 0, model.counter);
	}

	@Test
	public void testGetter() {
		Model model = new Model();
		model.counter = 14;

		assertEquals("Getter test", model.counter, model.getCounter());
	}

	@Test
	public void testSetter() {
		Model model = new Model();
		int oldValue = 14;
		
		model.counter = oldValue;
		model.setCounter(oldValue+1);
		int newValue = model.counter;
		assertEquals("Setter test", oldValue + 1, newValue);
	}

	@Test
	public void testReset() {
		Model model = new Model();
		model.setCounter(1);
		assertNotEquals(0, model.getCounter());
		
		model.reset();
		assertEquals("Model reset", 0, model.getCounter());
	}

}
