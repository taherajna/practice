package com.taherajna.practice.sorting;

import java.util.Arrays;

public class MergeSort implements Sorting {

  public int[] sort(int[] unsortedArray) {
    int[] sortedArray;
    if (unsortedArray.length == 1) {
      sortedArray = unsortedArray;
    } else {
      int[] left = sort(Arrays.copyOfRange(unsortedArray, 0, unsortedArray.length / 2));
      int[] right =
              sort(
                      Arrays.copyOfRange(
                              unsortedArray, unsortedArray.length / 2, unsortedArray.length));
      sortedArray = merge(left, right);
    }
    return sortedArray;
  }

  protected int[] merge(int[] left, int[] right) {
    int[] mergedArray = new int[left.length + right.length];
    int leftPointer = 0;
    int rightPointer = 0;
    for (int i = 0; i < mergedArray.length; i++) {
      if (rightPointer == right.length
              || leftPointer != left.length && left[leftPointer] < right[rightPointer]) {
        mergedArray[i] = left[leftPointer++];
      } else {
        mergedArray[i] = right[rightPointer++];
      }
    }
    return mergedArray;
  }
}
