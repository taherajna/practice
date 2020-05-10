package com.taherajna.practice;

import java.io.IOException;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class PascalTriangle {

  @Test
  public void draw() throws IOException {
    System.out.println(Arrays.toString(drawPascal(10)));
  }

  @Test
  public void getLevel() {
    int[] one = {1};
    Assert.assertArrayEquals(one, getPascalLevel(1));

    int[] two = {1, 1};
    Assert.assertArrayEquals(two, getPascalLevel(2));

    int[] three = {1, 2, 1};
    Assert.assertArrayEquals(three, getPascalLevel(3));
  }

  private int[] drawPascal(int levels) {
    int[] array = new int[levels];
    if (levels == 1) {
      System.out.println(1);
      array[0] = 1;
    } else {
      int[] intermediate = drawPascal(levels - 1);
      array[0] = 1;
      System.out.print(1 + " ");
      for (int i = 1; i < levels - 1; i++) {
        array[i] = intermediate[i] + intermediate[i - 1];
        System.out.print(array[i] + " ");
      }
      array[levels - 1] = 1;
      System.out.print(1);
      System.out.println();
    }
    return array;
  }

  private int[] getPascalLevel(int levels) {
    int[] array = new int[levels];
    if (levels == 1) {
      array[0] = 1;
    } else {
      int[] intermediate = getPascalLevel(levels - 1);
      array[0] = 1;
      for (int i = 1; i < levels - 1; i++) {
        array[i] = intermediate[i] + intermediate[i - 1];
      }
      array[levels - 1] = 1;
    }
    return array;
  }
}
