package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201203
 * To change this template use File | Settings | File Templates.
 */
public class Offer49NthUglyNumber {
    public int nthUglyNumber(int n) {
        //都一个丑数是1，后续每个丑数都是从2*a，3*b，，5*c中的最小值选，设dp[i]为丑数数组
        int p2 =0;
        int p3 =0;
        int p5 =0;
        int[] dp =new int[n];
        dp[0]=1;
        for (int i=1;i<n;i++){
            int a = dp[p2]*2;
            int b = dp[p3]*3;
            int c = dp[p5]*5;
            dp[i] =Math.min(Math.min(a,b),c);
            if(dp[i] == a){
                p2++;
            }
            if(dp[i] == b){
                p3++;
            }
            if(dp[i] == c){
                p5++;
            }
        }
        return dp[n-1];

    }
}
