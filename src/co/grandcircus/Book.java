package co.grandcircus;

public final class Book {

	private String title;
	private String author;
	private String dueAt;
	private Status status;
	private Category category;

	public Book(String _title, String _author, String _dueAt, Status _status, Category _category) {
		title = _title;
		author = _author;
		dueAt = _dueAt;
		status = _status;
		category = _category;
	}

	@Override
	public String toString() {
		return "\"" + title + "\"" + " by " + author + " (Due at " + dueAt + ")" + " (" + status + ")";
	}

	// toString() + book #
	public String getFullTitle(BookManager bm) {
		return toString() + " (" + bm.getNumberFromBook(this) + ")";
	}

	// setters
	public void setStatus(Status _new) {
		status = _new;
	}

	public void setDueAt(String date) {
		dueAt = date;
	}
	
	// getters
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getDueAt() {
		return dueAt;
	}
	public Status getStatus() {
		return status;
	}
	public Category getCategory() {
		return category;
	}
}