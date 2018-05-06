package com.lucadev.coinmarketcap;

import com.lucadev.coinmarketcap.model.CoinListing;

import java.util.List;

/**
 * Base API class used to access basic API functionality.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public final class CoinMarketCap {

    private static final CoinListingsFetcher COIN_LISTING_FETCHER = new CoinListingsFetcher();

    /**
     * Obtain a price ticker that can fetch multiple markets at once.
     *
     * @return a {@code /ticker/} API implementation.
     * @see <a href="https://coinmarketcap.com/api/">/ticker/ endpoint documentation.</a>
     */
    public static GlobalTicker ticker() {
        return new GlobalTicker();
    }

    /**
     * Obtain a price ticker that can fetch one market at a time.
     *
     * @return a {@code /ticker/{id}/} API implementation.
     * @see <a href="https://coinmarketcap.com/api/">/ticker/{id} endpoint documentation.</a>
     */
    public static CurrencyTicker ticker(long marketId) {
        return new CurrencyTicker(marketId);
    }

    /**
     * Coin listings
     *
     * @return
     */
    public static List<CoinListing> listings() {
        return COIN_LISTING_FETCHER.get().getData();
    }

}
