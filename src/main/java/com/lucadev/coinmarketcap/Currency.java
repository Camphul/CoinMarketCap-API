package com.lucadev.coinmarketcap;

import java.util.Arrays;

/**
 * Enum containing CMC supported currencies
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public enum Currency {

   AUD(CurrencyType.FIAT),
   BRL(CurrencyType.FIAT),
   CAD(CurrencyType.FIAT),
   CHF(CurrencyType.FIAT),
   CLP(CurrencyType.FIAT),
   CNY(CurrencyType.FIAT),
   CZK(CurrencyType.FIAT),
   DKK(CurrencyType.FIAT),
   EUR(CurrencyType.FIAT),
   GBP(CurrencyType.FIAT),
   HKD(CurrencyType.FIAT),
   HUF(CurrencyType.FIAT),
   IDR(CurrencyType.FIAT),
   ILS(CurrencyType.FIAT),
   INR(CurrencyType.FIAT),
   JPY(CurrencyType.FIAT),
   KRW(CurrencyType.FIAT),
   MXN(CurrencyType.FIAT),
   MYR(CurrencyType.FIAT),
   NOK(CurrencyType.FIAT),
   NZD(CurrencyType.FIAT),
   PHP(CurrencyType.FIAT),
   PKR(CurrencyType.FIAT),
   PLN(CurrencyType.FIAT),
   RUB(CurrencyType.FIAT),
   SEK(CurrencyType.FIAT),
   SGD(CurrencyType.FIAT),
   THB(CurrencyType.FIAT),
   TRY(CurrencyType.FIAT),
   TWD(CurrencyType.FIAT),
   ZAR(CurrencyType.FIAT),
   USD(CurrencyType.FIAT),
   BTC(CurrencyType.CRYPTO),
   ETH(CurrencyType.CRYPTO),
   XRP(CurrencyType.CRYPTO),
   LTC(CurrencyType.CRYPTO),
   BCH(CurrencyType.CRYPTO);

    private static Currency[] fiatCurrencies;
    private static Currency[] cryptoCurrencies;
    private final CurrencyType type;

    Currency(CurrencyType type) {
        this.type = type;
    }

    /**
     * Type of currency(fiat/crypto
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
     * @return
     */
    public boolean isCrypto() {
        return CurrencyType.CRYPTO == this.type;
    }

    /**
     * Get all fiat currencies
     * @return
     */
    public static Currency[] getFiatCurrencies() {
        if(fiatCurrencies == null) {
            fiatCurrencies = Arrays.stream(values()).filter(Currency::isFiat).toArray(Currency[]::new);
        }
        return fiatCurrencies;
    }

    /**
     * Get all crypto currencies
     * @return
     */
    public static Currency[] getCryptoCurrencies() {
        if(cryptoCurrencies == null) {
            cryptoCurrencies =  Arrays.stream(values()).filter(Currency::isCrypto).toArray(Currency[]::new);
        }
        return cryptoCurrencies;
    }

    /**
     * Type of currency
     */
    enum CurrencyType {
       FIAT,
       CRYPTO
   }
}
