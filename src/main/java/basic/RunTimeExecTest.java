package basic;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import util.IoHelper;

public class RunTimeExecTest {
    public static void main(String... args) {
        String urlString = "https://jill.morphling.worksap.com/grafana/api/search";
        try {
            Process process = Runtime.getRuntime().exec("curl -v --cookie \"UM-TOKEN=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsImJlbG9uZ2luZ0hvc3QiOiJodHRwczovL2ppbGwubW9ycGhsaW5nLndvcmtzYXAuY29tIiwidXNlck5hbWUiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsInVzZXJUeXBlIjoiRU5EX1VTRVIiLCJ1c2VyVG9rZW5BdHRlbXB0cyI6MiwidG9rZW5FeHRlbmRNaW51dGVzIjo3MjAsInRva2VuRXh0ZW5kQ29uZGl0aW9uIjo2MCwicGFzc3dvcmRVcGRhdGVkIjp0cnVlLCJjbGllbnRMQU5JUCI6IjE3Mi4yNi4xNDMuMiIsImV4cCI6MTUzMzMwMzQ3Nn0.VohGvVJ4sdExIMo21gQnwUNldUYKHjFXk-_SAOu505DQziNGeyLQc2zt7uCzSOaQ55Rmxa87nKWNzeY-3Arnyw\" " + urlString);

            process.waitFor();
            System.out.println(IoHelper.output(process.getInputStream()));
            process = Runtime.getRuntime().exec(new String[]{"curl", "-v", "--cookie", "UM-TOKEN=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsImJlbG9uZ2luZ0hvc3QiOiJodHRwczovL2ppbGwubW9ycGhsaW5nLndvcmtzYXAuY29tIiwidXNlck5hbWUiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsInVzZXJUeXBlIjoiRU5EX1VTRVIiLCJ1c2VyVG9rZW5BdHRlbXB0cyI6MCwidG9rZW5FeHRlbmRNaW51dGVzIjo3MjAsInRva2VuRXh0ZW5kQ29uZGl0aW9uIjo2MCwicGFzc3dvcmRVcGRhdGVkIjp0cnVlLCJjbGllbnRMQU5JUCI6IjE3Mi4yNi4xNDMuMiIsImV4cCI6MTUzMzMwNDc0MX0.04py0hKFXB2K54Pzvup7TU4EQGd-llTxe-LYLC-82zpHD1MroaEinN6uyBOLP-jEgS4IPKIDAH9NipgtGr7VHQ", urlString});

            process.waitFor();
            System.out.println(IoHelper.output(process.getInputStream()));


            process = new ProcessBuilder("curl", "-v", "--cookie", "UM-TOKEN=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsImJlbG9uZ2luZ0hvc3QiOiJodHRwczovL2ppbGwubW9ycGhsaW5nLndvcmtzYXAuY29tIiwidXNlck5hbWUiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsInVzZXJUeXBlIjoiRU5EX1VTRVIiLCJ1c2VyVG9rZW5BdHRlbXB0cyI6MCwidG9rZW5FeHRlbmRNaW51dGVzIjo3MjAsInRva2VuRXh0ZW5kQ29uZGl0aW9uIjo2MCwicGFzc3dvcmRVcGRhdGVkIjp0cnVlLCJjbGllbnRMQU5JUCI6IjE3Mi4yNi4xNDMuMiIsImV4cCI6MTUzMzMwNDc0MX0.04py0hKFXB2K54Pzvup7TU4EQGd-llTxe-LYLC-82zpHD1MroaEinN6uyBOLP-jEgS4IPKIDAH9NipgtGr7VHQ", urlString).start();

            process.waitFor();
            System.out.println(IoHelper.output(process.getInputStream()));


            String charset = "UTF-8";
            String query = String.format("include=%s", URLEncoder.encode("game", charset));
            URL myURL = new URL(urlString);
            HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
            myURLConnection.setRequestMethod("GET");
            myURLConnection.setRequestProperty("cookie", "UM-TOKEN=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsImJlbG9uZ2luZ0hvc3QiOiJodHRwczovL2ppbGwubW9ycGhsaW5nLndvcmtzYXAuY29tIiwidXNlck5hbWUiOiJsdW9fc29Ad29ya3NhcC5jby5qcCIsInVzZXJUeXBlIjoiRU5EX1VTRVIiLCJ1c2VyVG9rZW5BdHRlbXB0cyI6MCwidG9rZW5FeHRlbmRNaW51dGVzIjo3MjAsInRva2VuRXh0ZW5kQ29uZGl0aW9uIjo2MCwicGFzc3dvcmRVcGRhdGVkIjp0cnVlLCJjbGllbnRMQU5JUCI6IjE3Mi4yNi4xNDMuMiIsImV4cCI6MTUzMzMwNDc0MX0.04py0hKFXB2K54Pzvup7TU4EQGd-llTxe-LYLC-82zpHD1MroaEinN6uyBOLP-jEgS4IPKIDAH9NipgtGr7VHQ");
            myURLConnection.setUseCaches(false);
            myURLConnection.setDoInput(true);
            myURLConnection.setDoOutput(true);
            myURLConnection.connect();
            String s = myURLConnection.getResponseMessage();
            System.out.println(s);
            System.out.println(myURLConnection.getResponseCode());
            System.out.println(IoHelper.output(myURLConnection.getInputStream()));
        } catch (IOException | InterruptedException ignored) {
            ignored.printStackTrace();
        }
    }
}
