package co.grandcircus;

public final class Quote {
	private String author;
	private String content;
	public Quote(String _author, String _content) {
		author = _author;
		content = _content;
	}
	@Override 
	public String toString() {
		return String.format("\"%s\" - %s", content, author);
	}
}