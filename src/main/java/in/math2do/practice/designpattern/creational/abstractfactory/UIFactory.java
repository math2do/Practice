package in.math2do.practice.designpattern.creational.abstractfactory;

// Factory returns some products which are same types differing behaviour, or properties
// e.g. DarkButton, WhiteButton
public interface UIFactory {
  Button createButton();

  Checkbox createCheckbox();
}
