package offer;
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计
// 👍 130 👎 0

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201023
 * To change this template use File | Settings | File Templates.
 */
public class Offer09CQueue {
    private Stack<Integer> head;
    private Stack<Integer> tail;

    public Offer09CQueue() {
        head = new Stack<Integer>();
        tail = new Stack<Integer>();

    }
    //head栈添加数据
    public void appendTail(int value) {
        head.push(value);

    }
    //如果tail栈为空，建head栈的数据迁移过来
    public int deleteHead() {

        if(tail.isEmpty()){
            while (! head.isEmpty()){
                tail.push(head.pop());
            }
        }
        return tail.isEmpty() ? -1 : tail.pop();

    }
}
