package h4.oefening5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BtwTest {

	@Test
    public void testGetPrijsIncBTW(){
        Btw btw = new Btw();
        btw.setBtw(21);
        btw.setPrijs(10);

        assertEquals(12.1,btw.getPrijsInclusiefBtw());
        
        btw.setPrijs(0.99);
        assertEquals(1.99, btw.getPrijsInclusiefBtw());
    }
}
