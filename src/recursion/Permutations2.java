package recursion;
//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations.
//
// Example:
//
//
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
//
// Related Topics 回溯算法
// 👍 391 👎 0



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * [46]Permutations
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Permutations2 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp =  new ArrayList<>();
        //因为有重复元素，不能用list.contan判断
        //故需要状态数组，标识每个元素是否被使用
        boolean [] flags= new   boolean [nums.length];
        Arrays.sort(nums);
        dfs(nums,temp,result,flags);
        return result;

    }
    private static void dfs(int[] nums,List<Integer> temp,List<List<Integer>> result,boolean [] flags){
        if(temp.size()== nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i =0;i<nums.length;i++ ){
            if(flags[i]){
                continue;
            }
            //搜索到被之前撤銷的數字，必然会导致重复
            //排除在上一轮中撤销的数字
            if( i>0 && nums[i] == nums[i-1] && !flags[i-1]){
                continue;
            }
                flags[i] = true;
                temp.add(nums[i]);
                dfs( nums,temp, result,flags);
                temp.remove(temp.size()-1);
                flags[i] = false;

        }
    }

  public static void main(String[] args) {
    //
      int[] a = {3,3,0,3};
      List<List<Integer>> list = permute(a);
    System.out.println(list);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
