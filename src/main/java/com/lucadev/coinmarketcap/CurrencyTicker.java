package com.lucadev.coinmarketcap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucadev.coinmarketcap.http.ApiConnector;
import com.lucadev.coinmarketcap.model.CoinMarket;

/**
 * A price ticker/fetcher for a single given market. This class implements the {@link Ticker<CoinMarket>} interface.
 * This class implements the <a href="https://coinmarketcap.com/api/">/ticker/{id}</a> endpoint as described.
 * <p>
 * Instances of this class should be obtained through {@link CoinMarketCap#ticker(String)}.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class CurrencyTicker implements Ticker<CoinMarket> {

    private ApiConnector apiConnector;
    private ObjectMapper objectMapper;

    /**
     * Create the ticker with the specified market we want to fetch.
     *
     * @param coinName the market identifier. Examples of these are(cAsE-SentIvE): bitcoin, litecoin, ethereum, etc...
     * @throws IllegalArgumentException when the {@code coinName} argumeter that was passed is either null or empty.
     *                                  This does not check for invalid coin names.
     */
    public CurrencyTicker(String coinName) {
        if (coinName == null || coinName.isEmpty()) {
            throw new IllegalArgumentException("coinName parameter may not be null or empty.");
        }
        objectMapper = new ObjectMapper();
        apiConnector = new ApiConnector().path("ticker/" + coinName);
    }

    /**
     * Obtain current market information of the specified currency.
     *
     * @return a {@link CoinMarket} response containing market information
     * @see Ticker#get()
     * @see CoinMarket
     */
    @Override
    public CoinMarket get() {
        JsonNode json = apiConnector.getJsonNode();
        /* Request failed so we simply return null */
        if(json == null) {
            return null;
        }
        try {
            return objectMapper.treeToValue(json.get(0), CoinMarket.class);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
