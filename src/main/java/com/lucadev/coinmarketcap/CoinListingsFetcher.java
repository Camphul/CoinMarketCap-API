package com.lucadev.coinmarketcap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucadev.coinmarketcap.http.ApiConnector;
import com.lucadev.coinmarketcap.model.CoinListingsApiResponse;

/**
 * Fetches coin listings
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinListingsFetcher implements Ticker<CoinListingsApiResponse> {

    private final ApiConnector apiConnector;

    public CoinListingsFetcher() {
        apiConnector = new ApiConnector().path("/listings");
    }

    @Override
    public CoinListingsApiResponse get() {
        return apiConnector.get(CoinListingsApiResponse.class);
    }
}
