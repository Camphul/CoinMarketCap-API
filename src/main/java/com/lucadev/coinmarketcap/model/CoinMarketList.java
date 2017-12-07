package com.lucadev.coinmarketcap.model;

import java.util.Collections;
import java.util.List;

/**
 * Immutable model used to handle a response containing multiple markets.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public class CoinMarketList {

    private final List<CoinMarket> markets;

    /**
     * Instantiate the model with the required arguments.
     *
     * @param markets a {@link List<CoinMarket>} of market models.
     */
    public CoinMarketList(List<CoinMarket> markets) {
        if (markets == null) {
            throw new NullPointerException("markets argument may not be null.");
        }
        this.markets = Collections.unmodifiableList(markets);
    }

    /**
     * Gets a {@link List<CoinMarket>} list containing all of our obtained markets.
     *
     * @return a unmodifiable {@link List<CoinMarket>} containing our markets.
     */
    public List<CoinMarket> getMarkets() {
        return markets;
    }

    /**
     * Find a market in the market list by linear searching through the list.
     * @param marketId the id of the market such as: bitcoin, litecoin
     * @return a valid {@link CoinMarket} or null if we could not find a market.
     */
    public CoinMarket findMarket(String marketId) {
        if(marketId == null || marketId.isEmpty()) {
            return null;
        }
        return markets.stream()
                .filter(market->market.getId().equals(marketId))
                .findFirst().orElse(null);
    }


}
