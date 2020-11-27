package common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201124
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
