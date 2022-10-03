package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class Http {
    public List<listJsion> getProd(int i, int page) {
        HttpRequest request = null;
        HttpResponse<String> response = null;
        List<listJsion> products = null;
        try {
            Gson gson = new Gson();

            try {
                request = HttpRequest.newBuilder()
                        .uri(new URI("https://catalog.wb.ru/brands/k/catalog?appType=1&brand=" + i + "&couponsGeo=2,12,3,18,21&curr=rub&dest=-1029256,-81995,-1235082,123585487&emp=0&lang=ru&locale=ru&page=" + page + "&pricemarginCoeff=1.0&reg=0&regions=68,64,83,4,38,80,33,70,82,86,30,69,1,48,22,66,31,40&sort=priceup&spp=0"))
                        .GET()
                        .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //json1 json1 = objectMapper.readValue(response.body(), json1.class);

            json1 json1 = gson.fromJson(response.body(), json1.class);
            products = json1.data.getProducts();
        } catch (NullPointerException e){
            System.out.println("Json null");
        }
        return products;
    }
}