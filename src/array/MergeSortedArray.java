package array;//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * [88]Merge Sorted Array
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //方法一
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
        //方法二，从左往右双指针，需要开辟M内存空间
//        int[] nums1_copy = new int[m];
//        System.arraycopy(nums1,0,nums1_copy,0,m);
//        int p1=0;
//        int p2=0;
//        int p=0;
//        while(p1<m && p2<n){
//           nums1[p++] = nums1_copy[p1]<nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
//        }
//        //m>n nums1_copy剩余部分复制到nums1
//        if(p1<m){
//            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
//        }
//        //m<n nums2剩余部分复制到nums1
//        if(p2<n){
//            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
//        }
        //方法二，从右往左双指针
        int p1= m-1;
        int p2= n-1;
        int p=m+n-1;
        while (p1>=0 && p2>=0){
            nums1[p--] = nums1[p1]>nums2[p2] ? nums1[p1--] :nums2[p2--];
        }
        //m>n，剩余部分本就在nums1数组中不作处理
        //n>m，剩余部分复制到nums1
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
