package offer;
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
// 1
// / \
// 2 2
// / \ / \
//3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
// 1
// / \
// 2 2
// \ \
// 3 3
//
//
//
// 示例 1：
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
// Related Topics 树
// 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import common.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201119
 * To change this template use File | Settings | File Templates.
 */
public class Offer28IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        //如果先镜像在比等需要复制一棵树
        //画图查看对称节点的分布规律，对称节点相等
        if(root == null){
            return true;
        }
        return monitorDfs(root.left,root.right);

    }
    private Boolean monitorDfs(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if(left==null || right ==null || left.val != right.val){
            return false;
        }
        //对称规律，left.left = right.right,left.right=right.left
        return monitorDfs(left.left,right.right)&& monitorDfs(left.right,right.left);
    }
}
