package com.lucadev.coinmarketcap.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Builder for API connection
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class ApiConnector {

    public static final String API_VERSION = "v1";
    public static final String API_BASE_URL = "https://api.coinmarketcap.com/";
    private Client client;
    private ObjectMapper objectMapper;
    private WebTarget webTarget;

    public ApiConnector() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
        webTarget = client.target(API_BASE_URL + API_VERSION + "/");
    }

    public ApiConnector path(String path) {
        webTarget = webTarget.path(path);
        return this;
    }

    public ApiConnector queryParam(String key, Object value) {
        webTarget = webTarget.queryParam(key, String.valueOf(value));
        return this;
    }

    /**
     * Prepare generic requestb information
     *
     * @return
     */
    private Invocation.Builder prepareRequest() {
        return webTarget.request(MediaType.APPLICATION_JSON);
    }

    /**
     * Obtain a get request
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(Class<T> clazz) {
        return prepareRequest().get(clazz);
    }

    public JsonNode getJsonNode() {
        try {
            return objectMapper.readTree(get(String.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
