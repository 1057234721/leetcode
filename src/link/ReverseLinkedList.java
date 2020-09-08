package link;//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import common.ListNode;

/**
 * Created by IntelliJ IDEA.
 * [206]Reverse Linked List
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //当前节点前驱
        ListNode pre  = null;
        //当前节点
        ListNode cur  = head;
        while(cur != null){
            //当前节点后继
            ListNode temp = cur.next;
            //当前节点后指针指向前驱
            cur.next = pre;
            //前驱顺着链表前进
            pre = cur;
            //当前节cur.next点前进
            cur = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
