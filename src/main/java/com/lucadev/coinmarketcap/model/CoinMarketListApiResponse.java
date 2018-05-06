package com.lucadev.coinmarketcap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinMarketListApiResponse extends ApiResponse<Map<String, CoinMarket>> {

    /**
     * Constructs the response model.
     *
     * @param data     the response data.
     * @param metadata the metadata object in the response. Inside a map.
     */
    @JsonCreator
    public CoinMarketListApiResponse(@JsonProperty(PROPERTY_DATA) Map<String, CoinMarket> data,
                                     @JsonProperty(PROPERTY_METADATA) Map<String, Object> metadata) {
        super(data, metadata);
    }
}
