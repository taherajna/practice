package com.taherajna.practice.sorting;

public class BubbleSort implements Sorting {
  public int[] sort(int[] unsortedArray) {
    int[] sortedArray = unsortedArray;
    for (int i = 0; i < unsortedArray.length; i++) {
      for (int j = 0; j < unsortedArray.length - i - 1; j++) {
        if (unsortedArray[j] > unsortedArray[j + 1]) {
          int temp = unsortedArray[j + 1];
          unsortedArray[j + 1] = unsortedArray[j];
          unsortedArray[j] = temp;
        }
      }
    }
    return sortedArray;
  }
}
