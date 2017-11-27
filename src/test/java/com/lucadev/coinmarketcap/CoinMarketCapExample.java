package com.lucadev.coinmarketcap;

import com.lucadev.coinmarketcap.model.CoinMarket;

/**
 * Example to show how to use the API. This is not a unit test.
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public class CoinMarketCapExample {

    public static void main(String[] args) {
        CoinMarketCap.ticker()
                .setLimit(5)
                .get()
                    .getMarkets()
                    .forEach(System.out::println);

        System.out.println("Specific Currency:");

        CoinMarket market = CoinMarketCap.ticker("litecoin").get();
        System.out.println(market);
    }

}
