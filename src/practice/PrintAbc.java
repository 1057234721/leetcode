package practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA. 多线程交替打印ABC的多种实现方法
 *建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 * @author : huangdewei Date: 20210402 To change this template use File | Settings | File Templates.
 */
public class PrintAbc {
    private static Lock lock = new ReentrantLock();
    private static int status =0;

    private static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i =0;i<10;){
                try{
                    lock.lock();
                    while (status%3==0){
                        status ++;
                        i++;
                     System.out.print("A");
                    }
                }finally{
                    lock.unlock();
                }

            }
        }
    }
    private static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i =0;i<10;){
                try{
                    lock.lock();
                    while (status%3==1){
                        status ++;
                        i++;
                     System.out.print("B");
                    }
                }finally{
                    lock.unlock();
                }

            }
        }
    }
    private static class ThreadC extends Thread{
        @Override
        public void run() {
            for (int i =0;i<10;){
                try{
                    lock.lock();
                    while (status%3==2){
                        status ++;
                        i++;
                     System.out.print("C");
                    }
                }finally{
                    lock.unlock();
                }

            }
        }
    }

  public static void main(String[] args) {
    //

      new ThreadA().start();
      new ThreadB().start();
      new ThreadC().start();
  }
}
