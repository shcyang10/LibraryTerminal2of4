package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckOutReturn {
	public static String dueDate(String dueAt) {
		LocalDate ld = LocalDate.now().plusDays(14);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return ld.format(dateFormat);
	}
}