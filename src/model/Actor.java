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
    this.location = new Point(this.timeAndLocation.get(time));
  }
  //converts object to text output at a certain time
  String convertToTextAtTime(int time) {
    return this.shape.toString() + ", " + Integer.toString(time) + ", " + this.timeAndLocation.get(time);
  }

  void render() {
    //doesn't do anything yet
  }
}
