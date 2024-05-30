package h7.interface3.bke.views;

import javax.swing.*;

import h7.interface3.bke.controllers.BKEController;
import h7.interface3.bke.interfaces.IBKEController;
import h7.interface3.bke.models.BKEModel;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class BKEView extends JFrame implements PropertyChangeListener {
	
	JLabel jlresultaat = new JLabel("resultaat");
	JPanel pButtons;
	private IBKEController controller;
	
	public BKEView() {
		JPanel content = new JPanel();
		pButtons = new JPanel();
		pButtons.setLayout(new GridLayout(3,3));
		pButtons.setPreferredSize(new Dimension(300, 300));
		
		content.add(pButtons);
		for (int i=0; i<BKEModel.FIELDCOUNT; i++) {
			BKEButton jb = new BKEButton(i);
			jb.addActionListener(new BKEButtonClick());
			pButtons.add(jb);
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.add(content, BorderLayout.CENTER);
		this.add(jlresultaat, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}

	public void setController(IBKEController controller) {
		this.controller = controller;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propName = evt.getPropertyName();
		if (propName.startsWith(BKEController.BUTTON)) {
			int selected = Integer.parseInt(propName.substring(6));
			for (Component comp: pButtons.getComponents()) {
				if (comp instanceof BKEButton) {
					BKEButton mb = (BKEButton) comp;
					if (mb.getId() == selected) {
						mb.setText((String) evt.getNewValue());
					}
				}
			}
		}
		if (propName.equals(BKEController.RESULT)) {
			jlresultaat.setText((String) evt.getNewValue());
		}
	}
	
	class BKEButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			BKEButton clicked = (BKEButton) e.getSource();
			controller.setClicked(clicked.getId());
		}
		
	}

}
