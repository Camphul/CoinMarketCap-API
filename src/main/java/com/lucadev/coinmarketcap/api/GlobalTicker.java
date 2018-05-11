package com.lucadev.coinmarketcap.api;

import com.lucadev.coinmarketcap.CoinMarketCap;
import com.lucadev.coinmarketcap.Currency;
import com.lucadev.coinmarketcap.model.CoinMarketList;
import com.lucadev.coinmarketcap.model.CoinMarketListApiResponse;

/**
 * A price ticker/fetcher for multiple markets. This class implements the {@link Ticker< CoinMarketList >} interface.
 * This class implements the <a href="https://coinmarketcap.com/api/">/ticker/</a> endpoint as described.
 * <p>
 * Instances of this class should be obtained through {@link CoinMarketCap#ticker()}.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class GlobalTicker implements Ticker<CoinMarketListApiResponse, CoinMarketList> {

    private ApiConnector apiConnector;

    /**
     * Instantiate a new {@code GlobalTicker}.
     * It is recommended to use {@link CoinMarketCap#ticker()} to build this class.
     */
    public GlobalTicker() {
        apiConnector = new ApiConnector().path("/ticker");
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
     * Add a price quote for the given currency
     *
     * @param currency currency to convert price to
     * @return the current builder
     * @see <a href="https://coinmarketcap.com/api/">REST API Documentation</a> for more detailed documentation regarding the REST endpoint.
     */
    public GlobalTicker convert(Currency currency) {
        apiConnector = apiConnector.queryParam("convert", currency.name());
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
    public CoinMarketListApiResponse getApiResponse() {
        return apiConnector.getApiResponse(CoinMarketListApiResponse.class);
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
        return new CoinMarketList(getApiResponse().getData().values());
    }


}
