package co.grandcircus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Library {

	final static String GOODBYE_MSG = "Goodbye! Thank you for coming to the Library of Alexandria.";
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BookManager b = new BookManager();
		String cont = "y";
		System.out.println("Welcome to the Library of Alexandria!");

		while (cont.equalsIgnoreCase("y")) {
			System.out.println(
					"1. Display list\n2. Search by author\n3. Search by title\n4. Check book out\n5. Return book\n6. Add book\n7. Sort books by Category\n8. Delete book\n9. Exit");
			int userInput = Validator.getInt(scan, "Select an option: ", 1, 9);
			userSelection(scan, userInput, b);
			cont = Validator.getStringMatchingRegex(scan, "Would you like to continue? (y/n) ", "[YyNn]");
		}

		writeToFile(b);
		System.out.println(GOODBYE_MSG);
	}

	public static void userSelection(Scanner scan, int userInput, BookManager b) {
		switch (userInput) {

		// show all books
		case 1:
			System.out.println(b.getDisplayString());
			break;

		// show all books w/ author x
		case 2:
			String str = Validator.getString(scan, "Type in an author: ");
			String a = b.getDisplayString(str, null);
			System.out.println(a);
			break;

		// show all books w/ title x
		case 3:
			String str4 = Validator.getString(scan, "Type in a title: ");
			String t = b.getDisplayString(null, str4);
			System.out.println(t);
			break;

		// input to check book out
		case 4:
			System.out.println(b.getDisplayString());
			int i = Validator.getInt(scan, "Which book title number would you like to checkout?\n");
			Status co = Status.CHECKED_OUT;
			Status q =b.getBookByNumber(i).getStatus();
			if(q.equals(co)) {
				System.out.println("Sorry that book is checked out at the moment.");
			}else {
			b.getBookByNumber(i).setStatus(co);
			String date = null;
			b.getBookByNumber(i).setDueAt(date);}
			break;

		// input to return book
		case 5:
			System.out.println(b.getDisplayString());
			Status os = Status.ON_SHELF;
			int x = Validator.getInt(scan, "Which book title number would you like to return?\n");
			Status ch = b.getBookByNumber(x).getStatus();
			if(ch.equals(os)) {
				System.out.println("That book has already been returned.");
			}
			b.getBookByNumber(x).setStatus(os);
			b.getBookByNumber(x).resetDueAt();
			break;

		// adding book
		case 6:
			String str3 = Validator.getString(scan, "Enter the title of the book: ");
			String str2 = Validator.getString(scan, "Enter name of author: ");
			int c = Validator.getInt(scan,
					"Choose your category by entering the corresponding #\n1. Drama\n2. Fantasy\n3. Fiction\n4. Nonfiction\n5. Philosphy\n6. Science\n7. Science Fiction\nSelect option: ",
					1, 7);
			switch (c) {
			case 1:
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.DRAMA));
				break;
			case 2:
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.FANTASY));
				break;
			case 3:
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.FICTION));
				break;
			case 4:
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.NONFICTION));
				break;
			case 5:
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.PHILOSOPHY));
				break;
			case 6:
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.SCIENCE));
				break;
			case 7:
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.SCIENCE_FICTION));
				break;
			default:
				System.out.println("Wrong input!");
				break;
			}
			break;

		// sort by category
		case 7:
			int w = Validator.getInt(scan,
					"Choose your category by entering the corresponding #\n1. Drama\n2. Fantasy\n3. Fiction\n4. Nonfiction\n5. Philosphy\n6. Science\n7. Science Fiction\nSelect Option: ",
					1, 7);
			switch (w) {
			case 1:
				System.out.println(b.getDisplayString(Category.DRAMA));
				break;
			case 2:
				System.out.println(b.getDisplayString(Category.FANTASY));
				break;
			case 3:
				System.out.println(b.getDisplayString(Category.FICTION));
				break;
			case 4:
				System.out.println(b.getDisplayString(Category.NONFICTION));
				break;
			case 5:
				System.out.println(b.getDisplayString(Category.PHILOSOPHY));
				break;
			case 6:
				System.out.println(b.getDisplayString(Category.SCIENCE));
				break;
			case 7:
				System.out.println(b.getDisplayString(Category.SCIENCE_FICTION));
				break;
			default:
				System.out.println("Wrong input!");
				break;
			}
			break;

		// deleting book
		case 8:
			int m = Validator.getInt(scan,("Which book number would you like to delete?\n"));
			b.removeBook(m);
			break;

		case 9:
			System.out.println(GOODBYE_MSG);
			writeToFile(b);
			System.exit(0);
			break;
		}
	}

	public static void writeToFile(BookManager b) {
		Path path = Paths.get("booklist.txt");
		File file = path.toFile();
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileOutputStream(file, false));
			for (Book b1 : b.getBooks()) {
				String b2 = b1.toString().replaceAll(" {2,}", "").replaceAll("(by)|(\\(Due at)|(\\))", ",")
						.replaceAll("(on shelf)", "ON_SHELF,").replaceAll("(checked out)", "CHECKED_OUT,")
						.replaceAll("(nonfiction)", "NONFICTION").replaceAll("(science fiction)", "SCIENCE_FICTION")
						.replaceAll("(fiction)", "FICTION").replaceAll("(fantasy)", "FANTASY")
						.replaceAll("(science)", "SCIENCE").replaceAll("(philosophy)", "PHILOSOPHY")
						.replaceAll("(drama)", "DRAMA");
				output.println(b2);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} finally {
			output.close();
		}
	}
}