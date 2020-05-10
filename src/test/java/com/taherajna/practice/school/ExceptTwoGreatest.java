package com.taherajna.practice.school;

import com.taherajna.practice.sorting.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class ExceptTwoGreatest {

  @Test
  public void app() {
    int[] sortedArray = sortArray(getInputArray());
    int[] sortedArrayExceptGreatestTwo = getExceptLastTwo(sortedArray);
    Assert.assertArrayEquals(getSortedOutputArray(), sortedArrayExceptGreatestTwo);
  }

  private int[] getExceptLastTwo(int[] sortedArray) {
    int[] exceptLastTwo = new int[sortedArray.length - 2];
    for (int i = 0; i < exceptLastTwo.length; i++) {
      exceptLastTwo[i] = sortedArray[i];
    }
    return exceptLastTwo;
  }

  private int[] sortArray(int[] exceptGreatestTwo) {
    return new BubbleSort().sort(exceptGreatestTwo);
  }

  private int[] getSortedOutputArray() {
    int[] inputArray = {
            13, 20, 32, 35, 61, 95, 98, 118, 125, 150, 194, 220, 227, 229, 246, 271, 281, 287, 302, 307,
            318, 341, 351, 354, 369, 379, 380, 400, 404, 435, 441, 442, 445, 452, 468, 482, 489, 493, 498,
            501, 504, 529, 540, 556, 568, 571, 587, 602, 619, 620, 625, 652, 653, 676, 677, 684, 690, 709,
            710, 716, 724, 730, 733, 740, 755, 757, 765, 772, 796, 797, 830, 842, 847, 857, 866, 872, 903,
            922, 928
    };
    return inputArray;
  }

  private int[] getInputArray() {
    int[] inputArray = {
            857, 724, 755, 540, 498, 757, 796, 35, 468, 501, 602, 866, 529, 150, 619, 404, 922, 354, 842,
            229, 246, 710, 318, 652, 125, 118, 435, 493, 302, 830, 441, 797, 740, 227, 61, 571, 482, 620,
            380, 32, 556, 733, 13, 677, 928, 847, 653, 933, 587, 716, 452, 194, 903, 445, 379, 281, 351,
            220, 20, 568, 98, 442, 341, 271, 709, 690, 772, 400, 966, 625, 369, 684, 765, 730, 287, 504,
            872, 489, 307, 95, 676
    };
    return inputArray;
  }
}
