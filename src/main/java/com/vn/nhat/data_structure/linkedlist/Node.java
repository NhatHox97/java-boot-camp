package com.vn.nhat.data_structure.linkedlist;

class Node<T> {
  T value;
  Node<T> next;

  public Node(T data) {
    value = data;
    next = null;
  }
}
