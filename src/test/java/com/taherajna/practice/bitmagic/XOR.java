package com.taherajna.practice.bitmagic;

import org.junit.Assert;
import org.junit.Test;

public class XOR {

  @Test
  public void app() {
    int a = 10;
    int b = 20;
    int xor = a ^ b;
    Assert.assertEquals(30, xor);
    Assert.assertEquals(4, Integer.toBinaryString(xor).replaceAll("0", "").length());
    Assert.assertEquals(4, Integer.bitCount(xor));
  }
}
