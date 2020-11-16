package offer;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201023
 * To change this template use File | Settings | File Templates.
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 */
public class Offer06ReversePrint {

    public int[] reversePrint(ListNode head) {
//        Stack<Integer> stack = new Stack<Integer>();
//        while (head != null){
//            stack.push(head.val);
//            head = head.next;
//        }
//
//        int[] arr = new int[stack.size()];
//        for(int i=0;i<arr.length;i++){
//            arr[i] =  stack.pop();
//        }
//
//        return arr;
        //辅助栈，或者递归，先进入下一层，在add值
        List<Integer> list = new ArrayList<Integer>();
        recursion(head ,list);
        int[] arr = new int[list.size()];
        for (int i =0;i<list.size();i++ ){
            arr[i] = list.get(i);
        }

        return arr;

    }

    private void recursion(ListNode head, List<Integer> list) {
        if (head == null){
            return;
        }
       // head = head.next;
        recursion(head.next,list);
        list.add(head.val);
    }

}
