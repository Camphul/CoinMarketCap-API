package com.lucadev.coinmarketcap.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class PriceQuote {

    private final double price;
    private final double dayVolume;
    private final double marketCap;
    private final double hourChange;
    private final double dayChange;
    private final double weekChange;

    @JsonCreator
    public PriceQuote(@JsonProperty("price") double price,
                      @JsonProperty("volume_24h") double dayVolume,
                      @JsonProperty("market_cap") double marketCap,
                      @JsonProperty("percent_change_1h") double hourChange,
                      @JsonProperty("percent_change_24h") double dayChange,
                      @JsonProperty("percent_change_7d") double weekChange) {
        this.price = price;
        this.dayVolume = dayVolume;
        this.marketCap = marketCap;
        this.hourChange = hourChange;
        this.dayChange = dayChange;
        this.weekChange = weekChange;
    }

    public double getPrice() {
        return price;
    }

    public double getDayVolume() {
        return dayVolume;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public double getHourChange() {
        return hourChange;
    }

    public double getDayChange() {
        return dayChange;
    }

    public double getWeekChange() {
        return weekChange;
    }

    @Override
    public String toString() {
        return "PriceQuote{" +
                "price=" + price +
                ", dayVolume=" + dayVolume +
                ", marketCap=" + marketCap +
                ", hourChange=" + hourChange +
                ", dayChange=" + dayChange +
                ", weekChange=" + weekChange +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceQuote that = (PriceQuote) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (Double.compare(that.dayVolume, dayVolume) != 0) return false;
        if (Double.compare(that.marketCap, marketCap) != 0) return false;
        if (Double.compare(that.hourChange, hourChange) != 0) return false;
        if (Double.compare(that.dayChange, dayChange) != 0) return false;
        return Double.compare(that.weekChange, weekChange) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dayVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(marketCap);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(hourChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dayChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weekChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
