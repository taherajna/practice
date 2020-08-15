package com.taherajna.practice.trees.binary;

import org.junit.Assert;
import org.junit.Test;

public class SumOfDepths {

  /*
             1
         2          3
     4      5   6       7
   8   9

  */

    @Test
    public void testSimpleSumOfDepths() {
        Assert.assertEquals(16, sumOfDepths(getTree(), 0));
    }

    @Test
    public void testSimpleSumOfDepthsOfDepths() {
        Assert.assertEquals(26, sumOfDepthsOfDepths(getTree(), 0));
    }

    private int sumOfDepths(Node root, int currentDepth) {
        int sumOfDepths = currentDepth;
        if (root == null) {
            sumOfDepths = 0;
        } else {
            sumOfDepths += sumOfDepths(root.left, currentDepth + 1);
            sumOfDepths += sumOfDepths(root.right, currentDepth + 1);
        }
        return sumOfDepths;
    }

    private int sumOfDepthsOfDepths(Node root, int currentDepth) {
        int sumOfDepths = currentDepth;
        if (root == null) {
            sumOfDepths = 0;
        } else {
            sumOfDepths += sumOfDepthsOfDepths(root.left, currentDepth + 1);
            sumOfDepths += sumOfDepthsOfDepths(root.right, currentDepth + 1);
            if (currentDepth == 0) {
                sumOfDepths += sumOfDepthsOfDepths(root.left, 0);
                sumOfDepths += sumOfDepthsOfDepths(root.right, 0);
            }
        }
        return sumOfDepths;
    }

    public Node getTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        four.left = eight;
        four.right = nine;
        return one;
    }
}
