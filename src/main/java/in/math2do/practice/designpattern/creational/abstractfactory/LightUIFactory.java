package in.math2do.practice.designpattern.creational.abstractfactory;

public class LightUIFactory implements UIFactory {

  @Override
  public Button createButton() {
    return new LightButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new LightCheckbox();
  }
}
