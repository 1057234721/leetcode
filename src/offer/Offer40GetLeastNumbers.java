package offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201127
 * To change this template use File | Settings | File Templates.
 */
public class Offer40GetLeastNumbers {
    public static  int[] getLeastNumbers(int[] arr, int k) {
        if(k<=0 || k>arr.length){
            return  new int[0];
        }
        //快速排序，设定一个标准temp小于，左右两端和temp比较，先比右端，如果小于temp和左端交换，大于则前移，同理比较左端，
        dfs(arr,0,arr.length-1,k);
        int[] result =  new int[k];
        System.out.println(Arrays.toString(arr));
        System.arraycopy(arr,0,result,0,k);
        return result;
    }
    private static void dfs(int[] arr,int start,int end,int k){
        if(start>=end ){
            return;
        }
        int stand = arr[start];
        int high = end;
        int low = start;
        while (low<high){
            //先取右边
            while (low<high && stand<=arr[high]){
                high--;
            }
            arr[low]=arr[high];

            while (low<high && arr[low]<=stand){
                low++;
            }
            arr[high]=arr[low];

        }
        //确定标准的位置
        arr[low] =stand;
        if(low == k-1){
            return;
        }
        if(low > k-1){
            dfs(arr, start, low,  k);
        }
        if (low<k-1){
            dfs(arr, low+1, end , k);
        }
    }

  public static void main(String[] args) {
    //
      int[] a = {0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};
      int k = 75;
      int[] result = getLeastNumbers(a, k);
      System.out.println(Arrays.toString(result));
      PriorityQueue b = new PriorityQueue(
              new Comparator<Integer>() {
                  @Override
                  public int compare(Integer o1, Integer o2) {
                      return o2.compareTo(o1);
                  }
              }
      );
  }
}
