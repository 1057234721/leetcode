package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201707
 * To change this template use File | Settings | File Templates.
 */
public class Offer57twoSum {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            if(nums[left] +nums[right]==target){
                return new int[]{nums[left],nums[right]};
            }else if(nums[left] +nums[right]>target){
                right--;
            }else {
                left++;
            }
        }
        return new int[0];

    }
}
