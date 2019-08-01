package co.grandcircus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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
		switch(input) {
		case 1:
		//return readFromFile();
		
		case 2:
			String str;
			System.out.println("Type in an author");
			str = scanner.nextLine();
		//return	BookManager.getDisplayString(str);
			
		case 3:
		//return	searchTitle();
		
		case 4:
		//return	checkBookOut();
			
		case 5:
		//return	returnBook();
		case 6:
			String str3;
			String str2;
			System.out.println("Enter the title of the book: ");
			str3 = scanner.nextLine();
			System.out.println("Enter name of author: ");
			str2 = scanner.nextLine();
			//BookManager.addBook(str, str2);
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