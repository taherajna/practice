package com.taherajna.practice.threading;

import org.junit.Test;

public class PingPong {
  @Test
  public void name() throws InterruptedException {
    PrinterClass printerClass = new PrinterClass();
    Thread t1 = new Thread(new MyRunnable(printerClass, "Ping"), "Ping");
    Thread t2 = new Thread(new MyRunnable(printerClass, "Pong"), "Pong");
    Thread t3 = new Thread(new MyRunnable(printerClass, "Ting"), "Ting");
    t1.start();
    t2.start();
    t3.start();
    t1.join();
    t2.join();
    t3.join();
  }

  private static class MyRunnable implements Runnable {

    private final PrinterClass printerClass;

    String string;

    public MyRunnable(PrinterClass printerClass, String string) {
      this.printerClass = printerClass;
      this.string = string;
    }

    @Override
    public void run() {
      try {
        for (int i = 0; i < 10; i++) {
          printerClass.print(string);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private class PrinterClass {
    String prevState = "Ting";

    public synchronized void print(String stringToPrint) throws InterruptedException {
      while (!(prevState.equals("Ting") && stringToPrint.equals("Ping"))
              && !(prevState.equals("Ping") && stringToPrint.equals("Pong"))
              && !(prevState.equals("Pong") && stringToPrint.equals("Ting"))) {
        wait();
      }
      System.out.println(stringToPrint);
      prevState = stringToPrint;
      notifyAll();
    }
  }
}
