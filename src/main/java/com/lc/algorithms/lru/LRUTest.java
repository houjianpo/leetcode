package com.lc.algorithms.lru;

public class LRUTest {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.set(3,3);
        lruCache.set(2,2);
        lruCache.set(1,1);
        lruCache.set(5,5);
        lruCache.set(2,2);
        System.out.println(lruCache.size);
    }
}
