package h3.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ControllerTest {

	@Test
	public void testIncrease() {
		Controller controller = new Controller();

		int oldValue = controller.model.getCounter();
		controller.increase();

		int newValue = controller.model.getCounter();
		assertEquals(oldValue + 1, newValue);

		// ik verwacht dat de waarde veranderd en dus niet hetzelfde blijft.
		controller.increase();
		assertNotEquals(oldValue + 1, controller.model.getCounter());
	}

	@Test
	public void testReset() {
		Controller controller = new Controller();

		controller.model.setCounter(1);
		assertNotEquals(0, controller.model.getCounter());
		controller.reset();
		assertEquals(0, controller.model.getCounter());
	}

}
