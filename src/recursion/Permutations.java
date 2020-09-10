package recursion;
//Given a collection of distinct integers, return all possible permutations.
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics 回溯算法 
// 👍 873 👎 0


import java.util.ArrayList;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * [46]Permutations
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp =  new ArrayList<>();
        dfs(nums,temp,result);
        return result;

    }
    private static void dfs(int[] nums,List<Integer> temp,List<List<Integer>> result){
        if(temp.size()== nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i =0;i<nums.length;i++ ){
            //不能重复放入同一个数
            //替换状态数组
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            dfs( nums,temp, result);
            temp.remove(temp.size()-1);
        }
    }

  public static void main(String[] args) {
    //
      int[] a = {2, 7, 11, 15};
      List<List<Integer>> list = permute(a);
    System.out.println(list);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
