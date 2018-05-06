package com.lucadev.coinmarketcap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * API response for a single market
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinMarketApiResponse extends ApiResponse<CoinMarket> {

    /**
     * Constructs the response model.
     *
     * @param data     the response data.
     * @param metadata the metadata object in the response. Inside a map.
     */
    @JsonCreator
    public CoinMarketApiResponse(@JsonProperty(JSON_DATA_PROPERTY) CoinMarket data,
                                 @JsonProperty(JSON_METADATA_PROPERTY) Map<String, Object> metadata) {
        super(data, metadata);
    }
}
