package com.lucadev.coinmarketcap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model to represent a single coin listing.
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinListing {

    private final long id;
    private final String name;
    private final String symbol;
    private final String websiteSlug;

    @JsonCreator
    public CoinListing(@JsonProperty("id") long id, @JsonProperty("name") String name,
                       @JsonProperty("symbol") String symbol, @JsonProperty("website_slug") String websiteSlug) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.websiteSlug = websiteSlug;
    }

    @Override
    public String toString() {
        return "CoinListing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", websiteSlug='" + websiteSlug + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getWebsiteSlug() {
        return websiteSlug;
    }
}
