package com.vn.nhat.algorithm.string;

import com.vn.nhat.algorithm.factory.Level;
import com.vn.nhat.algorithm.factory.Problem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences extends Problem<String, List<String>> {

  private static final String DESCRIPTION = """
      The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
      
      For example, "ACGAATTCCG" is a DNA sequence.
      
      When studying DNA, it is useful to identify repeated sequences within the DNA.
      
      Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) 
      that occur more than once in a DNA molecule. You may return the answer in any order.
      """;

  public RepeatedDNASequences() {
    super(Level.MEDIUM, DESCRIPTION);
  }

  @Override
  public List<String> bruteForce(String input) {
    return solution(input);
  }

  @Override
  public List<String> solution(String input) {
    if (((input == null) ? 0 : input.length()) < 10) {
      return new ArrayList<>();
    }

    Set<String> uniqueSet = new HashSet<>();
    Set<String> duplicateSet = new HashSet<>();

    for (int i = 0; i < input.length(); i++) {
      int plusIdx = i + 10;
      if (plusIdx > input.length()) { break; }

      String subString = input.substring(i, plusIdx);
      if (uniqueSet.contains(subString)) {
        duplicateSet.add(subString);
      } else {
        uniqueSet.add(subString);
      }
    }

    return new ArrayList<>(duplicateSet);
  }

  @Override
  public String getSolutionIdea() {
    return """
        Solution idea: O(N)
        We use 2 HashSet(unique, duplicate). We loop through the input and get subString(i, i+10)
        If the subString already in unique -> add to duplicate
        Return duplicate
        """;
  }
}
