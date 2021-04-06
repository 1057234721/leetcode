package practice.account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20210406 To change this template use File | Settings | File Templates.
 */
/*
 问题1: 有二十个账户。每个账户初始余额10000元。
2。 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
3。 每个线程执行100次转账操作。
4。 最后请打印出二十个账户的余额。
*/
public class Move {
  private static Object obj = new Object();
  private static CountDownLatch latch = new CountDownLatch(10);

  public void transfer(User from, User to, int money) {
//    int fromIndex = System.identityHashCode(from);
//    int toindex = System.identityHashCode(to);
      int fromIndex = from.getId();
      int toIndex = to.getId();

    if (fromIndex < toIndex) {
      synchronized (from) {
        synchronized (to) {
          from.dec(money);
          to.incr(money);
        }
      }
    } else if (toIndex < fromIndex) {
      synchronized (to) {
        synchronized (from) {
          from.dec(money);
          to.incr(money);
        }
      }
    } else {
      synchronized (Move.class) {
        synchronized (from) {
          synchronized (to) {
            from.dec(money);
            to.incr(money);
          }
        }
      }
    }
  }
  

    public static List<User> initTwentyAccount(){
        List<User> accountLists = new ArrayList<User>();
        for(int i =0;i< 20 ;i++){
            User account = new User();
            account.setId(i);
            account.setName(""+ i);
            account.setBalance(10000);
            accountLists.add(account);
        }
        return accountLists;
    }

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        List<User> accounts = initTwentyAccount();
        for(int i =0;i< 10;i++){
            Collections.shuffle(accounts);
            User from = accounts.get(0);
            User to = accounts.get(1);
            int money = r.nextInt(100);
            new Thread(new TransferRunAble(from, to, money, latch)).start();
        }
        latch.await();
        int sum =0;
        for(User account : accounts){
            System.out.println(account.getBalance());
            sum += account.getBalance();
        }
    System.out.println(sum);
    }
}
