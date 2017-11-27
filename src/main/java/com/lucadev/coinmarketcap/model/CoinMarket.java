package com.lucadev.coinmarketcap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Immutable model used to display information about a single market.
 * Variable names should be self-explanatory. If not read the <a href="https://coinmarketcap.com/api/">API docs</a>.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
@XmlRootElement
public final class CoinMarket {

    private final String id;
    private final String name;
    private final String symbol;
    private final int rank;
    private final double priceUSD;
    private final double priceBTC;
    private final double dailyVolumeUSD;
    private final double marketCapUSD;
    private final double availableSupply;
    private final double totalSupply;
    private final double maxSupply;
    private final double hourPrecentChange;
    private final double dayPrecentChange;
    private final double weekPercentChange;
    private final long lastUpdated;

    /**
     * Constructor to instantiate a {@code CoinMarket}.
     * Parameters should be self-explanatory.
     *
     * @param id
     * @param name
     * @param symbol
     * @param rank
     * @param priceUSD
     * @param priceBTC
     * @param dailyVolumeUSD
     * @param marketCapUSD
     * @param availableSupply
     * @param totalSupply
     * @param maxSupply
     * @param hourPrecentChange
     * @param dayPrecentChange
     * @param weekPercentChange
     * @param lastUpdated
     */
    @JsonCreator
    public CoinMarket(@JsonProperty("id") String id, @JsonProperty("name") String name,
                      @JsonProperty("symbol") String symbol, @JsonProperty("rank") int rank,
                      @JsonProperty("price_usd") double priceUSD, @JsonProperty("price_btc") double priceBTC,
                      @JsonProperty("24h_volume_usd") double dailyVolumeUSD, @JsonProperty("market_cap_usd") double marketCapUSD,
                      @JsonProperty("available_supply") double availableSupply, @JsonProperty("total_supply") double totalSupply,
                      @JsonProperty("max_supply") double maxSupply, @JsonProperty("percent_change_1h") double hourPrecentChange,
                      @JsonProperty("percent_change_24h") double dayPrecentChange, @JsonProperty("percent_change_7d") double weekPercentChange,
                      @JsonProperty("last_updated") long lastUpdated) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.priceUSD = priceUSD;
        this.priceBTC = priceBTC;
        this.dailyVolumeUSD = dailyVolumeUSD;
        this.marketCapUSD = marketCapUSD;
        this.availableSupply = availableSupply;
        this.totalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.hourPrecentChange = hourPrecentChange;
        this.dayPrecentChange = dayPrecentChange;
        this.weekPercentChange = weekPercentChange;
        this.lastUpdated = lastUpdated;
    }

    /**
     * IntelliJ IDEA auto-generated equals
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoinMarket that = (CoinMarket) o;

        if (rank != that.rank) return false;
        if (Double.compare(that.priceUSD, priceUSD) != 0) return false;
        if (Double.compare(that.priceBTC, priceBTC) != 0) return false;
        if (Double.compare(that.dailyVolumeUSD, dailyVolumeUSD) != 0) return false;
        if (Double.compare(that.marketCapUSD, marketCapUSD) != 0) return false;
        if (Double.compare(that.availableSupply, availableSupply) != 0) return false;
        if (Double.compare(that.totalSupply, totalSupply) != 0) return false;
        if (Double.compare(that.maxSupply, maxSupply) != 0) return false;
        if (Double.compare(that.hourPrecentChange, hourPrecentChange) != 0) return false;
        if (Double.compare(that.dayPrecentChange, dayPrecentChange) != 0) return false;
        if (Double.compare(that.weekPercentChange, weekPercentChange) != 0) return false;
        if (lastUpdated != that.lastUpdated) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;

    }

    /**
     * IntelliJ IDEA auto-generated hashCode
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + rank;
        temp = Double.doubleToLongBits(priceUSD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceBTC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dailyVolumeUSD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(marketCapUSD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(availableSupply);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalSupply);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxSupply);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hourPrecentChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dayPrecentChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weekPercentChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (lastUpdated ^ (lastUpdated >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CoinMarket{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rank=" + rank +
                ", priceUSD=" + priceUSD +
                ", priceBTC=" + priceBTC +
                ", dailyVolumeUSD=" + dailyVolumeUSD +
                ", marketCapUSD=" + marketCapUSD +
                ", availableSupply=" + availableSupply +
                ", totalSupply=" + totalSupply +
                ", maxSupply=" + maxSupply +
                ", hourPrecentChange=" + hourPrecentChange +
                ", dayPrecentChange=" + dayPrecentChange +
                ", weekPercentChange=" + weekPercentChange +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return rank;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public double getPriceBTC() {
        return priceBTC;
    }

    public double getDailyVolumeUSD() {
        return dailyVolumeUSD;
    }

    public double getMarketCapUSD() {
        return marketCapUSD;
    }

    public double getAvailableSupply() {
        return availableSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public double getHourPrecentChange() {
        return hourPrecentChange;
    }

    public double getDayPrecentChange() {
        return dayPrecentChange;
    }

    public double getWeekPercentChange() {
        return weekPercentChange;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }
}
