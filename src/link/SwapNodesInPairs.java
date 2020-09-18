package link;//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
// 
// Related Topics 链表 
// 👍 623 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }.
 *
 */
/**
 * Created by IntelliJ IDEA.
 * [24]Swap Nodes in Pairs
 * @author : huangdewei
 * Date: 20200916
 * To change this template use File | Settings | File Templates.
 */
class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        //避免单独讨论，设置空节点，指向头节点，
        //画图即可解答
        //https://leetcode.wang/leetCode-24-Swap-Nodes-in-Pairs.html
        ListNode result = new ListNode(0);
        result.next = head;
        //遍历过程中需要记录中间态，不能用空节点记录，因为要返回空节点的下一个值（表头），而中间态是会变的
        ListNode start = result;
        while (start.next != null && start.next.next != null){
            ListNode s1 = start.next;
            ListNode s2 = start.next.next;
            start.next = s2;
            s1.next = s2.next;
            s2.next = s1;
            start = s1;


        }
        return   result.next;

    }
    public static void main(String[] args) {
        //
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode list = swapPairs(l1);
        while (list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
