package in.math2do.practice;

public class Main {
  public static class CustomException extends Exception {
    public CustomException(String msg) {
      super(msg);
    }
  }

  public static void doSomething() throws CustomException {
    throw new CustomException("Something wrong went");
  }

  public static void main(String[] args) throws CustomException {
    doSomething();
  }
}
