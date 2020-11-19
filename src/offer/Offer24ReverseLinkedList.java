package offer;//反转一个单链表。
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
class Offer24ReverseLinkedList {
    //    public ListNode reverseList(ListNode head) {
    //       //迭代，设前驱pre，当前节点cur，
    //        //缓存后继 tempNext
    //        //cur.next = pre 当前节点nex指针指向前驱
    //        //pre后移，pre=cur
    //        //cur后移，cur=temNext
    //        ListNode pre =null;
    //        ListNode cur =head;
    //        while (cur!= null){
    //            ListNode next =cur.next;
    //            //当前节点nex指针指向前驱
    //            cur.next = pre;
    //            //前驱后移
    //            pre = cur;
    //            //当前节点后移
    //            cur = next;
    //        }
    //        return pre;
    //
    //    }
    public static ListNode reverseList(ListNode head) {
        //cur.next.next=cur 当前节点的后继的next指向当前节点
        if(head == null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        ListNode cur =  reverseList(head.next);
        //先下探到底回溯的时候处理逻辑，故当前层逻辑在下探到下一层之后，如果反过来  执行到head.next =null时就不能下探到下一层
        // 当前节点的后继的next指向当前节点
        head.next.next = head;
        //断开当前节点的后继，因为当前节点的后继的next指向当前节点，如不断开这两节点形成环；
        head.next =null;
        //最底层的节点就是头节点，从底层向上回溯是改变了各节点的指针
        return cur;

    }

  public static void main(String[] args) {
    //
      ListNode l1 = new ListNode(1);
      ListNode l2 = new ListNode(2);
      ListNode l3 = new ListNode(3);
      ListNode l4 = new ListNode(4);
      ListNode l5 = new ListNode(5);
      l1.next = l2;
      l2.next = l3;
      l3.next = l4;
      l4.next = l5;
      ListNode list = reverseList(l1);
      while (list != null){
      System.out.println(list.val);
      list = list.next;
      }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
