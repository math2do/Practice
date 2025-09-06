package in.math2do.practice.designpattern.creational.abstractfactory;

public class DarkButton implements Button {

  @Override
  public void render() {
    System.out.println("Rendering dark button");
  }
}
