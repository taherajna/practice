package com.taherajna.practice.trees.nary;

import java.util.ArrayList;
import java.util.List;

public class EnigmaNode {
  private int id;
  private boolean state;
  private List<EnigmaNode> children;

  public EnigmaNode(int id, boolean state) {
    this.id = id;
    children = new ArrayList<>();
    this.state = state;
  }

  public void addChild(EnigmaNode node) {
    children.add(node);
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public List<EnigmaNode> getChildren() {
    return children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    EnigmaNode that = (EnigmaNode) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
