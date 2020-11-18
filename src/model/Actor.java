package model;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;


public class Actor {
  Shape shape;
  HashMap<String, Object> currentAttributes;
  RawAnimation rawAnimation;

  Actor(Shape shape, RawAnimation rawAnimation) {
    this.shape = shape;
    this.rawAnimation = rawAnimation;
    this.currentAttributes = rawAnimation.getAttributesAtTick(0);
  }

  //moves actor to a specified time
  void move(int time) {
    if (this.rawAnimation.containsKey(time)) {
      this.currentAttributes = rawAnimation.getAttributesAtTick(time);
    }
  }

  /**
   * @param rawAnimation represents the new animation to be added
   * @throws Exception thrown if there is already an animation at that time
   */
  void addAnimation(RawAnimation rawAnimation) throws Exception {
    this.rawAnimation.mergeRawAnimation(rawAnimation);
  }

  //TODO: REMOVE
  // converts object to text output at a certain time
  String convertToTextAtTime(int time) {
    return this.shape.toString() + ", " + Integer.toString(time) + ", ";
  }

  public RawAnimation getRawAnimation() {
    return this.rawAnimation;
  }

}
