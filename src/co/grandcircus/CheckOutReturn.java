package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckOutReturn {
	static Scanner scan = new Scanner(System.in);
	String dueAt;
	
	
	public static String dueDate(String dueAt) {
		LocalDate ld;
		ld = LocalDate.now().plusDays(14);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		dueAt = ld.format(dateFormat);
		return dueAt;
	}
	
}