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
		String quote = String.format("\"%s\" - %s", content, author);
		String divider = "";
		for (int i = 0; i < quote.length(); ++i) {
			divider += "-";
		}
		return divider + "\n" + quote;
	}
}