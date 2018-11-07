package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
    public static void main(String... args) {
        String dateStr = "08/22/2018";
        LocalDate theDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MM/d/yyyy"));
        System.out.println("year: " + theDate.getYear() + " month: " + theDate.getMonthValue() + " day: " + theDate.getDayOfMonth());
    }
}
