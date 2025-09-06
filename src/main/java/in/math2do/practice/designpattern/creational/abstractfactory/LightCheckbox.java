package in.math2do.practice.designpattern.creational.abstractfactory;

public class LightCheckbox implements Checkbox {

  @Override
  public void render() {
    System.out.println("Rendering light check box");
  }
}
