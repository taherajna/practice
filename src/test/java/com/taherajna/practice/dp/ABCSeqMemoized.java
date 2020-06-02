package com.taherajna.practice.dp;

import org.junit.Assert;
import org.junit.Test;

public class ABCSeqMemoized {

  @Test
  public void subSequenceAkBkCk_simple() {
    String inputString = "abbc";
    String[] splitString = inputString.split("");
    String[] expected = {"a", "b", "b", "c"};
    Assert.assertArrayEquals(expected, splitString);

    int[][] memo = getMemo(inputString);

    int subsequences = getSubSequencesAkBkCk_noStringSplit(inputString, 0, 0, memo);
    Assert.assertEquals(3, subsequences);
  }

  @Test
  public void subSequenceAkBkCk_g4g_stringSplit() {
    String inputString = "abcbbaabcbcbcbaabbccaac";
    String[] splitString = inputString.split("");

    int[][] memo = getMemo(inputString);

    int subsequences = getSubSequencesAkBkCk_noStringSplit(inputString, 0, 0, memo);
    Assert.assertEquals(9087, subsequences);
  }

  @Test
  public void subSequenceAkBkCk_complex() {
    String inputString = "abcabc";
    String[] splitString = inputString.split("");
    String[] expected = {"a", "b", "c", "a", "b", "c"};
    Assert.assertArrayEquals(expected, splitString);

    int[][] memo = getMemo(inputString);

    int subsequences = getSubSequencesAkBkCk_noStringSplit(inputString, 0, 0, memo);
    Assert.assertEquals(7, subsequences);
  }

  @Test
  public void subSequenceAkBkCk_g4g_noSplit() {
    String inputString = "abcbbaabcbcbcbaabbccaac";

    int[][] memo = getMemo(inputString);

    int subsequences = getSubSequencesAkBkCk_noStringSplit(inputString, 0, 0, memo);
    Assert.assertEquals(9087, subsequences);
  }

  private int[][] getMemo(String inputString) {
    int[][] memo = new int[inputString.length() + 1][4];
    for (int i = 0; i < memo.length; i++) {
      for (int j = 0; j < memo[i].length; j++) {
        memo[i][j] = -1;
      }
    }
    return memo;
  }

  private int getSubSequencesAkBkCk_noStringSplit(
          String string, int index, int letter, int[][] memo) {
    int count = 0;
    boolean valid;
    for (int i = index; i < string.length(); i++) {
      valid = false;
      if (letter == 0 && string.charAt(i) == 'a'
              || letter == 1 && string.charAt(i) == 'b'
              || letter == 2 && string.charAt(i) == 'c') {
        valid = true;
      }
      if (letter == 2 && string.charAt(i) == 'c') {
        count++;
      }
      if (valid) {
        if (memo[i + 1][letter] != -1) {
          count += memo[i + 1][letter];
        } else {
          int intermediateCount = getSubSequencesAkBkCk_noStringSplit(string, i + 1, letter, memo);
          count += intermediateCount;
          memo[i + 1][letter] = intermediateCount;
        }
        if (memo[i + 1][letter + 1] != -1) {
          count += memo[i + 1][letter + 1];
        } else {
          int intermediateCount = getSubSequencesAkBkCk_noStringSplit(string, i + 1, letter + 1, memo);
          count += intermediateCount;
          memo[i + 1][letter + 1] = intermediateCount;
        }
      }
    }
    return count;
  }
}
