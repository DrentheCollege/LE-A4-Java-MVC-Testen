package h6.interface2.v2;

abstract public class OnlinePlayableMedia implements PlayableMedia, OnlineUrl {

	private String url;

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getUrl() {
		return url;
	}

}
