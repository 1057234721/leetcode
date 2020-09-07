package array;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 *[15]3Sum
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //target +left+right =0
        //target 循环
        Arrays.sort(nums);
        for(int i = 0; i<nums.length - 2;i++){
            //target 去重
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    //满足条件记录值
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    list.add(tempList);
                    //满足条件的letf去重
                    while(left<right && nums[left]==nums[left +1]){
                        left++;
                    }
                    //满足条件的right去重
                    while(left<right && nums[right]==nums[right -1]){
                        right--;
                    }
                    //满足条件左右同时靠拢
                    left ++;
                    right --;
                }else if(nums[left] + nums[right] + nums[i] < 0){
                    //值小于0 left++
                    left ++;
                }else{
                    //值大于0 right--
                    right--;
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
