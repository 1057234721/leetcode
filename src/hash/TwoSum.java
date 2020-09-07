package hash;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by IntelliJ IDEA.
 *[1]Two Sum
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++ ){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++ ){
            //排除自己并且map中存在下标
            if(map.get(target - nums[i]) != null && i != map.get(target - nums[i])){
                return  new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(a, target);
        System.out.println(Arrays.toString(result));

    }
}

