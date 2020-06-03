package com.taherajna.practice.games;

import org.junit.Assert;
import org.junit.Test;

public class SudokuNineBlockTraversal {

  @Test
  public void testFormula() {
    int i = 0;
    int j = 0;
    Assert.assertEquals(0, getI(i, j));
    Assert.assertEquals(0, getJ(i, j));

    i = 0;
    j = 2;
    Assert.assertEquals(0, getI(i, j));
    Assert.assertEquals(2, getJ(i, j));

    i = 0;
    j = 3;
    Assert.assertEquals(1, getI(i, j));
    Assert.assertEquals(0, getJ(i, j));

    i = 1;
    j = 0;
    Assert.assertEquals(3, getI(i, j));
    Assert.assertEquals(0, getJ(i, j));

    i = 3;
    j = 0;
    Assert.assertEquals(0, getI(i, j));
    Assert.assertEquals(3, getJ(i, j));

    i = 3;
    j = 1;
    Assert.assertEquals(0, getI(i, j));
    Assert.assertEquals(4, getJ(i, j));

    i = 8;
    j = 8;
    Assert.assertEquals(8, getI(i, j));
    Assert.assertEquals(8, getJ(i, j));
  }

  int getI(int i, int j) {
    return (i * 3 + (j / 3)) % 9;
  }

  int getJ(int i, int j) {
    return ((i / 3) * 3) + j % 3;
  }

}
