package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201209
 * To change this template use File | Settings | File Templates.
 */
public class Offer61IsStraight {
    public boolean isStraight(int[] nums) {
        //Max-min<5;
        Set<Integer> set = new HashSet<Integer>();
        int max =0;
        int min =14;
        for(int n : nums){
            if(n==0){
                continue;
            }
            max = Math.max(n,max);
            min = Math.min(n,min);
            if(!set.add(n)) {
                return false;
            }
        }
        return max-min<5;


    }
}
