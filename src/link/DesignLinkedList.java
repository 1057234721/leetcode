package link;//Design your implementation of the linked list. You can choose to use a singly
//or doubly linked list. 
//A node in a singly linked list should have two attributes: val and next. val i
//s the value of the current node, and next is a pointer/reference to the next nod
//e. 
//If you want to use the doubly linked list, you will need one more attribute pr
//ev to indicate the previous node in the linked list. Assume all nodes in the lin
//ked list are 0-indexed. 
//
// Implement the MyLinkedList class: 
//
// 
// MyLinkedList() Initializes the MyLinkedList object. 
// int get(int index) Get the value of the indexth node in the linked list. If t
//he index is invalid, return -1. 
// void addAtHead(int val) Add a node of value val before the first element of t
//he linked list. After the insertion, the new node will be the first node of the 
//linked list. 
// void addAtTail(int val) Append a node of value val as the last element of the
// linked list. 
// void addAtIndex(int index, int val) Add a node of value val before the indext
//h node in the linked list. If index equals the length of the linked list, the no
//de will be appended to the end of the linked list. If index is greater than the 
//length, the node will not be inserted. 
// void deleteAtIndex(int index) Delete the indexth node in the linked list, if 
//the index is valid. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex
//", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//Output
//[null, null, null, null, 2, null, 3]
//
//Explanation
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//myLinkedList.get(1);              // return 2
//myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//myLinkedList.get(1);              // return 3
// 
//
// 
// Constraints: 
//
// 
// 0 <= index, val <= 1000 
// Please do not use the built-in LinkedList library. 
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and 
//deleteAtIndex. 
// 
// Related Topics 设计 链表 
// 👍 168 👎 0

import common.DoubleListNode;

import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA. [707]Design Linked List
 *
 * @author : huangdewei Date: 20200916 To change this template use File | Settings | File Templates.
 */
// leetcode submit region begin(Prohibit modification and deletion)
public class DesignLinkedList {
  private int size = 0;
  private DoubleListNode first;
  private DoubleListNode last;

  /** Initialize your data structure here. */
  public DesignLinkedList() {}

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if (index < 0 || index >= size) {
      return -1;
    }
    DoubleListNode node = findNodeByIndex(index);
    return node.val;
  }

  /**
   * Add a node of value val before the first element of the linked list. After the insertion, the
   * new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    if (first == null) {
      DoubleListNode node = new DoubleListNode(val, null, null);
      first = node;
      last = node;
    } else {
      DoubleListNode node = new DoubleListNode(val, null, first);
      first.prev = node;
    }
    size++;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    if (last == null) {
      DoubleListNode node = new DoubleListNode(val, null, null);
      first = node;
      last = node;
    } else {
      DoubleListNode node = new DoubleListNode(val, last, null);
      last.next = node;
    }
    size++;
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index equals to the
   * length of linked list, the node will be appended to the end of linked list. If index is greater
   * than the length, the node will not be inserted.
   */
  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) {
      return;
    }
    if (size == index) {
      addAtTail(val);
    }
    DoubleListNode result = findNodeByIndex(index);
    DoubleListNode prev = result.prev;
    ;
    DoubleListNode newNode = new DoubleListNode(val, prev, result);

    if (prev == null) {
      first = newNode;
    } else {
      prev.next = newNode;
    }
    size++;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    DoubleListNode result = findNodeByIndex(index);
    DoubleListNode prev = result.prev;
    DoubleListNode next = result.next;
    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      result.prev = null;
    }
    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      result.next = null;
    }
    result.val = 0;
    size--;
  }

  private DoubleListNode findNodeByIndex(int index) {
    int count = 0;
    while (first != null) {
      if (index == count) {
        return first;
      }
      first = first.next;
      count++;
    }
    return null;
  }

  /**
   * Your MyLinkedList object will be instantiated and called as such: MyLinkedList obj = new
   * MyLinkedList(); int param_1 = obj.get(index); obj.addAtHead(val); obj.addAtTail(val);
   * obj.addAtIndex(index,val); obj.deleteAtIndex(index);
   */
  public static void main(String[] args) {
    DesignLinkedList obj = new DesignLinkedList();

    obj.addAtHead(1);
    obj.addAtTail(2);
    obj.addAtIndex(1, 3);
    obj.deleteAtIndex(1);
    int param_1 = obj.get(1);
    System.out.println(param_1);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
