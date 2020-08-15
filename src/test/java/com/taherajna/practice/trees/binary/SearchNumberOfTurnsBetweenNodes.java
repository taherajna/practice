package com.taherajna.practice.trees.binary;

import org.junit.Assert;
import org.junit.Test;

public class SearchNumberOfTurnsBetweenNodes {

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

        int[] resultArray4 = new int[100];
        int[] resultArray2 = new int[100];
        search(resultArray4, 4, 0, node8, 0);
        search(resultArray2, 2, 0, node8, 0);
        Assert.assertEquals(1, getNumberOfTurns(resultArray4, resultArray2));
    }

    private int getNumberOfTurns(int[] array1, int[] array2) {
        int totalTurns = 0;
        int i = 0;
        while (array1[i] == array2[i]) {
            i++;
        }
        int prevArray1 = array1[i];
        int prevArray2 = array2[i];
        for (int j = i + 1; j < 100; j++) {
            if (array1[j] == 0) {
                break;
            }
            if (array1[j] != prevArray1) {
                totalTurns++;
                prevArray1 = array1[j];
            }
        }
        for (int j = i + 1; j < 100; j++) {
            if (array2[j] == 0) {
                break;
            }
            if (array2[j] != prevArray2) {
                prevArray2 = array2[j];
                totalTurns++;
            }
        }
        return totalTurns;
    }

    private int search(int[] turnArray, int i, int prevDir, Node root, int index) {
        int result;
        if (root == null) {
            result = -1;
        } else if (root.data == i) {
            result = 0;
        } else {
            turnArray[index] = 1;
            result = search(turnArray, i, 0, root.left, index + 1);
            if (result == -1) {
                turnArray[index] = 2;
                result = search(turnArray, i, 1, root.right, index + 1);
                if (result == -1) {
                    turnArray[index] = 0;
                }
            }
        }
        return result;
    }
}
