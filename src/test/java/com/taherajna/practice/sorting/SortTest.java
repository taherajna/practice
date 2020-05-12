package com.taherajna.practice.sorting;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

  @Test
  public void bubbleSort() {
    Sorting sorting = new BubbleSort();
    Assert.assertArrayEquals(getSortedArray(), sorting.sort(getUnsortedArray()));
  }

  @Test
  public void mergeSort() {
    Sorting sorting = new MergeSort();
    Assert.assertArrayEquals(getSortedArray(), sorting.sort(getUnsortedArray()));
  }

  private int[] getUnsortedArray() {
    int[] inputArray = new int[9];
    inputArray[0] = 16;
    inputArray[1] = 0;
    inputArray[2] = 81;
    inputArray[3] = 88;
    inputArray[4] = 26;
    inputArray[5] = 21;
    inputArray[6] = 58;
    inputArray[7] = 28;
    inputArray[8] = 45;

    return inputArray;
  }

  private int[] getSortedArray() {
    int[] inputArray = new int[9];
    inputArray[0] = 0;
    inputArray[1] = 16;
    inputArray[2] = 21;
    inputArray[3] = 26;
    inputArray[4] = 28;
    inputArray[5] = 45;
    inputArray[6] = 58;
    inputArray[7] = 81;
    inputArray[8] = 88;

    return inputArray;
  }
}
