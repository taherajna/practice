package com.taherajna.practice.trees.binary;

import org.junit.Assert;
import org.junit.Test;

public class PostorderTraversal {

  @Test
  public void app() {
    int[] expected = {};
    Assert.assertArrayEquals(expected, postorderArray(null));

    int[] expectedheightOne = {1};
    Node heightOne = new Node(1);
    Assert.assertArrayEquals(expectedheightOne, postorderArray(heightOne));

    int[] expectedheightTwo = {1, 2};
    Node heightTwo = new Node(2);
    heightTwo.setLeft(heightOne);
    Assert.assertArrayEquals(expectedheightTwo, postorderArray(heightTwo));

    int[] expectedheightThree = {1, 2, 3};
    Node heightThree = new Node(3);
    heightThree.setLeft(heightTwo);
    Assert.assertArrayEquals(expectedheightThree, postorderArray(heightThree));

    int[] expectedheightFour = {1, 2, 3, 4};
    Node heightFour = new Node(4);
    heightFour.setRight(heightThree);
    Assert.assertArrayEquals(expectedheightFour, postorderArray(heightFour));

    int[] expectedheightFive = {1, 2, 3, 4, 1, 2, 3, 4, 5};
    Node heightFive = new Node(5);
    heightFive.setLeft(heightFour);
    heightFive.setRight(heightFour);
    Assert.assertArrayEquals(expectedheightFive, postorderArray(heightFive));
  }

  private int[] postorderArray(Node node) {
    int[] valueArray;
    if (node == null) {
      valueArray = new int[0];
    } else {
      int[] left = postorderArray(node.left);
      int[] right = postorderArray(node.right);
      valueArray = new int[left.length + right.length + 1];
      populateArray(left, right, node.data, valueArray);
    }
    return valueArray;
  }

  private void populateArray(int[] left, int[] right, int data, int[] to) {
    for (int i = 0; i < left.length; i++) {
      to[i] = left[i];
    }
    for (int i = 0; i < right.length; i++) {
      to[left.length + i] = right[i];
    }
    to[left.length + right.length] = data;
  }
}
