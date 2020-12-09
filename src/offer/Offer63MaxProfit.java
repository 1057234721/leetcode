package offer;
/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201209
 * To change this template use File | Settings | File Templates.
 */
public class Offer63MaxProfit {
    public int maxProfit(int[] prices) {
        //状态转移方程，
        //dp[i]=Max(前i日最大值dp[i-1],当前元素prices[i]-数组0到i的最小值)
        int dp =0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            min = Math.min(prices[i],min);
            dp = Math.max(dp,prices[i]-min);
        }
        return dp;

    }
}
