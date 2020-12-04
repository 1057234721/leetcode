package offer;
//统计一个数字在排序数组中出现的次数。
//
//
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/
// Related Topics 数组 二分查找
// 👍 82 👎 0

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201203
 * To change this template use File | Settings | File Templates.
 */
public class Offer53Search {
    public int search(int[] nums, int target) {
        //用二分法确定左右边界
        int left = 0;
        int right = nums.length-1;
        //右边界
        while (left<=right){
            int mid = (left+right)/2;
            //左右边界区别
            if(nums[mid]<= target){
                left = mid+1;
            }else{
                right =mid-1;
            }

        }
        int left1 = 0;
        int right1 = nums.length-1;
        //左边界
        while (left1<=right1){
            int mid = (left1+right1)/2;
            //左右边界区别
            if(nums[mid]< target){
                left1 = mid+1;
            }else{
                right1 =mid-1;
            }

        }
        return left - right1-1;


    }
}
