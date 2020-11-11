package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AnimationTest {
  ArrayList<Actor> listOfAct = new ArrayList<Actor>();

  @Test
  public void createScene() {
    AnimationModel testBefore = new Animation(listOfAct, 0, 100);
    Scene scene = new Scene(Color.RED, 100, 100);
    testBefore.createScene(scene);

    Assert.assertTrue(testBefore.hasScene());
  }

  @Test
  public void hasScene() {
    AnimationModel testAnimation = new Animation(listOfAct, 0, 100);
    Assert.assertFalse(testAnimation.hasScene());
    testAnimation.createScene(new Scene(Color.BLUE, 200, 200));
    Assert.assertTrue(testAnimation.hasScene());
  }

  @Test
  public void addActor() {
    AnimationModel testAnimation = new Animation(listOfAct, 0, 100);
    Assert.assertEquals(0, testAnimation.getActors().size());
    testAnimation.addActor(new Actor(new Rectangle(), new Point(1,1), new HashMap<Integer, Point>()));
    Assert.assertEquals(1, testAnimation.getActors().size());
  }

  @Test
  public void getFileAsText() {
    AnimationModel testAnimation = new Animation(listOfAct, 0, 100);
    testAnimation.addActor(new Actor(new Rectangle(), new Point(1,1), new HashMap<Integer, Point>()));
    testAnimation.createScene(new Scene(Color.BLUE, 200, 200));
//    Assert.assertEquals(testAnimation.getFileAsText(),
//        "200x200 blue scene \n"
//            + "Rectangle ");

  }
}