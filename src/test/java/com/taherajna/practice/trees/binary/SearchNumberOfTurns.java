package com.taherajna.practice.trees.binary;

import org.junit.Assert;
import org.junit.Test;

public class SearchNumberOfTurns {

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

    Assert.assertEquals(3, search(4, 0, node8));

    Assert.assertEquals(2, search(2, 0, node8));
  }

  private int search(int i, int prevDir, Node root) {
    int result;
    if (root == null) {
      result = -1;
    } else if (root.data == i) {
      result = 0;
    } else {
      result = search(i, 0, root.left);
      if (result != -1) {
        if (prevDir == 1) {
          result++;
        }
      } else {
        result = search(i, 1, root.right);
        if (result != -1) {
          if (prevDir == 0) {
            result++;
          }
        }
      }
    }
    return result;
  }
}
