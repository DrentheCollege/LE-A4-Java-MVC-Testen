package h1.variant1;

public class Controller {
	
	private Model model;
	private View view;

	public Controller(View view) {
		this.model = new Model();
		this.view  = view;
	
	}

	public void doIncrease() {
		model.increase();
		view.setDisplay(model.getCounter().toString());
	}
}
