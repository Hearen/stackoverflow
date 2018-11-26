package io;

import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.NoSuchElementException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class UrlHttpPost {
    static String URL = "https://staging/huelog/athena/dump-file/report";
    static String tokenString = "UM-TOKEN=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQ1RvTFYiLCJiZWxvbmdpbmdIb3N0IjoiaHR0cHM6Ly9tb3JwaGxpbmcuaW50ZXJuYWwud29ya3NhcC5jb20iLCJ1c2VyTmFtZSI6IlJDVG9MViIsInVzZXJUeXBlIjoiRU5EX1VTRVIiLCJ1c2VyVG9rZW5BdHRlbXB0cyI6OTk5OTk5OTksInRva2VuRXh0ZW5kTWludXRlcyI6NjAsInRva2VuRXh0ZW5kQ29uZGl0aW9uIjo2MCwicGFzc3dvcmRVcGRhdGVkIjp0cnVlLCJjbGllbnRMQU5JUCI6IjEyNy4wLjAuMSIsImV4cCI6MTU3NDM5MDk4M30.7PVjAIod8s998QrLG-l-1IsCOyKsQh8PqWVHbpjhEOvX5enHG_WOb92zc44gYIXMtwe6rFEi96NlsdVRYu2_vw";
    static String JsonString = "[{\"jobName\":\"optj-develop-native-kubernetes-201811221627162575154304196149141\",\"dumpSignedS3Url\":\"https://opt-tool-eva.s3-ap-northeast-1.amazonaws.com/optj/develop/heapdump/kubernetes/2018-10-30-acall_develop_ac_accounting_18.06.00.0000.20180626.1729_xgmn5_1533108230959_32441.bin?X-Amz-Algorithm\\u003dAWS4-HMAC-SHA256\\u0026X-Amz-Date\\u003d20181122T082716Z\\u0026X-Amz-SignedHeaders\\u003dhost\\u0026X-Amz-Expires\\u003d7200\\u0026X-Amz-Credential\\u003dAKIAIQ7VVN5O6FZRXPTA%2F20181122%2Fap-northeast-1%2Fs3%2Faws4_request\\u0026X-Amz-Signature\\u003dd86b7670b562fd3226d50c44b9e65ef453c71f09461fa238c298dcabf98e3d64\",\"status\":\"FAILED\"}]\n" +
            " ";


    public static void main(String... args) {
//        testPost();
        testRestTemplate();
    }

    public static void testPost() {
        try {
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(new SSLContextBuilder()
                    .loadTrustMaterial(null, new TrustSelfSignedStrategy()).build());
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            HttpPost httpPost = new HttpPost(URL);
            //String tokenString = configurationRepository.findOneByKey(SUP_TOKEN).getValue();
            httpPost.setEntity(new StringEntity(JsonString));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 "
                    + "(KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36");
            httpPost.setHeader("Authorization", tokenString);
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println(response);
        } catch (KeyStoreException | NoSuchAlgorithmException | KeyManagementException
                | UnsupportedEncodingException | NoSuchElementException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testRestTemplate() {
        System.out.println("Using RestTemplate: ");
        RestTemplate restTemplate = getRestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Cookie", tokenString);
        requestHeaders.add("Accept", "application/json");
        requestHeaders.add("Content-Type", "application/json");
        HttpEntity requestEntity = new HttpEntity(JsonString, requestHeaders);
        ResponseEntity rssResponse = restTemplate.exchange(
                URL,
                HttpMethod.PUT,
                requestEntity,
                String.class);
        System.out.println(rssResponse.getBody());
    }

    private static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = null;
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpClient);
            restTemplate = new RestTemplate(requestFactory);
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        return restTemplate;
    }
}
