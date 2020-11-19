package offer;
// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
// 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//
//
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
// 返回链表 4->5.
// Related Topics 链表 双指针
// 👍 105 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
import common.ListNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20201118 To change this template use File | Settings | File Templates.
 */
public class Offer22GetKthFromEnd {
  // 一个指针先跑k-1，然后两个指针一起跑
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < k; i++) {
      // 链表长度小于k
      if (fast == null) {
        return null;
      }
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
