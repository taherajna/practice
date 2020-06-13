package com.taherajna.practice.games;

import org.junit.Assert;
import org.junit.Test;

public class SudokuOptimized {

  @Test
  public void simple() {
    int[][] grid = {
            {1, 2, 3, 0, 5, 6, 7, 8, 9},
            {0, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 0, 5, 6},
            {2, 3, 0, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 0},
            {8, 9, 1, 2, 3, 0, 5, 6, 7},
            {3, 0, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 0, 5},
            {9, 1, 2, 3, 0, 5, 6, 7, 8}
    };

    int[][] solved = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
    };
    Assert.assertTrue(SolveSudoko(grid));
    Assert.assertArrayEquals(solved, grid);
  }

  @Test
  public void complex() {
    int[][] grid = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    int[][] solved = {
            {3, 1, 6, 5, 7, 8, 4, 9, 2},
            {5, 2, 9, 1, 3, 4, 7, 6, 8},
            {4, 8, 7, 6, 2, 9, 5, 3, 1},
            {2, 6, 3, 4, 1, 5, 9, 8, 7},
            {9, 7, 4, 8, 6, 3, 1, 2, 5},
            {8, 5, 1, 7, 9, 2, 6, 4, 3},
            {1, 3, 8, 9, 4, 7, 2, 5, 6},
            {6, 9, 2, 3, 5, 1, 8, 7, 4},
            {7, 4, 5, 2, 8, 6, 3, 1, 9}
    };
    Assert.assertTrue(SolveSudoko(grid));
    Assert.assertArrayEquals(solved, grid);
  }

  boolean SolveSudoko(int grid[][]) {
    int[][][] availabilityMatrix = getAvailabilityMatrix(grid);
    return solve(grid, availabilityMatrix);
  }

  private int[][][] getAvailabilityMatrix(int[][] grid) {
    int[][][] availabilityMatrix = new int[3][9][];
    // Horizontal
    for (int i = 0; i < grid.length; i++) {
      int[] nineArray = new int[10];
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != 0) {
          nineArray[grid[i][j] - 1]++;
        }
      }
      availabilityMatrix[0][i] = nineArray;
    }

    // Vertical
    for (int i = 0; i < grid.length; i++) {
      int[] nineArray = new int[10];
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[j][i] != 0) {
          nineArray[grid[j][i] - 1]++;
        }
      }
      availabilityMatrix[1][i] = nineArray;
    }

    // 3*3
    for (int i = 0; i < grid.length; i++) {
      int[] nineArray = new int[10];
      for (int j = 0; j < grid[i].length; j++) {
        int entry = grid[(i * 3 + (j / 3)) % 9][((i / 3) * 3) + j % 3];
        if (entry != 0) {
          nineArray[entry - 1]++;
        }
      }
      availabilityMatrix[2][i] = nineArray;
    }
    return availabilityMatrix;
  }

  private boolean solve(int[][] grid, int[][][] availabilityMatrix) {
    boolean solvable = true;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          int candidate = 0;
          do {
            candidate++;
          } while (candidate != 10
                  && (!isValidGrid(grid, candidate, availabilityMatrix, i, j)
                  || (!solve(grid, availabilityMatrix))));
          if (candidate != 10) {
            solvable = true;
          } else {
            solvable = false;
            setValue(grid, availabilityMatrix, i, j, candidate, 0, 0);
            break;
          }
        }
      }
      if (!solvable) {
        break;
      }
    }
    return solvable;
  }

  private void setValue(
          int[][] grid,
          int[][][] availabilityMatrix,
          int i,
          int j,
          int candidate,
          int gridValue,
          int availMatValue) {
    grid[i][j] = gridValue;
    availabilityMatrix[0][i][candidate - 1] = availMatValue;
    availabilityMatrix[1][(i * 3 + (j / 3)) % 9][candidate - 1] = availMatValue;
    availabilityMatrix[2][j][candidate - 1] = availMatValue;
  }

  private boolean isValidGrid(
          int[][] grid, int candidate, int[][][] availabilityMatrix, int i, int j) {

    boolean isValid = true;
    // check horizontal validity
    if (availabilityMatrix[0][i][candidate - 1] > 0) {
      isValid = false;
    }
    // check vertical validatity
    if (isValid) {
      if (availabilityMatrix[1][j][candidate - 1] > 0) {
        isValid = false;
      }
    }

    // check validity in 3*3 grid
    /*if (isValid) {
      if (availabilityMatrix[2][(i * 3 + (j / 3)) % 9][candidate-1] > 0) {
        isValid = false;
      }
    }*/
    if (isValid) {
      setValue(grid, availabilityMatrix, i, j, candidate, candidate, 1);
    }

    return isValid;
  }

  boolean isValid9Array(int[] nineArray) {
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
