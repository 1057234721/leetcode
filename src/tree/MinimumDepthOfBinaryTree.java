package tree;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 354 👎 0


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
 *[111]Minimum Depth of Binary Tree
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //如果第一层左子树为空，返回右子树高度
        if(root.left == null ){
            return  minDepth(root.right) +1 ;
        }
        //如果第一层右子树为空，返回左子树高度
        if(root.right == null ){
            return  minDepth(root.left)+1 ;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
