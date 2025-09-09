package com.vn.nhat.algorithm.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromicTest {

  @Test
  void testHappyCase() {
    String input = "babad";
    String expected = "bab";
    LongestPalindromic longestPalindromic = new LongestPalindromic();
    String result = longestPalindromic.solution(input);
    Assertions.assertEquals(expected, result);
  }

  @Test
  void testEmptyInput() {
    String input = "";
    String expected = "";
    LongestPalindromic longestPalindromic = new LongestPalindromic();
    String result = longestPalindromic.solution(input);
    Assertions.assertEquals(expected, result);
  }

  @Test
  void testNullInput() {
    LongestPalindromic longestPalindromic = new LongestPalindromic();
    String result = longestPalindromic.solution(null);
    Assertions.assertEquals(null, result);
  }
}
