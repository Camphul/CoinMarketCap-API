package com.lucadev.coinmarketcap.model;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Immutable model used to handle a response containing multiple marketList.
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public class CoinMarketList implements List<CoinMarket> {

    private final List<CoinMarket> marketList;

    /**
     * Instantiate the model with the required arguments.
     *
     * @param markets a {@link List<CoinMarket>} of market models.
     */
    public CoinMarketList(Collection<CoinMarket> markets) {
        if (markets == null) {
            throw new NullPointerException("markets argument may not be null.");
        }
        this.marketList = Collections.unmodifiableList(new ArrayList<>(markets));
    }

    /**
     * Find a market in the market list by linear searching through the list.
     *
     * @param marketId the id of the market such as: bitcoin, litecoin
     * @return a valid {@link CoinMarket} or null if we could not find a market.
     */
    public CoinMarket getByName(String marketId) {
        if (marketId == null || marketId.isEmpty()) {
            return null;
        }
        return marketList.stream()
                .filter(market -> market.getName().equalsIgnoreCase(marketId))
                .findFirst().orElse(null);
    }

    /**
     * Find a market in the market list by linear searching through the list.
     *
     * @param symbol the symbol of the market such as BTC, LTC
     * @return a valid {@link CoinMarket} or null if we could not find a market.
     */
    public CoinMarket getBySymbol(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            return null;
        }
        return marketList.stream()
                .filter(market -> market.getSymbol().equalsIgnoreCase(symbol))
                .findFirst().orElse(null);
    }

    @Override
    public int size() {
        return marketList.size();
    }

    @Override
    public boolean isEmpty() {
        return marketList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return marketList.contains(o);
    }

    @Override
    public Iterator<CoinMarket> iterator() {
        return marketList.iterator();
    }

    @Override
    public Object[] toArray() {
        return marketList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return marketList.toArray(ts);
    }

    @Override
    public boolean add(CoinMarket coinMarket) {
        return marketList.add(coinMarket);
    }

    @Override
    public boolean remove(Object o) {
        return marketList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return marketList.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends CoinMarket> collection) {
        return marketList.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends CoinMarket> collection) {
        return marketList.addAll(i, collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return marketList.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return marketList.retainAll(collection);
    }

    @Override
    public void replaceAll(UnaryOperator<CoinMarket> unaryOperator) {
        marketList.replaceAll(unaryOperator);
    }

    @Override
    public void sort(Comparator<? super CoinMarket> comparator) {
        marketList.sort(comparator);
    }

    @Override
    public void clear() {
        marketList.clear();
    }

    @Override
    public boolean equals(Object o) {
        return marketList.equals(o);
    }

    @Override
    public int hashCode() {
        return marketList.hashCode();
    }

    @Override
    public CoinMarket get(int i) {
        return marketList.get(i);
    }

    @Override
    public CoinMarket set(int i, CoinMarket coinMarket) {
        return marketList.set(i, coinMarket);
    }

    @Override
    public void add(int i, CoinMarket coinMarket) {
        marketList.add(i, coinMarket);
    }

    @Override
    public CoinMarket remove(int i) {
        return marketList.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return marketList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return marketList.lastIndexOf(o);
    }

    @Override
    public ListIterator<CoinMarket> listIterator() {
        return marketList.listIterator();
    }

    @Override
    public ListIterator<CoinMarket> listIterator(int i) {
        return marketList.listIterator(i);
    }

    @Override
    public List<CoinMarket> subList(int i, int i1) {
        return marketList.subList(i, i1);
    }

    @Override
    public Spliterator<CoinMarket> spliterator() {
        return marketList.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super CoinMarket> predicate) {
        return marketList.removeIf(predicate);
    }

    @Override
    public Stream<CoinMarket> stream() {
        return marketList.stream();
    }

    @Override
    public Stream<CoinMarket> parallelStream() {
        return marketList.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super CoinMarket> consumer) {
        marketList.forEach(consumer);
    }
}
