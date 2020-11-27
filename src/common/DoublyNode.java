package common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201124
 * To change this template use File | Settings | File Templates.
 */
public class DoublyNode {
    public int val;
    public DoublyNode left;
    public DoublyNode right;

    public DoublyNode() {}

    public DoublyNode(int _val) {
        val = _val;
    }

    public DoublyNode(int _val,DoublyNode _left,DoublyNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
