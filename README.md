# CoinMarketCap-API
An API implementation written in Java for the [CoinMarketCap API](https://coinmarketcap.com/api/).

## Installation
To install this project first make sure you have Java 8 installed. Download or clone the project and open it in your terminal.

Execute the following command: `mvn clean install`

You may then use the maven dependency
```
<dependency>
    <groupId>com.lucadev</groupId>
    <artifactId>coinmarketcap-api</artifactId>
    <version>1.0</version>
</dependency>
```

## Usage
```java
//All the markets
CoinMarketCap.ticker()
                .setLimit(5)
                .get()
                    .getMarkets()
                    .forEach(System.out::println);

//A single selected market
CoinMarket market = CoinMarketCap.ticker("litecoin").get();
System.out.println(market);
```

An example implementation can be found in the maven test sources.

## License
This project is developed under the GNUv3 license. This license can be found under [LICENSE.txt](LICENSE.txt)

## Donations
If you wish to donate to me please use the following addresses:

* BitCoin: `1CozQVtEKF46cna5QdcvBTyb1T6qt6g67R`
* LiteCoin: `LfSix129Ceoo3LFEwe58MNG1Dt7j4t14QF`
* Ethereum: `0x4523E6b7439a3A58BaCD3ca9EAAeDe5875Fd7503`
* NEM(XEM): `NCFKOG2FZNVH6QMCRWDZEM67Q65M2UZTI7G3DPXQ`