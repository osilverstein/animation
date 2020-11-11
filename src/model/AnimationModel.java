package model;

import java.io.IOException;
import java.util.ArrayList;

public interface AnimationModel {

  void play(int time1, int time2);
  void createScene(Scene scene);
  void addActor(Actor actor);
  void getFileAsText() throws IOException;
  boolean hasScene();
  ArrayList<Actor> getActors();

}
