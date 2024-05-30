package h3.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ControllerTest {

	@Test
	public void testDoIncrease() {
		Controller controller = new Controller();

		int oldValue = controller.model.getCounter();
		controller.doIncrease();

		int newValue = controller.model.getCounter();
		assertEquals(oldValue + 1, newValue);

		// ik verwacht dat de waarde veranderd en dus niet hetzelfde blijft.
		controller.doIncrease();
		assertNotEquals(oldValue + 1, controller.model.getCounter());
	}

}
