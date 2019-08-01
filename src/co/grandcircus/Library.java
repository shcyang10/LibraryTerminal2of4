package co.grandcircus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public final class Library {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userInput;
		String cont = "y";
		System.out.println("Welcome to the Library of Alexandria");
		// display list
		// need textfile for methods
		// numbers to select from the list
		// input to search by author
		// input to search by title
		// input to ask if they want to check book out
		// input to ask if they want to return the book
		while (cont.equalsIgnoreCase("y")) {
			System.out.println(
					"1. Display list\n2. Search by author\n3. Search by title\n4. Check book out\n5. Return book\n6. Add book");
			userInput = Validator.getInt(scan, "Select an option: ", 1, 6);
			userSelection(scan, userInput);
			cont = Validator.getStringMatchingRegex(scan, "Would you like to continue?(y/n) ", "[YyNn]");
		}
	}

	public static String userSelection(Scanner scan, int userInput) {
		BookManager b = new BookManager();
		switch (userInput) {
		case 1:
			b.getDisplayString(null, null);
			break;
		case 2:
			String str;
			scan.nextLine();
			System.out.println("Type in an author: ");
			str = scan.nextLine();
			String a = b.getDisplayString(str, null);
			System.out.println(a);
			break;
		case 3:
			String str4;
			scan.nextLine();
			System.out.println("Type in a title: ");
			str4 = scan.nextLine();
			String t = b.getDisplayString(null, str4);
			System.out.println(t);
			break;
		case 4:
			// return checkBookOut();
			break;
		case 5:
			// return returnBook();
		case 6:
			scan.nextLine();
			String str3;
			String str2;
			System.out.println("Enter the title of the book: ");
			str3 = scan.nextLine();
			System.out.println("Enter name of author: ");
			str2 = scan.nextLine();
			b.addBook(new Book(str3, str2, "on Shelf", null, null));
		}
		return " "; // remove this later it's not needed
	}

	public static void writeToFile(ArrayList<Book> bookList) {
		String fileName = "booklist.txt";
		Path path = Paths.get("library", fileName);
		File file = path.toFile();
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			output.println();
			/*
			 *
			 *
			 * add the name of array of books
			 *
			 *
			 */
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Hey, contact customer service");
		} finally {
			output.close();
		}
	}
}