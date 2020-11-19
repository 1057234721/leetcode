package offer;
//Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 488 👎 0

/**
 * Created by IntelliJ IDEA.
 * Pow(x, n)
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Offer16Pow {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
        }
       return recursion(x,n);

    }
    public double recursion(double x, int n) {
        if(n==0){
            return 1;
        }
        double result = recursion(x,n/2);

        return n%2 == 0 ? result *result: result*result*x;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
