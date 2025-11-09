package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class JavaUtility {

	public static String currentTime() {
		LocalDateTime current = LocalDateTime.now();

        // Format date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Print formatted date and time
        String formatted = current.format(formatter);
        return formatted;
        //System.out.println("Current Date and Time: " + formatted);
	}
}
