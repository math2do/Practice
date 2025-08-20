package in.math2do.practice.thread;

public class Counter {
  private int count = 0;

  // This method will be executed for one thread at once.
  public synchronized void increment() {
    this.count++;
  }

  public int getCount() {
    return this.count;
  }
}
