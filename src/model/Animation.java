package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import util.Pair;

/**
 *
 */
public class Animation implements AnimationModel<Actor, RawAnimation, Color, Shape, Point, Float> {

  Scene scene;
  ArrayList<Actor> listOfActors;
  int currentTime;
  int endTime;

  Animation(ArrayList<Actor> listOfActors, int currentTime, int endTime) {
    this.listOfActors = listOfActors;
    this.currentTime = currentTime;
    this.endTime = endTime;
    this.scene = null;
  }

  /**
   * @param time1 is the start time to play
   * @param time2 is the end time
   */
  @Override
  public void play(int time1, int time2) {
    for (int i = currentTime; i <= endTime; i++) {
      for (int j = 0; j < this.listOfActors.size(); j++) {
        Actor current = this.listOfActors.get(j);
        current.move(i);
        //current.render();
      }
    }

  }

  /**
   * @param bg    the background color of the scene
   * @param xSize is the x dimension
   * @param ySize is the y dimension
   */
  @Override
  public void createScene(Color bg, int xSize, int ySize) {
    this.scene = new Scene(bg, xSize, ySize);
  }

  /**
   * @param shape is the shape of the actor
   * @param location is the current location of the actor
   * @param rawAnimation is the class representing its animation
   */
  @Override
  public void addActor(Shape shape, Point location, RawAnimation rawAnimation) {
    this.listOfActors.add(new Actor(shape,rawAnimation));
  }

  /**
   * @param time1    is the start time of the new animation
   * @param duration is the length of the animation
   * @param loc1     is the start location
   * @param loc2     is the end location
   * @return a hashmap represent the final animation ready for input
   */
  @Override
  public RawAnimation generateEaseMoveAnimation(int time1, int duration, Point loc1,
      Point loc2) throws Exception {
    float xTotalDelta = loc2.x - loc1.x; //total x distance covered
    float yTotalDelta = loc2.y - loc1.y; // total y distance covered

    //change per tick of both x and y
    float xDeltaPerUnitOfTime = this.generateEase(time1, duration, loc1.x, xTotalDelta);
    float yDeltaPerUnitOfTime = this.generateEase(time1, duration, loc1.y, yTotalDelta);

    HashMap<Integer, Point> outputAnimation = new HashMap<Integer, Point>();

    Point cachedLocation = new Point(loc1.x, loc1.y);

    for (int i = time1; i <= time1 + duration; i++) {
      cachedLocation.x = (int) (cachedLocation.x + xDeltaPerUnitOfTime); //update the x cache
      cachedLocation.y = (int) (cachedLocation.y + yDeltaPerUnitOfTime); //update the y cache
      outputAnimation.put(i, cachedLocation); //put in the new location at the current time
    }

    return new RawAnimation("move", outputAnimation);
  }

  /**
   * @param time           the time at which to put the animation
   * @param duration
   * @param initial_width
   * @param initial_height
   * @param final_width
   * @param final_height
   * @return
   */
  @Override
  public RawAnimation generateEaseResizeAnimation(int time, int duration,
      int initial_width, int initial_height, int final_width, int final_height) throws Exception {
    float xTotalDelta = final_width - initial_width; //total x distance
    float yTotalDelta = final_height - initial_height; // total y distance covered

    //change per tick of both x and y
    float xDeltaPerUnitOfTime = this.generateEase(time, duration, initial_width, xTotalDelta);
    float yDeltaPerUnitOfTime = this.generateEase(time, duration, initial_height, yTotalDelta);

    HashMap<Integer, Point> outputAnimation = new HashMap<Integer, Point>();

    Point cachedLocation = new Point(initial_width, initial_height);

    for (int i = time; i <= time + duration; i++) {
      cachedLocation.x = (int) (cachedLocation.x + xDeltaPerUnitOfTime); //update the x cache
      cachedLocation.y = (int) (cachedLocation.y + yDeltaPerUnitOfTime); //update the y cache
      outputAnimation.put(i, cachedLocation); //put in the new location at the current time
    }

    return new RawAnimation("size", outputAnimation);
  }

  @Override
  public void safeAddAnimationToActor(int actorIndex, RawAnimation rawAnimation)
      throws Exception {
    Actor current = this.listOfActors.get(actorIndex);
    current.addAnimation(rawAnimation);
  }


  /**
   *
   */
  @Override
  public void getFileAsText() {
    try {
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write(this.scene.toString());
      for (int i = 0; i < endTime; i++) {
        for (int j = 0; j < this.listOfActors.size(); j++) {
          myWriter.write(this.listOfActors.get(j).convertToTextAtTime(i));
        }
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  /**
   * @return boolean of whether scene exists
   */
  @Override
  public boolean hasScene() {
    return this.scene != null;
  }

  /**
   * @return ArrayList of actors
   */
  @Override
  public ArrayList<Actor> getActors() {
    return new ArrayList<Actor>(this.listOfActors);
  }

  /**
   * Generates ease for any purpose.
   * I selected this approach because I am confident floats can represent any data I need.
   * Taken from https://stackoverflow.com/questions/13462001/ease-in-and-ease-out-animation-formula
   * Nothing groundbreaking.
   * @param time is the initial time
   * @param startValue is the initial value
   * @param change is the total change in the value
   * @param duration is the time duration of the change
   * @return the amount of delta in value per second needed for smooth transition
   */
  float generateEase(float time, float duration, float startValue, float change) {
    time /= duration / 2;
    if (time < 1)  {
      return change / 2 * time * time + startValue;
    }

    time--;
    return -change / 2 * (time * (time - 2) - 1) + startValue;
  }

  public int getEndTime() {
    return this.endTime;
  }
}
