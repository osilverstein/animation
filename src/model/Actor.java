package model;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;


public class Actor {
  Shape shape;
  Point location;
  HashMap<Integer, Point> timeAndLocation;

  Actor(Shape shape, Point location, HashMap<Integer, Point> timeAndLocation) {
    this.shape = shape;
    this.location = location;
    this.timeAndLocation = timeAndLocation;
  }

  //moves actor to a speciied time
  void move(int time) {
    if (this.timeAndLocation.containsKey(time)) {
      this.location = new Point(this.timeAndLocation.get(time));
    }
  }

  /**
   * @param newTimeAndLocation represents the new animation and its times to be added
   * @throws Exception thrown if there is already an animation at that time
   */
  void addAnimation(HashMap<Integer, Point> newTimeAndLocation) throws Exception {
    for (Integer key : newTimeAndLocation.keySet()) {
      if (this.timeAndLocation.containsKey(key)) {
        throw new Exception(
            "Error adding animation: there is already an animation at tick #" + key);
      }
      else {
        this.timeAndLocation.put(key, newTimeAndLocation.get(key));
      }
    }
  }

  //converts object to text output at a certain time
  String convertToTextAtTime(int time) {
    return this.shape.toString() + ", " + Integer.toString(time) + ", " + this.timeAndLocation.get(time);
  }

  void render() {
    //doesn't do anything yet
  }
}
