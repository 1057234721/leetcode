package practice.account;

import java.util.concurrent.CountDownLatch;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20210406
 * To change this template use File | Settings | File Tem------------------------plates.
 */
public class TransferRunAble implements Runnable{
    private User from;
    private User to;
    private int money;
    private CountDownLatch latch;

    public TransferRunAble(User from, User to, int money, CountDownLatch latch){
        this.from = from;
        this.to = to;
        this.money=money;
        this.latch = latch;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            Move move = new Move();
            move.transfer(from,to,money);
        }
        latch.countDown();
    }
}