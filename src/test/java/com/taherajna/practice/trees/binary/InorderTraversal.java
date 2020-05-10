package com.taherajna.practice.trees.binary;

import org.junit.Assert;
import org.junit.Test;

public class InorderTraversal {

  @Test
  public void app() {
    int[] expected = {};
    Assert.assertArrayEquals(expected, inOrderArray(null));

    int[] expectedheightOne = {1};
    Node heightOne = new Node(1);
    Assert.assertArrayEquals(expectedheightOne, inOrderArray(heightOne));

    int[] expectedheightTwo = {1, 2};
    Node heightTwo = new Node(2);
    heightTwo.setLeft(heightOne);
    Assert.assertArrayEquals(expectedheightTwo, inOrderArray(heightTwo));

    int[] expectedheightThree = {1, 2, 3};
    Node heightThree = new Node(3);
    heightThree.setLeft(heightTwo);
    Assert.assertArrayEquals(expectedheightThree, inOrderArray(heightThree));

    int[] expectedheightFour = {4, 1, 2, 3};
    Node heightFour = new Node(4);
    heightFour.setRight(heightThree);
    Assert.assertArrayEquals(expectedheightFour, inOrderArray(heightFour));

    int[] expectedheightFive = {4, 1, 2, 3, 5, 4, 1, 2, 3};
    Node heightFive = new Node(5);
    heightFive.setLeft(heightFour);
    heightFive.setRight(heightFour);
    Assert.assertArrayEquals(expectedheightFive, inOrderArray(heightFive));
  }

  private int[] inOrderArray(Node node) {
    int[] valueArray;
    if (node == null) {
      valueArray = new int[0];
    } else if (node.left == null && node.right == null) {
      valueArray = new int[1];
      valueArray[0] = node.data;
    } else {
      int[] left = inOrderArray(node.left);
      int[] right = inOrderArray(node.right);
      valueArray = new int[left.length + right.length + 1];
      populateFromLeftRightArray(left, right, node.data, valueArray);
    }
    return valueArray;
  }

  private void populateFromLeftRightArray(int[] left, int[] right, int data, int[] to) {
    for (int i = 0; i < left.length; i++) {
      to[i] = left[i];
    }
    to[left.length] = data;
    for (int i = 0; i < right.length; i++) {
      to[left.length + 1 + i] = right[i];
    }
  }
}
