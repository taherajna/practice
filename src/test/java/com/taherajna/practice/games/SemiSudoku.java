package com.taherajna.practice.games;

import org.junit.Assert;
import org.junit.Test;

public class SemiSudoku {

  @Test
  public void simple() {
    int[][] grid = {{1, 2, 0}, {4, 0, 6}, {0, 8, 0}};
    int[][] solved = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    Assert.assertTrue(SolveSudoko(grid));
    Assert.assertArrayEquals(solved, grid);
  }

  @Test
  public void complex() {
    int[][] grid = {{0, 1, 0}, {4, 0, 7}, {0, 0, 0}};
    int[][] solved = {{2, 1, 3}, {4, 5, 7}, {6, 8, 9}};
    Assert.assertTrue(SolveSudoko(grid));
    Assert.assertArrayEquals(solved, grid);
  }

  boolean SolveSudoko(int grid[][]) {
    return solve(grid, 0, 0);
  }

  private boolean solve(int[][] grid, int row, int col) {
    boolean solvable = true;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          int candidate = 1;
          do {
            grid[i][j] = candidate++;
          } while (candidate != 10
                  && (!isValidGrid(grid)
                  || (!solve(
                  grid,
                  j == grid[0].length - 1 ? i + 1 : i,
                  j == grid[0].length - 1 ? 0 : j + 1))));
          if (grid[i][j] != 10) {
            solvable = true;
          } else {
            solvable = false;
            grid[i][j] = 0;
          }
        }
      }
    }
    return solvable;
  }

  private boolean isValidGrid(int[][] grid) {
    int[] nineArray = new int[10];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != 0) {
          nineArray[grid[i][j] - 1]++;
        }
      }
    }

    boolean isValid = true;
    if (nineArray[9] > 0) {
      isValid = false;
    } else {
      for (int i = 0; i < nineArray.length; i++) {
        if (nineArray[i] > 1) {
          isValid = false;
          break;
        }
      }
    }
    return isValid;
  }
}
