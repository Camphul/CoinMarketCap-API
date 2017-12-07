package com.lucadev.coinmarketcap;

import com.lucadev.coinmarketcap.model.CoinMarket;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests the {@link CurrencyTicker}. Includes tests for invalid coins etc..
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 7-12-17
 */
public class CurrencyTickerTest {

    /**
     * Should get a valid coin
     */
    @Test
    public void shouldGetValidCoinMarketResponse() {
        String expectedMarket = "bitcoin";
        CoinMarket market = CoinMarketCap.ticker(expectedMarket).get();
        assertNotNull(market);
        assertEquals(expectedMarket, market.getId());
    }

    /**
     * What happens when we enter an invalid market.
     */
    @Test
    public void shouldGetNullMarketOnInvalidMarketId() {
        String marketId = "abcdefhijklmnop";
        CoinMarket market = CoinMarketCap.ticker(marketId).get();
        assertNull(market);
    }

}