# CoinMarketCap-API
[![Build Status](http://lucadev.com/jenkins/buildStatus/icon?job=CoinMarketCap-API)](https://github.com/Camphul/CoinMarketCap-API)

An API implementation written in Java for the [CoinMarketCap API](https://coinmarketcap.com/api/).

Currently working on support for CMC API v2!!
## Installation
I have released this library onto maven central:
```
<dependency>
    <groupId>com.lucadev</groupId>
    <artifactId>coinmarketcap-api</artifactId>
    <version>1.2</version>
</dependency>
```

## Usage
```java
//All the markets
CoinMarketList coinMarkets  = CoinMarketCap.ticker().setLimit(5).get();
coinMarkets.getMarkets().forEach(System.out::println);

//find a market
CoinMarket bitcoinMarket = coinMarkets.findMarket("bitcoin");
System.out.println(bitcoinMarket.getPriceUSD());

System.out.println("Specific Currency:");

CoinMarket market = CoinMarketCap.ticker("litecoin").get();
System.out.println(market);
```

An example implementation can be found in the maven test sources.

## License
This project is developed under the GNU GPLv3 license. This license can be found under [LICENSE.txt](LICENSE.txt)

## Donations
If you wish to donate to me please use the following addresses:

* BitCoin: `1CozQVtEKF46cna5QdcvBTyb1T6qt6g67R`
* LiteCoin: `LfSix129Ceoo3LFEwe58MNG1Dt7j4t14QF`
* Ethereum: `0x4523E6b7439a3A58BaCD3ca9EAAeDe5875Fd7503`
* NEM(XEM): `NCFKOG2FZNVH6QMCRWDZEM67Q65M2UZTI7G3DPXQ`