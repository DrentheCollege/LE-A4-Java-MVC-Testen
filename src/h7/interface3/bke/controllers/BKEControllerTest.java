package h7.interface3.bke.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import h7.interface3.bke.interfaces.*;
import h7.interface3.bke.models.BKEModel;

class BKEControllerTest {

	BKEController controller;
	IBKEModel model;

	@BeforeEach
	void beforeEach() {
		model = new BKEModel();
		controller = new BKEController();
		controller.setModel(model);
	}

	//deze klasse doet View met PropertyChangeListener na
	class PCLTest implements PropertyChangeListener {
		boolean called;
		HashMap<String, String> values = new HashMap<>();

		public PCLTest() {
			reset();
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			called = true;
			values.put(evt.getPropertyName(), (String) evt.getNewValue());
		}

		public void reset() {
			called = false;
			values.clear();
		}
	}

	@Test
	void testSetClicked() {
		PCLTest pclTest = new PCLTest();
		controller.addPropertyChangeListener(pclTest);

		// is View-simulator niet aangeroepen?
		assertEquals(false, pclTest.called);
		assertEquals(0, pclTest.values.size());

		int testId = 1;
		// eerste klik:
		controller.setClicked(testId);
		// zijn button aanpassing en resultaat verstuurd?
		assertEquals(IBKEModel.PLAYER1, pclTest.values.get(BKEController.BUTTON + testId).charAt(0));
		assertEquals(BKEController.TURNS + ": 1 " + BKEController.PLAYER + ": " + IBKEModel.PLAYER2,
				pclTest.values.get(BKEController.RESULT));

		testId = 4;
		// tweede klik:
		controller.setClicked(testId);
		// zijn button aanpassing en resultaat verstuurd?
		// eerste assert test ook impliciet de wisseling van speler
		assertEquals(IBKEModel.PLAYER2, pclTest.values.get(BKEController.BUTTON + testId).charAt(0));
		assertEquals(BKEController.TURNS + ": 2 " + BKEController.PLAYER + ": " + IBKEModel.PLAYER1,
				pclTest.values.get(BKEController.RESULT));
	}

	@Test
	void testChangePlayer() {
		assertEquals(IBKEModel.PLAYER1, model.getCurrentPlayer(), "Eerste speler");
		controller.changePlayer();
		assertEquals(IBKEModel.PLAYER2, model.getCurrentPlayer(), "Speler wisselen");
		controller.changePlayer();
		assertEquals(IBKEModel.PLAYER1, model.getCurrentPlayer(), "2e speler wisseling");
	}
	
	@Test
	void testGetGameOver() {
		// gelijk spel
		// oxo
		// xxo
		// xox
		int[] nonWinningSet = { 4, 0, 1, 7, 6, 2, 3, 5, 8 };
		
		// vul velden vanuit nonWinningSet
		for (int i = 0; i < IBKEModel.FIELDCOUNT; i++) {
			// controleer of gameOver is
			assertEquals(false, controller.isGameOver(), "Game over = false");
			controller.setClicked(nonWinningSet[i]);
			// controleer of het aantal beurten klopt
			assertEquals(i + 1, model.getTurns());
		}
		// aantal beurten is maximaal dus gameOver
		assertEquals(true, controller.isGameOver(), "Game over = true");
		assertEquals(IBKEModel.FIELDCOUNT, model.getTurns());
	}

	@Test
	void testGetWinnerEersteKolom() {
		controller.setClicked(0);
		controller.setClicked(1);
		controller.setClicked(3);
		controller.setClicked(2);
		controller.setClicked(6);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Eerste kolom");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}

	@Test
	void testGetWinnerTweedeKolom() {
		controller.setClicked(1);
		controller.setClicked(2);
		controller.setClicked(4);
		controller.setClicked(5);
		controller.setClicked(7);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Tweede kolom");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}

	@Test
	void testGetWinnerDerdeKolom() {
		controller.setClicked(2);
		controller.setClicked(1);
		controller.setClicked(5);
		controller.setClicked(4);
		controller.setClicked(8);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Derde kolom");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}
	
	@Test
	void testGetWinnerEersteRij() {
		controller.setClicked(0);
		controller.setClicked(3);
		controller.setClicked(1);
		controller.setClicked(4);
		controller.setClicked(2);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Eerste rij");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}

	@Test
	void testGetWinnerTweedeRij() {
		controller.setClicked(3);
		controller.setClicked(6);
		controller.setClicked(4);
		controller.setClicked(7);
		controller.setClicked(5);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Tweede rij");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}	
	
	@Test
	void testGetWinnerDerdeRij() {
		controller.setClicked(6);
		controller.setClicked(0);
		controller.setClicked(7);
		controller.setClicked(1);
		controller.setClicked(8);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Derde rij");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}
	
	@Test
	void testGetWinnerDiagonaalLinksBovenRechtsOnder() {
		controller.setClicked(0);
		controller.setClicked(1);
		controller.setClicked(4);
		controller.setClicked(2);
		controller.setClicked(8);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Diagonaal 1");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}

	@Test
	void testGetWinnerDiagonaalRechtsBovenLinksOnder() {
		controller.setClicked(2);
		controller.setClicked(0);
		controller.setClicked(4);
		controller.setClicked(1);
		controller.setClicked(6);

		assertEquals(IBKEModel.PLAYER1, controller.getWinner(), "Diagonaal 2");
		assertEquals(true, controller.isGameOver(), "Game over = true");
	}
	
}
