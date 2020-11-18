package model;

import java.awt.Color;
import java.util.HashMap;
import util.Pair;

public class RawAnimation {
  HashMap<Integer, Pair<Integer, Integer>> size;
  HashMap<Integer, Pair<Integer, Integer>> motion;
  HashMap<Integer, Color> color;
  int currentTick;

  RawAnimation(HashMap<Integer,
      Pair<Integer, Integer>> size,
      HashMap<Integer, Pair<Integer, Integer>> motion,
      HashMap<Integer, Color> color)
  {
    this.size = size;
    this.motion = motion;
    this.color = color;
    this.currentTick = 0;
  }

  RawAnimation(HashMap<Integer,
      Pair<Integer, Integer>> size,
      HashMap<Integer, Pair<Integer, Integer>> motion,
      HashMap<Integer, Color> color, int currentTick)
  {
    this.size = size;
    this.motion = motion;
    this.color = color;
    this.currentTick = currentTick;
  }

  <E> RawAnimation(String knownAttribute, E attribute) throws Exception
  {
    switch (knownAttribute) {
      case "motion":
        this.size = new HashMap<Integer, Pair<Integer, Integer>>();
        this.motion = (HashMap<Integer, Pair<Integer, Integer>>) attribute;
        this.color = new HashMap<Integer, Color>();
        break;
      case "size":
        this.size = (HashMap<Integer, Pair<Integer, Integer>>) attribute;
        this.motion = new HashMap<Integer, Pair<Integer, Integer>>();
        this.color = new HashMap<Integer, Color>();
        break;
      case "color":
        this.size = new HashMap<Integer, Pair<Integer, Integer>>();
        this.motion = new HashMap<Integer, Pair<Integer, Integer>>();
        this.color = (HashMap<Integer, Color>) attribute;
        break;
      default:
        throw
            new Exception("Error: cannot create RawAnimation containing " + attribute + " since that attribute does not exist.");
    }
  }

  RawAnimation( HashMap<Integer, Color> color)
  {
    this.size = new HashMap<Integer, Pair<Integer, Integer>>();
    this.motion = new HashMap<Integer, Pair<Integer, Integer>>();
    this.color = color;
  }

  void addSize(HashMap<Integer, Pair<Integer, Integer>> reSize) {
    this.size = reSize;
  }

  void addMotion(HashMap<Integer, Pair<Integer, Integer>> reMotion) {
    this.size = reMotion;
  }

  void addColor(HashMap<Integer, Color> reColor) {
    this.color = reColor;
  }

  /**
   * Gets the current actor's attributes at a certain time
   * @param tick is the tick at which to pull the attributes as hashmap
   * @return the attributes in a hashmap with the name of attribute as key
   */
  public HashMap<String, Object> getAttributesAtTick(int tick) {
    HashMap<String, Object> output = new HashMap<String, Object>();
    output.put("size", this.safeGetSizeAtTick(tick));
    output.put("color", this.safeGetColorAtTick(tick));
    output.put("motion", this.safeGetLocationAtTick(tick));
    return output;
  }

  public void safeSetAttributeAtTick(String attribute, int tick, float x, float y, float z) throws Exception {
    if (this.motion.containsKey(tick)) {
      throw
          new Exception("Error: Cannot add " + attribute + " because tick #" + tick +  " is filled.");
    }
    switch (attribute) {
      case "motion":
        this.motion.put(tick, new Pair<Integer, Integer>((int) x,(int) y));
        break;
      case "size":
        this.size.put(tick, new Pair<Integer, Integer>((int) x,(int) y));
        break;
      case "color":
        this.color.put(tick, new Color(x, y, z));
        break;
      default:
        throw
            new Exception("Error cannot add " + attribute + " be that attribute does not exist.");
    }
  }

  public void setAttributeAtTick(String attribute, int tick, float x, float y, float z) throws Exception {
    switch (attribute) {
      case "motion":
        this.motion.put(tick, new Pair<Integer, Integer>((int) x,(int) y));
        break;
      case "size":
        this.size.put(tick, new Pair<Integer, Integer>((int) x,(int) y));
        break;
      case "color":
        this.color.put(tick, new Color(x, y, z));
        break;
      default:
        throw
            new Exception("Error cannot add " + attribute + " since that attribute does not exist.");
    }
  }
  public boolean containsKey(Integer key) {
    return this.size.containsKey(key) && this.color.containsKey(key) && this.motion.containsKey(key);
  }

  public HashMap<Integer, Color> getColor() {
    return this.color;
  }

  public Color safeGetColorAtTick(int tick) {
    while (!color.containsKey(tick) && tick >= 0) {
      tick--;
    }
    return this.color.get(tick);
  }

  public HashMap<Integer, Pair<Integer, Integer>> getMotion() {
    return this.motion;
  }

  public Pair<Integer, Integer> safeGetLocationAtTick(int tick) {
    while (!motion.containsKey(tick) && tick >= 0) {
      tick--;
    }
    return this.motion.get(tick);
  }

  public HashMap<Integer, Pair<Integer, Integer>> getSize() {
    return this.size;
  }

  public Pair<Integer, Integer> safeGetSizeAtTick(int tick) {
    while (!size.containsKey(tick) && tick >= 0) {
      tick--;
    }
    return this.size.get(tick);
  }

  public void mergeRawAnimation(RawAnimation animation) {
    this.color.putAll(animation.getColor());
    this.size.putAll(animation.getSize());
    this.motion.putAll(animation.getMotion());
  }

}
