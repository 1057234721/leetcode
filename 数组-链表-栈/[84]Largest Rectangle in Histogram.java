//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        class Solution {
            public int largestRectangleArea(int[] heights) {
                if(heights == null){
                    return 0;
                }
                if(heights.length ==1){
                    return heights[0];
                }
                //遍历数组时维护一个单调不减栈，当前元素小于stack.peek时，此时该元素是栈顶元素top的右边界right，栈顶元素的前一个元素始终为栈顶的左边接界left
                // maxArea= (right-left-1)* heights[top]
                //遍历后单调不减栈栈非空，依次出栈
                //运用哨兵，即在栈首添加最小值，防止空栈，栈尾加最大值防止栈满，可以分开使用；
                int maxArea =0;
                Stack<Integer> stack = new Stack<Integer>();
                stack.push(-1);
                for(int i =0;i<heights.length;i++){
                    //小于栈顶要依次出栈，直至满足单调不减栈位置，故需while
                    while (stack.peek()!= -1 && heights[i] < heights[stack.peek()]){

                        int right = i;
                        int height = heights[stack.pop()]; ;
                        int left = stack.peek();
                        maxArea= Math.max((right-left-1) * height,maxArea );
                    }
                    stack.push(i);
                }
                while (stack.peek()!= -1){
                    //这里heights.length为栈里元素,+1才为右边界
                    int right = heights.length-1+1;
                    int height = heights[stack.pop()]; ;
                    int left = stack.peek();
                    maxArea= Math.max((right-left-1) * height,maxArea );
                }
                return  maxArea;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
