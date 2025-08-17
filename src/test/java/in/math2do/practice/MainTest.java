package in.math2do.practice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
  @BeforeAll
  public static void beforeAll() {
    System.out.println("before all");
  }

  @AfterAll
  public static void afterAll() {
    System.out.println("after all");
  }

  @Test
  @DisplayName("Adding numbers 2, 3, and 6 should give us 11")
  public void TestAddition() {
    int c = Main.add(2, 3, 6);
    Assertions.assertEquals(11, c);
  }
}
