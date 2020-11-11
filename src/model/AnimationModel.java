package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface AnimationModel<ACTOR_CLASS, COLOR_CLASS, SHAPE_CLASS, POINT_CLASS> {

  /**
   * Plays back the current animation.
   * @param time1 start of time to play
   * @param time2 when to stop playing
   */
  void play(int time1, int time2);

  /**
   * Adds a scene to the animation
   * @param bg the background color of the scene
   * @param xSize is the x dimension
   * @param ySize is the y dimension
   */
  void createScene(COLOR_CLASS bg, int xSize, int ySize);

  /**
   * @param shape is the shape of the actor
   * @param location is the current location of the actor
   * @param timeAndLocation is the hashmap representing its movement
   */
  void addActor(SHAPE_CLASS shape, POINT_CLASS location, HashMap<Integer, POINT_CLASS> timeAndLocation);

  void addAnimationToActor(int actorIndex, HashMap<Integer, POINT_CLASS> newTimeAndLocation)
      throws Exception;
  /**
   *
   */
  void getFileAsText();

  /**
   * @return
   */
  boolean hasScene();

  /**
   * @return
   */
  ArrayList<ACTOR_CLASS> getActors();

}
