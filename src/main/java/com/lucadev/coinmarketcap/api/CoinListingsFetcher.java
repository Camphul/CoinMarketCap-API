package com.lucadev.coinmarketcap.api;

import com.lucadev.coinmarketcap.model.CoinListingList;
import com.lucadev.coinmarketcap.model.CoinListingsApiResponse;

import java.util.concurrent.TimeUnit;

/**
 * Fetches coin listings
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinListingsFetcher implements Ticker<CoinListingsApiResponse, CoinListingList> {

    /**
     * Expiry of cache in seconds
     */
    public static final long CACHE_EXPIRY_TIME_DEFAULT = 600;
    /**
     * Always fetch new
     */
    public static final long CACHE_EXPIRY_TIME_NO_CACHE = -1;

    private final ApiConnector apiConnector;
    private CoinListingsApiResponse cachedResponse;
    private long cacheExpiryTimeout = CACHE_EXPIRY_TIME_DEFAULT;

    public CoinListingsFetcher() {
        apiConnector = new ApiConnector().path("/listings");

    }

    @Override
    public CoinListingsApiResponse getApiResponse() {
        if (isCacheExpired()) {
            cachedResponse = apiConnector.getApiResponse(CoinListingsApiResponse.class);
        }
        return cachedResponse;
    }

    /**
     * Check if cache is expired.
     *
     * @return true when cache is expired.
     */
    private boolean isCacheExpired() {

        //No cache available so return true to fetch
        if (cachedResponse == null) {
            return true;
        }

        //If cache is disabled
        if (cacheExpiryTimeout <= CACHE_EXPIRY_TIME_NO_CACHE) {
            return true;
        }

        long currentUnix = System.currentTimeMillis();
        //Timestamp when cache should expire
        long expiryUnix = currentUnix
                + TimeUnit.SECONDS.convert(cacheExpiryTimeout, TimeUnit.MILLISECONDS);

        if (currentUnix < expiryUnix) {
            return true;
        }

        return false;
    }

    @Override
    public CoinListingList get() {
        return getApiResponse().getData();
    }

    /**
     * Remove cache response, forcing the api to refetch when {@link #get()} is invoked.
     * @return the current {@code CoinListingsFetcher}
     */
    public CoinListingsFetcher evictCache() {
        this.cachedResponse = null;
        return this;
    }

    /**
     * After how many time units should we refresh our cache
     *
     * @param cacheExpiryTimeout
     * @param timeUnit
     */
    public CoinListingsFetcher cacheExpiryTimeout(long cacheExpiryTimeout, TimeUnit timeUnit) {
        this.cacheExpiryTimeout = timeUnit.convert(cacheExpiryTimeout, TimeUnit.SECONDS);
        return this;
    }
}
