package in.math2do.practice.thread;

public class CustomThread extends Thread {
  private Counter counter;

  public CustomThread(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      this.counter.increment();
    }
  }

  public static void main() {
    Counter counter = new Counter();
    CustomThread customThread1 = new CustomThread(counter);
    CustomThread customThread2 = new CustomThread(counter);

    customThread1.start();
    customThread2.start();

    try {
      customThread1.join();
      customThread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(counter.getCount());
  }
}
