package view;

import java.util.Set;
import model.Actor;
import model.Animation;
import model.RawAnimation;

public class TextualView implements AnimationView<String, String> {
  private final Animation model;
  private final int ticksPerSecond;

  TextualView(Animation model, int ticksPerSecond) {
    this.model = model;
    this.ticksPerSecond = ticksPerSecond;
  }

  public static void main(String[] args) {
    // FILL IN HERE
  }

  @Override
  public String play() {
    StringBuilder outputB = new StringBuilder();
    for (Actor currentActor : this.model.getActors()) {
      RawAnimation currentAnimation = currentActor.getRawAnimation();
      Set<Integer> motionKeys = currentAnimation.getMotion().keySet();
      Set<Integer> sizeKeys = currentAnimation.getSize().keySet();
      Set<Integer> colorKeys = currentAnimation.getMotion().keySet();

      for (int i = 0; i < this.model.getEndTime(); i++) {
        outputB.append(currentAnimation.safeGetColorAtTick(i).toString() + "\n");
        outputB.append(currentAnimation.safeGetSizeAtTick(i).toString() + "\n");
        outputB.append(currentAnimation.safeGetLocationAtTick(i).toString() + "\n");


      }
    }
    return outputB.toString();
  }

  @Override
  public String renderAtTime(int seconds) {
    return null;
  }
}
