package in.math2do.practice.designpattern.creational.abstractfactory;

public class DarkCheckbox implements Checkbox {

  @Override
  public void render() {
    System.out.println("Rendering dark check box");
  }
}
