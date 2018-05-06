package com.lucadev.coinmarketcap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Model for apibase/listings endpoint
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinListingsApiResponse extends ApiResponse<List<CoinListing>> {

    protected static final String KEY_METADATA_LISTING_COUNT = "num_cryptocurrencies";

    /**
     * Constructs the response model.
     *
     * @param data     the response data.
     * @param metadata the metadata object in the response. Inside a map.
     */
    @JsonCreator
    public CoinListingsApiResponse(@JsonProperty(PROPERTY_DATA) List<CoinListing> data,
                                   @JsonProperty(PROPERTY_METADATA) Map<String, Object> metadata) {
        super(data, metadata);
    }

    /**
     * @return amount of listings
     */
    public long count() {
        return Long.parseLong((String) getMetadata().get(KEY_METADATA_LISTING_COUNT));
    }
}
