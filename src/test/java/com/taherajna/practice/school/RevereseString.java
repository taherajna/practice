package com.taherajna.practice.school;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class RevereseString {

  @Test
  public void app() throws IOException {
    String string = "Taher";
    Assert.assertEquals("rehaT", reverseString(string));
  }

  private String reverseString(String inputString) {
    StringBuilder reveresedString = new StringBuilder();
    for (int j = inputString.length() - 1; j >= 0; j--) {
      reveresedString.append(inputString.charAt(j));
    }
    return reveresedString.toString();
  }
}
