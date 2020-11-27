package offer;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
// 👍 145 👎 0

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201124
 * To change this template use File | Settings | File Templates.
 */
public class Offer33VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        //最后一个元素为根，从左到右遍历数组，第一个大于根的数为右子树第一元素，递归
        return dfs(postorder,0,postorder.length-1);
    }
    private Boolean dfs(int[] postorder,int start,int end){
        //子树只有一个元素，或者null
        if(start>=end){
            return true;
        }
        int temp = start;
        while (postorder[temp]<postorder[end]){
            temp++;
        }
        int mid = temp;
        while (postorder[temp]>postorder[end]){
            temp++;
        }
        return temp==end && dfs(postorder,start,temp-1)&& dfs(postorder,temp,end-1);
    }
}
