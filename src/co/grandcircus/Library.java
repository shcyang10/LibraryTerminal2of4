package co.grandcircus;

import java.util.Scanner;

public final class Library {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userInput;
		System.out.println("Welcome to the Library of Alexandria");
		// display list
		// need textfile for methods
		// numbers to select from the list
		// input to search by author
		// input to search by title
		// input to ask if they want to check book out
		// input to ask if they want to return the book
		menu();
		
		userInput = scan.nextInt();
		userSelection(scan, userInput);
		
		System.out.println("Would you like to continue?(y/n)");
	}
	public static void menu() {
		System.out.println("1. Display list\n2. Search by author\n3. Search by title\n4. Check book out\n5. Return book");
	}
	public static String userSelection(Scanner scanner, int input) {
		switch(input) {
		case 1:
		return readFromFile();
		
		case 2:
		return	searchAuthor();
			
		case 3:
		return	searchTitle();
		
		case 4:
		return	checkBookOut();
			
		case 5:
		return	returnBook();
		}
	}
}	