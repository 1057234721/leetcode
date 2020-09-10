package recursion;//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 743 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Created by IntelliJ IDEA.
 * [78]Subsets
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
//        Arrays.sort(nums);
        dfs(nums,0,temp,result);

        return result;

    }

    private static void dfs(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for(int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(nums,i+1,temp,result);
            temp.remove(temp.size()-1);
        }


    }

  public static void main(String[] args) {
    //
      int[] a = {3,2,1};
    System.out.println(subsets( a ));
  }
}
//leetcode submit region end(Prohibit modification and deletion)
