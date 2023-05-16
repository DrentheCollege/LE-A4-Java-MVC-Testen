package h7.interface3.bke.controllers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import h7.interface3.bke.interfaces.Controller;
import h7.interface3.bke.interfaces.Model;
import h7.interface3.bke.models.BKEModel;

public class BKEController implements Controller {

	PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private Model model;

	public final static String BUTTON = "button";
	public final static String RESULT = "result";
	public static final String FINISHED = "Game over";
	public static final String TURNS = "Beurt";
	public static final String PLAYER = "Speler";
	public static final String WINNERIS = "Winnaar is";

	@Override
	public void addPropertyChangeListener(PropertyChangeListener view) {
		pcs.addPropertyChangeListener(view);
	}

	@Override
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void setClicked(int id) {
		if (!isGameOver()) {
			if (model.canSet(id)) {
				model.setField(id);
				pcs.firePropertyChange(BUTTON + id, "", String.valueOf(model.getCurrentPlayer()));

				changePlayer();
			}
		}
		displayGameStatus();
	}

	protected void changePlayer() {
		if (model.getCurrentPlayer() == BKEModel.PLAYER1) {
			model.setCurrentPlayer(BKEModel.PLAYER2);
		} else {
			model.setCurrentPlayer(BKEModel.PLAYER1);
		}
	}

	private void displayGameStatus() {
		if (!isGameOver()) {
			pcs.firePropertyChange(RESULT, "", BKEController.TURNS + ": " + Integer.toString(model.getTurns()) + " "
					+ BKEController.PLAYER + ": " + model.getCurrentPlayer());
		} else {
			if (getWinner() != 0) {
				pcs.firePropertyChange(RESULT, "",
						BKEController.FINISHED + " " + BKEController.WINNERIS + " " + getWinner());
			} else {
				pcs.firePropertyChange(RESULT, "", BKEController.FINISHED);
			}
		}
	}

	protected boolean isGameOver() {
		if (getWinner() != 0) {
			return true;
		}
		return model.getTurns() >= BKEModel.FIELDCOUNT;
	}

	protected char getWinner() {
		char[] fields = model.getFields();
		char winner = 0;

		// controleer kolommen
		for (int iKolom = 0; iKolom < Math.sqrt(BKEModel.FIELDCOUNT) && winner == 0; iKolom++) {
			if (fields[iKolom] == fields[3 + iKolom] && fields[iKolom] == fields[6 + iKolom]) {
				winner = fields[iKolom];
			}
		}
		;

		// controleer rijen
		for (int iRij = 0; iRij < Math.sqrt(BKEModel.FIELDCOUNT) && winner == 0; iRij++) {
			if (fields[iRij * 3] == fields[1 + iRij * 3] && fields[iRij * 3] == fields[2 + iRij * 3]) {
				winner = fields[iRij * 3];
			}
		}
		;

		// controleer diagonaal
		if (fields[0] == fields[4] && fields[0] == fields[8]) {
			winner = fields[0];
		}

		// controleer diagonaal
		if (fields[2] == fields[4] && fields[2] == fields[6]) {
			winner = fields[2];
		}

		return winner;
	}

	public void reset() {
		model.reset();
		displayGameStatus();
	}

}
