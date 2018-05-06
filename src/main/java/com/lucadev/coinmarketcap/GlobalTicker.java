package com.lucadev.coinmarketcap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucadev.coinmarketcap.http.ApiConnector;
import com.lucadev.coinmarketcap.model.CoinMarket;
import com.lucadev.coinmarketcap.model.CoinMarketList;
import com.lucadev.coinmarketcap.model.CoinMarketListApiResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * A price ticker/fetcher for multiple markets. This class implements the {@link Ticker< CoinMarketList >} interface.
 * This class implements the <a href="https://coinmarketcap.com/api/">/ticker/</a> endpoint as described.
 * <p>
 * Instances of this class should be obtained through {@link CoinMarketCap#ticker()}.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class GlobalTicker implements Ticker<CoinMarketList> {

    private ApiConnector apiConnector;
    private ObjectMapper objectMapper;

    /**
     * Instantiate a new {@code GlobalTicker}.
     * It is recommended to use {@link CoinMarketCap#ticker()} to build this class.
     */
    public GlobalTicker() {
        apiConnector = new ApiConnector().path("/ticker");
        objectMapper = new ObjectMapper();
    }

    /**
     * Configure the starting position.
     *
     * @param start results from rank {@code start} and up
     * @return the current builder.
     * @see <a href="https://coinmarketcap.com/api/">REST API Documentation</a> for more detailed documentation regarding the REST endpoint.
     */
    public GlobalTicker setStart(int start) {
        apiConnector = apiConnector.queryParam("start", start);
        return this;
    }

    /**
     * Configure the rank limit position.
     *
     * @param limit maximum amount of results/markets to get. Default is 100. Use 0 to get all results/markets.
     * @return the current builder.
     * @see <a href="https://coinmarketcap.com/api/">REST API Documentation</a> for more detailed documentation regarding the REST endpoint.
     */
    public GlobalTicker setLimit(int limit) {
        apiConnector = apiConnector.queryParam("limit", limit);
        return this;
    }

    /**
     * Obtain market information of multiple markets.
     *
     * @return a {@link CoinMarketList} response containing our markets.
     * @see Ticker#get()
     * @see CoinMarketList
     */
    @Override
    public CoinMarketList get() {
        CoinMarketListApiResponse apiResponse = apiConnector.get(CoinMarketListApiResponse.class);
        Map<String, CoinMarket> marketMap = apiResponse.getData();
        Collection<CoinMarket> markets = marketMap.values();
        return new CoinMarketList(markets);
    }


}
