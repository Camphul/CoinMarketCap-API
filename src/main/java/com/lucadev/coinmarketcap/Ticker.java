package com.lucadev.coinmarketcap;

/**
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public interface Ticker<T> {

    /**
     * Get the ticker response.
     *
     * @return ticker response.
     */
    T get();

}
