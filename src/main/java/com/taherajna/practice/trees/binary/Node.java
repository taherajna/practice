package com.taherajna.practice.trees.binary;

public class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Node that = (Node) o;

    if (data != that.data) {
      return false;
    }
    if (left != null ? !left.equals(that.left) : that.left != null) {
      return false;
    }
    return right != null ? right.equals(that.right) : that.right == null;
  }

  @Override
  public int hashCode() {
    int result = data;
    result = 31 * result + (left != null ? left.hashCode() : 0);
    result = 31 * result + (right != null ? right.hashCode() : 0);
    return result;
  }
}
