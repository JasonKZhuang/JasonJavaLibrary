package com.jasonz.network;

import com.jasonz.network.http_client.HttpClientExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jason Zhuang
 * @created 2024.06.02 11:08
 * @project JasonJavaLibrary
 * @description:
 */
@Slf4j
class HttpClientExampleTest {

    @Test
    void newHttpClient_shouldNotBeNull() {
        HttpClientExample httpClientExample = new HttpClientExample();
        HttpClient httpClient = httpClientExample.buildTypicalHttpClient();
        log.info("HttpClient version: {}", httpClient.version());
        assertNotNull(httpClient);
        assertEquals(HttpClient.Version.HTTP_2, httpClient.version());

    }

    @Test
    void generateTypicalHttpRequest() {
        String uri = "https://jsonplaceholder.typicode.com/posts";
        // generate a typical http request
        // method is get
        // timeout is 10 seconds
        // header is Content-Type: application/json
        HttpClientExample httpClientExample = new HttpClientExample();
        HttpRequest request = httpClientExample.generateTypicalHttpRequest(uri);
        assertEquals(request.method(), "GET");
        request.timeout().ifPresentOrElse(
                v -> assertEquals(v, java.time.Duration.ofSeconds(10)),
                () -> {
                    throw new RuntimeException("timeout is not set");
                }
        );

        request.headers().map().forEach((k, v) -> {
            if (k.equals("Content-Type")) {
                assertEquals(v.get(0), "application/json");
            }
        });

    }

    @Test
    void aTypicalSynchronousRequest() {

        HttpClientExample httpClientExample = new HttpClientExample();
        int statusCode = httpClientExample.aTypicalSynchronousRequest();
        assertEquals(200, statusCode);

    }

    @Test
    void aTypicalASynchronousRequest() {
        HttpClientExample httpClientExample = new HttpClientExample();
        String v = httpClientExample.aTypicalASynchronousRequest();
        log.info("response: {}", v);
        assertNotNull(v);
    }

    @Test
    public void testAsyncRequestTimeout() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpstat.us/200?sleep=20000")) // This URL simulates a long delay
                .timeout(Duration.ofSeconds(5))
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Verify that a CompletionException wrapping a HttpTimeoutException is thrown
        CompletionException exception = assertThrows(CompletionException.class, responseFuture::join);

        // Verify that the cause of the CompletionException is a HttpTimeoutException
        assertEquals(HttpTimeoutException.class, exception.getCause().getClass());
    }
}