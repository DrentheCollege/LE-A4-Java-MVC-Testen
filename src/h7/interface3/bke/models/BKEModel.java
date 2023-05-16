package h7.interface3.bke.models;

import h7.interface3.bke.interfaces.Model;

public class BKEModel implements Model {
	protected char[] fields = new char[FIELDCOUNT];
	private char currentPlayer = PLAYER1;

	@Override
	public boolean canSet(int id) {
		// controleer of id binnen bereik is
		// en of het veld niet is gevuld
		return id >= 0 && id < FIELDCOUNT && (fields[id] == 0);
	}

	@Override
	public void setField(int id) {
		//alleen het veld zetten als het mag
		if (canSet(id))
			fields[id] = currentPlayer;
	}

	@Override
	public char getCurrentPlayer() {
		return currentPlayer;
	}

	@Override
	public void setCurrentPlayer(char currentPlayer) {
		//alleen PLAYER1 en PLAYER2 zijn geldige waarden
		if (currentPlayer == BKEModel.PLAYER1 || currentPlayer == BKEModel.PLAYER2) {
			this.currentPlayer = currentPlayer;
		}
	}

	@Override
	public int getTurns() {
		//als een veld gevuld is er een beurt geweest
		int count = 0;
		for (char test : fields) {
			if (test != 0) {
				count++;
			}
		}
		return count;
	}

	@Override
	public char[] getFields() {
		return fields;
	}

	@Override
	public void reset() {
		fields = new char[FIELDCOUNT];
		currentPlayer = PLAYER1;
	}

}
