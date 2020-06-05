package com.taherajna.practice.trees.binary;

import org.junit.Assert;
import org.junit.Test;

public class Search {

  @Test
  public void app() {
    Node node = new Node(1);
    Node node1 = new Node(2);
    node1.setRight(node);
    Node node2 = new Node(3);
    node2.setLeft(node1);
    Node node3 = new Node(4);
    node2.setRight(node3);
    Node node4 = new Node(5);
    node4.setLeft(node2);
    Node node5 = new Node(6);
    node5.setRight(node4);
    Node node6 = new Node(7);
    node6.setRight(node5);
    Node node7 = new Node(8);
    node6.setLeft(node7);
    Node node8 = new Node(9);
    node8.setLeft(node6);

    Assert.assertEquals(node3, search(4, node8));

    Assert.assertEquals(node2, search(3, node8));
  }

  private Node search(int i, Node root) {
    Node result;
    if (root == null) {
      result = null;
    } else if (root.data == i) {
      result = root;
    } else {
      result = search(i, root.left);
      if (result == null) {
        result = search(i, root.right);
      }
    }
    return result;
  }
}
