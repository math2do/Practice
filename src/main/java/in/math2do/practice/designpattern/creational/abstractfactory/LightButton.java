package in.math2do.practice.designpattern.creational.abstractfactory;

public class LightButton implements Button {

  @Override
  public void render() {
    System.out.println("Rendering light button");
  }
}
