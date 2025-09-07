package com.vn.nhat.data_structure.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple singly linked list implementation by Nhat -> N-LinkedList
 *
 * @param <T>
 */
public class LinkedList<T> {

  private Node<T> head;
  private int size;

  public LinkedList<T> fromList(List<T> list) {
    list.reversed().forEach(this::addFirst);
    return this;
  }

  /**
   * Insert a new element at the beginning of the list.
   *
   * @param value the element to add
   */
  public void addFirst(T value) {
    Node<T> newNode = new Node(value);
    newNode.next = head;
    head = newNode;
    size++;
  }

  /**
   * Insert a new element after the position pos.
   *
   * @param value the element to add
   * @param pos   position to add after
   */
  public void addAfter(T value, int pos) {
    checkIndex(pos);

    Node<T> newNode = new Node(value);
    Node<T> current = head;
    for (int i = 0; i < pos; i++) {
      current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;
    size++;
  }

  /**
   * Remove the first element in the linked list.
   */
  public void remove() {
    head = head.next;
  }

  /**
   * Remove the element at the position pos.
   *
   * @param pos position to remove
   */
  public void remove(int pos) {
    Node<T> current = head;
    for (int i = 0; i < pos; i++) {
      current = current.next;
    }
    current.next = current.next.next;
    size--;
  }

  /**
   * Get the head of the linked list.
   *
   * @return the head of the linked list
   */
  public Node<T> getHead() {
    return head;
  }

  /**
   * Get the element at the position pos.
   *
   * @param pos position of the element to get
   * @return the element at the position pos
   */
  public Node<T> get(int pos) {
    checkIndex(pos);

    Node<T> current = head;
    for (int i = 0; i < pos; i++) {
      current = current.next;
    }
    return current;
  }

  /**
   * Print all elements in the linked list.
   *
   * @return a list of elements
   */
  public List<T> printAll() {
    List<T> arr = new ArrayList();
    Node<T> current = head;
    while (current != null) {
      arr.add(current.value);
      current = current.next;
    }
    return arr;
  }

  /**
   * Reverse the linked list by swapping the element. Need extra space -> clone a linked list
   *
   */
  public void reverseElement() {
    List<T> newArr = this.printAll().reversed();
    this.deleteAll();
    this.fromList(newArr);
  }

  /**
   * Reverse the linked list by swapping the link. Using sliding 3 nodes at a time. Moving the link
   * is always more space/performance efficient than moving the value of the node
   *
   */
  public void reverseLink() {
    Node<T> nodeRight = head;
    Node<T> nodeLeft = null;
    Node<T> nodeMiddle = null;
    while (nodeRight != null) {
      nodeLeft = nodeMiddle;
      nodeMiddle = nodeRight;
      nodeRight = nodeRight.next;

      nodeMiddle.next = nodeLeft;
    }
    head = nodeMiddle;
  }

  /**
   * Get the size of the linked list.
   *
   * @return size of the linked list
   */
  public int size() {
    return size;
  }

  /**
   * Check if the position pos is valid.
   *
   * @param pos position to check
   */
  private void checkIndex(int pos) {
    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException("Index: " + pos + ", Size: " + size);
    }
  }

  /**
   * Delete all elements in the linked list.
   *
   */
  private void deleteAll() {
    head = null;
    size = 0;
  }
}

