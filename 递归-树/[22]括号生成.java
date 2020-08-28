//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1260 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursion(list,"",0,0,n);
        return  list;

    }
    //回溯算法，递归过程中枚举若干种优化策略，若策略无效，退化为暴力
    //左括号小于n可插入，右括号小于左括号数量可插入
    private void recursion(List<String> list,String  s,int start,int end ,int n){
        if(start == n && end == n){
            list.add(s.toString());
            return;
        }
        if(start<  n){
            recursion(list,s+"(",start+1,end,n);
        }
        if(end <  start){
            recursion(list,s+")",start,end+1,n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
