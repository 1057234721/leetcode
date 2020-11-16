package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201029
 * To change this template use File | Settings | File Templates.
 */
public class Offer14IntegerBreak {
    public static  int integerBreak(int n) {
        // 创建数组 dp，其中dp[i] 表示将正整数 i
        // 拆分成至少两个正整数的和之后，这些正整数的最大乘积。特别地，0 不是正整数，1 是最小的正整数，0 和 1 都不能拆分，因此
        // dp[0]=dp[1]=0。
        //
        // 当 i≥2 时，假设对正整数 i 拆分出的第一个正整数是 j（ 1≤j<i），则有以下两种方案：
        //
        // 将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
        //
        // 将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是j×dp[i−j]。
        //
        // 因此，当 j 固定时，有 dp[i]=max(j×(i−j),j×dp[i−j])。由于 j 的取值范围是 1 到 i−1，需要遍历所有的 j 得到
        // dp[i] 的最大值，因此可以得到状态转移方程如下：
        //        dp[i]=max{max(j×(i−j),j×dp[i−j])}
        //             1≤j<i


//        int[] dp = new int[n + 1];
//        for (int i =2;i<=n;i++){
//            for (int j =1;j<=i;j++){
//                dp[i]= Math.max(j*(i-j),j*dp[i-j]);
//            }
//        }
//
//        return dp[n];
        if (n<=3){
            return n-1;
        }
        int a = n/3;
        int b = n%3;
        double max =0;
        if(b==0){
            max = Math.pow(3,a);
        }
        if(b==1){
            max = Math.pow(3,a-1)*4;
        }
        if(b==2){
            max = Math.pow(3,a)*2;
        }
        return (int) max;
    }


    public static void main(String[] args) {

        System.out.println(integerBreak(10));
        //
    }
}
