package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TailFollowUsingProcessBuilder {
    public static void main(String... args) {
        ProcessBuilder processBuilder = new ProcessBuilder("tail", "-f", "/Users/lhearen/jmeter.log");
        try {
            Process process = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }
}
