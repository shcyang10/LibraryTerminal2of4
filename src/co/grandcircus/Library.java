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
					"1. Display list\n2. Search by author\n3. Search by title\n4. Check book out\n5. Return book\n6. Add book");
			int userInput = Validator.getInt(scan, "Select an option: ", 1, 6);
			userSelection(scan, userInput, b);
			cont = Validator.getStringMatchingRegex(scan, "Would you like to continue?(y/n) ", "[YyNn]");
		}
		
		writeToFile(b);
	}

	public static void userSelection(Scanner scan, int userInput, BookManager b) {
		switch (userInput) {
		
		// show all books
		case 1:
			System.out.println(b.getDisplayString(null, null));
			break;

		// show all books w/ author x
		case 2:
			String str;
			System.out.println("Type in an author: ");
			str = scan.nextLine();
			String a = b.getDisplayString(str, null);
			System.out.println(a);
			break;
		// show all books w/ title x
		case 3:
			String str4;
			System.out.println("Type in a title: ");
			str4 = scan.nextLine();
			String t = b.getDisplayString(null, str4);
			System.out.println(t);
			break;
		// checkout book
		case 4:
			System.out.println(b.getDisplayString(null, null));
			Status co = Status.CHECKED_OUT;
			System.out.println("Which book title number would you like to checkout");
			int i = scan.nextInt();
			b.getBookByNumber(i).setStatus(co);
			break;
		// return book
		case 5:
			System.out.println(b.getDisplayString(null, null));
			Status os = Status.ON_SHELF;
			System.out.println("Which book title number would you like to return");
			int x = scan.nextInt();
			b.getBookByNumber(x).setStatus(os);
			break;
		// return book
		case 6:
			String str3;
			String str2;
			System.out.println("Enter the title of the book: ");
			str3 = scan.nextLine();
			System.out.println("Enter name of author: ");
			str2 = scan.nextLine();
//			b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, Category.FICTION));
			// TODO: add category choice
			Category z = null ;
			boolean check = true;
			System.out.println("Choose your category by entering the corresponding #\n1. Drama\n2. Fantasy\n3. Fiction\n4. Nonfiction\n5. Philosphy\n6. Science\n7. Science Fiction");
			int c = scan.nextInt();
			while (check) {
			if(c==1) {
				 z = Category.DRAMA;
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, z));
			}else if (c==2) {
				z = Category.FANTASY;
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, z));
			}else if(c==3) {
				z = Category.FICTION;
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, z));
			}else if(c==4) {
				z = Category.NONFICTION;
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, z));
			}else if(c==5) {
				z = Category.PHILOSOPHY;
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, z));
			}else if(c==6) {
				z = Category.SCIENCE;
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, z));
			}else if (c==7) {
				z = Category.SCIENCE_FICTION;
				b.addBook(new Book(str3, str2, "NULL", Status.ON_SHELF, z));
			}else {
				System.out.println("Wrong input");
				check = false;
			}
			}
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