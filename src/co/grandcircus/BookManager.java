package co.grandcircus
import java.util.Vector;

public final class BookManager {
	// immutable list of books
	private final Vector<Book> books = new Vector<>();
	// function definitions
	public String getDisplayString() {
		String ret = "\n";
		for (Book book : books) {
			ret += book.toString(); 
			ret += "\n";
		}
		return ret;
	}
	public void addBook(Book book) {
		books.add(book);
	}
}