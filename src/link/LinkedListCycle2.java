package link;//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Notice that you should not modify the linked list. 
//
// Follow up: 
//
// Can you solve it using O(1) (i.e. constant) memory? 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// pos is -1 or a valid index in the linked-list. 
// 
// Related Topics 链表 双指针 
// 👍 624 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Created by IntelliJ IDEA.
 *[142]Linked List Cycle II
 * @author : huangdewei
 * Date: 20200916
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        //快慢指针，慢指针走一步，快走2布，两阶段，第一阶段先判断有没有环记录相遇点node
        //第二阶段，从head和相遇点每次周一步，直到再次相遇，则为入口。
        if(head==null){
            return null;
        }
        ListNode node = getMeetNode(head);
        if(node==null){
            return null;
        }
        ListNode node2 = head;
        while (node != node2){
            node= node.next;
            node2= node2.next;
        }
        return node2;

    }
    private ListNode getMeetNode(ListNode head){
        ListNode  fast = head;
        ListNode  slow = head;
        while (fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast== slow){
                return fast;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
