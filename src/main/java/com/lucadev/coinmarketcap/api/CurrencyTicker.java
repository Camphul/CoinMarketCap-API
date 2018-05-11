package com.lucadev.coinmarketcap.api;

import com.lucadev.coinmarketcap.CoinMarketCap;
import com.lucadev.coinmarketcap.Currency;
import com.lucadev.coinmarketcap.model.CoinMarket;
import com.lucadev.coinmarketcap.model.CoinMarketApiResponse;

/**
 * A price ticker/fetcher for a single given market. This class implements the {@link Ticker<CoinMarket>} interface.
 * This class implements the <a href="https://coinmarketcap.com/api/">/ticker/{id}</a> endpoint as described.
 * <p>
 * Instances of this class should be obtained through {@link CoinMarketCap#ticker(Long)}.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class CurrencyTicker implements Ticker<CoinMarketApiResponse, CoinMarket> {

    private ApiConnector apiConnector;

    /**
     * Create the ticker with the specified market we want to fetch.
     *
     * @param marketId the market id which is obtained through listings.
     * @throws IllegalArgumentException when the {@code coinName} argumeter that was passed is either null or empty.
     *                                  This does not check for invalid coin names.
     */
    public CurrencyTicker(long marketId) {
        apiConnector = new ApiConnector().path("ticker/" + marketId);
    }

    /**
     * Add a price quote for the given currency
     *
     * @param currency currency to convert price to
     * @return the current builder
     * @see <a href="https://coinmarketcap.com/api/">REST API Documentation</a> for more detailed documentation regarding the REST endpoint.
     */
    public CurrencyTicker convert(Currency currency) {
        apiConnector = apiConnector.queryParam("convert", currency.name());
        return this;
    }

    /**
     * Obtain current market information of the specified currency.
     *
     * @return a {@link CoinMarket} response containing market information
     * @see Ticker#get()
     * @see CoinMarketApiResponse
     */
    @Override
    public CoinMarketApiResponse getApiResponse() {
        return apiConnector.getApiResponse(CoinMarketApiResponse.class);
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
        return getApiResponse().getData();
    }

}
