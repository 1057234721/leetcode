package common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
public class DoubleListNode {
    public int val;
    public DoubleListNode prev;
    public DoubleListNode next;
    public DoubleListNode(int x) { val = x; }
    public DoubleListNode(int x, DoubleListNode prev1, DoubleListNode next1) {
        val = x;
        prev = prev1;
        next = next1;
    }

}
