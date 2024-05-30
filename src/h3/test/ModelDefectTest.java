package h3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelDefectTest extends ModelTest {
	
	@Test
	public void testCreate() {
		ModelDefect model = new ModelDefect();	
		
		assertEquals("Create test", Integer.valueOf(0), model.counter);
	}

	@Test
	public void testGetter() {
		ModelDefect model = new ModelDefect();	
		
		model.counter = 14;

		assertEquals("Getter test", model.counter, model.getCounter());
	}
	
	@Test
	public void testIncrease() {
		ModelDefect model = new ModelDefect();	
		
		int oldValue = model.getCounter();
		model.increase();

		int newValue = model.getCounter();
		assertEquals(oldValue + 1, newValue);

		// ik verwacht dat de waarde veranderd en dus niet hetzelfde blijft.
		model.increase();
		assertNotEquals(oldValue + 1, model.getCounter());
	}

}
