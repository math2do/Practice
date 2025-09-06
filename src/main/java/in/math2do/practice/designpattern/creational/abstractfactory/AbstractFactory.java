package in.math2do.practice.designpattern.creational.abstractfactory;

// Invoke the main method as AbstractFactory.main()
public class AbstractFactory {
  public static void main() {
    UIFactory factory;

    // Suppose user chose Dark Theme
    factory = new DarkUIFactory();
    Button darkButton = factory.createButton();
    Checkbox darkCheckbox = factory.createCheckbox();
    darkButton.render();
    darkCheckbox.render();

    // Suppose user chose Light Theme
    factory = new LightUIFactory();
    Button lightButton = factory.createButton();
    Checkbox lightCheckbox = factory.createCheckbox();
    lightButton.render();
    lightCheckbox.render();
  }
}
