package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessBuilderTest {
    public static void main(String... args) {
        String s = "http://www.baidu.com";
        ProcessBuilder processBuilder = new ProcessBuilder("curl", "-X POST", "-k",  "-I", s);
//        ProcessBuilder processBuilder = new ProcessBuilder("echo", "hi");
        try {
            Process process = processBuilder.start();
            process.waitFor();
            int exitCode = process.exitValue();
            System.out.println(exitCode);
            System.out.println(output(process.getInputStream()));
        } catch (IOException | InterruptedException ignored) {
            ignored.printStackTrace();
        }
    }
    private static String output(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }
}
