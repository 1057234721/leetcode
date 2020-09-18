package link;//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists. 
//
// Example: 
//
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1274 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Created by IntelliJ IDEA.
 *[21]Merge Two Sorted Lists
 * @author : huangdewei
 * Date: 20200916
 * To change this template use File | Settings | File Templates.
 */
class MergeTwoSortedLists {
  //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  //        //迭代设一个空节点node，避免表头单独讨论，画图可解
  //        ListNode start = new ListNode(0);
  //        ListNode node = start;
  //        while (l1!= null && l2!= null){
  //            if(l1.val<l2.val){
  //                node.next=l1;
  //                //指针后移
  //                l1=l1.next;
  //            }else{
  //                node.next=l2;
  //                //指针后移
  //                l2=l2.next;
  //            }
  //            //目标链表的表尾后移
  //            node = node.next;
  //
  //        }
  //        //拼接不为空的链表
  //        if(l1 != null){
  //            node.next=l1;
  //        }
  //        if(l2 != null){
  //            node.next=l2;
  //        }
  //        return  start.next;
  //
  //    }
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2
    // 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
      if(l1 ==null){
          return l2;
      }
      if(l2 ==null){
          return l1;
      }
      if(l1.val<l2.val){
          l1.next = mergeTwoLists(l1.next,l2);
          return l1;
      }else {
          l2.next = mergeTwoLists(l1,l2.next);
          return l2;
      }

  }
}
//leetcode submit region end(Prohibit modification and deletion)
