package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TimeFormatter {
    public static void main(String... args) {
        String dateStr = "08/22/2018";
        LocalDate theDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MM/d/yyyy"));
        System.out.println("year: " + theDate.getYear() + " month: " + theDate.getMonthValue() + " day: " + theDate.getDayOfMonth());

        String dateTimeName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(dateTimeName);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + new Random().nextLong());
        LocalDate startDate = LocalDate.now().minusDays(2);
        LocalDate endDate = LocalDate.now().minusDays(1);
        System.out.println(startDate.toString());
        System.out.println(endDate.toString());
    }
}
