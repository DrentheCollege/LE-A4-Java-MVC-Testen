package h3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ModelTest {
	
	
	@Test
	public void testCreate() {
		Model model = new Model();	
	
		assertEquals("Create test", Integer.valueOf(0), model.counter);
	}

	@Test
	public void testGetter() {
		Model model = new Model();	
		
		model.counter = 14;

		assertEquals("Getter test", model.counter, model.getCounter());
	}
	
	@Test
	public void testIncrease() {
		Model model = new Model();	

		int oldValue = model.getCounter();
		model.increase();

		int newValue = model.getCounter();
		assertEquals(oldValue + 1, newValue);

		// ik verwacht dat de waarde veranderd en dus niet hetzelfde blijft.
		model.increase();
		assertNotEquals(oldValue + 1, model.getCounter());
	}
	


}
