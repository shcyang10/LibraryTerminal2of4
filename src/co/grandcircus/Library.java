package co.grandcircus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Library {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BookManager b = new BookManager();
		String cont = "y";

		System.out.println("Welcome to the Library of Alexandria!");

		while (cont.equalsIgnoreCase("y")) {
			System.out.println(
					"1. Display list\n2. Search by author\n3. Search by title\n4. Check book out\n5. Return book\n6. Add book\n7. Sort books by Category\n8. Exit");
			int userInput = Validator.getInt(scan, "Select an option: ", 1, 8);
			userSelection(scan, userInput, b);
			cont = Validator.getStringMatchingRegex(scan, "Would you like to continue? (y/n) ", "[YyNn]");
		}
		writeToFile(b);

		System.out.println("Goodbye!");
	}

	public static void userSelection(Scanner scan, int userInput, BookManager b) {
		switch (userInput) {

		// show all books
		case 1:
			System.out.println(b.getDisplayString());
			break;

		// show all books w/ author x
		case 2:
			String str;
			//System.out.println("Type in an author: ");
			str = Validator.getString(scan, "Type in an author: ");
			String a = b.getDisplayString(str, null);
			System.out.println(a);
			break;
		// show all books w/ title x
		case 3:
			String str4;
			//System.out.println("Type in a title: ");
			str4 = Validator.getString(scan, "Type in a title: ");
			String t = b.getDisplayString(null, str4);
			System.out.println(t);
			break;
		// checkout book
		case 4:
			System.out.println(b.getDisplayString());
			Status co = Status.CHECKED_OUT;
			//System.out.println("Which book title number would you like to checkout");
			int i = Validator.getInt(scan, "Which book title number would you like to checkout");
			b.getBookByNumber(i).setStatus(co);
			break;
		// return book
		case 5:
			System.out.println(b.getDisplayString());
			Status os = Status.ON_SHELF;
			//System.out.println("Which book title number would you like to return");
			int x = Validator.getInt(scan, "Which book title number would you like to return");
			b.getBookByNumber(x).setStatus(os);
			break;
		// return book
		case 6:
			String str3;
			String str2;
			//System.out.println("Enter the title of the book: ");
			str3 = Validator.getString(scan, "Enter the title of the book: ");
			//System.out.println("Enter name of author: ");
			str2 = Validator.getString(scan, "Enter name of author: ");
			// TODO: add category choice
			int c = Validator.getInt(scan,
					"Choose your category by entering the corresponding #\n1. Drama\n2. Fantasy\n3. Fiction\n4. Nonfiction\n5. Philosphy\n6. Science\n7. Science Fiction",
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
				System.out.println("Wrong input");
				break;
			}break;
		case 7:
			int w = Validator.getInt(scan,
					"Choose your category by entering the corresponding #\n1. Drama\n2. Fantasy\n3. Fiction\n4. Nonfiction\n5. Philosphy\n6. Science\n7. Science Fiction",
					1, 7);
			switch (w) {
			case 1:
				b.getDisplayString(Category.DRAMA);
				break;
			case 2:
				b.getDisplayString(Category.FANTASY);
				break;
			case 3:
				b.getDisplayString(Category.FICTION);
				break;
			case 4:
				b.getDisplayString(Category.NONFICTION);
				break;
			case 5:
				b.getDisplayString(Category.PHILOSOPHY);
				break;
			case 6:
				b.getDisplayString(Category.SCIENCE);
				break;
			case 7:
				b.getDisplayString(Category.SCIENCE_FICTION);
				break;
			default:
				System.out.println("Wrong input");
				break;
			}break;
			
		case 8:
//			System.out.println("");
			System.exit(0);
			break;
		}
		
	}

	public static void writeToFile(BookManager b) {
		String fileName = "booklist.txt";
		Path path = Paths.get(fileName);
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