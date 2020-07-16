//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        //左右两边向中间夹逼，左右两边中的短棒子动（宽度不变，高度若提高，面积变大）
        int left = 0;
        int right = height.length -1;
        int area =0;
        while (left<right){
            //计算面积并保存最大值
            //木桶效应，面积由短板确定
            area = Math.max(area,  (right - left)* Math.min(height[left],height[right]));
            //短板棒子内移
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
