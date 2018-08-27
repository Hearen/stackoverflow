package time;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeTest {
    public static void main(String... args) {
        System.out.println(OffsetDateTime.parse("2018-08-21T10:12:06.872722+00:00",
                DateTimeFormatter.ISO_OFFSET_DATE_TIME).toLocalDate());
    }
}
