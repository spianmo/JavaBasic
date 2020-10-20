package org.spianmo.algorithm.Archive.common;

/**
 * In computer science, an associative array, map, or dictionary is an abstract data type composed of a collection of
 * (key, value) pairs, such that each possible key appears at most once in the collection.
 * <p>
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 * @see <a href="https://en.wikipedia.org/wiki/Associative_array">Associative Array
 * (Wikipedia)</a> <br>
 */
public interface IMap<K, V> {

    /**
     * Put key->value pair in the map.
     *
     * @param key   to be inserted.
     * @param value to be inserted.
     * @return V previous value or null if none.
     */
    V put(K key, V value);

    /**
     * Get value for key.
     *
     * @param key to get value for.
     * @return value mapped to key.
     */
    V get(K key);

    /**
     * Remove key and value from map.
     *
     * @param key to remove from the map.
     * @return True if removed or False if not found.
     */
    V remove(K key);

    /**
     * Clear the entire map.
     */
    void clear();

    /**
     * Does the map contain the key.
     *
     * @param key to locate in the map.
     * @return True if key is in the map.
     */
    boolean contains(K key);

    /**
     * Number of key/value pairs in the hash map.
     *
     * @return number of key/value pairs.
     */
    int size();

    /**
     * Validate the map according to the invariants.
     *
     * @return True if the map is valid.
     */
    boolean validate();

    /**
     * Wraps this map in a Java compatible Map
     *
     * @return Java compatible Map
     */
    java.util.Map<K, V> toMap();

}
