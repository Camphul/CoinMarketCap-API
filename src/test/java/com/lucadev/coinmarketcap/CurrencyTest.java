package com.lucadev.coinmarketcap;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests enum methods to fetch currencies
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CurrencyTest {

    @Test
    public void shouldOnlyGetFiatCurrencies() {
        for (Currency currency : Currency.getFiatCurrencies()) {
            assertTrue(currency.isFiat());
            assertFalse(currency.isCrypto());
        }
    }

    @Test
    public void shouldOnlyGetCryptoCurrencies() {
        for (Currency currency : Currency.getCryptoCurrencies()) {
            assertFalse(currency.isFiat());
            assertTrue(currency.isCrypto());
        }
    }

}