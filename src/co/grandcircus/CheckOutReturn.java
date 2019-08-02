package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckOutReturn {
	static Scanner scan = new Scanner(System.in);
	LocalDate ld;
	String dueAt;
	
	
	public static String dueDate(LocalDate ld, String dueAt) {
		ld = LocalDate.now();
		ld.plusDays(14);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		dueAt = ld.format(dateFormat);
		return dueAt;
	}
	
}
