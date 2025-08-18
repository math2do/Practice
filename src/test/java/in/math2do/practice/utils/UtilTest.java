package in.math2do.practice.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;


@DisplayName("Testing the util class")
public class UtilTest {
  @BeforeAll
  public static void beforeAll() {
    System.out.println("before all");
  }

  @AfterAll
  public static void afterAll() {
    System.out.println("after all");
  }

  private static Stream<Arguments> testTable() {
    return Stream.of(
      Arguments.of(2, 3, 5),
      Arguments.of(1, 3, 4),
      Arguments.of(2, 1, 3),
      Arguments.of(6, 3, 9)
    );
  }

  @ParameterizedTest
  @DisplayName("Adding two numbers with test parameterized")
  @MethodSource("testTable")
  public void TestAddition(int a, int b, int expected) {
    int actualResult = Util.add(a, b);
    Assertions.assertEquals(expected, actualResult);
  }

  @Test
  @DisplayName("Adding two numbers usual way")
  public void TestAdditionNormal() {
    int actualResult = Util.add(1, 2);
    Assertions.assertEquals(3, actualResult);
  }

  @Test
  public void TestMocking() {
    List<String> mockedList = mock();
    mockedList.add("first-element");
    mockedList.add("second-element");
    mockedList.add("third-element");
    mockedList.add("third-element");
    mockedList.clear();

    verify(mockedList).add("first-element");
    verify(mockedList).add("second-element");
    verify(mockedList, times(2)).add("third-element");

    verify(mockedList).clear();
  }
}
