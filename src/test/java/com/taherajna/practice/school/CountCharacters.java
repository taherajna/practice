package com.taherajna.practice.school;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class CountCharacters {

  @Test
  public void app() throws IOException {
    String string = "Taher@34aT";
    int[] expected = {2, 5, 2, 1};
    Assert.assertArrayEquals(expected, countCharacters(string));
  }

  private int[] countCharacters(String inputString) {
    int[] output = new int[4];
    for (char c : inputString.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        output[0]++;
      } else if (c >= 'a' && c <= 'z') {
        output[1]++;
      } else if (c >= '0' && c <= '9') {
        output[2]++;
      } else {
        output[3]++;
      }
    }
    return output;
  }
}
