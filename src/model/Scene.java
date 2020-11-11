package model;

import java.awt.Color;

public class Scene {
  Color background;
  private final int x;
  private final int y;

  Scene(Color bg, int x, int y) {
    this.x = x;
    this.y = y;
    this.background = bg;
  }
}
