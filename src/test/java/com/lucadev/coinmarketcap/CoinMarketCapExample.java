package com.lucadev.coinmarketcap;

import com.lucadev.coinmarketcap.model.CoinListing;
import com.lucadev.coinmarketcap.model.CoinMarket;
import com.lucadev.coinmarketcap.model.CoinMarketList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Example to show how to use the API. This is not a unit test.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public class CoinMarketCapExample {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(Currency.values()));
        CoinMarketList coinMarkets = CoinMarketCap.ticker().setLimit(5).convert(Currency.EUR).get();
        coinMarkets.forEach(System.out::println);

        //find a market
        CoinMarket bitcoinMarket = coinMarkets.getByName("bitcoin");
        System.out.println(bitcoinMarket.getUSDPriceQuote().getPrice());

        System.out.println("Specific Currency:");

        CoinMarket market = CoinMarketCap.ticker(1).get();
        System.out.println(market);

        System.out.println("Specific currency by market name:");
        CoinMarket namedMarket = CoinMarketCap.ticker("bitcoin").get();
        System.out.println(namedMarket);
        CoinMarketCap.listings().evictCache();
        System.out.println("Listings: ");

        measureListingRequestTime();
        measureListingRequestTime();
        measureListingRequestTime();
        measureListingRequestTime();
    }

    public static void measureListingRequestTime() {
        long start = System.currentTimeMillis();
        List<CoinListing> listings = CoinMarketCap.listings().cacheExpiryTimeout(600, TimeUnit.SECONDS).get();
        long end = System.currentTimeMillis();
        System.out.println("Fetch listings took: " + (end - start) + "ms, size: " + listings.size());
    }
}
