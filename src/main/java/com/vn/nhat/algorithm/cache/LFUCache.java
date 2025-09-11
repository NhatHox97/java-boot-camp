package com.vn.nhat.algorithm.cache;

import com.vn.nhat.algorithm.factory.Level;
import com.vn.nhat.algorithm.factory.Problem;

import java.util.*;

class LFUCacheInput {
    int capacity;
    int[][] operations;

    public LFUCacheInput(int capacity, int[][] operations) {
        this.capacity = capacity;
        this.operations = operations;
    }
}

class Pair<T, U> {
    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class LFUCache extends Problem<LFUCacheInput, List<Integer>> {
    private static final String DESCRIPTION = """
            Design and implement a data structure for a Least Frequently Used (LFU) cache. 
            It should support the following operations: get and put.
            Eviction Policy:
            When the cache reaches its capacity, it should invalidate and remove the least frequently used item before inserting a new item.
            If multiple key have same frequency, remove the smallest key.
            If key not found return -1.
            """;

    HashMap<Integer, Pair<Integer, Integer>> cacheMap = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> freqMap = new HashMap<>();
    int capacity = 0;


    public LFUCache() {
        super(Level.MEDIUM, DESCRIPTION);
    }


    @Override
    public List<Integer> bruteForce(LFUCacheInput input) {
        return solution(input);
    }

    @Override
    public List<Integer> solution(LFUCacheInput input) {
        // Reset state before processing
        clearMap();
        capacity = input.capacity;
        List<Integer> result = new ArrayList<>();

        for (int[] op : input.operations) {
            validateOperation(op);

            int actionType = op[0];
            validateActionType(actionType);
            int key = op[1];

            if (actionType == 1) {
                int value = getKey(key);
                result.add(value);
                continue;
            }

            int value = op[2];
            putKey(key, value);
        }

        return result;
    }

    private void putKey(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (cacheMap.containsKey(key)) {
            Pair<Integer, Integer> valueFreq = cacheMap.get(key);
            Pair<Integer, Integer> newValueFreq = new Pair<>(value, valueFreq.second + 1);
            updateFrequency(key, valueFreq.second, 1);
            return;
        }

        int cacheSize = cacheMap.size();
        if (cacheSize == capacity) {
            evictKey();
        }
        Pair<Integer, Integer> valueFreq = new Pair<>(value, 1);
        cacheMap.put(key, valueFreq);
        updateFrequency(key, 0, 1);
    }

    private void evictKey() {
        int minFreq = Collections.min(freqMap.keySet());
        HashSet<Integer> keysWithMinFreq = freqMap.get(minFreq);
        int keyToEvict = Collections.min(keysWithMinFreq);
        keysWithMinFreq.remove(keyToEvict);
        freqMap.put(minFreq, keysWithMinFreq);
        cacheMap.remove(keyToEvict);
    }

    private int getKey(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Pair<Integer, Integer> valueFreq = cacheMap.get(key);
        Pair<Integer, Integer> newValueFreq = new Pair(valueFreq.first, valueFreq.second + 1);
        updateFrequency(key, valueFreq.second, 1);
        return newValueFreq.first;
    }

    private void updateFrequency(int key, int oldFreq, int increment) {
        HashSet<Integer> keysWithOldFreq = freqMap.getOrDefault(oldFreq, new HashSet<>());
        keysWithOldFreq.remove(key);
        freqMap.put(oldFreq, keysWithOldFreq);
        HashSet<Integer> keysWithNewFreq = freqMap.getOrDefault(oldFreq + increment, new HashSet<>());
        keysWithNewFreq.add(key);
        freqMap.put(oldFreq + increment, keysWithNewFreq);
    }

    private void clearMap() {
        cacheMap.clear();
        freqMap.clear();
    }

    private void validateOperation(int[] operation) throws IllegalArgumentException {
        int actionType = operation[0];
        validateActionType(actionType);

        if (actionType == 1 && operation.length != 2) {
            throw new IllegalArgumentException("Invalid get operation: " + Arrays.toString(operation));
        }
        if (actionType == 2 && operation.length != 3) {
            throw new IllegalArgumentException("Invalid put operation: " + Arrays.toString(operation));
        }
    }

    private void validateActionType(int actionType) throws IllegalArgumentException {
        if (actionType == 1 || actionType == 2) {
            return;
        }
        throw new IllegalArgumentException("Invalid action type: " + actionType);
    }

    @Override
    public String getSolutionIdea() {
        return """
                Use HashMap<Int, Pair<Int,Int>> store key to (value, frequency) -> call this cacheMap.
                Use HashMap<Int, HashSet<Int>> store frequency to list keys -> call this freqMap.
                
                For Get operations: Get key, update frequency on cacheMap, also update freqMap
                
                For Put operations: If key exist, update value and frequency (like Get operations)
                If key not exist, check capacity -> process eviction logic(remove from cacheMap + freqMap) -> add new key to cacheMap
                """;
    }
}
