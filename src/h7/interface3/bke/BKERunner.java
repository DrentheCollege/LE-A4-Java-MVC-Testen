package h7.interface3.bke;

import h7.interface3.bke.controllers.BKEController;
import h7.interface3.bke.interfaces.IBKEController;
import h7.interface3.bke.interfaces.IBKEModel;
import h7.interface3.bke.models.BKEModel;
import h7.interface3.bke.views.BKEView;

public class BKERunner {

	public static void main(String[] args) {
		
		BKEView view = new BKEView();
		IBKEController controller = new BKEController();
		view.setController(controller);
		
		controller.addPropertyChangeListener(view);
		IBKEModel model = new BKEModel();
		controller.setModel(model);
	}

}
