package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201201
 * To change this template use File | Settings | File Templates.
 */
public class Offer46translateNum {
    public int translateNum(int num) {
        //f(i) = f(i-1)+f(i-2),substring(i-2,i)在10到25之间
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=s.length();i++){
            String temp = s.substring(i-2,i);
            if(temp.compareTo("10")>=0 && temp.compareTo("25")<=0){
                dp[i]=dp[i-1]+dp[i-2];

            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
