package com.vn.nhat.datastructure.linkedlist;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

  @Test
  void testAddFirstSuccess() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addFirst(23);
    list.addFirst(10);
    Node<Integer> first = list.getHead();
    Assertions.assertEquals(10, first.value);
  }

  @Test
  void testAddPositionSuccess() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addFirst(23);
    list.addFirst(10);
    list.addAfter(12, 1);
    Node<Integer> result = list.get(2);
    Assertions.assertEquals(12, result.value);
  }

  @Test
  void testAddPositionOutOfBounds() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addFirst(23);
    list.addFirst(10);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      list.addAfter(12, 3);
    });
  }

  @Test
  void testAddPositionNegative() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addFirst(23);
    list.addFirst(10);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      list.addAfter(12, -1);
    });
  }

  @Test
  void testFromList() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    linkedList.fromList(list);
    Assertions.assertEquals(list, linkedList.printAll());
  }

  @Test
  void testReverseElementSuccess() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    linkedList.fromList(list);
    linkedList.reverseElement();
    Assertions.assertEquals(list.reversed(), linkedList.printAll());
  }

  @Test
  void testReverseLinkSuccess() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    linkedList.fromList(list);
    linkedList.reverseLink();
    Assertions.assertEquals(list.reversed(), linkedList.printAll());
  }
}

