package com.lucadev.coinmarketcap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucadev.coinmarketcap.http.ApiConnector;
import com.lucadev.coinmarketcap.model.CoinMarket;
import com.lucadev.coinmarketcap.model.TickerResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * GlobalTicker endpoint implementation
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class GlobalTicker implements Ticker<TickerResponse> {

    private ApiConnector apiConnector;
    private ObjectMapper objectMapper;

    public GlobalTicker() {
        apiConnector = new ApiConnector();
        objectMapper = new ObjectMapper();
    }

    public GlobalTicker setStart(int start) {
        apiConnector = apiConnector.queryParam("start", start);
        return this;
    }

    public GlobalTicker setLimit(int limit) {
        apiConnector = apiConnector.queryParam("limit", limit);
        return this;
    }

    @Override
    public TickerResponse get() {
        JsonNode json = apiConnector.path("ticker").getJsonNode();
        List<CoinMarket> markets = new ArrayList<>();
        for (JsonNode jsonNode : json) {
            try {
                markets.add(objectMapper.treeToValue(jsonNode, CoinMarket.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return new TickerResponse(markets);
    }


}
