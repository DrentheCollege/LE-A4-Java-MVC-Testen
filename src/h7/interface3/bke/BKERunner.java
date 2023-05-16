package h7.interface3.bke;

import h7.interface3.bke.controllers.BKEController;
import h7.interface3.bke.interfaces.Controller;
import h7.interface3.bke.interfaces.Model;
import h7.interface3.bke.models.BKEModel;
import h7.interface3.bke.views.BKEView;

public class BKERunner {

	public static void main(String[] args) {
		
		BKEView view = new BKEView();
		Controller controller = new BKEController();
		view.setController(controller);
		
		controller.addPropertyChangeListener(view);
		Model model = new BKEModel();
		controller.setModel(model);
	}

}
