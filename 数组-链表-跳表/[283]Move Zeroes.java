//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        //两次循环，第一次用非零元素覆盖当前数组(先去除数字0)
        //第二次末尾补零
//        int start =0;
////        for(int num : nums){
////            if(num !=0){
////                nums[start++] = num;
////            }
////        }
////        if(start != nums.length){
////            for (int i=start;i<nums.length;i++){
////                nums[i] = 0;
////            }
////        }
        //一次循环，双指针，检测到指针不相等，快慢指针交换值
        int pos =  0;
        for (int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[pos] = nums[i];
                //检查pos至i路段是否含连续个零,如包含这不相等,则替换nums[pos] num[i]，
                // 如果pos与i不想等，那么num[pos]到num[i]之间都是0
                if(pos < i){
                    nums[i] =0;
                }
                pos ++;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
