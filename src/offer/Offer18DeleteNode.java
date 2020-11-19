package offer;

import common.ListNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201107
 * To change this template use File | Settings | File Templates.
 */
public class Offer18DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }
        if(head.val == val){
            head =head.next;
            return head;
        }
        ListNode node = head;
        //待删除节点的
        while (node.next != null){
            if(node.next.val==val){
                node.next =node.next.next;
                return head;
            }
            node =node.next;
        }
        return null;


    }
}
