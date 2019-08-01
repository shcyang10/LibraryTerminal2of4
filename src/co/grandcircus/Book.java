package co.grandcircus;

public final class Book {
	private String title;
	private String author;
	private String dueAt;
	private Status status;
	public Book(String _title, String _author, String _dueAt, Status _status) {
		title = _title;
		author = _author;
		dueAt = _dueAt;
		status = _status;
	}
}