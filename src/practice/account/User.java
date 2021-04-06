package practice.account;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20210406
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private  int  id;
    private String name;
    private int balance;

    public User(String name, int balance){
        this.name=name;
        this.balance=balance;
    }
    public User(){
    }

    public void dec(int money){
        this.balance = this.balance - money;
    }
    public void incr (int money){
        this.balance = this.balance + money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
