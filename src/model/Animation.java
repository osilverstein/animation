package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class Animation implements AnimationModel<Actor, Scene> {

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
   * @param time1
   * @param time2
   */
  @Override
  public void play(int time1, int time2) {
    for (int i = currentTime; i < endTime; i++) {
      for (int j = 0; j < this.listOfActors.size(); j++) {
        Actor current = this.listOfActors.get(j);
        current.move(i);
        current.render();
      }
    }

  }

  /**
   * @param scene
   */
  @Override
  public void createScene(Scene scene) {
    this.scene = scene;
  }

  /**
   * @param actor
   */
  @Override
  public void addActor(Actor actor) {
    this.listOfActors.add(actor);
  }

  /**
   * @return
   */
  @Override
  public void getFileAsText() throws IOException {
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
}
