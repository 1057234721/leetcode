package offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201201
 * To change this template use File | Settings | File Templates.
 */
public class Offer45minNumber {
    public static String minNumber(int[] nums) {
        //重置排序规则，x+y<y+x => x<y,重写Array.sort的排序规则即可
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (x+y).compareTo(y+x);
            }
        });
        StringBuffer result = new StringBuffer();
        for (String s : arr){
            result.append(s);
        }
        return result.toString();

    }

  public static void main(String[] args) {
    // int[] a = {0,1,1
      int[] a = {10,2};
    System.out.println(minNumber(a));

  }
}
