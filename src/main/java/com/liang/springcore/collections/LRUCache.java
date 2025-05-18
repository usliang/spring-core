package com.liang.springcore.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> accessOrder;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.accessOrder = new LinkedList<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            // Move the accessed key to the tail of the list to mark it as recently used
            accessOrder.remove(key);
            accessOrder.addLast(key);
            return cache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            // Key exists, update the value and move it to the tail
            cache.put(key, value);
            accessOrder.remove(key);
            accessOrder.addLast(key);
        } else {
            if (cache.size() == capacity) {
                // Cache is full, remove the least recently used element (head of the list)
                K oldestKey = accessOrder.removeFirst();
                cache.remove(oldestKey);
            }
            // Add the new key-value pair to the cache and the tail of the list
            cache.put(key, value);
            accessOrder.addLast(key);
        }
    }

    public int size() {
        return cache.size();
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LRUCache { capacity=");
        sb.append(capacity).append(", size=").append(size()).append(", entries=[");
        boolean first = true;
        for (K key : accessOrder) {
            if (!first) {
                sb.append(", ");
            }
            sb.append("(").append(key).append("=").append(cache.get(key)).append(")");
            first = false;
        }
        sb.append("] }");
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        int capacity = lruCache.getCapacity();
        System.out.println("capacity = " + capacity);

        lruCache.put(1, "one");
        System.out.println(lruCache); // Output: LRUCache { capacity=3, size=1, entries=[(1=one)] }

        lruCache.put(2, "two");
        System.out.println(lruCache); // Output: LRUCache { capacity=3, size=2, entries=[(1=one), (2=two)] }

        lruCache.put(3, "three");
        System.out.println(lruCache); // Output: LRUCache { capacity=3, size=3, entries=[(1=one), (2=two), (3=three)] }

        System.out.println("Get key 1: " + lruCache.get(1)); // Output: Get key 1: one
        System.out.println(lruCache); // Output: LRUCache { capacity=3, size=3, entries=[(2=two), (3=three), (1=one)] }

        lruCache.put(4, "four"); // Cache is full, 2 (least recently used) will be removed
        System.out.println(lruCache); // Output: LRUCache { capacity=3, size=3, entries=[(3=three), (1=one), (4=four)] }

        System.out.println("Get key 2: " + lruCache.get(2)); // Output: Get key 2: null

        System.out.println("Get key 3: " + lruCache.get(3)); // Output: Get key 3: three
        System.out.println(lruCache); // Output: LRUCache { capacity=3, size=3, entries=[(1=one), (4=four), (3=three)] }
    }
}