package com.workspace.demo.leetcode.linkedlist;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    final int cacheSize;
    Deque<String> deque;
    Map<String, Integer> cacheMap;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.deque = new LinkedList<>();
        this.cacheMap = new HashMap<>();
    }

    public void addToCache(String key, Integer value) {
        if (deque.size() == cacheSize) {
            String removedKey = deque.removeLast();
            cacheMap.remove(removedKey);
        }
        deque.addFirst(key);
        cacheMap.put(key, value);
    }

    public Integer getFromCache(String key) {
        deque.remove(key);
        deque.addFirst(key);
        return cacheMap.get(key);
    }

    public void deleteFromCache(String key) {
        cacheMap.remove(key);
        deque.remove(key);
    }
    public void printKeys() {
        System.out.println("deque = " + deque);
    }

    public static void main(String[] args) {

        LRUCache lru = new LRUCache(3);
        lru.addToCache("A", 1);
        lru.addToCache("B", 2);
        lru.printKeys();
        lru.addToCache("C", 3);
        lru.printKeys();
        lru.addToCache("D",4);
        lru.printKeys();
        lru.addToCache("E", 5);
        lru.printKeys();
        lru.addToCache("F", 6);
        lru.printKeys();
        lru.getFromCache("D");
        lru.printKeys();
        lru.addToCache("G",7);
        lru.printKeys();


    }
}
