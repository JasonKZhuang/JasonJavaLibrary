package com.jasonz.network.http_client;

import org.apache.commons.lang3.StringUtils;

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
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

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

    private static final String BLOG_POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws Exception {

    }

    // Once built, an HttpClient can be used to send multiple requests.
    public HttpClient buildTypicalHttpClient() {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                // .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                // .authenticator(Authenticator.getDefault())
                .build();
    }

    // Once built an HttpRequest is immutable, and can be sent multiple times.
    public HttpRequest generateTypicalHttpRequest(String url) {
        if (StringUtils.length(url) == 0) {
            url = BLOG_POSTS_API_URL;
        }
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .build();


//        HttpRequest.BodyPublishers::ofByteArray(byte[])
//        HttpRequest.BodyPublishers::ofByteArrays(Iterable)
//        HttpRequest.BodyPublishers::ofFile(Path)
//        HttpRequest.BodyPublishers::ofString(String)
//        HttpRequest.BodyPublishers::ofInputStream(Supplier<InputStream>)
    }

    // The synchronous API, as expected, blocks until the HttpResponse is available.
    public int aTypicalSynchronousRequest() {
        try {
            HttpClient httpClient = buildTypicalHttpClient();
            HttpRequest request = generateTypicalHttpRequest(BLOG_POSTS_API_URL);
            HttpResponse<String> response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return response.statusCode();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String aTypicalASynchronousRequest() {
        try {
            HttpClient httpClient = buildTypicalHttpClient();
            HttpRequest request = generateTypicalHttpRequest(BLOG_POSTS_API_URL);
            CompletableFuture<String> future =httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(response -> {
                        System.out.println(response.statusCode());
                        return response;
                    })
                    .thenApply(HttpResponse::body);
                    //.thenAccept(System.out::println);
            System.out.println("Async request sent");
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        HttpResponse.BodyHandlers::ofByteArray()
//        HttpResponse.BodyHandlers::ofString()
//        HttpResponse.BodyHandlers::ofFile(Path)
//        HttpResponse.BodyHandlers::discarding()

    }

    private void usingHttpClientGetResponseBody() {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BLOG_POSTS_API_URL))
                .build();

        try {
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private void usingHttpClientGet() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(BLOG_POSTS_API_URL))
                .header("accept", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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

    private String readString(InputStream is) {
        BufferedReader br = null;
        StringBuilder content = new StringBuilder();
        try {
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(br);
        }
        return content.toString();
    }

    private void close(Closeable closeable) {
        if (closeable == null)
            return;

        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TrustManager[] getTrustAllCerts() {
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
