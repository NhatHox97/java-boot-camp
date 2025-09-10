package com.vn.nhat.datastructure.tree.binarytree.array;

/**
 * Present a binary tree by an array
 * <pre>
 * 1/ All the elements
 * 2/ The relationship between the elements
 *
 * Formula (element at index I):
 *  <pre>
 * - left child (2 * I) + 1
 * - right child: (2 * I) + 2
 * - parent: (I - 1) / 2
 *
 */
public class ArrayBinaryTree<T> {
  private Object[] tree;
  private int size;

  public ArrayBinaryTree(int size) {
    this.tree = new Object[size];
    this.size = 0;
  }

  public void setRoot(T value) {
    this.tree[0] = value;
    size = Math.max(size, 1);
  }




}
