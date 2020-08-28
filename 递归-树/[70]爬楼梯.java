//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1202 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //傻递归
//    public int climbStairs(int n) {
//      return  climb(n);
//    }
//   private int  climb(int n){
//        if(n<3){
//            return n;
//        }
//       n = climb(n-1) + climb(n-2);
//        return n;
//   }
   //加缓存优化
    private int[] arr;
   public int climbStairs(int n) {
       arr = new int[n+1];
       return  climb(n);
   }
    private int  climb(int n){
        if(n<3){
            return n;
        }
        if(arr[n] == 0){
            arr[n] = climb(n-1) + climb(n-2);
        }
    return arr[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
