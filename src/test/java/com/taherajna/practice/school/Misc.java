package com.taherajna.practice.school;

import org.junit.Assert;
import org.junit.Test;

public class Misc {

  @Test
  public void charToInt() {
    Assert.assertEquals(49, '1');
    Assert.assertEquals(50, '2');
    Assert.assertEquals(51, '3');
  }

  @Test
  public void changeArrayValue() {
    int[] array = new int[1];
    Assert.assertEquals(0, array[0]);
    changeValue(array);
    Assert.assertEquals(2, array[0]);
  }

  private void changeValue(int[] array) {
    array[0] = 2;
  }
}
