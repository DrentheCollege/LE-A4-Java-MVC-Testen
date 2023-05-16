package h6.interface2.v1;

public class YoutubeMovie implements IOnlinePlayableMedia {

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
		System.out.println("haal film van Youtube");
		System.out.println("en laat hem zien");
		System.out.println("url = "+getUrl());
	}

}
