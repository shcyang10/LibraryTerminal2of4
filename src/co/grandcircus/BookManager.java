package co.grandcircus;

import java.util.Vector;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

public final class BookManager {

	// immutable Vector of books shared by all instances of BookManager
	private static final Vector<Book> books = new Vector<>();

	// constructor: loads books
	public BookManager() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("booklist.txt"));
			try {
				String line = br.readLine();
				while (line != null) {
					String[] split = line.split(",");
					addBook(new Book(split[0], split[1], split[2], Status.valueOf(split[3]),
							Category.valueOf(split[4])));
					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: booklist.txt was not found!");
		}
	}

	// function definitions
	public String getDisplayString(String author, String title, Category category) {
		String ret = "\n";
		for (Book book : books) {
			if ((author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase()))
					&& (title == null || book.getTitle().toLowerCase().contains(title.toLowerCase()))
					&& (category == null || book.getCategory() == category)) {
				ret += book.getFullTitle(this);
				ret += "\n";
			}
		}
		if (ret.equals("\n")) {
			ret += "We couldn't find that book in our archives.\n";
		}
		return ret;
	}

	// syntactic sugar for getDisplayString(null, null, category)
	public String getDisplayString(Category category) {
		return getDisplayString(null, null, category);
	}

	// syntactic sugar for getDisplayString(null, null, null)
	public String getDisplayString() {
		return getDisplayString(null, null, null);
	}

	// syntactic sugar for getDisplayString(String|null, String|null, null)
	public String getDisplayString(String author, String title) {
		return getDisplayString(author, title, null);
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public boolean removeBook(Book book) {
		if (books.contains(book)) {
			books.remove(book);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeBook(int number) {
		return removeBook(getBookByNumber(number));
	}

	public Vector<Book> getBooks() {
		return books;
	}

	public Book getBookByNumber(int number) {
		try {
			return books.get(number - 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public int getNumberFromBook(Book book) {
		return books.indexOf(book) + 1;
	}

}