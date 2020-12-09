package offer;
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 521 👎 0


import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
/**
 * Created by IntelliJ IDEA.
 *[239]Sliding Window Maximum
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Offer59SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口的长度为k，最后一个坐标k-1；维护一个单调递减栈，右边界：当前元素大于栈顶时，出栈，直至栈顶元素大于当前元素或者栈为空
        //左边界元素不在滑动窗口内时i -k+1，要从栈底移除，故改栈为队列，栈底变队头，队列头的元素始终是局部最大，即滑动窗口最大
        if(k==0 || nums == null){
            return new int[0];
        }
       int n =  nums.length;
       int[] max = new int [n - k+1];
       int idx = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i=0;i<n;i++){
            //判断队列第一个元素在不在滑动窗口内,如不在移除第一个元素
            while (!deque.isEmpty() && deque.peekFirst() <i -k+1 ){
                deque.removeFirst();
            }
            //当前元素大于队尾元素，出队，直至不满足条件位置
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()] ){
                deque.removeLast();
            }
            deque.addLast(i);
            //将最值放入新数组
            if(i >= k-1){
            max[idx++] = nums[deque.peekFirst()];
             }
        }
       return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
