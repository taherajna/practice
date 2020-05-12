package com.taherajna.practice.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

  private MergeSort sorting;

  @Before
  public void setUp() {
    sorting = new MergeSort();
  }

  @Test
  public void sort() {
  }

  @Test
  public void mergeSize2() {
    int[] left = {2, 4};
    int[] right = {1, 3};
    int[] mergedArray = {1, 2, 3, 4};

    Assert.assertArrayEquals(mergedArray, sorting.merge(left, right));
  }

  @Test
  public void mergeSize1() {
    int[] left = {2};
    int[] right = {1};
    int[] mergedArray = {1, 2};

    Assert.assertArrayEquals(mergedArray, sorting.merge(left, right));
  }

  @Test
  public void mergeSize10() {
    int[] left = {2};
    int[] right = {};
    int[] mergedArray = {2};

    Assert.assertArrayEquals(mergedArray, sorting.merge(left, right));
  }

  @Test
  public void mergeSize01() {
    int[] left = {};
    int[] right = {1};
    int[] mergedArray = {1};

    Assert.assertArrayEquals(mergedArray, sorting.merge(left, right));
  }

  @Test
  public void mergeSize4() {
    int[] left = {1, 2, 4, 6};
    int[] right = {1, 3, 7, 8};
    int[] mergedArray = {1, 1, 2, 3, 4, 6, 7, 8};

    Assert.assertArrayEquals(mergedArray, sorting.merge(left, right));
  }

  public void multiDimensionalArrayCopy(int[][] original, int left, int right) {
    int[] copy = new int[right - left];
  }

  @Test
  public void multiDimensionalMerge_even() {
    int[][] multiDim = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
    int[] sorted = {10, 15, 20, 25, 27, 29, 30, 32, 33, 35, 37, 39, 40, 45, 48, 50};
    Assert.assertArrayEquals(sorted, sortMulti(multiDim));
  }

  @Test
  public void multiDimensionalMerge_odd() {
    int[][] multiDim = {{1, 3, 4}, {2, 6, 7}, {5, 8, 9}};
    int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Assert.assertArrayEquals(sorted, sortMulti(multiDim));
  }

  protected int[] sortMulti(int[][] multi) {
    int[] sortedArray = new int[0];
    if (multi.length == 1) {
      sortedArray = multi[0];
    } else {
      int combinedArrayLength = multi.length % 2 == 0 ? multi.length / 2 : multi.length / 2 + 1;
      int[][] combinedMulti = new int[combinedArrayLength][];
      int k = 0;
      int i = 0;
      while (k < multi.length) {
        if (multi.length - k == 1) {
          combinedMulti[i++] = multi[k++];
        } else {
          combinedMulti[i++] = sorting.merge(multi[k++], multi[k++]);
        }
      }
      sortedArray = sortMulti(combinedMulti);
    }
    return sortedArray;
  }
}
