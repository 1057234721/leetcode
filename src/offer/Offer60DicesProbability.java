package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201209
 * To change this template use File | Settings | File Templates.
 */
public class Offer60DicesProbability {
    public double[] dicesProbability(int n) {
//        1.构造dp数组：tmp[]为n个骰子的点数概率数组，pre[]为n-1个骰子的点数概率数组，一个骰子的点数概率数组显然是6个六分之一,不需要另设数组。
//        2.初始化dp数组：pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
//        3.构造状态转移方程:tmp[x+y]+=pre[x]*num[y];

        double[] pre = new double[]{1/6.0,1/6.0,1/6.0,1/6.0,1/6.0,1/6.0};
        for (int i=2; i<=n;i++){
            //n个骰子的范围[n,6n]
            double[] temp = new double[6*n-n+1];
            //(n-1)个骰子
            for (int j=0;j<pre.length;j++){
                //最后一个骰子，6种情况
                for (int x=0;x<6;x++){
                    temp[j+x] += pre[j] * 1/6.0;
                }
            }
            pre =temp;
        }
        return pre;

    }
}
