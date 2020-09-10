package recursion;//Given two integers n and k, return all possible combinations of k numbers out
//of 1 ... n. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯算法 
// 👍 366 👎 0


import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * [77]Combinations
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        //多叉树，每一层都可以在剩余的节点取数据。
        //因为是组合，故已选的数字不可再选择
        //剪枝，当i>i-k+1时已经凑不够k个数了
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new LinkedList<Integer>();
        dfs( n, k,1,temp,result );
        return result;

    }
    private static void dfs(int n, int k, int start,  List<Integer> temp,  List<List<Integer>> result){
        if (temp.size()== k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n;i++){
            temp.add(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数不允许出现重复的元素
            dfs(n,k,i+1,temp,result);
            temp.remove(temp.size()-1);
        }

    }

  public static void main(String[] args) {
      List<List<Integer>> list = combine(4,2);
    System.out.println(list);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
