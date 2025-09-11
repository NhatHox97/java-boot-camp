package com.vn.nhat.algorithm.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LFUCacheTest {

    @Test
    void test_LFUCache_success() {
        int capacity = 2;
        int[][] ops = new int[][]{
                {2, 1, 10},      // put(1,10)
                {2, 2, 20},      // put(2,20)
                {1, 1},          // get(1) -> 10
                {1, 2},          // get(2) -> 20
                {1, 3}           // get(3) -> -1
        };
        LFUCacheInput input = new LFUCacheInput(capacity, ops);
        List<Integer> expected = List.of(10, 20, -1);
        List<Integer> result = new LFUCache().solution(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testLFUCache_noGetOperation() {
        int capacity = 2;
        int[][] ops = new int[][]{
                {2, 1, 10},      // put(1,10)
                {2, 2, 20}       // put(2,20)
        };
        LFUCacheInput input = new LFUCacheInput(capacity, ops);
        List<Integer> expected = List.of();
        List<Integer> result = new LFUCache().solution(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testLFUCache_noPutOperation() {
        int capacity = 2;
        int[][] ops = new int[][]{
                {1, 1},          // get(1) -> -1
                {1, 2}           // get(2) -> -1
        };
        LFUCacheInput input = new LFUCacheInput(capacity, ops);
        List<Integer> expected = List.of(-1, -1);
        List<Integer> result = new LFUCache().solution(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testLFUCache_capacityZero() {
        int capacity = 0;
        int[][] ops = new int[][]{
                {2, 1, 10},      // put(1,10)
                {1, 1}           // get(1) -> -1
        };
        LFUCacheInput input = new LFUCacheInput(capacity, ops);
        List<Integer> expected = List.of(-1);
        List<Integer> result = new LFUCache().solution(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testLFUCache_invalidOperations() {
        int capacity = 2;
        int[][] ops = new int[][]{
                {3, 1, 10},      // invalid operation
                {1, 1},          // get(1) -> -1
                {2, 2, 20},      // put(2,20)
                {4, 2}           // invalid operation
        };
        LFUCacheInput input = new LFUCacheInput(capacity, ops);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LFUCache().solution(input));
    }
}
