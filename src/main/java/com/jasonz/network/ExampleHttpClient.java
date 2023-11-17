package com.jasonz.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
public class ExampleHttpClient {
    private static final String POST_API_URL = "https://jsonplaceholder.typicode.com/posts";
//    private static final String POST_API_URL = "https://www.lexiangxiang.com/api/four_elements_verification?partnerId=6225368075496071183&registrationNumber=91460000MAC19L2335&entName=文昌刘超科技有限公司&name=刘超&idCard=342401198810265890&signature=237c9e7a99f9efb750d7c0ee94cecebc&signatureType=md5";

    public static void main(String[] args) {
        ExampleHttpClient instance = new ExampleHttpClient();
        instance.usingHttpClientGet();
    }

    private void usingHttpClientGet() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POST_API_URL))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void usingHttpConnection() {

    }
}
