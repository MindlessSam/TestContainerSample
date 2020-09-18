package com.wipro.witaas.Goibibo;

import org.apache.http.HttpRequest;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContainerDemo {
    @ClassRule
    public static GenericContainer simpleWebServer
            = new GenericContainer("alpine:3.2")
            .withExposedPorts(80)
            .withCommand("/bin/sh", "-c", "while true; do echo "
                    + "\"HTTP/1.1 200 OK\n\nHello World!\" | nc -l -p 80; done");

    @Test
    public void givenSimpleWebServerContainer_whenGetReuqest_thenReturnsResponse()
            throws Exception {
        String address = "http://" + simpleWebServer.getContainerIpAddress() + ":" + simpleWebServer.getMappedPort(80);
        String response =simpleGetRequest(address);

        assertEquals(response, "Hello World!");
    }

    private String simpleGetRequest(String address) throws IOException {
        String inputLine=null;
        StringBuffer response = new StringBuffer();
        URL obj = new URL(address);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        return response.toString();
    }
}
