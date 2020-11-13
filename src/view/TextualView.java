package view;

import model.Animation;

public class TextualView implements AnimationView<String> {
  private final Animation model;
  private final int ticksPerSecond;

  TextualView(Animation model, int ticksPerSecond) {
    this.model = model;
    this.ticksPerSecond = ticksPerSecond;
  }

  public static void main(String[] args) {
    // FILL IN HERE
  }

  @Override
  public String play() {
    String output = "";
    //output += this.model.
  }
}
