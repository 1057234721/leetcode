package array;//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
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


/**
 * Created by IntelliJ IDEA.
 * [283]Move Zeroes
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MoveZeroes {
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
        //一次循环，快速排序思想，非0放左边，0放右边
        int pos =  0;
        for (int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos ++;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
