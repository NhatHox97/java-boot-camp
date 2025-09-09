package com.vn.nhat.algorithm.string;

import com.vn.nhat.algorithm.factory.Problem;
import com.vn.nhat.algorithm.factory.Level;

public class LongestPalindromic extends Problem<String, String> {

  public LongestPalindromic() {
    super(Level.MEDIUM, "Given a string s, return the longest in s.");
  }

  @Override
  public String bruteForce(String input) {
    if (input == null || input.length() <= 1) {
      return input;
    }

    int bestLeft = 0;
    int bestRight = 0;
    for (int left = 0; left < input.length(); left++) {
      for (int right = left + 1; right <= input.length(); right++) {
        if (bestRight - bestLeft >= right - left) {
          continue;
        }
        String tempSub = input.substring(left, right);
        if (isPalindrome(tempSub)) {
          bestLeft = left;
          bestRight = right;
        }
      }
    }
    return input.substring(bestLeft, bestRight);
  }

  @Override
  public String solution(String input) {
    return bruteForce(input);
  }

  private boolean isPalindrome(String input) {
    if (input.length() <= 1) {
      return true;
    }
    for (int i = 0; i < input.length() / 2; i++) {
      char left = input.charAt(i);
      char right = input.charAt(input.length() - 1 - i);
      if (left != right) {
        return false;
      }
    }
    return true;
  }
}
