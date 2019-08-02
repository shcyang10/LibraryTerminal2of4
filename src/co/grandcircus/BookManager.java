package co.grandcircus;
import java.util.Vector;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public final class BookManager {

	// immutable Vector of books
	private static final Vector<Book> books = new Vector<>();
	
	// constructor: loads books
	public BookManager() {
		try {
			BufferedReader br = new BufferedReader(
				new FileReader("booklist.txt"));
			try {
				String line = br.readLine();
				while (line != null) {
					String[] split = line.split(",");
					addBook(new Book(split[0], split[1], split[2], Status.valueOf(split[3]), Category.valueOf(split[4])));
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: booklist.txt was not found!");
		}
	}

	// function definitions
	public String getDisplayString(String author, String title) {
		String ret = "\n";
		for (Book book : books) {
			if (
				(author == null || author.equals(book.getAuthor())) &&
				(title == null || book.getTitle().contains(title))) {
				ret += book.getFullTitle(this); 
				ret += "\n";
			}
		}
		return ret;
		
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public Vector<Book> getBooks() {
		return books;
	}

	public Book getBookByNumber(int number) {
		return books.get(number-1);
	}

	public int getNumberFromBook(Book book) {
		return books.indexOf(book)+1;
	}

}