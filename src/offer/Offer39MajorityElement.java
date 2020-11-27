package offer;//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 728 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Created by IntelliJ IDEA.
 * [169]Majority Element
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class Offer39MajorityElement {
    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[(nums.length-1)/2];
        //Boyer-Moore 投票算法
        //遍历数组，设置候选者x=0，设置计数器cout=0，当改次遍历count=0时，设置该数组元素为候选者，遍历完成后，候选者即是最终值
        //循环过程中，候选者等于当前元素，count++，否则count--
       //在对整个数组进行遍历的过程中，count 的值一定非负。这是因为如果 count 的值为 0，那么在这一轮遍历的开始时刻，我们会将 x 的值赋予 candidate 并在接下来的一步中将 count 的值增加 1。因此 count 的值在遍历的过程中一直保持非负
       int count = 0;
       int result =0;
        for (int i=0;i<nums.length;i++){
            if(count==0){
                result=nums[i];
            }
            if(nums[i]==result){
                count++;
            }else {
                count--;
            }
        }
        return  result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
