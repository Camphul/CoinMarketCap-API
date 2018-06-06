package com.lucadev.coinmarketcap;

import java.util.Arrays;

/**
 * Enum containing CMC supported currencies
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public enum Currency {

    AUD(),
    BRL(),
    CAD(),
    CHF(),
    CLP(),
    CNY(),
    CZK(),
    DKK(),
    EUR(),
    GBP(),
    HKD(),
    HUF(),
    IDR(),
    ILS(),
    INR(),
    JPY(),
    KRW(),
    MXN(),
    MYR(),
    NOK(),
    NZD(),
    PHP(),
    PKR(),
    PLN(),
    RUB(),
    SEK(),
    SGD(),
    THB(),
    TRY(),
    TWD(),
    ZAR(),
    USD(),
    BTC(CurrencyType.CRYPTO),
    ETH(CurrencyType.CRYPTO),
    XRP(CurrencyType.CRYPTO),
    LTC(CurrencyType.CRYPTO),
    BCH(CurrencyType.CRYPTO);

    private static Currency[] fiatCurrencies;
    private static Currency[] cryptoCurrencies;
    private final CurrencyType type;

    /**
     * Defaults type to {@link CurrencyType#FIAT}
     */
    Currency() {
        this(CurrencyType.FIAT);
    }

    Currency(CurrencyType type) {
        this.type = type;
    }

    /**
     * Get all fiat currencies
     *
     * @return
     */
    public static Currency[] getFiatCurrencies() {
        if (fiatCurrencies == null) {
            fiatCurrencies = Arrays.stream(values()).filter(Currency::isFiat).toArray(Currency[]::new);
        }
        return fiatCurrencies;
    }

    /**
     * Get all crypto currencies
     *
     * @return
     */
    public static Currency[] getCryptoCurrencies() {
        if (cryptoCurrencies == null) {
            cryptoCurrencies = Arrays.stream(values()).filter(Currency::isCrypto).toArray(Currency[]::new);
        }
        return cryptoCurrencies;
    }

    /**
     * Type of currency(fiat/crypto
     *
     * @return
     */
    public CurrencyType getType() {
        return type;
    }

    /**
     * @return if the currency is of fiat type
     */
    public boolean isFiat() {
        return CurrencyType.FIAT == this.type;
    }

    /**
     * If the currency is of crypto type
     *
     * @return
     */
    public boolean isCrypto() {
        return CurrencyType.CRYPTO == this.type;
    }

    /**
     * Type of currency
     */
    enum CurrencyType {
        FIAT,
        CRYPTO
    }
}
