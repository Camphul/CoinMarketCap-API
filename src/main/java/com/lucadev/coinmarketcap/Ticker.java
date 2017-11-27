package com.lucadev.coinmarketcap;

/**
 * A basic interface that offers methodes required to implement a ticker functionality.
 *
 * @param <T> the type of response that will be returned.
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public interface Ticker<T> {

    /**
     * Obtain a response from the ticker implementation.
     *
     * @return a valid response containing our requested information.
     */
    T get();

}
