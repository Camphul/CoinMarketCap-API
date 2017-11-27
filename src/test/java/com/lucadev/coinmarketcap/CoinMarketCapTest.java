package com.lucadev.coinmarketcap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests to see if the API base class {@link CoinMarketCap} works correctly.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 27-11-17
 */
public class CoinMarketCapTest {

    /**
     * Test if the {@link CoinMarketCap#ticker()} method returns a not-null value.
     */
    @Test
    public void shouldGetNotNullGlobalTicker() {
        GlobalTicker globalTicker = CoinMarketCap.ticker();
        assertNotNull(globalTicker);
    }

    /**
     * Test if the {@link CoinMarketCap#ticker(String)} method returns a not-null value.
     */
    @Test
    public void shouldNotGetNullTicker() {
        CurrencyTicker currencyTicker = CoinMarketCap.ticker("bitcoin");
        assertNotNull(currencyTicker);
    }

}