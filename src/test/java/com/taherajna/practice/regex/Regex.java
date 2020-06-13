package com.taherajna.practice.regex;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class Regex {

  @Test
  public void simple() {
    String pattern = "pattern";
    String output = parse(pattern);
    Assert.assertTrue(output.equals("pattern"));
  }

  @Test
  public void option() {
    String pattern = "{option1|option2}";
    String output = parse(pattern);
    Assert.assertTrue(output.equals("option1") || output.equals("option2"));
  }

  @Test
  public void multipleOptions() {
    String pattern = "{option1|option2} {option3|option4}";
    String output = parse(pattern);
    Assert.assertTrue(
            output.equals("option1 option3")
                    || output.equals("option2 option3")
                    || output.equals("option1 option4")
                    || output.equals("option2 option4"));
  }

  @Test
  public void nestedOptions() {
    String pattern = "{option1|option2 {option3|option4}}";
    String output = parse(pattern);
    Assert.assertTrue(
            output.equals("option1")
                    || output.equals("option2 option3")
                    || output.equals("option2 option4"));
  }

  @Test
  public void finalTest() {
    String pattern =
            "{this is a {specific|particular} example | a {particular|specific} example like this}";
    String output = parse(pattern);
    Assert.assertTrue(
            output.equals("this is a specific example ")
                    || output.equals("this is a particular example ")
                    || output.equals(" a particular example like this")
                    || output.equals(" a specific example like this"));
  }

  @Test
  public void finalFinalTest() {
    String pattern = "{I am|I'm} {working on|starting} this {online| } interview";
    String output = parse(pattern);
  }

  private String parse(String pattern) {
    String result = "";
    Stack<Integer> start = new Stack();
    int end;
    for (int i = 0; i < pattern.length() && i >= 0; i++) {
      if (pattern.charAt(i) == '{') {
        start.push(i + 1);
      } else if ((pattern.charAt(i) == '}')) {
        end = i;
        result = splitAndGetRandom(pattern.substring(start.peek(), end));
        pattern = pattern.substring(0, start.peek() - 1) + result + pattern.substring(end + 1);
        i = start.peek() + result.length() - 2;
        start.pop();
      }
    }

    return pattern;
  }

  private String splitAndGetRandom(String pattern) {
    String[] splitArray = pattern.split("[|]");
    String output =
            splitArray[(int) ((Math.random() * (splitArray.length * 10)) % splitArray.length)];
    return output.replaceAll("[{|}]", "");
  }
}
