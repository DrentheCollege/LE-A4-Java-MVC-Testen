package h6.interface2.v2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class YoutubeMovieTest {

	@Test
	void testGettersSetters() {
		OnlinePlayableMedia media = new YoutubeMovie();
		
		//is het veld leeg?
		assertEquals(null, media.getUrl());
		
		// stop een duidelijke tekst in url van object 
		// en die moet het goed bewaren 
		String testUrl = "testurl"; 
		media.setUrl(testUrl);
		assertEquals(testUrl, media.getUrl());
	}
}
