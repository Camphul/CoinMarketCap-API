package com.lucadev.coinmarketcap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucadev.coinmarketcap.Currency;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Map;

/**
 * Immutable model used to display information about a single market.
 * Variable names should be self-explanatory. If not read the <a href="https://coinmarketcap.com/api/">API docs</a>.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
@XmlRootElement
public final class CoinMarket {

    private final long id;
    private final String name;
    private final String symbol;
    private final String websiteSlug;
    private final int rank;
    private final double circulatingSupply;
    private final double totalSupply;
    private final double maxSupply;
    private final Map<Currency, PriceQuote> priceQuotes;
    private final long lastUpdated;

    /**
     * Constructor to instantiate a {@code CoinMarket}.
     * Parameters should be self-explanatory.
     *
     * @param id
     * @param name
     * @param symbol
     * @param rank
     */
    @JsonCreator
    public CoinMarket(@JsonProperty("id") long id, @JsonProperty("name") String name,
                      @JsonProperty("symbol") String symbol, @JsonProperty("website_slug") String websiteSlug,
                      @JsonProperty("rank") int rank, @JsonProperty("circulating_supply") double circulatingSupply,
                      @JsonProperty("total_supply") double totalSupply,
                      @JsonProperty("max_supply") double maxSupply,
                      @JsonProperty("quotes") Map<Currency, PriceQuote> priceQuotes,
                      @JsonProperty("last_updated") long lastUpdated) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.websiteSlug = websiteSlug;
        this.rank = rank;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.priceQuotes = priceQuotes;
        this.lastUpdated = lastUpdated;
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

    public int getRank() {
        return rank;
    }

    public double getCirculatingSupply() {
        return circulatingSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public Map<Currency, PriceQuote> getPriceQuotes() {
        return priceQuotes;
    }

    public PriceQuote getPriceQuote(Currency currency) {
        return getPriceQuotes().get(currency);
    }

    public PriceQuote getUSDPriceQuote() {
        return getPriceQuote(Currency.USD);
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public Date getLastUpdatedDate() {
        return new Date(getLastUpdated());
    }

    @Override
    public String toString() {
        return "CoinMarket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", websiteSlug='" + websiteSlug + '\'' +
                ", rank=" + rank +
                ", circulatingSupply=" + circulatingSupply +
                ", totalSupply=" + totalSupply +
                ", maxSupply=" + maxSupply +
                ", priceQuotes=" + priceQuotes +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoinMarket market = (CoinMarket) o;

        if (id != market.id) return false;
        if (rank != market.rank) return false;
        if (Double.compare(market.circulatingSupply, circulatingSupply) != 0) return false;
        if (Double.compare(market.totalSupply, totalSupply) != 0) return false;
        if (Double.compare(market.maxSupply, maxSupply) != 0) return false;
        if (lastUpdated != market.lastUpdated) return false;
        if (name != null ? !name.equals(market.name) : market.name != null) return false;
        if (symbol != null ? !symbol.equals(market.symbol) : market.symbol != null) return false;
        if (websiteSlug != null ? !websiteSlug.equals(market.websiteSlug) : market.websiteSlug != null) return false;
        return priceQuotes != null ? priceQuotes.equals(market.priceQuotes) : market.priceQuotes == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (websiteSlug != null ? websiteSlug.hashCode() : 0);
        result = 31 * result + rank;
        temp = Double.doubleToLongBits(circulatingSupply);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalSupply);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxSupply);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (priceQuotes != null ? priceQuotes.hashCode() : 0);
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        return result;
    }
}
