package com.lucadev.coinmarketcap.api;

import com.lucadev.coinmarketcap.model.CoinListing;
import com.lucadev.coinmarketcap.model.CoinListingsApiResponse;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Fetches coin listings
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinListingsFetcher implements Ticker<CoinListingsApiResponse, List<CoinListing>> {

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
        long currentUnix = System.currentTimeMillis();
        if (cachedResponse == null ||
                cacheExpiryTimeout <= CACHE_EXPIRY_TIME_NO_CACHE ||
                currentUnix > (cachedResponse.getTimestamp() +
                        TimeUnit.SECONDS.convert(cacheExpiryTimeout, TimeUnit.MILLISECONDS))) {
            cachedResponse = apiConnector.getApiResponse(CoinListingsApiResponse.class);
        }
        return cachedResponse;
    }

    @Override
    public List<CoinListing> get() {
        return getApiResponse().getData();
    }

    /**
     * After how many time units should we refresh our cache
     *
     * @param cacheExpiryTimeout
     * @param timeUnit
     */
    public void setCacheExpiryTimeout(long cacheExpiryTimeout, TimeUnit timeUnit) {
        this.cacheExpiryTimeout = timeUnit.convert(cacheExpiryTimeout, TimeUnit.SECONDS);
    }
}
