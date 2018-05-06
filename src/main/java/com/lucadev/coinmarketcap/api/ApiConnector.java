package com.lucadev.coinmarketcap.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucadev.coinmarketcap.model.ApiResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Helper class to support/layer {@link Ticker} implementations with the <a href="https://coinmarketcap.com/api/">REST-service</a>.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class ApiConnector {

    /**
     * API version that is supported.
     */
    public static final String API_VERSION = "v2";
    /**
     * Base URL for API endpoints.
     */
    public static final String API_BASE_URL = "https://api.coinmarketcap.com/";
    private Client client;
    private ObjectMapper objectMapper;
    private WebTarget webTarget;

    /**
     * Instantiate a new client to access API endpoints.
     */
    public ApiConnector() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
        webTarget = client.target(API_BASE_URL + API_VERSION + "/");
    }

    /**
     * Append the URI path after the {@link ApiConnector#API_BASE_URL}/{@link ApiConnector#API_VERSION} URL.
     *
     * @param path the path to append to our request.
     * @return the configured {@link ApiConnector}. We may use this as a sort-of builder pattern.
     */
    public ApiConnector path(String path) {
        webTarget = webTarget.path(path);
        return this;
    }

    /**
     * Configure a query parameter.
     *
     * @param key   the query key such as {@code start}
     * @param value the value we assign to the key such as {@code 5}.
     * @return
     */
    public ApiConnector queryParam(String key, Object value) {
        webTarget = webTarget.queryParam(key, String.valueOf(value));
        return this;
    }

    /**
     * Finish setting up the request which should now be ready for any type of HTTP request.
     *
     * @return a builder used to invoke the request we configured using this {@link ApiConnector}.
     */
    private Invocation.Builder prepareRequest() {
        return webTarget.request(MediaType.APPLICATION_JSON);
    }

    /**
     * Obtain a HTTP GET response and return a json-parsed response.
     *
     * @param clazz the class to parse the response into.
     * @param <T>   the type of response we expect.
     * @return an instance of {@code <T>} build from our HTTP GET response.
     */
    public <T> T get(Class<T> clazz) {
        return prepareRequest().get(clazz);
    }

    /**
     * Get API response
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends ApiResponse<?>> T getApiResponse(Class<T> clazz) {
        return prepareRequest().get(clazz);
    }

}
