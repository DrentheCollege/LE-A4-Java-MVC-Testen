package h7.interface3.bke.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import h7.interface3.bke.interfaces.Model;

class BKEModelTest {
	Model model;
	
	@BeforeEach
	void beforeEach() {
		model = new BKEModel();
	}
	
	@Test
	void testGetSetCurrentPlayer() {
		assertEquals(Model.PLAYER1, model.getCurrentPlayer(), "Eerste speler");	
		model.setCurrentPlayer(Model.PLAYER2);
		assertEquals(Model.PLAYER2, model.getCurrentPlayer(), "Aanpassen speler");	
		model.setCurrentPlayer('t');
		assertEquals(Model.PLAYER2, model.getCurrentPlayer(), "Ongeldige speler");	
	}
	
	@Test
	void testSetField() {
		int testId = 1;
		model.setField(testId);
		assertEquals(model.getCurrentPlayer(), model.getFields()[testId], "Goede veld gezet");
		
		for (int i=0; i<BKEModel.FIELDCOUNT; i++) {
			if (i!=testId) {
				assertEquals(0, model.getFields()[i], "Veld "+i+" niet gezet");
			}
		}
	}
	
	@Test
	void testCanSet() {
		int testId = 1;
		assertEquals(true, model.canSet(testId), "Leeg veld");
		model.setField(testId);
		assertEquals(false, model.canSet(testId),"Veld al gevuld");
		
		model.setField(-1);
		assertEquals(false, model.canSet(testId),"Id te laag");
		model.setField(10);
		assertEquals(false, model.canSet(testId),"Id te hoog");
	}

	@Test
	void testGetTurns() {
		assertEquals(0, model.getTurns(), "Start van het spel");
		model.setField(1);
		assertEquals(1, model.getTurns(), "Een beurt geweest");
		
		//zelfde veld, dus geen verandering in aantal beurten
		model.setField(1);
		assertEquals(1, model.getTurns(), "Verkeerde zet, geen extra beurt");

		model.setField(2);
		assertEquals(2, model.getTurns(), "Twee beurten geweest");
	}
	
	@Test
	void testReset() {
		//zet 2 velden in het model
		model.setField(1);
		model.setCurrentPlayer(Model.PLAYER2);
		model.setField(2);
		assertEquals(2, model.getTurns(), "2 beurten");
		
		model.reset();
		//alle velden moeten leeg zijn en huidige speler PLAYER1
		assertEquals(Model.PLAYER1, model.getCurrentPlayer(),"Speler 1");
		assertEquals(0, model.getTurns(), "0 beurten");
		for(char check: model.getFields()) {
			assertEquals(0, check, "Veld is niet leeg");
		}
	}
	
}

