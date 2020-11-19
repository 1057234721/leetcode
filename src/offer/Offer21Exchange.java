package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201117
 * To change this template use File | Settings | File Templates.
 */
public class Offer21Exchange {
    public int[] exchange(int[] nums) {
        int left =0 ;int right = nums.length-1;
        while (left < right){
            if((nums[left]&1) ==1){
                left++;
                continue;
            }
            if((nums[right]&1) ==0){
                right--;
                continue;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;

    }
}
