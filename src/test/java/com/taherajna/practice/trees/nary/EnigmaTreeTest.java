package com.taherajna.practice.trees.nary;

import static com.taherajna.practice.trees.nary.EnigmaSolver.getNumberOfSteps;

import org.junit.Assert;
import org.junit.Test;

public class EnigmaTreeTest {

  public static EnigmaNode getModifiedExample() {
    EnigmaNode node1 = new EnigmaNode(1, true);
    EnigmaNode node2 = new EnigmaNode(2, false);
    EnigmaNode node3 = new EnigmaNode(3, true);
    EnigmaNode node4 = new EnigmaNode(4, true);
    EnigmaNode node5 = new EnigmaNode(5, true);
    EnigmaNode node6 = new EnigmaNode(6, true);
    EnigmaNode node7 = new EnigmaNode(7, false);

    node1.addChild(node5);
    node1.addChild(node6);
    node1.addChild(node7);

    node7.addChild(node3);
    node7.addChild(node4);

    node3.addChild(node2);

    return node1;
  }

  public static EnigmaNode getCorrectExample() {
    EnigmaNode node1 = new EnigmaNode(1, false);
    EnigmaNode node2 = new EnigmaNode(2, false);
    EnigmaNode node3 = new EnigmaNode(3, true);
    EnigmaNode node4 = new EnigmaNode(4, false);
    EnigmaNode node5 = new EnigmaNode(5, true);
    EnigmaNode node6 = new EnigmaNode(6, false);
    EnigmaNode node7 = new EnigmaNode(7, true);

    node1.addChild(node5);
    node1.addChild(node6);
    node1.addChild(node7);

    node7.addChild(node3);
    node7.addChild(node4);

    node3.addChild(node2);

    return node1;
  }

  public static EnigmaNode getModifiedExample_allFlipped() {
    EnigmaNode node1 = new EnigmaNode(1, true);
    EnigmaNode node2 = new EnigmaNode(1, true);
    EnigmaNode node3 = new EnigmaNode(1, true);
    EnigmaNode node4 = new EnigmaNode(1, true);
    EnigmaNode node5 = new EnigmaNode(1, true);
    EnigmaNode node6 = new EnigmaNode(1, true);
    EnigmaNode node7 = new EnigmaNode(1, true);

    node1.addChild(node5);
    node1.addChild(node6);
    node1.addChild(node7);

    node7.addChild(node3);
    node7.addChild(node4);

    node3.addChild(node2);

    return node1;
  }

  public static EnigmaNode getCorrectExample_allFlipped() {
    EnigmaNode node1 = new EnigmaNode(1, false);
    EnigmaNode node2 = new EnigmaNode(1, false);
    EnigmaNode node3 = new EnigmaNode(1, false);
    EnigmaNode node4 = new EnigmaNode(1, false);
    EnigmaNode node5 = new EnigmaNode(1, false);
    EnigmaNode node6 = new EnigmaNode(1, false);
    EnigmaNode node7 = new EnigmaNode(1, false);

    node1.addChild(node5);
    node1.addChild(node6);
    node1.addChild(node7);

    node7.addChild(node3);
    node7.addChild(node4);

    node3.addChild(node2);

    return node1;
  }

  @Test
  public void test_singleNodeEqual() {
    EnigmaNode modifiedTreeRoot = new EnigmaNode(1, true);

    EnigmaNode correctTreeRoot = new EnigmaNode(1, true);

    Assert.assertEquals(0, getNumberOfSteps(modifiedTreeRoot, correctTreeRoot));
  }

  @Test
  public void test_singleNodeNotEqual() {
    EnigmaNode modifiedTreeRoot = new EnigmaNode(1, false);

    EnigmaNode correctTreeRoot = new EnigmaNode(1, true);

    Assert.assertEquals(1, getNumberOfSteps(modifiedTreeRoot, correctTreeRoot));
  }

  @Test
  public void test_twoNodesEqual() {
    EnigmaNode modifiedTreeRoot = new EnigmaNode(1, false);
    modifiedTreeRoot.addChild(new EnigmaNode(2, false));

    EnigmaNode correctTreeRoot = new EnigmaNode(1, false);
    correctTreeRoot.addChild(new EnigmaNode(2, false));

    Assert.assertEquals(0, getNumberOfSteps(modifiedTreeRoot, correctTreeRoot));
  }

  @Test
  public void test_twoNodesOneNotEqual() {
    EnigmaNode modifiedTreeRoot = new EnigmaNode(1, false);
    modifiedTreeRoot.addChild(new EnigmaNode(2, false));

    EnigmaNode correctTreeRoot = new EnigmaNode(1, false);
    correctTreeRoot.addChild(new EnigmaNode(2, true));

    Assert.assertEquals(1, getNumberOfSteps(modifiedTreeRoot, correctTreeRoot));
  }

  @Test
  public void test_twoNodesTwoNotEqual() {
    EnigmaNode modifiedTreeRoot = new EnigmaNode(1, false);
    modifiedTreeRoot.addChild(new EnigmaNode(2, false));

    EnigmaNode correctTreeRoot = new EnigmaNode(1, true);
    correctTreeRoot.addChild(new EnigmaNode(2, true));

    Assert.assertEquals(1, getNumberOfSteps(modifiedTreeRoot, correctTreeRoot));
  }

  @Test
  public void test_example() {
    EnigmaNode modifiedTreeRoot = getModifiedExample();
    EnigmaNode correctTreeRoot = getCorrectExample();
    Assert.assertEquals(3, getNumberOfSteps(modifiedTreeRoot, correctTreeRoot));
  }

  @Test
  public void test_exampleAllFlipped() {
    EnigmaNode modifiedTreeRoot = getModifiedExample_allFlipped();
    EnigmaNode correctTreeRoot = getCorrectExample_allFlipped();
    Assert.assertEquals(1, getNumberOfSteps(modifiedTreeRoot, correctTreeRoot));
  }

  @Test
  public void toggle() {
    boolean toggle = true;
    Assert.assertEquals(true, toggle || false);
    Assert.assertEquals(false, toggle && false);
    Assert.assertEquals(true, toggle ^ false);
    Assert.assertEquals(false, toggle ^ true);
    toggle = false;
    Assert.assertEquals(false, toggle ^ false);
    Assert.assertEquals(true, toggle ^ true);
  }
}
