package model;

import java.io.IOException;
import java.util.ArrayList;

public interface AnimationModel<K, J> {

  void play(int time1, int time2);
  void createScene(J scene);
  void addActor(K actor);
  void getFileAsText() throws IOException;
  boolean hasScene();
  ArrayList<K> getActors();

}
