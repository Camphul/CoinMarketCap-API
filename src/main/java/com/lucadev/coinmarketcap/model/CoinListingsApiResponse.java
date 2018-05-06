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
public class CoinListingsApiResponse extends ApiResponse<CoinListingList> {

    protected static final String KEY_METADATA_LISTING_COUNT = "num_cryptocurrencies";

    /**
     * Constructs the response model.
     *
     * @param data     the response data.
     * @param metadata the metadata object in the response. Inside a map.
     */
    @JsonCreator
    public CoinListingsApiResponse(@JsonProperty(JSON_DATA_PROPERTY) List<CoinListing> data,
                                   @JsonProperty(JSON_METADATA_PROPERTY) Map<String, Object> metadata) {
        super(new CoinListingList(data), metadata);
    }

    /**
     * @return amount of listings
     */
    public long count() {
        return Long.parseLong((String) getMetadata().get(KEY_METADATA_LISTING_COUNT));
    }
}
