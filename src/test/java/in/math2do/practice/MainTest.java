package in.math2do.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testing the main class")
public class MainTest {
    int number = 1;
    int max = 10;

    public void oddPrinter() {
        synchronized (this) {

            while (number <= max) {
                while (number % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf("%d ", number);
                number++;
                notify();
            }
        }
    }

    public void evenPrinter() {
        synchronized (this) {

            while (number <= max) {
                while (number % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf("%d ", number);
                number++;
                notify();
            }
        }
    }

    @Test
    void testPlaceholder() {
        Thread evenThread = new Thread(() -> {
            evenPrinter();
        });

        Thread oddThread = new Thread(() -> {
            oddPrinter();
        });

        evenThread.start();
        oddThread.start();
    }
}
