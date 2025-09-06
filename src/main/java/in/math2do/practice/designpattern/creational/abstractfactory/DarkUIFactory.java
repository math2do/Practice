package in.math2do.practice.designpattern.creational.abstractfactory;

public class DarkUIFactory implements UIFactory {

  @Override
  public Button createButton() {
    return new DarkButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new DarkCheckbox();
  }
}
