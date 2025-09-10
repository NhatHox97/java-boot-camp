package com.vn.nhat.algorithm.string;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepeatedDNASequencesTest {

  @Test
  void testDNAHappyCase() {
    String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    List<String> expected = List.of("AAAAACCCCC", "CCCCCAAAAA");
    List<String> result = new RepeatedDNASequences().solution(input);
    Assertions.assertEquals(expected.size(), result.size());
    Assertions.assertArrayEquals(expected.toArray(), result.toArray());
  }

  @Test
  void testDNANotValidLength() {
    String input = "AAAAAA";
    List<String> expected = List.of();
    List<String> result = new RepeatedDNASequences().solution(input);
    Assertions.assertEquals(expected.size(), result.size());
    Assertions.assertArrayEquals(expected.toArray(), result.toArray());
  }

  @Test
  void testDNANullInput() {
    String input = null;
    List<String> expected = List.of();
    List<String> result = new RepeatedDNASequences().solution(input);
    Assertions.assertEquals(expected.size(), result.size());
    Assertions.assertArrayEquals(expected.toArray(), result.toArray());
  }

  @Test
  void testDNANoRepeated() {
    String input = "ABCDEFGHWACVBJGOEP";
    List<String> expected = List.of();
    List<String> result = new RepeatedDNASequences().solution(input);
    Assertions.assertEquals(expected.size(), result.size());
    Assertions.assertArrayEquals(expected.toArray(), result.toArray());
  }
}
