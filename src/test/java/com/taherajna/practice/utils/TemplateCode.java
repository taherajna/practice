package com.taherajna.practice.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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

  public static void readInputArray() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int numberOfInputs = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < numberOfInputs; i++) {
      String[] inputString = bufferedReader.readLine().split(" ");
      int[] inputArray = new int[inputString.length];

      for (int j = 0; j < inputString.length; j++) {
        inputArray[i] = Integer.parseInt(inputString[i]);
      }
    }
  }

  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public static void readInput_Scanner() throws IOException {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    int numberOfInputs = scanner.nextInt();
    for (int i = 0; i < numberOfInputs; i++) {
    }
  }
}
