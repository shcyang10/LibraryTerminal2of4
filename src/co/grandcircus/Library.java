package co.grandcircus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		menu();
		
		userInput = scan.nextInt();
		userSelection(scan, userInput);
		
		cont = Validator.getStringMatchingRegex(scan, "Would you like to continue?(y/n) ", "[YyNn]");
		}
	}
	public static void menu() {
		System.out.println("1. Display list\n2. Search by author\n3. Search by title\n4. Check book out\n5. Return book\n6. Add book");
	}
	public static String userSelection(Scanner scanner, int input) {
		BookManager b = new BookManager();
		switch(input) {
		case 1:
		//return readFromFile();
		
		case 2:
			String str;
			scanner.nextLine();
			System.out.println("Type in an author");
			str = scanner.nextLine();
		return	b.getDisplayString(str);
			
		case 3:
		//return	searchTitle();
		
		case 4:
		//return	checkBookOut();
			
		case 5:
		//return	returnBook();
		case 6:
			scanner.nextLine();
			String str3;
			String str2;
			System.out.println("Enter the title of the book: ");
			str3 = scanner.nextLine();
			System.out.println("Enter name of author: ");
			str2 = scanner.nextLine();
			b.addBook(new Book(str3, str2, "on Shelf", null, null));
			
		}
		return " "; // remove this later it's not needed
	}
	
	public static void writeToFile(Vector<Book> books) {
        String fileName = "booklist.txt";
        Path path = Paths.get("library", fileName);
        File file = path.toFile();
        PrintWriter output = null;
        try {
            output = new PrintWriter(new FileOutputStream(file, true));
            output.println(books);
          
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            System.out.println("Hey, contact customer service");
        } finally {
            output.close();
        }
    }
}	