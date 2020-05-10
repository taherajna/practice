package com.taherajna.practice.school;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class Median {

  @Test
  public void appEvenNumber() throws IOException {
    int[] input = {9, 47, 32, 44, 41, 69, 34, 51, 42, 50, 16, 31, 42, 3};
    int[] sortedArray = new int[0];
    for (int i = 0; i < input.length; i++) {
      sortedArray = insertSort(i, input[i], sortedArray);
    }
    Assert.assertEquals(41, median(sortedArray));
  }

  @Test
  public void appOddNumbers() throws IOException {
    int[] input = {9, 47, 32, 44, 41, 69, 34, 51, 42, 50, 16, 31, 42};
    int[] sortedArray = new int[0];
    for (int i = 0; i < input.length; i++) {
      sortedArray = insertSort(i, input[i], sortedArray);
    }
    Assert.assertEquals(42, median(sortedArray));
  }

  private int median(int[] input) {
    double median;
    if (input.length % 2 == 0) {
      median = (input[input.length / 2] + input[input.length / 2 - 1]) / 2.0;
    } else {
      median = input[input.length / 2];
    }
    return (int) median;
  }

  @Test
  public void oneByOneSort() {
    int[] input = {9, 47, 32, 44, 41, 69, 34, 51, 42, 50, 16, 31, 42, 3};
    int[] expected = {3, 9, 16, 31, 32, 34, 41, 42, 42, 44, 47, 50, 51, 69};
    int[] sortedArray = new int[0];
    for (int i = 0; i < input.length; i++) {
      sortedArray = insertSort(i, input[i], sortedArray);
    }

    Assert.assertArrayEquals(expected, sortedArray);
  }

  private int[] insertSort(int i, int input, int[] sortedArray) {
    int[] output = new int[i + 1];
    boolean inputConsumed = false;
    int k = 0;
    for (int j = 0; j < sortedArray.length; j++) {
      if (!inputConsumed && input < sortedArray[j]) {
        inputConsumed = true;
        output[k++] = input;
        output[k++] = sortedArray[j];
      } else {
        output[k++] = sortedArray[j];
      }
    }
    if (!inputConsumed) {
      output[k++] = input;
    }

    return output;
  }
}
