package com.lucadev.coinmarketcap.model;

import java.util.List;

/**
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public class TickerResponse {

    private List<CoinMarket> markets;

    public TickerResponse(List<CoinMarket> markets) {
        this.markets = markets;
    }

    public List<CoinMarket> getMarkets() {
        return markets;
    }


}
