package com.taherajna.practice.trees.binary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LevelOrderTraversal {

  @Test
  public void test_UsingRecursion() {
    int[] expected = {-1};
    Assert.assertArrayEquals(expected, levelorderArray(null));

    int[] expectedheightOne = {1, -1, -1};
    Node heightOne = new Node(1);
    Assert.assertArrayEquals(expectedheightOne, levelorderArray(heightOne));

    int[] expectedheightTwo = {2, 1, -1, -1, -1};
    Node heightTwo = new Node(2);
    heightTwo.setLeft(heightOne);
    Assert.assertArrayEquals(expectedheightTwo, levelorderArray(heightTwo));

    int[] expectedheightThree = {3, 2, -1, 1, -1, -1, -1};
    Node heightThree = new Node(3);
    heightThree.setLeft(heightTwo);
    Assert.assertArrayEquals(expectedheightThree, levelorderArray(heightThree));

    int[] expectedheightFour = {4, -1, 3, 2, -1, 1, -1, -1, -1};
    Node heightFour = new Node(4);
    heightFour.setRight(heightThree);
    Assert.assertArrayEquals(expectedheightFour, levelorderArray(heightFour));

    int[] expectedheightFive = {5, 4, 4, -1, -1, 3, 3, 2, 2, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1};
    Node heightFive = new Node(5);
    heightFive.setLeft(heightFour);
    heightFive.setRight(heightFour);
    Assert.assertArrayEquals(expectedheightFive, levelorderArray(heightFive));
  }

  @Test
  public void test_UsingQueue() {
    /*int[] expected = {};
    Assert.assertArrayEquals(expected, levelOrderQueue(null));*/

    int[] expectedheightOne = {1};
    Node heightOne = new Node(1);
    Assert.assertArrayEquals(expectedheightOne, levelOrderQueue(heightOne));

    int[] expectedheightTwo = {2, 1};
    Node heightTwo = new Node(2);
    heightTwo.setLeft(heightOne);
    Assert.assertArrayEquals(expectedheightTwo, levelOrderQueue(heightTwo));

    int[] expectedheightThree = {3, 2, 1};
    Node heightThree = new Node(3);
    heightThree.setLeft(heightTwo);
    Assert.assertArrayEquals(expectedheightThree, levelOrderQueue(heightThree));

    int[] expectedheightFour = {4, 3, 2, 1};
    Node heightFour = new Node(4);
    heightFour.setRight(heightThree);
    Assert.assertArrayEquals(expectedheightFour, levelOrderQueue(heightFour));

    int[] expectedheightFive = {5, 4, 4, 3, 3, 2, 2, 1, 1};
    Node heightFive = new Node(5);
    heightFive.setLeft(heightFour);
    heightFive.setRight(heightFour);
    Assert.assertArrayEquals(expectedheightFive, levelOrderQueue(heightFive));
  }

  @Test
  public void g4gTest_1() {
    int[] expected = {5, 5, 4, 10, 8, 5, 8, 8, 6};
    Node node = new Node(6);
    Node node1 = new Node(8);
    node1.setRight(node);
    Node node2 = new Node(5);
    node2.setLeft(node1);
    Node node3 = new Node(8);
    node2.setRight(node3);
    Node node4 = new Node(8);
    node4.setLeft(node2);
    Node node5 = new Node(10);
    node5.setRight(node4);
    Node node6 = new Node(5);
    node6.setRight(node5);
    Node node7 = new Node(4);
    node6.setLeft(node7);
    Node node8 = new Node(5);
    node8.setLeft(node6);
    Assert.assertArrayEquals(expected, removeMinusOne(levelorderArray(node8)));
  }

  @Test
  @Ignore
  public void g4gTest_2() {
    int[] expected = {5, 5, 4, 10, 8, 5, 8, 8, 6};
    Node node = new Node(6);
    Node node1 = new Node(5);
    node1.setRight(node);
    Node node2 = new Node(10);
    node2.setLeft(node1);

    Node node3 = new Node(8);
    Node node4 = new Node(8);
    Node node5 = new Node(8);
    node5.setLeft(node3);
    node5.setRight(node4);

    Node node6 = new Node(4);
    node6.setRight(node5);

    Node node7 = new Node(5);
    node7.setLeft(node6);
    node7.setRight(node2);

    Node node8 = new Node(5);
    node8.setLeft(node7);

    Assert.assertArrayEquals(expected, removeMinusOne(levelorderArray(node8)));
  }


  @Test
  public void g4gTest_1_UsingQueue() {
    int[] expected = {5, 5, 4, 10, 8, 5, 8, 8, 6};
    Node node = new Node(6);
    Node node1 = new Node(8);
    node1.setRight(node);
    Node node2 = new Node(5);
    node2.setLeft(node1);
    Node node3 = new Node(8);
    node2.setRight(node3);
    Node node4 = new Node(8);
    node4.setLeft(node2);
    Node node5 = new Node(10);
    node5.setRight(node4);
    Node node6 = new Node(5);
    node6.setRight(node5);
    Node node7 = new Node(4);
    node6.setLeft(node7);
    Node node8 = new Node(5);
    node8.setLeft(node6);
    Assert.assertArrayEquals(expected, levelOrderQueue(node8));
  }

  @Test
  public void g4gTest_2_UsingQueue() {
    int[] expected = {5, 5, 4, 10, 8, 5, 8, 8, 6};
    Node node = new Node(6);
    Node node1 = new Node(5);
    node1.setRight(node);
    Node node2 = new Node(10);
    node2.setLeft(node1);

    Node node3 = new Node(8);
    Node node4 = new Node(8);
    Node node5 = new Node(8);
    node5.setLeft(node3);
    node5.setRight(node4);

    Node node6 = new Node(4);
    node6.setRight(node5);

    Node node7 = new Node(5);
    node7.setLeft(node6);
    node7.setRight(node2);

    Node node8 = new Node(5);
    node8.setLeft(node7);

    Assert.assertArrayEquals(expected, levelOrderQueue(node8));
  }

  private int[] removeMinusOne(int[] intArray) {
    List asList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
    asList.removeAll(Arrays.asList(-1));
    return asList.stream().mapToInt(value -> (int) value).toArray();
  }

  private int[] levelorderArray(Node node) {
    int[] valueArray = {-1};
    if (node != null) {
      int[] left = levelorderArray(node.left);
      int[] right = levelorderArray(node.right);
      valueArray = new int[left.length + right.length + 1];
      merge(left, right, node.data, valueArray);
    }
    return valueArray;
  }

  private void merge(int[] left, int[] right, int data, int[] to) {
    to[0] = data;
    int i = 1;
    int leftPointer = 0;
    int rightPointer = 0;
    while (i < to.length) {
      if (leftPointer < left.length) {
        to[i++] = left[leftPointer++];
      }
      if (rightPointer < right.length) {
        to[i++] = right[rightPointer++];
      }
    }
  }

  private int[] levelOrderQueue(Node node) {
    List list = new ArrayList<Integer>();

    Queue<Node> queue = new ArrayDeque();
    queue.add(node);
    while (queue.peek() != null) {
      Node peek = queue.poll();
      list.add(peek.data);
      if (peek.left != null) {
        queue.add(peek.left);
      }
      if (peek.right != null) {
        queue.add(peek.right);
      }
    }

    return list.stream().mapToInt(value -> (int) value).toArray();
  }
}
