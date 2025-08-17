package in.math2do.practice;

public class Main {
  public static int add(int... numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    int c = add(1, 3, 4);
    System.out.println(c);
  }
}
