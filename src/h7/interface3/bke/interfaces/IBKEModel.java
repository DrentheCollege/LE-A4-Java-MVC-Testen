package h7.interface3.bke.interfaces;

public interface IBKEModel {
	public final static char PLAYER1 = 'X';
	public final static char PLAYER2 = 'O';
	public final static int FIELDCOUNT = 9;

	boolean canSet(int id);
	void setField(int id);
	char[] getFields();

	char getCurrentPlayer();
	void setCurrentPlayer(char currentPlayer);
	int getTurns();
	
	void reset();
	
}
