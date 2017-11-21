package com.lucadev.coinmarketcap;

/**
 * Main class for the API. Used as a factory
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 19-11-17
 */
public class CoinMarketCap {

    public static GlobalTicker ticker() {
        return new GlobalTicker();
    }

    public static CurrencyTicker ticker(String currency) {
        return new CurrencyTicker(currency);
    }

}
