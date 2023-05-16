package h6.interface2.v2;

public class SpotifySong extends OnlinePlayableMedia {

	@Override
	public void play() {
		System.out.println("haal song van Spotify");
		System.out.println("en laat hem horen.");
		System.out.println("url = "+getUrl());
	}

}
