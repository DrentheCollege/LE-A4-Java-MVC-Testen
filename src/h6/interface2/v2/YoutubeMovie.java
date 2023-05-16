package h6.interface2.v2;

public class YoutubeMovie extends OnlinePlayableMedia{

	@Override
	public void play() {
		System.out.println("haal film van Youtube");
		System.out.println("en laat hem zien");
		System.out.println("url = "+getUrl());
	}

}
