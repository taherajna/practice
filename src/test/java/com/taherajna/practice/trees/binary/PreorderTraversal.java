package com.taherajna.practice.trees.binary;

import org.junit.Assert;
import org.junit.Test;

public class PreorderTraversal {

  private static void populateArray(int[] left, int[] right, int data, int[] to) {
    to[0] = data;
    for (int i = 0; i < left.length; i++) {
      to[i + 1] = left[i];
    }
    for (int i = 0; i < right.length; i++) {
      to[left.length + 1 + i] = right[i];
    }
  }

  @Test
  public void app() {
    int[] expected = {};
    Assert.assertArrayEquals(expected, preorderArray(null));

    int[] expectedheightOne = {1};
    Node heightOne = new Node(1);
    Assert.assertArrayEquals(expectedheightOne, preorderArray(heightOne));

    int[] expectedheightTwo = {2, 1};
    Node heightTwo = new Node(2);
    heightTwo.setLeft(heightOne);
    Assert.assertArrayEquals(expectedheightTwo, preorderArray(heightTwo));

    int[] expectedheightThree = {3, 2, 1};
    Node heightThree = new Node(3);
    heightThree.setLeft(heightTwo);
    Assert.assertArrayEquals(expectedheightThree, preorderArray(heightThree));

    int[] expectedheightFour = {4, 3, 2, 1};
    Node heightFour = new Node(4);
    heightFour.setRight(heightThree);
    Assert.assertArrayEquals(expectedheightFour, preorderArray(heightFour));

    int[] expectedheightFive = {5, 4, 3, 2, 1, 4, 3, 2, 1};
    Node heightFive = new Node(5);
    heightFive.setLeft(heightFour);
    heightFive.setRight(heightFour);
    Assert.assertArrayEquals(expectedheightFive, preorderArray(heightFive));
  }

  private int[] preorderArray(Node node) {
    int[] valueArray;
    if (node == null) {
      valueArray = new int[0];
    } else {
      int[] left = preorderArray(node.left);
      int[] right = preorderArray(node.right);
      valueArray = new int[left.length + right.length + 1];
      populateArray(left, right, node.data, valueArray);
    }
    return valueArray;
  }
}
