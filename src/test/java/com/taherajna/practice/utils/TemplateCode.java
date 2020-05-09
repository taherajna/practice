package com.taherajna.practice.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemplateCode {
  private TemplateCode() {
  }

  public static void readInput() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int numberOfInputs = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < numberOfInputs; i++) {
      String inputString = bufferedReader.readLine();
      System.out.println(); // Call Code
    }
  }
}
