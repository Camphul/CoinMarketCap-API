package com.lucadev.coinmarketcap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucadev.coinmarketcap.http.ApiConnector;
import com.lucadev.coinmarketcap.model.CoinMarket;

/**
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class CurrencyTicker implements Ticker<CoinMarket> {

    private String coinName;
    private ApiConnector apiConnector;
    private ObjectMapper objectMapper;

    public CurrencyTicker(String coinName) {
        this.coinName = coinName;
        objectMapper = new ObjectMapper();
        apiConnector = new ApiConnector().path("ticker/" + coinName);
    }

    @Override
    public CoinMarket get() {
        JsonNode json = apiConnector.getJsonNode();
        try {
            return objectMapper.treeToValue(json.get(0), CoinMarket.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
