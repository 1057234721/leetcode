package offer;
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// 各函数的调用总次数不超过 20000 次
//
//
//
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
// Related Topics 栈 设计
// 👍 66 👎 0

import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201123
 * To change this template use File | Settings | File Templates.
 */
public class Offer30MinStack { //辅助栈
    private Stack<Integer> min;
    //辅助栈
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public Offer30MinStack() {
        min = new Stack<Integer>();
        stack = new Stack<Integer>();

    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek()>= x){
            min.push(x);
        }

    }

    public void pop() {
        int x =  stack.pop();
        if(!min.isEmpty()&& min.peek() == x){
            min.pop();
        }

    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return min.peek();
    }

}
