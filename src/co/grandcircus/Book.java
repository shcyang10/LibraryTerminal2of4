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
		return String.format("%-30s %-4s %-30s %-8s %-12s %-3s %-12s %-10s", title, "by", author, "(Due at ", dueAt, ")", status, category);
	}

	// toString() + book #
	public String getFullTitle(BookManager bm) {
		String spaces= "   ";
		double bookNum = bm.getNumberFromBook(this);
		while (true) {
			if (bookNum < 1) {
				break;
			} else {
				bookNum /= 10;
				spaces = spaces.substring(0, spaces.length() - 1);
			}
		}
		return bm.getNumberFromBook(this) + ". " + spaces + toString();
	}

	// setters
	public void setStatus(Status _new) {
		status = _new;
	}

	public void setCategory(Category _new) {
		category = _new;
	}

	public void setDueAt(String date) {
		dueAt = CheckOutReturn.dueDate(date);
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