package com.taherajna.practice.trees.nary;

public class EnigmaSolver {
  public static int getNumberOfSteps(EnigmaNode modifiedTreeRoot, EnigmaNode correctTreeRoot) {
    return Math.min(
            getNumberOfStepsMin(modifiedTreeRoot, correctTreeRoot, false),
            getNumberOfStepsMin(modifiedTreeRoot, correctTreeRoot, true) + 1);
  }

  private static int getNumberOfStepsMin(
          EnigmaNode modifiedTreeRoot, EnigmaNode correctTreeRoot, boolean fullToggle) {
    int numberOfSteps = 0;
    if (!modifiedTreeRoot.getChildren().isEmpty()) {
      for (int i = 0; i < modifiedTreeRoot.getChildren().size(); i++) {
        int route1 = Integer.MAX_VALUE;
        int route2 = Integer.MAX_VALUE;
        if (fullToggle) {
          route1 =
                  Math.min(
                          getNumberOfStepsMin(
                                  modifiedTreeRoot.getChildren().get(i),
                                  correctTreeRoot.getChildren().get(i),
                                  true),
                          getNumberOfStepsMin(
                                  modifiedTreeRoot.getChildren().get(i),
                                  correctTreeRoot.getChildren().get(i),
                                  false)
                                  + 1);
        } else {
          route2 =
                  Math.min(
                          getNumberOfStepsMin(
                                  modifiedTreeRoot.getChildren().get(i),
                                  correctTreeRoot.getChildren().get(i),
                                  false),
                          getNumberOfStepsMin(
                                  modifiedTreeRoot.getChildren().get(i),
                                  correctTreeRoot.getChildren().get(i),
                                  true)
                                  + 1);
        }
        numberOfSteps += Math.min(route1, route2);
      }
    }
    if ((fullToggle ^ modifiedTreeRoot.isState()) != correctTreeRoot.isState()) {
      numberOfSteps += 1;
    }
    return numberOfSteps;
  }
}
