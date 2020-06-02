package com.taherajna.practice.dp;

import org.junit.Assert;
import org.junit.Test;

public class ABCSeq {

  @Test
  public void subSequenceABC_simple() {
    String inputString = "abbcc";
    String[] splitString = inputString.split("");
    String[] expected = {"a", "b", "b", "c", "c"};
    Assert.assertArrayEquals(expected, splitString);

    int subsequences = getSubSequencesABC(splitString, 0, 0);
    Assert.assertEquals(4, subsequences);
  }

  @Test
  public void subSequenceABC_complex() {
    String inputString = "accabbcc";
    String[] splitString = inputString.split("");
    String[] expected = {"a", "c", "c", "a", "b", "b", "c", "c"};
    Assert.assertArrayEquals(expected, splitString);

    int subsequences = getSubSequencesABC(splitString, 0, 0);
    Assert.assertEquals(8, subsequences);
  }

  private int getSubSequencesABC(String[] splitString, int index, int letter) {
    int count = 0;
    for (int i = index; i < splitString.length; i++) {
      switch (letter) {
        case 0:
          if (splitString[i].equals("a")) {
            count += getSubSequencesABC(splitString, i + 1, letter + 1);
          }
          break;
        case 1:
          if (splitString[i].equals("b")) {
            count += getSubSequencesABC(splitString, i + 1, letter + 1);
          }
          break;
        case 2:
          if (splitString[i].equals("c")) {
            count += 1;
          }
          break;
      }
    }
    return count;
  }

  @Test
  public void subSequenceAkBkCk_simple() {
    String inputString = "abbc";
    String[] splitString = inputString.split("");
    String[] expected = {"a", "b", "b", "c"};
    Assert.assertArrayEquals(expected, splitString);

    int subsequences = getSubSequencesAkBkCk(splitString, 0, 0);
    Assert.assertEquals(3, subsequences);
  }

  @Test
  public void subSequenceAkBkCk_g4g_stringSplit() {
    String inputString = "abcbbaabcbcbcbaabbccaac";
    String[] splitString = inputString.split("");

    int subsequences = getSubSequencesAkBkCk(splitString, 0, 0);
    Assert.assertEquals(9087, subsequences);
  }

  @Test
  public void subSequenceAkBkCk_complex() {
    String inputString = "abcabc";
    String[] splitString = inputString.split("");
    String[] expected = {"a", "b", "c", "a", "b", "c"};
    Assert.assertArrayEquals(expected, splitString);

    int subsequences = getSubSequencesAkBkCk(splitString, 0, 0);
    Assert.assertEquals(7, subsequences);
  }

  private int getSubSequencesAkBkCk(String[] splitString, int index, int letter) {
    int count = 0;
    for (int i = index; i < splitString.length; i++) {
      switch (letter) {
        case 0:
          if (splitString[i].equals("a")) {
            count += getSubSequencesAkBkCk(splitString, i + 1, letter);
            count += getSubSequencesAkBkCk(splitString, i + 1, letter + 1);
          }
          break;
        case 1:
          if (splitString[i].equals("b")) {
            count += getSubSequencesAkBkCk(splitString, i + 1, letter);
            count += getSubSequencesAkBkCk(splitString, i + 1, letter + 1);
          }
          break;
        case 2:
          if (splitString[i].equals("c")) {
            count += getSubSequencesAkBkCk(splitString, i + 1, letter);
            count++;
          }
          break;
      }
    }
    return count;
  }

  @Test
  public void subSequenceAkBkCk_g4g_noSplit() {
    String inputString = "abcbbaabcbcbcbaabbccaac";

    int subsequences = getSubSequencesAkBkCk_noStringSplit(inputString, 0, 0);
    Assert.assertEquals(9087, subsequences);
  }

  private int getSubSequencesAkBkCk_noStringSplit(String string, int index, int letter) {
    int count = 0;
    boolean valid;
    for (int i = index; i < string.length(); i++) {
      valid = false;
      switch (letter) {
        case 0:
          if (string.charAt(i) == 'a') {
            valid = true;
          }
          break;
        case 1:
          if (string.charAt(i) == 'b') {
            valid = true;
          }
          break;
        case 2:
          if (string.charAt(i) == 'c') {
            count++;
            valid = true;
          }
          break;
      }
      if (valid) {
        count += getSubSequencesAkBkCk_noStringSplit(string, i + 1, letter);
        count += getSubSequencesAkBkCk_noStringSplit(string, i + 1, letter + 1);
      }
    }
    return count;
  }
}
