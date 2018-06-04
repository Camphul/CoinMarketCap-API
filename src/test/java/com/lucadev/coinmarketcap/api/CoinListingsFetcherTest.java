package com.lucadev.coinmarketcap.api;

import com.lucadev.coinmarketcap.model.CoinListingsApiResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinListingsFetcherTest {

    private CoinListingsFetcher fetcher;

    @Before
    public void before() {
        fetcher = new CoinListingsFetcher();
    }

    @After
    public void teardown() {
        this.fetcher = null;
    }

    @Test
    public void shouldGetNonEmptyListResult() {
        assertNotNull(fetcher);
        CoinListingsApiResponse response = fetcher.getApiResponse();
        assertNotNull(response);
        assertTrue(response.getData().size() > 0);
    }

}