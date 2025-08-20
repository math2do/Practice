package in.math2do.practice.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
  private int balance = 100;
  //TODO: OR use the more general Lock = new ReentrantLock(true);
  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
  private final Lock readLock = readWriteLock.readLock();
  private final Lock writeLock = readWriteLock.writeLock();

  public void withdraw(int amount) throws RuntimeException {
    System.out.println(Thread.currentThread().getName() + " attempting to withdraw amount " + amount);

    writeLock.lock();  // there is a tryLock() method as well
    if (balance >= amount) {
      try {
        System.out.println(Thread.currentThread().getName() + " Proceeding for withdrawal");
        Thread.sleep(3000);
        this.balance -= amount;
        System.out.println("Completed withdrawal, remaining balance: " + this.balance);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } finally {
        writeLock.unlock();
      }
    } else {
      System.out.println("Insufficient balance");
    }
  }

  public int checkBalance() {
    System.out.println(Thread.currentThread().getName() + " attempting to get balance ");
    readLock.lock();
    try {
      Thread.sleep(4000);
      System.out.println(Thread.currentThread().getName() + " fetched balance: " + this.balance);
      return this.balance;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      readLock.unlock();
    }
    // When error happens
    return 0;
  }

  public static void main() throws RuntimeException {
    final BankAccount sbi = new BankAccount();
    Runnable WithdrawalTask = () -> {
      sbi.withdraw(50);
    };

    Runnable BalanceCheckTask = sbi::checkBalance;

    Thread thread1 = new Thread(WithdrawalTask, "Thread 1");
    Thread thread2 = new Thread(WithdrawalTask, "Thread 2");
    Thread thread3 = new Thread(BalanceCheckTask, "Thread 3");

    thread1.start();
    thread2.start();
    thread3.start();

    try {
      thread1.join();
      thread2.join();
      thread3.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
