package view;

public interface AnimationView<VIEW_OUTPUT, SHAPE_OUTPUT> {
  VIEW_OUTPUT play();
  SHAPE_OUTPUT renderAtTime(int seconds);

}
