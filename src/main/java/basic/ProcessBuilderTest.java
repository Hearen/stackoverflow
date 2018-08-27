package basic;

import java.io.IOException;

import util.IoHelper;

public class ProcessBuilderTest {
    public static void main(String... args) {
        String s = "https://tokyo-main-147-elb-pm-157752887.ap-northeast-1.elb.amazonaws.com:30990/-/reload";
        ProcessBuilder processBuilder = new ProcessBuilder("curl", "-X", "POST", "-k", "-i", s);
//        ProcessBuilder processBuilder = new ProcessBuilder("echo", "hi");
        try {
            Process process = processBuilder.start();
            process.waitFor();
            int exitCode = process.exitValue();
            System.out.println(IoHelper.output(process.getInputStream()));
            System.out.println(exitCode);
        } catch (IOException | InterruptedException ignored) {
            ignored.printStackTrace();
        }
    }
}
