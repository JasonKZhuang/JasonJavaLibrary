package com.jasonz.network;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author Jason Zhuang
 * @created 2023.05.30 08:11
 * @project JasonJavaLibrary
 * @description: public API:
 * https://httpbin.org/
 * https://documenter.getpostman.com/view/8854915/Szf7znEe
 * https://github.com/public-apis/public-apis
 * https://jsonplaceholder.typicode.com/posts
 */
public class HttpClientExample {

    public static void main(String[] args) throws Exception {
            HttpClientExample example = new HttpClientExample();
            example.post();
    }

    private void post() {
        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newBuilder().build();

        // Define the URL endpoint for the POST request
        String url = "https://www.lexiangxiang.com/api/four_elements_verification";

        // Define the JSON payload for the POST request
        //        String jsonPayload = "{\"name\": \"John\", \"age\": 30}";
        String jsonPayload = "" +
                "{" +
                "\"partnerId\": \"6225368075496071183\"," +
                "\"registrationNumber\": \"92532901MAC7P58KXL\"," +
                "\"entName\": \"大理市维创通讯设备经营部\"," +
                "\"name\": \"马文龙\"," +
                "\"idCard\": \"532126199109122331\"," +
                "\"signatureType\": \"md5\"," +
                "\"signature\": \"db3c71baf450968fb14b15eeba5e4a5c\"" +
                "}";
        // Create the HttpRequest with POST method and the JSON payload
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonPayload))
                .build();
        try {
            // Send the request and receive the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Get the response status code
            int statusCode = response.statusCode();

            // Get the response body
            String responseBody = response.body();

            // Get the response headers
            HttpHeaders headers = response.headers();

            // Print the response
            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
            System.out.println("Response Headers: " + headers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static String readString(InputStream is) {
        BufferedReader br = null;
        String content = "";
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                content += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(br);
        }
        return content;
    }

    private static void close(Closeable closeable) {
        if (closeable == null)
            return;

        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TrustManager[] getTrustAllCerts() {
        return new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
    }

}
