package com.lucadev.coinmarketcap.api;

import com.lucadev.coinmarketcap.model.ApiResponse;

/**
 * A basic interface that offers methodes required to implement a ticker functionality.
 *
 * @param <T> the type of response that will be returned.
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public interface Ticker<T extends ApiResponse<?>, E> {

    /**
     * Obtain a response from the ticker implementation.
     *
     * @return a full api response containing our requested information.
     */
    T getApiResponse();

    /**
     * Obtain a usable model from the ticker implementation.
     *
     * @return a valid response containing our requested information.
     */
    E get();

}
