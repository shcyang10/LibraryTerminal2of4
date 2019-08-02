package co.grandcircus;

import java.util.Scanner;

public class Validator {

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	public static String getString(Scanner scan, String prompt) {
		System.out.print(prompt);
		return scan.nextLine(); // read user entry
	}

	public static double getDouble(Scanner sc, String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				if (d > 0) {
					isValid = true;
				} else
					System.out.println("Error! Invalid value. Try again.");
			} else {
				System.out.println("Error! Invalid value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static String getStringMatchingRegex(Scanner scan, String prompt, String regex) {
		boolean isValid = false;

		String input;

		do {
			input = getString(scan, prompt);
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Invalid entry. Please try again.");
			}
		} while (!isValid);
		return input;
	}
}