package model;

import java.util.ArrayList;
import java.util.HashMap;

public interface AnimationModel<ACTOR_CLASS, ACTOR_ANIMATION_CLASS, COLOR_CLASS, SHAPE_CLASS, LOCATION_CLASS, TERTIARY_DATA> {

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
   * @param rawAnimation is the hashmap representing its movement
   */
  void addActor(SHAPE_CLASS shape, LOCATION_CLASS location, ACTOR_ANIMATION_CLASS rawAnimation);

  /**
   * @param time1 is the start time of the new animation
   * @param duration is the length of the animation
   * @param loc1 is the start location
   * @param loc2 is the end location
   * @return a hashmap represent the final animation ready for input
   */
  ACTOR_ANIMATION_CLASS generateEaseMoveAnimation(int time1, int duration, LOCATION_CLASS loc1, LOCATION_CLASS loc2)
      throws Exception;

  /**
   * @param time the time at which to put the animation
   * @param duration
   * @param initial_width
   * @param initial_height
   * @param final_width
   * @param final_height
   * @return
   */
  ACTOR_ANIMATION_CLASS generateEaseResizeAnimation(int time, int duration, int initial_width, int initial_height, int final_width, int final_height)
      throws Exception;

  /**
   * Will only add animation if there is not already motion during the designated times
   *  @param actorIndex is the index of the actor on which to animate
   * @param rawAnimation is the actor's animation represented as a
   *                           series of "ticks" and locations
   * @throws Exception if an animation is added that conflicts with a time
   */
  void safeAddAnimationToActor(int actorIndex, ACTOR_ANIMATION_CLASS rawAnimation)
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
