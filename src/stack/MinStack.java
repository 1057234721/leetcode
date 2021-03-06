package stack;//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计


import java.util.Stack;
/**
 * Created by IntelliJ IDEA.
 *[155]Min Stack
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
//
//    private Stack<Integer> stack;
//    private Integer min = Integer.MAX_VALUE;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<Integer>();
//    }
//    //当最小值变化的时候，需要将最小值二次入栈
//    public void push(int x) {
//        if(x <= min){
//            stack.push(min);
//            min = x;
//        }
//        stack.push(x);
//    }
//    //弹出最小值的时候，需要二次弹出并赋值给min
//    public void pop() {
//      int pop =  stack.pop();
//      if(pop==min){
//          min = stack.pop();
//      }
//    }
//    public int top() {
//      return  stack.peek();
//    }
//
//    public int getMin() {
//        return  min;
//    }
//
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    //当最小值变化的时候，需要将最小值二次入栈
    public void push(int x) {
        if(minStack.empty() ){
            minStack.push(x);
        }else if( !minStack.empty() && x <= minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }
    //弹出最小值的时候，需要二次弹出并赋值给min
    public void pop() {
      int pop =  stack.pop();
      if(pop==minStack.peek()){
          minStack.pop();
      }
    }
    public int top() {
      return  stack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
