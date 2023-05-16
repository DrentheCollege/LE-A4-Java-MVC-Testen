package h6.interface2.v1;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		//hoe zou je een interface kunnen gebruiken?
		
		IOnlinePlayableMedia youtube = new YoutubeMovie();
		youtube.play();
		
		IOnlinePlayableMedia spotify = new SpotifySong();
		spotify.play();
		
		ArrayList<IOnlinePlayableMedia> playList = new ArrayList<IOnlinePlayableMedia>();
		playList.add(youtube);
		playList.add(spotify);
		
		System.out.println("\nPlay all items in playlist");
		for (IOnlinePlayableMedia media: playList) {
			media.play();
		}
	}

}
