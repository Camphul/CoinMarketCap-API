package com.lucadev.coinmarketcap.api;

import com.lucadev.coinmarketcap.model.ApiResponse;

/**
 * Exception for when an api request fails
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class ApiResponseException extends RuntimeException {

    private final ApiResponse<?> apiResponse;

    public ApiResponseException(ApiResponse<?> apiResponse) {
        super("Failed API Request. Returned: " + apiResponse.getError());
        this.apiResponse = apiResponse;
    }

    public ApiResponse<?> getApiResponse() {
        return apiResponse;
    }
}
