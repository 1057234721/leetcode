package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201203
 * To change this template use File | Settings | File Templates.
 */
public class Offer53MissingNumber {
    public int missingNumber(int[] nums) {
        //二分
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if(nums[m]==m){
                l = m+1;
            }else {
                r =m-1;
            }
        }
        return l;
    }
}
