package com.taherajna.practice.trees;

import static java.lang.Math.max;

import com.taherajna.practice.trees.binary.Node;
import org.junit.Assert;
import org.junit.Test;

public class HeightOfTree {

  @Test
  public void app() {
    Assert.assertEquals(0, height(null));

    Node heightOne = new Node(1);
    Assert.assertEquals(1, height(heightOne));

    Node heightTwo = new Node(2);
    heightTwo.setLeft(heightOne);
    Assert.assertEquals(2, height(heightTwo));

    Node heightThree = new Node(3);
    heightThree.setLeft(heightTwo);
    Assert.assertEquals(3, height(heightThree));

    Node heightFour = new Node(3);
    heightFour.setRight(heightThree);
    Assert.assertEquals(4, height(heightFour));
  }

  private int height(Node node) {
    int totalHeight = 1;
    if (node == null) {
      totalHeight = 0;
    } else {
      totalHeight += max(height(node.getLeft()), height(node.getRight()));
    }
    return totalHeight;
  }
}
