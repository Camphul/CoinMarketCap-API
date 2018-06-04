package com.lucadev.coinmarketcap.model;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Wrapper to manage a list of Coinlistings
 *
 * @author <a href="mailto:Luca.Camphuisen@hva.nl">Luca Camphuisen</a>
 * @since 6-5-18
 */
public class CoinListingList implements List<CoinListing> {

    private final List<CoinListing> coinListings;

    /**
     * Construct from a {@link List}
     *
     * @param coinListings
     */
    public CoinListingList(List<CoinListing> coinListings) {
        this.coinListings = coinListings;
    }

    private Optional<CoinListing> search(Predicate<CoinListing> predicate) {
        return coinListings.stream().filter(predicate).findFirst();
    }

    /**
     * Search through listings
     *
     * @param id the listing id to search for
     * @return the {@link Optional} with our {@link CoinListing} result
     */
    public Optional<CoinListing> getById(long id) {
        return search(listing -> listing.getId() == id);
    }

    /**
     * Search through listings
     *
     * @param name the name of the listing. Case insensitive
     * @return the {@link Optional} with our {@link CoinListing} result
     */
    public Optional<CoinListing> getByName(String name) {
        return search(listing -> listing.getName().equalsIgnoreCase(name));
    }

    /**
     * Search through listings
     *
     * @param symbol the symbol of the listing. Case insensitive
     * @return the {@link Optional} with our {@link CoinListing} result
     */
    public Optional<CoinListing> getBySymbol(String symbol) {
        return search(listing -> listing.getSymbol().equalsIgnoreCase(symbol));
    }

    /**
     * Search through listings
     *
     * @param websiteSlug the website slug of the listing. Case insensitive
     * @return the {@link Optional} with our {@link CoinListing} result
     */
    public Optional<CoinListing> getByWebsiteSlug(String websiteSlug) {
        return search(listing -> listing.getWebsiteSlug().equalsIgnoreCase(websiteSlug));
    }

    @Override
    public int size() {
        return coinListings.size();
    }

    @Override
    public boolean isEmpty() {
        return coinListings.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return coinListings.contains(o);
    }

    @Override
    public Iterator<CoinListing> iterator() {
        return coinListings.iterator();
    }

    @Override
    public Object[] toArray() {
        return coinListings.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return coinListings.toArray(ts);
    }

    @Override
    public boolean add(CoinListing coinListing) {
        return coinListings.add(coinListing);
    }

    @Override
    public boolean remove(Object o) {
        return coinListings.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return coinListings.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends CoinListing> collection) {
        return coinListings.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends CoinListing> collection) {
        return coinListings.addAll(i, collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return coinListings.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return coinListings.retainAll(collection);
    }

    @Override
    public void replaceAll(UnaryOperator<CoinListing> unaryOperator) {
        coinListings.replaceAll(unaryOperator);
    }

    @Override
    public void sort(Comparator<? super CoinListing> comparator) {
        coinListings.sort(comparator);
    }

    @Override
    public void clear() {
        coinListings.clear();
    }

    @Override
    public boolean equals(Object o) {
        return coinListings.equals(o);
    }

    @Override
    public int hashCode() {
        return coinListings.hashCode();
    }

    @Override
    public CoinListing get(int i) {
        return coinListings.get(i);
    }

    @Override
    public CoinListing set(int i, CoinListing coinListing) {
        return coinListings.set(i, coinListing);
    }

    @Override
    public void add(int i, CoinListing coinListing) {
        coinListings.add(i, coinListing);
    }

    @Override
    public CoinListing remove(int i) {
        return coinListings.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return coinListings.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return coinListings.lastIndexOf(o);
    }

    @Override
    public ListIterator<CoinListing> listIterator() {
        return coinListings.listIterator();
    }

    @Override
    public ListIterator<CoinListing> listIterator(int i) {
        return coinListings.listIterator(i);
    }

    @Override
    public List<CoinListing> subList(int i, int i1) {
        return coinListings.subList(i, i1);
    }

    @Override
    public Spliterator<CoinListing> spliterator() {
        return coinListings.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super CoinListing> predicate) {
        return coinListings.removeIf(predicate);
    }

    @Override
    public Stream<CoinListing> stream() {
        return coinListings.stream();
    }

    @Override
    public Stream<CoinListing> parallelStream() {
        return coinListings.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super CoinListing> consumer) {
        coinListings.forEach(consumer);
    }
}
