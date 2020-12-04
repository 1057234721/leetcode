package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201204
 * To change this template use File | Settings | File Templates.
 */
public class Offer56SingleNumbers {
    public static int[] singleNumbers(int[] nums) {
        //如果只有一个数字出现一次这么做，全体异或，成对异或即为0，故结果数字只剩出现一次的
        //两个数字全体异或变成a^b,取二进制位1的位，分组，因为a,b在次位置不同必然被分在不同组，在小组内在次异或
        int res = 0;
        for (int n : nums){
            res ^= n;
        }
        int temp=1;
        while ((res&temp)==0){
            temp<<=1;
        }
        int a=0;
        int b=0;
        for (int n : nums){
            if((n&temp) ==0){
                System.out.println((n^temp) +"!=0");
                a^=n;
            }else {
                System.out.println((n^temp) +"==0");
                b^=n;
            }
        }
        return new int[]{a,b};

    }

  public static void main(String[] args) {
    //singleNumbers(new int[]{1,2,5,2})
      int [] a =singleNumbers(new int[]{1,2,5,2});
      for (int n : a){
          System.out.println(n);
      }


  }
}
