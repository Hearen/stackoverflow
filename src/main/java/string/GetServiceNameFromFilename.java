package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetServiceNameFromFilename {
    private static final Pattern SERVICE_NAME_PATTERN = Pattern.compile("(.*)-\\d{2}\\.\\d{2}\\.\\d{2}.\\d{4}.*");
    public static void main(String... args) {
        String fileName = "collabo-w-17.12.00.0004.20180906.1220janfi5m52-vr6dc.tar.gz";
        String serviceName = "";
        Matcher matcher = SERVICE_NAME_PATTERN.matcher(fileName);
        if (matcher.find()) {
            serviceName = matcher.group(1);
        }
        System.out.println(serviceName);
    }
}
