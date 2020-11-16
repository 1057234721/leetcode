package offer;
//找出数组中重复的数字。
//        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
//        示例 1：
//
//        输入：
//        [2, 3, 1, 0, 2, 5, 3]
//        输出：2 或 3

import common.ListNode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201020
 * To change this template use File | Settings | File Templates.
 */
public class Offer03FindRepeatNumber {
    public static  int findRepeatNumber(int[] nums) {
        /**
         * 遍历数组，利用数组可用下标定位，如果数据无重复数组下标值等于数据值，即i= nums[i]
         * 如果nums[i]= m，则判断nums[i]与 nums[m]是否相等，如果相等即为所求，如果不等，则把nums[i]放置在下标m，num[m]放置到下标i
         *
         */
        for(int i=0;i<nums.length;i++){
            if(nums[i]!= i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int temp =nums[nums[i]];
                nums[nums[i]]= nums[i];
                nums[i] = temp;

            }
        }

        return -1;
    }
    public static void main(String[] args) {
        //
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        int result = findRepeatNumber(a);
        System.out.println((result));

    }
}
