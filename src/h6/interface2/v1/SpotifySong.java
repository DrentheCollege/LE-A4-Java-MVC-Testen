package h6.interface2.v1;

public class SpotifySong implements IOnlinePlayableMedia {

	private String url;

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void play() {
		System.out.println("haal song van Spotify");
		System.out.println("en laat hem horen.");
		System.out.println("url = "+getUrl());
	}

}
