package com.lucadev.coinmarketcap;

import com.lucadev.coinmarketcap.api.CurrencyTicker;
import com.lucadev.coinmarketcap.api.GlobalTicker;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
     * Test if the {@link CoinMarketCap#ticker(long)} method returns a not-null value.
     */
    @Test
    public void shouldNotGetNullTicker() {
        CurrencyTicker currencyTicker = CoinMarketCap.ticker(1);
        assertNotNull(currencyTicker);
    }

    /**
     * Test if the {@link CoinMarketCap#ticker(long)} method returns a not-null value.
     */
    @Test
    public void shouldNotGetNullTickerWithMarketName() {
        CurrencyTicker currencyTicker = CoinMarketCap.ticker("bitcoin");
        assertNotNull(currencyTicker);
    }

}