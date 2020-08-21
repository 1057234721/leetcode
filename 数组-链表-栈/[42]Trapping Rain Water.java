//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length==0)
            return 0;
        //维护降序栈：遍历数组时入栈，入栈规则，当前元素小于栈顶入栈，大于栈顶时，需要依次出站，一直至当前元素小于栈顶
        //当前元素大于栈顶元素时，当前元素为右边界right。栈顶元素的前一个元素为左边界left（降序栈）。
        //雨水面积为(min（left，rihht）-hight[stack.peek]（弹出元素高度)) *  (right -left -1),当前元素大于若干个栈元素时，便要计算
        //面积的宽度（right -left -1）
//         int area = 0;
//        Stack<Integer> stack = new Stack<Integer>();
//        for(int right = 0 ;right<height.length;right++){
//            //大于栈顶时，需要依次出站，一直至当前元素小于栈顶,故不能用if
//            while(!stack.empty() && height[right]>height[stack.peek()]){
//                //弹出元素的高度
//                int top = stack.pop();
//                if(stack.empty()){
//                    break;
//                }
//                int left =  stack.peek();
//                area += (Math.min(height[left],height[right]) - height[top]) * (right-left-1);
//            }
//            stack.push(right);
//        }
//
//      return area;


        //数组,当前元素i接水的高度，枚举左右边界max，左边界left为数组[0,i-1]高度Max，右边界right为数组[i+1，nums.length-1]高度Max
        //由于是逐个元素遍历，故宽度是1
        //改进，增加leftMax数组和rightMax数组缓存当前元素的leftMax及rightMax
//        int area = 0;
//        for(int i=0;i<height.length;i++){
//            //当i在为0和height.length-1时，为数组的左右边界，此时不会储水
//            if(i==0 || i== height.length-1){
//                continue;
//            }
//            //在[0,i-1]中找leftMax
//            int leftMax = 0;
//            for(int j=i;j>=0;j--){
//                leftMax = Math.max(leftMax,height[j]);
//            }
//            //在[i+1，nums.length-1]中找rightMax
//            int rightMax =0;
//            for(int k=i;k<height.length;k++){
//                rightMax = Math.max(rightMax,height[k]);
//            }
//            area += Math.min(leftMax,rightMax)-height[i];
//
//        }
//        return  area;


        //改进，增加leftMax数组和rightMax数组缓存当前元素的leftMax及rightMax
//        int area =0;
//        int[] leftMax = new int[height.length];
//        int[] rightMax = new int[height.length];
//        leftMax[0] =height[0];
//        for (int i =1; i<height.length;i++){
//            leftMax[i] = Math.max(leftMax[i-1],height[i]);
//        }
//
//        rightMax[height.length-1] =height[height.length-1];
//        for (int i=height.length-2;i>=0;i--){
//            rightMax[i] = Math.max(rightMax[i+1],height[i]);
//        }
//        for (int i=1;i<height.length-1;i++){
//            area += Math.min(leftMax[i],rightMax[i])-height[i];
//        }
//        return area;

        //优化数组为左右指针,
        // 因当前元素在找leftMax，rightMax时，由min（leftMax，rightMax）决定高度，
        //故先用左右指针分别指向left，right,再记录leftMax，rightMax，左右指针分别向中间靠拢，过程中，若height[left]<height[right],操作左指针，否则操作右指针，以左指针为例，当前元素若小于leftMax，则计算当前元素储水面积，
        // area = hight[leftMax] - hight[i] ,若当前元素若大于leftMax。则赋值leftMax = hight[i];
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int area =0;
        while(left<right){
            if (height[left]<height[right]){
                if(height[left]<leftMax){
                    area += leftMax-height[left];
                }else {
                    leftMax = height[left];
                }
                left++;
            }else{
                if(height[right]<rightMax){
                    area += rightMax-height[right];
                }else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return area;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
